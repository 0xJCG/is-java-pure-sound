package gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.BoxLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.SwingConstants;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreePath;

import puresound.Artista;
import puresound.ListaArtistasFavoritos;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class User extends JPanel implements Observer, TreeSelectionListener {
	private JTree tree;
	private DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("Panel de usuario");
	private DefaultMutableTreeNode artistasF = new DefaultMutableTreeNode("Artistas favoritos");
	private DefaultTreeModel modelo = new DefaultTreeModel(raiz);
	
	public User(ListaArtistasFavoritos model) {
		/* Ponemos el layout deseado para poner los elementos. */
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		/* El label de ayuda. */
		JLabel lblAyuda = new JLabel("En este menú se mostrarán sus artistas favoritos. Podrá borrarlos seleccionándolos.");
		lblAyuda.setHorizontalAlignment(SwingConstants.CENTER);
		lblAyuda.setForeground(new Color(30, 144, 255));
		lblAyuda.setBackground(new Color(255, 255, 255));
		lblAyuda.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		this.setBackground(Color.WHITE);
		add(lblAyuda); // Lo añadimos al panel.
		
		/* El árbol con nuestro artistas favoritos que en principio estará vacío. */
		modelo.insertNodeInto(artistasF, raiz, 0);
		tree = new JTree(modelo); // Añadimos el modelo de árbol al JTree.
        tree.addTreeSelectionListener(this); // Añadimos los triggers.
        tree.setForeground(new Color(30, 144, 255));
        tree.setFont(new Font("Segoe UI", Font.PLAIN, 15));
        tree.setEditable(false);
        
        /* Diremos que salgan las barras de scroll cuando el JTree no entre en el panel. */
        JScrollPane sPane = new JScrollPane(tree, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(sPane);
        
        /* Esta clase será observadora del modelo pasado, es decir, la lista de artistas favoritos. */
        model.addObserver(this);
	}

	/* Se activará este método cuando se añada un nuevo artista a nuestra lista de favoritos. */
	public void update(Observable model, Object arg1) {
		Artista ar = (Artista) arg1;
		/* Metemos el artista únicamente si éste no está ya en la lista. */
		if (ar != null) {
			DefaultMutableTreeNode artista = new DefaultMutableTreeNode(ar.getNombre());
			modelo.insertNodeInto(artista, artistasF, artistasF.getChildCount());
			
			/* Expandimos todos los nodos para que sean visibles. */
	        for (int i = 0; i < tree.getRowCount(); i++)
	            tree.expandRow(i);
		}
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
					/* Buscamos el artista y lo borramos de la lista. */
					Artista ar = ListaArtistasFavoritos.getListaArtistasFavoritos().buscarArtista(node.toString()); // Buscamos el artista.
					if (ListaArtistasFavoritos.getListaArtistasFavoritos().remove(ar)) // Si se ha eliminado correctamente, procedemos a borrar el nodo del árbol.
						modelo.removeNodeFromParent((DefaultMutableTreeNode) node);
				}
			}
		}
	}
}