package puresound;

import net.sf.jga.fn.UnaryFunctor;

@SuppressWarnings("serial")
public class FiltrarPorGenero extends UnaryFunctor<Cancion, Boolean> {
	private Genero genero;
	
	public FiltrarPorGenero(Genero pGenero) {
		this.genero = pGenero;
	}

	private Genero getGenero() {
		return this.genero;
	}

	public Boolean fn(Cancion pCancion) {
		return this.getGenero().compareTo(pCancion.getGenero()) == 0;
	}
}
