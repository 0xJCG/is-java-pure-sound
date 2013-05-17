package gui;

import java.awt.BorderLayout;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.TreeModel;
import javax.swing.tree.TreePath;

@SuppressWarnings("serial")
public class Datos extends JPanel implements TreeSelectionListener {
	private JTree tree;
	
	/**
	 * Create the panel.
	 */
	public Datos() {
		setLayout(new BorderLayout());
        ProjectItemNode rootNode = ProjectTreeBuilder.buildPureSound();
        TreeModel model = new ProjectTreeModel(rootNode);
        tree = new JTree(model);
        tree.setCellRenderer(new NodeRenderer());
        tree.addTreeSelectionListener(this);
        add(new JScrollPane(tree), BorderLayout.CENTER);
        
        // expand all nodes in the tree to be visible
        for (int i = 0; i < tree.getRowCount(); i++)
            tree.expandRow(i);
        
        //setSize(390, 500);
	}
	
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		Object node = tree.getLastSelectedPathComponent();
		if (node == null)
			return;
		else {
			TreePath path = e.getPath();
			Object [] nodos = path.getPath();
			if (nodos.length == 3) // Artistas seleccionados.
				JOptionPane.showConfirmDialog(this, "¿Añadir como favorito?");
		}
	}
}