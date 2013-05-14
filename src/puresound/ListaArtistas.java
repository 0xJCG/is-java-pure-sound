package puresound;

import java.util.Iterator;
import java.util.TreeSet;

import net.sf.jga.algorithms.Filter;

public class ListaArtistas {
	private TreeSet<Artista> lista;
	
	public ListaArtistas() {
		this.lista = new TreeSet<Artista>(); 
	}
	
	public TreeSet<Artista> getLista() {
		return this.lista;
	}
	
	private Iterator<Artista> getIterador(){
		return this.getLista().iterator();
	}
	
	public void addArtista(Artista pArtista) {
		this.getLista().add(pArtista);
	}
	
	public boolean removeArtista(String pNombre) {
		Artista artista = this.buscarArtista(pNombre);
		if (artista != null)
			return this.remove(artista);
		return false;
	}
	
	public boolean remove(Artista pArtista) {
		return this.getLista().remove(pArtista);
	}
	
	public Artista buscarArtista(String pNombre) {
		Artista artista = null;
		Iterator<Artista> it = this.getIterador();
		boolean salir = false;
		while (it.hasNext() && salir) {
			artista = it.next();
			if (artista.compareTo(pNombre) == 0)
				salir = true;
		}
		return (salir)?artista:null;
	}
	
	public void mostrarDatos(){
		Iterator<Artista> it = this.getIterador();
		while (it.hasNext()) {
			it.next().mostrarDatos();
		}
	}
	
	public void mostrarDatosArtista(String pNombre) {
		this.buscarArtista(pNombre).mostrarDatos();
	}
	
	public Iterable<Artista> filtrarPorDiscografica(Discografica pDiscografica) {
		return Filter.filter(this.getLista(), new FiltrarPorDiscografica(pDiscografica));
	}
	
	public Iterable<Artista> filtrarPorNombre(String pNombre) {
		return Filter.filter(this.getLista(), new FiltrarPorNombre(pNombre));
	}
}