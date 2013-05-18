package gui;

import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JButton;

import puresound.CargaDeDatos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;

@SuppressWarnings("serial")
public class Carga extends JPanel {

	/**
	 * Create the panel.
	 */
	public Carga() {
		JButton btnCargar = new JButton("Cargar");
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				JFileChooser chooser = new JFileChooser();
				chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
				chooser.setAcceptAllFileFilterUsed(false);
				int opcion = chooser.showSaveDialog(chooser);
				if (opcion == JFileChooser.APPROVE_OPTION) {
					CargaDeDatos.getCargaDeDatos().cargar(chooser.getSelectedFile().getAbsolutePath());
					JOptionPane.showMessageDialog(null, "Datos cargados. Para continuar vaya a Mostrar->Datos.");
				}
			}
		});
		
		JLabel lblSeleccionaLaCarpeta = new JLabel("Selecciona la carpeta que contiene los archivos XML:");
		add(lblSeleccionaLaCarpeta);
		add(btnCargar);
	}
}