package puresound;

import java.util.Calendar;

public class Solista extends Artista {
	private Musico integrante;
	
	public Solista(String pNombre, Calendar pFechaFormacion, Musico pIntegrante, Discografica pDiscografica) {
		super(pNombre, pFechaFormacion, pDiscografica);
		this.integrante = pIntegrante;
	}
	
	public Musico getIntegrante() {
		return this.integrante;
	}
	
	public void mostrarDatos() {
		super.mostrarDatos();
		System.out.println("Datos reales del solista: ");
		this.getIntegrante().mostrarDatos();
	}
}