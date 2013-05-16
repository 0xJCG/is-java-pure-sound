package puresound;

import java.util.Comparator;

public class OrdenarPorNombreA implements Comparator<Artista> {
	public int compare(Artista pArtista0, Artista pArtista1) {
		return pArtista0.compareTo(pArtista1);
	}
}