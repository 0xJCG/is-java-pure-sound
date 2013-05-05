 package puresound;

import java.util.Date;

public class Musico implements Comparable<String> {
	private String nombre;
	private Date fechaNac;
	private String nacionalidad;
	private Rol rol;
	
	public Musico(String pNombre, Date pFechaNac, String pNacionalidad, Rol pRol) {
		this.nombre = pNombre;
		this.fechaNac = pFechaNac;
		this.nacionalidad = pNacionalidad;
		this.rol = pRol;
	}
	
	public String getNombre() {
		return this.nombre;
	}

	public Date getFechaNac() {
		return this.fechaNac;
	}

	public String getNacionalidad() {
		return this.nacionalidad;
	}

	public Rol getRol() {
		return this.rol;
	}
	
	public void mostrarDatos() {
		System.out.println("Nombre: " + this.getNombre());
		System.out.println("Fecha de nacimiento: " + this.getFechaNac());
		System.out.println("Nacionalidad: " + this.getNacionalidad());
		System.out.println("Rol: " + this.getRol());
	}

	public int compareTo(String pNombre) {
		return (this.getNombre().compareTo(pNombre));
	}
}