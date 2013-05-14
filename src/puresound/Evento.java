package puresound;

import java.util.Calendar;

public abstract class Evento implements Comparable<String> {
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

	public int compareTo(String pNombre) {
		return (this.getNombre().compareTo(pNombre));
	}
}