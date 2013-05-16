package puresound;

import java.util.ArrayList;
import java.util.Iterator;

import net.sf.jga.algorithms.Filter;

public class ListaCanciones {
	private ArrayList<Cancion> lista;

	public ListaCanciones() {
		this.lista = new ArrayList<Cancion>();
	}
	
	public ArrayList<Cancion> getLista() {
		return this.lista;
	}
	
	public void addCancion(Cancion pCancion) {
		this.getLista().add(pCancion);
	}
	
	public boolean removeCancion(String pNombre) {
		Cancion cancion = this.buscarCancion(pNombre);
		if (cancion != null)
			return this.remove(cancion);
		return false;
	}
	
	public boolean remove(Cancion pCancion) {
		return this.getLista().remove(pCancion);
	}
	
	public Cancion buscarCancion(String pNombre) {
		Cancion cancion = null;
		Iterator<Cancion> it = this.getIterador();
		boolean salir = false;
		while (it.hasNext() && !salir) {
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
		return Filter.filter(this.getLista(), new FiltrarPorGenero(pGenero));
	}	
}