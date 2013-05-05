package puresound;

import java.util.Date;

public class ConciertoFuturo extends Concierto implements Futuro {
	private int aforo;
	private String anuncio;
	
	public ConciertoFuturo(String pNombre, Date pFecha, String pLugar, Artista pArtista, int pAforo, String pAnuncio) {
		super(pNombre, pFecha, pLugar, pArtista);
		this.aforo = pAforo;
		this.anuncio = pAnuncio;
	}

	public String verAnuncio() {
		return this.anuncio;
	}

	public int verAforo() {
		return this.aforo;
	}
}