package gui;

import java.util.Iterator;
import java.util.Observable;
import java.util.Observer;

import javax.swing.JPanel;
import javax.swing.JLabel;

import puresound.Evento;
import puresound.ListaEventos;

@SuppressWarnings("serial")
public class Eventos extends JPanel implements Observer {
	private JLabel lblEventos = new JLabel("Eventos");
	private JLabel lblDatos = new JLabel("Datos");
	
	/**
	 * Create the panel.
	 */
	public Eventos(ListaEventos model) {
		add(lblEventos);
		add(lblDatos);
		
		model.addObserver(this);
		this.mostrarEventos(model.iterator());
	}
	
	public void update(Observable eve, Object arg1) {
		ListaEventos eventos = (ListaEventos) eve;
		mostrarEventos(eventos.iterator());
	}
	
	private void mostrarEventos(Iterator<Evento> it) {
		int salir = 0;
		Evento ev = null;
		String textoAMostrar = "";
		while (it.hasNext() && salir < 10) {
			ev = it.next();
			textoAMostrar += "Evento: " + ev.getNombre() + ".\nLugar: " + ev.getLugar() + ".\n";
			salir++;
		}
		this.lblDatos.setText(textoAMostrar);
	}
}