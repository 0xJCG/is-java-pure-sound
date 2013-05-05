package puresound;

import java.util.Date;

public class FestivalFuturo extends Festival implements Futuro {
	private int aforo;
	private String anuncio;
	
	public FestivalFuturo(String pNombre, Date pFecha, String pLugar, int pAforo, String pAnuncio) {
		super(pNombre, pFecha, pLugar);
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