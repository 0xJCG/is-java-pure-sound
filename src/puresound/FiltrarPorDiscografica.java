package puresound;

import net.sf.jga.fn.UnaryFunctor;

@SuppressWarnings("serial")
public class FiltrarPorDiscografica extends UnaryFunctor<Artista, Boolean> {
	private Discografica discografica;
	
	public FiltrarPorDiscografica(Discografica pDiscografica) {
		this.discografica = pDiscografica;
	}

	private Discografica getDiscografica() {
		return this.discografica;
	}

	public Boolean fn(Artista pArtista) {
		return this.getDiscografica().compareTo(pArtista.getDiscografica().getNombre()) == 0;
	}
}