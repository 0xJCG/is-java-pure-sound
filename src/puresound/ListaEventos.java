package puresound;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.Observable;

import net.sf.jga.algorithms.Filter;
import net.sf.jga.algorithms.Sort;

public class ListaEventos extends Observable implements Iterable<Evento> {
	private static ListaEventos mListaEventos = new ListaEventos();
	private ArrayList<Evento> lista;

	private ListaEventos() {
		this.lista = new ArrayList<Evento>();
	}
	
	public static ListaEventos getListaEventos() {
		return mListaEventos;
	}
	
	private ArrayList<Evento> getLista() {
		return ListaEventos.getListaEventos().lista;
	}
	
	private Iterator<Evento> getIterator() {
		return this.getLista().iterator();
	}
	
	public void addEvento(Evento pEvento) {
		this.getLista().add(pEvento);
	}
	
	public boolean removeEvento(String pNombre) {
		Evento evento = this.buscarEvento(pNombre);
		if (evento != null)
			return this.remove(evento);
		return false;
	}
	
	public boolean remove(Evento pEvento) {
		return this.getLista().remove(pEvento);
	}
	
	public Evento buscarEvento(String pNombre) {
		Evento evento = null;
		Iterator<Evento> it = this.getIterator();
		boolean salir = false;
		while (it.hasNext() && !salir) {
			evento = it.next();
			if (evento.getNombre().compareTo(pNombre) == 0)
				salir = true;
		}
		return (salir)?evento:null;
	}
	
	public void OrdenarPorNombreE() {
		this.lista = (ArrayList<Evento>) Sort.sort(this.getLista(), new OrdenarPorNombreE());
	}
	
	public Iterable<Evento> filtrarProximosEventos() {
		return Filter.filter(this.getLista(), new FiltrarProximosEventos());
	}
	
	public Iterable<Evento> filtrarEventosPasados() {
		return Filter.filter(this.getLista(), new FiltrarEventosPasados());
	}
	
	public Iterator<Evento> iterator() {
		return this.getLista().iterator();
	}
}