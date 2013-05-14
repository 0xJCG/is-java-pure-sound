package puresound;

import java.util.Iterator;
import java.util.TreeSet;

public class ListaMusicos {
	private TreeSet<Musico> lista;
	
	public ListaMusicos() {
		this.lista = new TreeSet<Musico>();
	}

	public TreeSet<Musico> getLista() {
		return this.lista;
	}
	
	private Iterator<Musico> getIterator() {
		return this.getLista().iterator();
	}
	
	public void addMusico(Musico pMusico) {
		this.getLista().add(pMusico);
	}
	
	public boolean removeMusico(String pNombre) {
		Musico musico = this.buscarMusico(pNombre);
		if (musico != null)
			return this.remove(musico);
		return false;
	}
	
	public boolean remove(Musico pMusico) {
		return this.getLista().remove(pMusico);
	}
	
	private Musico buscarMusico(String pNombre) {
		Musico musico = null;
		Iterator<Musico> it = this.getIterator();
		boolean salir = false;
		while (it.hasNext() && salir) {
			musico = it.next();
			if (musico.compareTo(pNombre) == 0)
				salir = true;
		}
		return (salir)?musico:null;
	}
	
	public void reemplazarIntegrante(String pNombre, Musico pMusico) {
		if (this.removeMusico(pNombre))
			this.addMusico(pMusico);
	}
	
	public void mostrarDatos() {
		Iterator<Musico> it = this.getIterator();
		while (it.hasNext()) {
			it.next().mostrarDatos();
		}
	}
}