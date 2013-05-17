package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import puresound.Artista;
import puresound.Cancion;
import puresound.Grupo;
import puresound.ListaArtistasFavoritos;
import puresound.Solista;

@SuppressWarnings("serial")
public class User extends JPanel implements Observer, TreeSelectionListener {
	private static JTree tree;
	private static int contadorA = 0;
	private static int contadorC = 0;
	private ListaArtistasFavoritos model = null;
	
	/**
	 * Create the panel.
	 */
	public User(ListaArtistasFavoritos model) {
		this.model = model;
		
		Arbol.pintarArbol();
        tree.addTreeSelectionListener(this);
        add(new JScrollPane(tree), BorderLayout.CENTER);
        
        this.model.addObserver(this);
        
        /* Le ponemos un ancho más apropiado al JTree para aprovechar el espacio. */
        Dimension preferredSize = new Dimension();
        preferredSize.width = 350;
		tree.setPreferredSize(preferredSize);
	}

	public void update(Observable model, Object arg1) {
		/* Hay que distinguir entre grupos, solistas y canciones. */
		if (arg1.getClass() == Grupo.class || arg1.getClass() == Solista.class) {
			Artista ar = (Artista) arg1;
			Arbol.addArtista(ar.getNombre());
		} else {
			Cancion ca = (Cancion) arg1;
			Arbol.addCancion(ca.getNombre());
		}
		
		/* Expandimos todos los nodos para que sean visibles. */
        for (int i = 0; i < tree.getRowCount(); i++)
            tree.expandRow(i);
	}
	
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		Object node = tree.getLastSelectedPathComponent();
		if (node == null)
			return;
		JOptionPane.showMessageDialog(this, "You have selected: " + node);
	}
	
	private static class Arbol {
		private static DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Panel de usuario");
		private static DefaultMutableTreeNode artistasF = new DefaultMutableTreeNode("Artistas favoritos");
		private static DefaultMutableTreeNode cancionesF = new DefaultMutableTreeNode("Canciones favoritas");
		private static DefaultTreeModel modelo = new DefaultTreeModel(raiz);
		
		private static void pintarArbol() {
			modelo.insertNodeInto(artistasF, raiz, 0);
			modelo.insertNodeInto(cancionesF, raiz, 1);
			Iterator<Artista> itA = ListaArtistasFavoritos.getListaArtistasFavoritos().iterator();
	        while (itA.hasNext()) {
				Artista ar = itA.next();
				DefaultMutableTreeNode artista = new DefaultMutableTreeNode(ar.getNombre());
				modelo.insertNodeInto(artista, artistasF, contadorA);
				contadorA++;
	        }
	        tree = new JTree(modelo);
		}
		
		private static void addArtista(String pNombre) {
			DefaultMutableTreeNode artista = new DefaultMutableTreeNode(pNombre);
			modelo.insertNodeInto(artista, artistasF, contadorA);
			contadorA++;
		}
		
		private static void addCancion(String pNombre) {
			DefaultMutableTreeNode cancion = new DefaultMutableTreeNode(pNombre);
			modelo.insertNodeInto(cancion, cancionesF, contadorC);
			contadorC++;
		}
	}
}