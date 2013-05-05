package PureSound;

import java.util.Observable;
import java.util.Observer;
import java.util.TreeSet;

public class ListaArtistas implements Observer {
	private TreeSet<Artista> lista;

	public ListaArtistas() {
		this.lista = new TreeSet<Artista>();
	}

	public TreeSet<Artista> getLista() {
		return this.lista;
	}

	@Override
	public void update(Observable o, Object arg) {
		// TODO Auto-generated method stub
		
	}
}