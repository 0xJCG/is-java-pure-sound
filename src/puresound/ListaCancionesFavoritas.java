package puresound;

import java.util.Iterator;

public class ListaCancionesFavoritas implements Iterable<Cancion> {
	private static ListaCancionesFavoritas mListaCancionesFavoritas = new ListaCancionesFavoritas();
	private ListaCanciones lista;
	
	public ListaCancionesFavoritas() {
		this.lista = new ListaCanciones();
	}
	
	public static ListaCancionesFavoritas getListaCancionesFavoritas() {
		return mListaCancionesFavoritas;
	}
	
	private ListaCanciones getLista() {
		return ListaCancionesFavoritas.getListaCancionesFavoritas().lista;
	}
	
	public void addCancion(Cancion pCancion) {
		this.getLista().addCancion(pCancion);
	}
	
	public boolean removeCancion(String pNombre) {
		return this.getLista().removeCancion(pNombre);
	}
	
	public boolean remove(Cancion pCancion) {
		return this.getLista().remove(pCancion);
	}
	
	public Cancion buscarCancion(String pNombre) {
		return this.getLista().buscarCancion(pNombre);
	}
	
	public Iterable<Cancion> filtrarPorGenero(Genero pGenero) {
		return this.getLista().filtrarPorGenero(pGenero);
	}

	@Override
	public Iterator<Cancion> iterator() {
		return this.getLista().iterator();
	}
}