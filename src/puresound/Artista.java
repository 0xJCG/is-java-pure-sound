package puresound;

import java.util.Calendar;

public abstract class Artista implements Comparable<Artista> {
	private String nombre;
	private Calendar fechaFormacion;
	private boolean enActivo;
	private Discografica discografica;
	private ListaDiscos discografia;
	
	public Artista(String pNombre, Calendar pFechaFormacion, Discografica pDiscografica) {
		this.nombre = pNombre;
		this.fechaFormacion = pFechaFormacion;
		this.enActivo = true;
		this.discografica = pDiscografica;
		this.discografia = new ListaDiscos();
	}
	
	public ListaDiscos getDiscografia() {
		return this.discografia;
	}
	
	public boolean estaActivo() {
		return this.enActivo;
	}
	
	private void setEnActivo(boolean pEnActivo) {
		this.enActivo = pEnActivo;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public Calendar getFechaFormacion() {
		return this.fechaFormacion;
	}
	
	public Discografica getDiscografica() {
		return this.discografica;
	}
	
	public void addDisco(Disco pDisco){
		this.getDiscografia().addDisco(pDisco);
	}
	
	public void removeDisco(String pNombre){
		this.getDiscografia().removeDisco(pNombre);
	}
	
	public void removeDisco(Disco pDisco){
		this.getDiscografia().removeDisco(pDisco);
	}
	
	public Disco buscarDisco(String pNombre){
		return this.getDiscografia().buscarDisco(pNombre);
	}
	
	public void cambiarEstado() {
		if (this.estaActivo())
			this.setEnActivo(false);
		else
			this.setEnActivo(true);	
	}
	
	public void mostrarDatos(){
		System.out.println("Nobre:" + this.getNombre());
		System.out.println("Fecha de formacion:" + this.getFechaFormacion());
		System.out.println("En activo: ");
		System.out.println((this.estaActivo())?"Si":"No");
	}
	
	public int compareTo(Artista pArtista) {
		return (this.getNombre().compareTo(pArtista.getNombre()));
	}
}