package puresound;

import java.util.Comparator;

public class OrdenarPorNombreE implements Comparator<Evento> {
	public int compare(Evento pEvento0, Evento pEvento1) {
		return pEvento0.compareTo(pEvento1);
	}
}