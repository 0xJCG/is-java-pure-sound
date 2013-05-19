package gui;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import puresound.Cancion;
import javax.swing.JLabel;
import javax.swing.JButton;

@SuppressWarnings("serial")
public class Reproductor extends JDialog {
	public Reproductor(Cancion pCancion) {
		setTitle("Reproductor");
		
		getContentPane().setLayout(new BorderLayout());
		
		JLabel lblTitulo = new JLabel(pCancion.getNombre());
		getContentPane().add(lblTitulo, BorderLayout.NORTH);
		
		JButton btnStop = new JButton("Stop");
		getContentPane().add(btnStop, BorderLayout.WEST);
		
		JButton btnPlay = new JButton("Play");
		getContentPane().add(btnPlay, BorderLayout.EAST);
		
		JLabel lblLetra = new JLabel(pCancion.getLetra());
		getContentPane().add(lblLetra, BorderLayout.CENTER);
	}
}