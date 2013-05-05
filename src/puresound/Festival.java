package puresound;

import java.util.Date;

public abstract class Festival extends Evento {
	private ListaArtistas listaArtistas;
	
	public Festival(String pNombre, Date pFecha, String pLugar) {
		super(pNombre, pFecha, pLugar);
		this.listaArtistas = new ListaArtistas();
	}

	private ListaArtistas getListaArtistas() {
		return this.listaArtistas;
	}
	
	public void addArtista(Artista pArtista) {
		this.getListaArtistas().addArtista(pArtista);
	}
	
	public void removeArtista(String pNombre) {
		this.getListaArtistas().removeArtista(pNombre);
	}
}