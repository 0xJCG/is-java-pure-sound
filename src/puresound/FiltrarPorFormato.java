package puresound;

import net.sf.jga.fn.UnaryFunctor;

@SuppressWarnings("serial")
public class FiltrarPorFormato extends UnaryFunctor<Disco, Boolean> {
	private Formato formato;
	
	public FiltrarPorFormato(Formato pFormato) {
		this.formato = pFormato;
	}

	private Formato getFormato() {
		return this.formato;
	}

	public Boolean fn(Disco pDisco) {
		return this.getFormato().compareTo(pDisco.getFormato()) == 0;
	}
}
