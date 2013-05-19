package gui;

import java.awt.Color;

import javax.swing.BoxLayout;
import javax.swing.JDialog;
import javax.swing.JButton;
import javax.swing.JTextField;
import javax.swing.JComboBox;

@SuppressWarnings("serial")
public class Busqueda extends JDialog {
	public Busqueda() {
		setTitle("Búsqueda");
		getContentPane().setBackground(new Color(255, 255, 255));
		
		getContentPane().setLayout(new BoxLayout(this.getContentPane(), BoxLayout.Y_AXIS));
		
		JTextField txtTexto = new JTextField();
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
	}
}