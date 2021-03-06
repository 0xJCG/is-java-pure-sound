package puresound;

import java.util.Calendar;

public class Grupo extends Artista {
	private ListaMusicos integrantes;
	public Grupo(String pNombre, Calendar pFechaFormacion, Discografica pDiscografica) {
		super(pNombre, pFechaFormacion, pDiscografica);
		this.integrantes = new ListaMusicos();
	}
	
	public ListaMusicos getIntegrantes(){
		return this.integrantes;
	}
	
	public void addIntegrante(Musico pMusico){
		this.getIntegrantes().addMusico(pMusico);
	}
	
	public boolean removeIntegrante(String pNombre){
		return this.getIntegrantes().removeMusico(pNombre);
	}
	
	public boolean removeIntegrante(Musico pMusico){
		return this.getIntegrantes().remove(pMusico);
	}
	
	public void reemplazarIntegrante(String pNombre, Musico pMusico){
		this.getIntegrantes().reemplazarIntegrante(pNombre, pMusico);
	}
	
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Integrantes: ");
		this.getIntegrantes().mostrarDatos();
	}
}