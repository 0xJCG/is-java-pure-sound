package gui;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JLabel;
import javax.swing.JPanel;

import puresound.Artista;
import puresound.ListaArtistasTotal;

@SuppressWarnings("serial")
public class Artistas extends JPanel implements Observer {
	private JLabel lblArtistas = new JLabel("Artistas");
	private JLabel lblDatos = new JLabel("Datos");
	
	/**
	 * Create the panel.
	 */
	public Artistas(ListaArtistasTotal model) {
		add(lblArtistas);
		add(lblDatos);
		
		model.addObserver(this);
		mostrarArtistas(model.iterator());
	}
	
	public void update(Observable art, Object arg1) {
		ListaArtistasTotal artistas = (ListaArtistasTotal) art;
		mostrarArtistas(artistas.iterator());
	}
	
	private void mostrarArtistas(Iterator<Artista> it) {
		int salir = 0;
		Artista ar = null;
		String textoAMostrar = "";
		while (it.hasNext() && salir < 10) {
			ar = it.next();
			textoAMostrar += "Artista: " + ar.getNombre();// + ".\nDiscografica: " + ar.getDiscografica().getNombre() + ".\n";
			salir++;
		}
		this.lblDatos.setText(textoAMostrar);
	}
}