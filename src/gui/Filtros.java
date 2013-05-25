package gui;

import java.awt.Color;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.DefaultTreeModel;

import puresound.Evento;
import puresound.ListaEventos;

import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Iterator;
import java.awt.GridLayout;

@SuppressWarnings("serial")
public class Filtros extends JDialog {
	private JTree tree = null;
	private DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("PureSound");
	private DefaultMutableTreeNode padre = new DefaultMutableTreeNode();
	private DefaultTreeModel modelo = new DefaultTreeModel(raiz);
	private JComboBox<String> cmbBxTipo = new JComboBox<String>();
	
	public Filtros() {
		setTitle("Filtros");
		getContentPane().setBackground(new Color(255, 255, 255));
		getContentPane().setLayout(new GridLayout(0, 1, 0, 0));
		
		tree = new JTree(modelo); // Añadimos el modelo de árbol al JTree.
		tree.setBorder(null);
		tree.setEditable(false);
		tree.setForeground(new Color(30, 144, 255));
		tree.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		getContentPane().add(tree);

        /* Diremos que salgan las barras de scroll cuando el JTree no entre en el panel. */
        JScrollPane sPane = new JScrollPane(tree, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(sPane);
        
		cmbBxTipo.setForeground(new Color(30, 144, 255));
		cmbBxTipo.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		cmbBxTipo.addItem("Filtrado con los eventos pasados");
		cmbBxTipo.addItem("Filtrado con los próximos eventos");
		getContentPane().add(cmbBxTipo);
		
		JButton btnFiltrar = new JButton("Filtrar");
		btnFiltrar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				pintarArbol(cmbBxTipo.getSelectedIndex());
			}
		});
		btnFiltrar.setForeground(new Color(30, 144, 255));
		btnFiltrar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnFiltrar.setBackground(new Color(255, 255, 255));
		getContentPane().add(btnFiltrar);
		
		this.setModal(true);
	}
	
	private void pintarArbol(int pSeleccion) {
		Iterator<Evento> it;
		
		if (padre.getChildCount() > 1) {
			modelo.removeNodeFromParent(padre);
			modelo.reload(raiz);
		}
		
		switch (pSeleccion) {
			case 0:
				padre = new DefaultMutableTreeNode("Eventos pasados");
				it = ListaEventos.getListaEventos().filtrarEventosPasados().iterator();
				break;
			case 1:
				padre = new DefaultMutableTreeNode("Próximos eventos");
				it = ListaEventos.getListaEventos().filtrarProximosEventos().iterator();
				break;
			default:
				return;
		}
		
		modelo.insertNodeInto(padre, raiz, 0);
		
		while (it.hasNext()) {
			Evento ob = it.next();
			DefaultMutableTreeNode hijo = new DefaultMutableTreeNode(ob.getNombre());
			modelo.insertNodeInto(hijo, padre, padre.getChildCount());
        }
		
		/* Expandimos todos los nodos para que sean visibles. */
        for (int i = 0; i < tree.getRowCount(); i++)
            tree.expandRow(i);
	}
}