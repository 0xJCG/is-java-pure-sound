package puresound;

import java.util.Calendar;

public abstract class Concierto extends Evento {
	private Artista artista;
	
	public Concierto(String pNombre, Calendar pFecha, String pLugar, Artista pArtista) {
		super(pNombre, pFecha, pLugar);
		this.artista = pArtista;
	}

	public Artista getArtista() {
		return this.artista;
	}
}