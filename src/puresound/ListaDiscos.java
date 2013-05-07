package puresound;

import java.util.Iterator;
import java.util.TreeSet;

import net.sf.jga.algorithms.Filter;

public class ListaDiscos {
	private TreeSet<Disco> lista;

	public ListaDiscos() {
		this.lista = new TreeSet<Disco>();
	}

	public TreeSet<Disco> getLista() {
		return this.lista;
	}
	
	private Iterator<Disco> getIterator() {
		return this.getLista().iterator();
	}
	
	public void addDisco(Disco pDisco) {
		if (!this.getLista().contains(pDisco))
			this.getLista().add(pDisco);
	}
	
	public void removeDisco(String pNombre) {
		Disco disco = this.buscarDisco(pNombre);
		if (disco != null)
			this.getLista().remove(disco);
	}
	
	public Disco buscarDisco(String pNombre) {
		Disco disco = null;
		Iterator<Disco> it = this.getIterator();
		boolean salir = false;
		while (it.hasNext() && salir) {
			disco = it.next();
			if (disco.compareTo(pNombre) == 0)
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