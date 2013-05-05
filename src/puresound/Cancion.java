package puresound;

public class Cancion implements Comparable<String> {
	private String nombre;
	private Puntuacion puntuacion;
	private Genero genero;
	private String letra; 
	
	public Cancion(String pNombre, Puntuacion pPuntuacion, Genero pGenero, String pLetra) {
		this.puntuacion = pPuntuacion;
		this.nombre = pNombre;
		this.genero = pGenero;
		this.letra = pLetra;
	}

	public String getNombre() {
		return this.nombre;
	}

	public Puntuacion getPuntuacion() {
		return this.puntuacion;
	}

	public Genero getGenero() {
		return this.genero;
	}

	public String getLetra() {
		return this.letra;
	}
	
	public void mostrarDatos(){
		System.out.println("Nombre:" + this.getNombre());
		System.out.println("Genero:" + this.getGenero());
		System.out.println("Letra:" + this.getLetra());
		System.out.println("Puntuacion:");
		this.getPuntuacion().mostrarDatos();
	}

	public int compareTo(String pNombre) {
		return (this.getNombre().compareTo(pNombre));
	}
}
