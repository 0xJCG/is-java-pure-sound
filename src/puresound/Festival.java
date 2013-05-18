package puresound;

import java.util.Calendar;

public abstract class Festival extends Evento {
	private ListaArtistas listaArtistas;
	
	public Festival(String pNombre, Calendar pFecha, String pLugar) {
		super(pNombre, pFecha, pLugar);
		this.listaArtistas = new ListaArtistas();
	}

	public ListaArtistas getListaArtistas() {
		return this.listaArtistas;
	}
	
	public void addArtista(Artista pArtista) {
		this.getListaArtistas().addArtista(pArtista);
	}
	
	public boolean removeArtista(String pNombre) {
		return this.getListaArtistas().removeArtista(pNombre);
	}
	
	public boolean remove(Artista pArtista) {
		return this.getListaArtistas().remove(pArtista);
	}
}