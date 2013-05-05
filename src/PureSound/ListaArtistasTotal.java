package PureSound;

public class ListaArtistasTotal {
	private static ListaArtistasTotal miListaArtistasTotal = new ListaArtistasTotal();
	private ListaArtistas lista;

	private ListaArtistasTotal() {
		this.lista = new ListaArtistas();
	}

	public static ListaArtistasTotal getListaAlumnosCurso() {
		return miListaArtistasTotal;
	}
}