package puresound;

import java.util.Iterator;
import java.util.Observable;

public class ListaArtistasTotal extends Observable implements Iterable<Artista> {
	private static ListaArtistasTotal mListaArtistasTotal = new ListaArtistasTotal();
	private ListaArtistas lista;

	private ListaArtistasTotal() {
		this.lista = new ListaArtistas();
	}
	
	public static ListaArtistasTotal getListaArtistasTotal() {
		return mListaArtistasTotal;
	}
	
	private ListaArtistas getLista() {
		return ListaArtistasTotal.getListaArtistasTotal().lista;
	}
	
	public void addArtista(Artista pArtista) {
		this.getLista().addArtista(pArtista);
	}
	
	public boolean removeArtista(String pNombre) {
		return this.getLista().removeArtista(pNombre);
	}
	
	public boolean remove(Artista pArtista) {
		return this.getLista().remove(pArtista);
	}
	
	public Artista buscarArtista(String pNombre) {
		return this.getLista().buscarArtista(pNombre);
	}
	
	public void mostrarDatos(){
		this.getLista().mostrarDatos();
	}
	
	public void mostrarDatosArtista(String pNombre) {
		this.getLista().mostrarDatosArtista(pNombre);
	}
	
	public void OrdenarPorNombreA() {
		/* Avisa a los observadores de algún cambio. */
		setChanged();
		notifyObservers();
		this.getLista().OrdenarPorNombreA();
	} 
	
	public Iterable<Artista> filtrarPorDiscografica(Discografica pDiscografica) {
		return this.getLista().filtrarPorDiscografica(pDiscografica);
	}
	
	public Iterator<Artista> iterator() {
		return this.getLista().iterator();
	}
}