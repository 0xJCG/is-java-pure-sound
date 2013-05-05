package puresound;

import java.util.Iterator;
import java.util.TreeSet;

public class ListaCanciones {
	private TreeSet<Cancion> lista;

	public ListaCanciones() {
		this.lista = new TreeSet<Cancion>();
	}
	
	public TreeSet<Cancion> getLista() {
		return this.lista;
	}
	
	public void addCancion(Cancion pCancion) {
		if (!this.getLista().contains(pCancion))
			this.getLista().add(pCancion);
	}
	
	public void removeCancion(String pNombre) {
		Cancion cancion = this.buscarCancion(pNombre);
		if (cancion != null)
			this.getLista().remove(cancion);
	}
	
	public Cancion buscarCancion(String pNombre) {
		Cancion cancion = null;
		Iterator<Cancion> it = this.getIterador();
		boolean salir = false;
		while (it.hasNext() && salir) {
			cancion = it.next();
			if (cancion.compareTo(pNombre) == 0)
				salir = true;
		}
		return (salir)?cancion:null;
	}
	
	/*private Cancion getCancion(String pNombre) {
		return null;
	}*/
	
	private Iterator<Cancion> getIterador(){
		return lista.iterator();
	}
	
	public void mostrarDatos(){
		Iterator<Cancion> it = this.getIterador();
		while (it.hasNext()) {
			it.next().mostrarDatos();
		}
	}
	
	public Iterable<Cancion> filtrarPorGenero(Genero pGenero) {
		return null;
	}	
}