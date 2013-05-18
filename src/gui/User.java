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
import puresound.ListaArtistasFavoritos;

@SuppressWarnings("serial")
public class User extends JPanel implements Observer, TreeSelectionListener {
	private JTree tree;
	private int contadorA = 0;
	private DefaultMutableTreeNode raiz;
	private DefaultMutableTreeNode artistasF;
	private DefaultTreeModel modelo;
	
	/**
	 * Create the panel.
	 */
	public User(ListaArtistasFavoritos model) {
		this.setLayout(new GridLayout(2, 1));
		
		this.pintarArbol();
        tree.addTreeSelectionListener(this);
        
        /* Diremos que salgan las barras de scroll cuando el JTree no entre en el panel. */
        JScrollPane sPane = new JScrollPane(tree, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(sPane);
        
        model.addObserver(this);
	}

	public void update(Observable model, Object arg1) {
		Artista ar = (Artista) arg1;
		
		if (ListaArtistasFavoritos.getListaArtistasFavoritos().esta(ar))
			this.addArtista(ar.getNombre());
		else {
			DefaultMutableTreeNode nodo = (DefaultMutableTreeNode) modelo.getRoot();
			this.removeArtista(nodo);
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
		else {
			TreePath path = e.getPath();
			Object[] nodos = path.getPath();
			if (nodos.length == 3) { // Artista seleccionado.
				if (JOptionPane.showConfirmDialog(this, "¿Eliminar a " + node.toString() + " como artista favorito?") == 0) { // Si el usuario pulsa "Sí".
					Artista ar = ListaArtistasFavoritos.getListaArtistasFavoritos().buscarArtista(node.toString()); // Buscamos el artista.
					ListaArtistasFavoritos.getListaArtistasFavoritos().remove(ar); // Lo quitamos de la lista de favoritos.
				}
			}
		}
	}
	
	private void pintarArbol() {
		raiz = new DefaultMutableTreeNode("Panel de usuario");
		artistasF = new DefaultMutableTreeNode("Artistas favoritos");
		modelo = new DefaultTreeModel(raiz);
		modelo.insertNodeInto(artistasF, raiz, 0);
		Iterator<Artista> itA = ListaArtistasFavoritos.getListaArtistasFavoritos().iterator();
        while (itA.hasNext()) {
			Artista ar = itA.next();
			DefaultMutableTreeNode artista = new DefaultMutableTreeNode(ar.getNombre());
			modelo.insertNodeInto(artista, artistasF, contadorA);
			contadorA++;
        }
        tree = new JTree(modelo);
	}
	
	private void addArtista(String pNombre) {
		DefaultMutableTreeNode artista = new DefaultMutableTreeNode(pNombre);
		modelo.insertNodeInto(artista, artistasF, contadorA);
		contadorA++;
	}
	
	private void removeArtista(DefaultMutableTreeNode pArtista) {
		modelo.nodeStructureChanged(artistasF);
		//modelo.removeNodeFromParent(pArtista);
		contadorA--;
	}
}