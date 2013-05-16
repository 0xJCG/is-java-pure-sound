package puresound;

import java.util.Calendar;

public abstract class Evento implements Comparable<Evento> {
	private String nombre;
	private Calendar fecha;
	private String lugar;
	
	public Evento(String pNombre, Calendar pFecha, String pLugar) {
		this.nombre = pNombre;
		this.fecha = pFecha;
		this.lugar = pLugar;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public Calendar getFecha() {
		return this.fecha;
	}

	public String getLugar() {
		return this.lugar;
	}

	public int compareTo(Evento pEvento) {
		return (this.getNombre().compareTo(pEvento.getNombre()));
	}
}