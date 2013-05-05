package PureSound;

public class ListaArtistasFavoritos {
	private static ListaArtistasFavoritos miListaArtistasFavoritos = new ListaArtistasFavoritos();
	private ListaArtistas lista;

	private ListaArtistasFavoritos() {
		this.lista = new ListaArtistas();
	}

	public static ListaArtistasFavoritos getListaAlumnosCurso() {
		return miListaArtistasFavoritos;
	}
}