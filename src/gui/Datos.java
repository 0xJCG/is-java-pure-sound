package gui;

import java.awt.GridLayout;
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
import javax.swing.tree.TreePath;

import puresound.Artista;
import puresound.Cancion;
import puresound.Concierto;
import puresound.ConciertoFuturo;
import puresound.ConciertoPasado;
import puresound.Disco;
import puresound.Evento;
import puresound.Festival;
import puresound.ListaArtistasFavoritos;
import puresound.ListaArtistasTotal;
import puresound.ListaEventos;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Datos extends JPanel implements Observer, TreeSelectionListener {
	private JTree tree = null;
	private DefaultMutableTreeNode raiz;
	private DefaultMutableTreeNode artistas;
	private DefaultMutableTreeNode eventos;
	private DefaultTreeModel modelo;
	
	/**
	 * Create the panel.
	 */
	public Datos(ListaArtistasTotal model) {
		this.setLayout(new GridLayout(2, 1));
		
		this.pintarArbol();
		
        
        tree.addTreeSelectionListener(this);
        
        JButton btnOrdenarArtistasNombre = new JButton("Ordenar Artistas por nombre");
        btnOrdenarArtistasNombre.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent arg0) {
        		ListaArtistasTotal.getListaArtistasTotal().OrdenarPorNombreA();
        	}
        });
        add(btnOrdenarArtistasNombre);
        
       
        
        /* Expandimos todos los nodos para que sean visibles. */
        for (int i = 0; i < tree.getRowCount(); i++)
            tree.expandRow(i);
        
        model.addObserver(this);
	}
	
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		Object node = tree.getLastSelectedPathComponent();
		if (node == null)
			return;
		else {
			TreePath path = e.getPath();
			Object[] nodos = path.getPath();
			DefaultMutableTreeNode ultimoNodo = (DefaultMutableTreeNode) nodos[nodos.length-1];
			if (ultimoNodo.getParent().toString().equals("Artistas")) { // Artista seleccionado.
				if (JOptionPane.showConfirmDialog(this, "¿Añadir a " + node.toString() + " como artista favorito?") == 0) { // Si el usuario pulsa "Sí".
					Artista ar = ListaArtistasTotal.getListaArtistasTotal().buscarArtista(node.toString()); // Buscamos el artista.
					ListaArtistasFavoritos.getListaArtistasFavoritos().addArtista(ar); // Lo añadimos en la lista de favoritos.
				}
			} else if (ultimoNodo.getParent().toString().equals("Eventos")) {
				Evento ev = ListaEventos.getListaEventos().buscarEvento(node.toString());
				JOptionPane.showMessageDialog(this, ev.getNombre());
			}
		}
	}
	
	private void pintarArbol() {
		if (tree != null) {
			tree.remove(0);
		}
		raiz = new DefaultMutableTreeNode("PureSound");
		artistas = new DefaultMutableTreeNode("Artistas");
		eventos = new DefaultMutableTreeNode("Eventos");
		modelo = new DefaultTreeModel(raiz);
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
				while (itC.hasNext()) {
					Cancion ca = itC.next();
					DefaultMutableTreeNode cancion = new DefaultMutableTreeNode(ca.getNombre());
					modelo.insertNodeInto(cancion, disco, contadorC);
					contadorC++;
				}
				contadorC = 0;
			}
			contadorD = 0;
        }
        Iterator<Evento> itE = ListaEventos.getListaEventos().iterator();
        while (itE.hasNext()) {
			Evento ev = itE.next();
			DefaultMutableTreeNode evento = new DefaultMutableTreeNode(ev.getNombre());
			modelo.insertNodeInto(evento, eventos, contadorE);
			contadorE++;
			if (ev.getClass().equals(ConciertoPasado.class) || ev.getClass().equals(ConciertoFuturo.class)) {
				Concierto co = (Concierto) ev;
				DefaultMutableTreeNode artista = new DefaultMutableTreeNode(co.getArtista().getNombre());
				modelo.insertNodeInto(artista, evento, 0);
			} else {
				Festival fe = (Festival) ev;
				Iterator<Artista> itArF = fe.getListaArtistas().iterator();
				int contadorArF = 0;
				while (itArF.hasNext()) {
					Artista ar = itArF.next();
					DefaultMutableTreeNode artista = new DefaultMutableTreeNode(ar.getNombre());
					modelo.insertNodeInto(artista, evento, contadorArF);
					contadorArF++;
				}
			}
        }
        
        tree = new JTree(modelo);
        
        /* Diremos que salgan las barras de scroll cuando el JTree no entre en el panel. */
        JScrollPane sPane = new JScrollPane(tree, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(sPane);
	}

	@Override
	public void update(Observable o, Object arg) {
		pintarArbol();
		modelo.nodeStructureChanged(artistas);
		modelo.nodeChanged(artistas);
	}
}