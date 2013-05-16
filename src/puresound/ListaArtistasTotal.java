package puresound;

public class ListaArtistasTotal {
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
	
	public Iterable<Artista> OrdenarPorNombreA() {
		return this.getLista().OrdenarPorNombreA();
	} 
	
	public Iterable<Artista> filtrarPorDiscografica(Discografica pDiscografica) {
		return this.getLista().filtrarPorDiscografica(pDiscografica);
	}
}