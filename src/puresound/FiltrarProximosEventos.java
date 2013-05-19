package puresound;

import net.sf.jga.fn.UnaryFunctor;

@SuppressWarnings("serial")
public class FiltrarProximosEventos extends UnaryFunctor<Evento, Boolean> {
	public Boolean fn(Evento pEvento) {
		return (pEvento.getClass().equals(FestivalFuturo.class) || pEvento.getClass().equals(ConciertoFuturo.class));
	}
}