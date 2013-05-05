package PureSound;

public abstract class Artista {
	private String nombre;

	public Artista(String pNombre) {
		this.nombre = pNombre;
	}

	public String getNombre() {
		return this.nombre;
	}
}