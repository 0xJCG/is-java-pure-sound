package puresound;

import net.sf.jga.fn.UnaryFunctor;

@SuppressWarnings("serial")
public class FiltrarPorNombre extends UnaryFunctor<Artista, Boolean>{
	private String nombre;
	
	public FiltrarPorNombre(String pNombre) {
		this.nombre = pNombre;
	}

	private String getNombre() {
		return this.nombre;
	}

	public Boolean fn(Artista pArtista) {
		return this.getNombre().compareTo(pArtista.getNombre()) == 0;
	}
}