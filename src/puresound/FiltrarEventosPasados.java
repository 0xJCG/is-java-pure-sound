package puresound;

import net.sf.jga.fn.UnaryFunctor;

@SuppressWarnings("serial")
public class FiltrarEventosPasados extends UnaryFunctor<Evento, Boolean> {
	public Boolean fn(Evento pEvento) {
		return (pEvento.getClass().equals(FestivalPasado.class) || pEvento.getClass().equals(ConciertoPasado.class));
	}
}
