package gui;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JProgressBar;

import puresound.CargaDeDatos;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

@SuppressWarnings("serial")
public class Carga extends JPanel {

	/**
	 * Create the panel.
	 */
	public Carga() {
		JButton btnCargar = new JButton("Cargar");
		JProgressBar progressBar = new JProgressBar();
		btnCargar.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				CargaDeDatos.getCargaDeDatos().cargar();
			}
		});
		add(btnCargar);
		add(progressBar);
	}
}