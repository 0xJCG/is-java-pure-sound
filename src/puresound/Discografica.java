package puresound;

public class Discografica {
	private String nombre;
	private int anio;
	
	public Discografica(String pNombre, int pAnio) {
		this.nombre = pNombre;
		this.anio = pAnio;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public int getAnio() {
		return this.anio;
	}
}