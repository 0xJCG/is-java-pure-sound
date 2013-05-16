package puresound;

import java.util.ArrayList;
import java.util.Iterator;

import net.sf.jga.algorithms.Filter;

public class ListaDiscos {
	private ArrayList<Disco> lista;

	public ListaDiscos() {
		this.lista = new ArrayList<Disco>();
	}

	public ArrayList<Disco> getLista() {
		return this.lista;
	}
	
	private Iterator<Disco> getIterator() {
		return this.getLista().iterator();
	}
	
	public void addDisco(Disco pDisco) {
		this.getLista().add(pDisco);
	}
	
	public boolean removeDisco(String pNombre) {
		Disco disco = this.buscarDisco(pNombre);
		if (disco != null)
			return this.removeDisco(disco);
		return false;
	}
	
	public boolean removeDisco(Disco pDisco) {
		return this.getLista().remove(pDisco);
	}
	
	public Disco buscarDisco(String pNombre) {
		Disco disco = null;
		Iterator<Disco> it = this.getIterator();
		boolean salir = false;
		while (it.hasNext() && !salir) {
			disco = it.next();
			if (disco.getNombre().compareTo(pNombre) == 0)
				salir = true;
		}
		return (salir)?disco:null;
	}
	
	public Cancion buscarCancion(String pDisco, String pCancion) {
		return this.buscarDisco(pDisco).buscarCancion(pCancion);
	}
	
	public Iterable<Disco> filtrarPorFormato(Formato pFormato) {
		return Filter.filter(this.getLista(), new FiltrarPorFormato(pFormato));
	}
}