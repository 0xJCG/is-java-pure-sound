package gui;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import puresound.Cancion;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.Color;
import java.awt.Font;

@SuppressWarnings("serial")
public class Reproductor extends JDialog {
	public Reproductor(Cancion pCancion) {
		setTitle("Reproductor");
		getContentPane().setBackground(new Color(255, 255, 255));
		
		getContentPane().setLayout(new BorderLayout());
		
		JLabel lblTitulo = new JLabel(pCancion.getNombre());
		lblTitulo.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblTitulo.setBackground(new Color(255, 255, 255));
		lblTitulo.setForeground(new Color(30, 144, 255));
		getContentPane().add(lblTitulo, BorderLayout.NORTH);
		
		JButton btnStop = new JButton("Stop");
		btnStop.setForeground(new Color(30, 144, 255));
		btnStop.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnStop.setBackground(new Color(255, 255, 255));
		getContentPane().add(btnStop, BorderLayout.WEST);
		
		JButton btnPlay = new JButton("Play");
		btnPlay.setForeground(new Color(30, 144, 255));
		btnPlay.setBackground(new Color(255, 255, 255));
		btnPlay.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		getContentPane().add(btnPlay, BorderLayout.EAST);
		
		JLabel lblLetra = new JLabel(pCancion.getLetra());
		lblLetra.setForeground(new Color(30, 144, 255));
		lblLetra.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		lblLetra.setBackground(new Color(255, 255, 255));
		getContentPane().add(lblLetra, BorderLayout.CENTER);
	}
}