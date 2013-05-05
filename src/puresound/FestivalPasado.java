package puresound;

import java.util.Date;

public class FestivalPasado extends Festival implements Pasado {
	private Puntuacion puntuacion;
	private String resumen;
	private int asistenciaFinal;
	
	public FestivalPasado(String pNombre, Date pFecha, String pLugar, String pResumen, int pAsistenciaFinal) {
		super(pNombre, pFecha, pLugar);
		this.resumen = pResumen;
		this.asistenciaFinal = pAsistenciaFinal;
		this.puntuacion = null;
	}

	public String verResumen() {
		return this.resumen;
	}

	public int verAsistenciaFinal() {
		return this.asistenciaFinal;
	}

	public Puntuacion getPuntuacion() {
		return this.puntuacion;
	}
	
	private void setPuntuacion(Puntuacion pPuntuacion) {
		this.puntuacion = pPuntuacion;
	}

	public void addPuntuacion(Puntuacion pPuntuacion) {
		this.setPuntuacion(pPuntuacion);
	}
	
	public void removePuntuacion() {
		this.setPuntuacion(null);
	}
}