package puresound;

import java.util.Iterator;
import java.util.TreeSet;

public class ListaEventos {
	private static ListaEventos mListaEventos = new ListaEventos();
	private TreeSet<Evento> lista;

	private ListaEventos() {
		this.lista = new TreeSet<Evento>();
	}
	
	public static ListaEventos getListaEventos() {
		return mListaEventos;
	}
	
	private TreeSet<Evento> getLista() {
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
	
	private Evento buscarEvento(String pNombre) {
		Evento evento = null;
		Iterator<Evento> it = this.getIterator();
		boolean salir = false;
		while (it.hasNext() && salir) {
			evento = it.next();
			if (evento.compareTo(pNombre) == 0)
				salir = true;
		}
		return (salir)?evento:null;
	}
	
	public Iterable<Evento> filtrarProximosEventos() {
		return null;
	}
	
	public Iterable<Evento> filtrarEventosPasados() {
		return null;
	}
	
	public Iterable<Evento> filtrarPorArtista(Artista pArtista) {
		return null;
	}
}