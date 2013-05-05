package puresound;

import java.util.Date;

public abstract class Evento implements Comparable<String> {
	private String nombre;
	private Date fecha;
	private String lugar;
	
	public Evento(String pNombre, Date pFecha, String pLugar) {
		this.nombre = pNombre;
		this.fecha = pFecha;
		this.lugar = pLugar;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public Date getFecha() {
		return this.fecha;
	}

	public String getLugar() {
		return this.lugar;
	}

	public int compareTo(String pNombre) {
		return (this.getNombre().compareTo(pNombre));
	}
}