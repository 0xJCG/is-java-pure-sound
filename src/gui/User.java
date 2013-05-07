package gui;

import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JLabel;

import puresound.ListaArtistasFavoritos;

@SuppressWarnings("serial")
public class User extends JPanel implements Observer {

	/**
	 * Create the panel.
	 */
	public User() {
		JLabel lblUser = new JLabel("Panel de Usuario");
		add(lblUser);
	}

	public void update(Observable fav, Object arg1) {
		ListaArtistasFavoritos favoritos = (ListaArtistasFavoritos) fav;
		favoritos.filtrarPorNombre("Prueba");
	}
}