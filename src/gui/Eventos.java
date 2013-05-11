package gui;

import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JList;

import puresound.Evento;

@SuppressWarnings("serial")
public class Eventos extends JPanel {

	/**
	 * Create the panel.
	 */
	public Eventos() {
		
		JLabel lblEventos = new JLabel("Eventos");
		add(lblEventos);
		
		JList<Evento> list = new JList<Evento>();
		add(list);

	}

}
