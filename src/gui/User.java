package gui;

import java.awt.BorderLayout;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;

@SuppressWarnings("serial")
public class User extends JPanel implements Observer, TreeSelectionListener {
	private JTree tree;
	
	/**
	 * Create the panel.
	 */
	public User() { //ListaArtistasFavoritos model) {
		setLayout(new BorderLayout());
        ProjectItemNode rootNode = ProjectTreeBuilder.buildArbolUsuario();
        TreeModel model = new ProjectTreeModel(rootNode);
        tree = new JTree(model);
        tree.setCellRenderer(new NodeRenderer());
        tree.addTreeSelectionListener(this);
        add(new JScrollPane(tree), BorderLayout.CENTER);
        
        // expand all nodes in the tree to be visible
        for (int i = 0; i < tree.getRowCount(); i++)
            tree.expandRow(i);
	}

	public void update(Observable fav, Object arg1) {
		//ListaArtistasFavoritos favoritos = (ListaArtistasFavoritos) fav;
		//mostrarArtistas(favoritos.iterator());
	}
	
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		Object node = tree.getLastSelectedPathComponent();
		if (node == null)
			return;
		JOptionPane.showMessageDialog(this, "You have selected: " + node);
	}
}