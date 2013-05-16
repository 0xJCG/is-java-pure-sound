package gui;

import java.util.Calendar;
import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JLabel;

import puresound.Artista;
import puresound.Discografica;
import puresound.Grupo;
import puresound.ListaArtistasFavoritos;
import puresound.Musico;
import puresound.Rol;
import puresound.Solista;

@SuppressWarnings("serial")
public class User extends JPanel implements Observer {
	private JLabel lblUser = new JLabel("Panel de Usuario");
	private JLabel lblDatos = new JLabel("Datos");
	
	/**
	 * Create the panel.
	 */
	public User(ListaArtistasFavoritos model) {
		add(lblUser);
		add(lblDatos);
		
		Calendar fecha = Calendar.getInstance();
		Musico m1 = new Musico("Musico", fecha, "Francia", Rol.BAJO);
		Discografica d1 = new Discografica("Discografica", 1993);
		Grupo g1= new Grupo("Grupo", fecha, d1);
		Solista s1= new Solista("Solista", fecha, m1, d1);
		
		ListaArtistasFavoritos.getListaArtistasFavoritos().addArtista(g1);
		ListaArtistasFavoritos.getListaArtistasFavoritos().addArtista(s1);
		
		model.addObserver(this);
		mostrarArtistas(model.iterator());
	}

	public void update(Observable fav, Object arg1) {
		ListaArtistasFavoritos favoritos = (ListaArtistasFavoritos) fav;
		mostrarArtistas(favoritos.iterator());
	}
	
	private void mostrarArtistas(Iterator<Artista> it) {
		int salir = 0;
		Artista ar = null;
		String textoAMostrar = "";
		while (it.hasNext() && salir < 10) {
			ar = it.next();
			textoAMostrar += "Artista: " + ar.getNombre() + ".\nDiscografica: " + ar.getDiscografica().getNombre() + ".\n";
			salir++;
		}
		this.lblDatos.setText(textoAMostrar);
	}
}