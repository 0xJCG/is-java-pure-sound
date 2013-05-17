package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Iterator;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import puresound.Artista;
import puresound.Cancion;
import puresound.Disco;
import puresound.Evento;
import puresound.ListaArtistasFavoritos;
import puresound.ListaArtistasTotal;
import puresound.ListaEventos;

@SuppressWarnings("serial")
public class Datos extends JPanel implements TreeSelectionListener {
	private static JTree tree;
	
	/**
	 * Create the panel.
	 */
	public Datos() {
		Arbol.pintarArbol();
        tree.addTreeSelectionListener(this);
        add(new JScrollPane(tree), BorderLayout.CENTER);
        
        /* Expandimos todos los nodos para que sean visibles. */
        for (int i = 0; i < tree.getRowCount(); i++)
            tree.expandRow(i);
        
        /* Le ponemos un ancho más apropiado al JTree para aprovechar el espacio. */
        Dimension preferredSize = new Dimension();
        preferredSize.width = 350;
		tree.setPreferredSize(preferredSize);
	}
	
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		Object node = tree.getLastSelectedPathComponent();
		if (node == null)
			return;
		else {
			TreePath path = e.getPath();
			Object [] nodos = path.getPath();
			if (nodos.length == 3) { // Artista seleccionado.
				if (JOptionPane.showConfirmDialog(this, "¿Añadir a " + node.toString() + " como favorito?") == 0) { // Si el usuario pulsa "Sí".
					Artista ar = ListaArtistasTotal.getListaArtistasTotal().buscarArtista(node.toString()); // Buscamos el artista.
					ListaArtistasFavoritos.getListaArtistasFavoritos().addArtista(ar); // Lo añadimos en la lista de favoritos.
				}
			}
		}
	}
	
	private static class Arbol {
		private static DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("PureSound");
		private static DefaultMutableTreeNode artistas = new DefaultMutableTreeNode("Artistas");
		private static DefaultMutableTreeNode eventos = new DefaultMutableTreeNode("Eventos");
		private static DefaultTreeModel modelo = new DefaultTreeModel(raiz);
		
		private static void pintarArbol() {
			int contadorA = 0;
			int contadorD = 0;
			int contadorC = 0;
			int contadorE = 0;
			modelo.insertNodeInto(artistas, raiz, 0);
			modelo.insertNodeInto(eventos, raiz, 1);
			Iterator<Artista> itA = ListaArtistasTotal.getListaArtistasTotal().iterator();
	        while (itA.hasNext()) {
				Artista ar = itA.next();
				DefaultMutableTreeNode artista = new DefaultMutableTreeNode(ar.getNombre());
				modelo.insertNodeInto(artista, artistas, contadorA);
				contadorA++;
				Iterator<Disco> itD = ar.getDiscografia().iterator();
				while (itD.hasNext()) {
					Disco di = itD.next();
					DefaultMutableTreeNode disco = new DefaultMutableTreeNode(di.getNombre());
					modelo.insertNodeInto(disco, artista, contadorD);
					contadorD++;
					Iterator<Cancion> itC = di.getCanciones().iterator();
					while (itD.hasNext()) {
						Cancion ca = itC.next();
						DefaultMutableTreeNode cancion = new DefaultMutableTreeNode(ca.getNombre());
						modelo.insertNodeInto(cancion, disco, contadorC);
						contadorC++;
					}
				}
	        }
	        Iterator<Evento> itE = ListaEventos.getListaEventos().iterator();
	        while (itE.hasNext()) {
				Evento ev = itE.next();
				DefaultMutableTreeNode evento = new DefaultMutableTreeNode(ev.getNombre());
				modelo.insertNodeInto(evento, eventos, contadorE);
				contadorE++;
	        }
	        tree = new JTree(modelo);
		}
	}
}