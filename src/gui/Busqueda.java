package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class Busqueda extends JPanel {
	private JTextField txtTexto;

	/**
	 * Create the panel.
	 */
	public Busqueda() {
		
		txtTexto = new JTextField();
		txtTexto.setText("Introduce el texto a buscar...");
		add(txtTexto);
		txtTexto.setColumns(20);
		
		JComboBox<String> cmbBxTipo = new JComboBox<String>();
		cmbBxTipo.addItem("Artista");
		cmbBxTipo.addItem("Disco");
		cmbBxTipo.addItem("Canción");
		cmbBxTipo.addItem("Evento");
		
		add(cmbBxTipo);
		
		JButton btnBuscar = new JButton("Buscar");
		add(btnBuscar);

		setSize(800, 100);
	}

}
