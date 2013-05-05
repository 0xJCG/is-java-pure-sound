package puresound;

public class ListaCancionesFavoritas {
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
	
	public void removeCancion(String pNombre) {
		this.getLista().removeCancion(pNombre);
	}
	
	public Cancion buscarCancion(String pNombre) {
		return this.getLista().buscarCancion(pNombre);
	}
	
	public Iterable<Cancion> filtrarPorGenero(Genero pGenero) {
		return this.getLista().filtrarPorGenero(pGenero);
	}
}