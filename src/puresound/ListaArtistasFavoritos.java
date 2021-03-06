package puresound;

import java.util.Iterator;
import java.util.Observable;

public class ListaArtistasFavoritos extends Observable implements Iterable<Artista> {
	private static ListaArtistasFavoritos miListaArtistasFavoritos = new ListaArtistasFavoritos();
	private ListaArtistas lista;

	private ListaArtistasFavoritos() {
		this.lista = new ListaArtistas();
	}

	public static ListaArtistasFavoritos getListaArtistasFavoritos() {
		return miListaArtistasFavoritos;
	}
	
	private ListaArtistas getLista() {
		return ListaArtistasFavoritos.getListaArtistasFavoritos().lista;
	}
	
	public void addArtista(Artista pArtista) {
		/* Avisa a los observadores de algún cambio. */
		setChanged();
		notifyObservers(this.getLista().addArtista(pArtista));
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
		this.getLista().OrdenarPorNombreA();
	}
	
	public Iterable<Artista> filtrarPorDiscografica(Discografica pDiscografica) {
		return this.getLista().filtrarPorDiscografica(pDiscografica);
	}
	
	public Iterator<Artista> iterator() {
		return this.getLista().iterator();
	}
	
	public boolean esta(Artista pArtista) {
		return this.getLista().esta(pArtista);
	}
}