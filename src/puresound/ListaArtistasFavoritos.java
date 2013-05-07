package puresound;

import java.util.Observable;

public class ListaArtistasFavoritos extends Observable {
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
		this.getLista().addArtista(pArtista);
	}
	
	public void removeArtista(String pNombre) {
		this.getLista().removeArtista(pNombre);
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
	
	public Iterable<Artista> filtrarPorDiscografica(Discografica pDiscografica) {
		return this.getLista().filtrarPorDiscografica(pDiscografica);
	}
	
	public Iterable<Artista> filtrarPorNombre(String pNombre) {
		return this.getLista().filtrarPorNombre(pNombre);
	}
}