package puresound;

public class Disco implements Comparable<String> {
	private String nombre;
	private int anio;
	private ListaCanciones canciones;
	private Formato formato;
	
	public Disco(String pNombre, int pAnio, Formato pFormato) {
		this.nombre = pNombre;
		this.anio = pAnio;
		this.formato = pFormato;
		this.canciones = new ListaCanciones();
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public int getAnio() {
		return this.anio;
	}
	
	public ListaCanciones getCanciones() {
		return this.canciones;
	}
	
	public Formato getFormato() {
		return this.formato;
	}
	
	public void addCancion(Cancion pCancion){
		this.getCanciones().getLista().add(pCancion);
	}
	
	public void removeCancion(String pNombre) {
		this.getCanciones().removeCancion(pNombre);
	}
	
	public Cancion buscarCancion(String pNombre) {
		return this.getCanciones().buscarCancion(pNombre);
	}
	
	public void mostrarDatos(){
		System.out.println("Nombre: " + this.getNombre());
		System.out.println("Anio: " + this.getAnio());
		System.out.println("Formato: " + this.getFormato());
		System.out.println("Canciones: ");
		this.getCanciones().mostrarDatos();
	}
	
	public int compareTo(String pNombre) {
		return (this.getNombre().compareTo(pNombre));
	}
}