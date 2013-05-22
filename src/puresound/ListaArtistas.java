package puresound;

import java.util.ArrayList;
import java.util.Iterator;

import net.sf.jga.algorithms.Filter;
import net.sf.jga.algorithms.Sort;

public class ListaArtistas implements Iterable<Artista> {
	private ArrayList<Artista> lista;
	
	public ListaArtistas() {
		this.lista = new ArrayList<Artista>(); 
	}
	
	private ArrayList<Artista> getLista() {
		return this.lista;
	}
	
	private Iterator<Artista> getIterador(){
		return this.getLista().iterator();
	}
	
	public Artista addArtista(Artista pArtista) {
		if (!this.getLista().contains(pArtista)) {
			this.getLista().add(pArtista);
			return pArtista;
		}
		return null;
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
		while (it.hasNext() && !salir) {
			artista = it.next();
			if (artista.getNombre().compareTo(pNombre) == 0)
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
	
	public void OrdenarPorNombreA() {
		this.lista = (ArrayList<Artista>) Sort.sort(this, new OrdenarPorNombreA());
	} 
	
	public Iterable<Artista> filtrarPorDiscografica(Discografica pDiscografica) {
		return Filter.filter(this, new FiltrarPorDiscografica(pDiscografica));
	}

	public Iterator<Artista> iterator() {
		return this.getIterador();
	}
	
	public boolean esta(Artista pArtista) {
		return this.getLista().contains(pArtista);
	}
}