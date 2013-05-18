package gui;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

import puresound.ListaArtistasFavoritos;
import puresound.ListaArtistasTotal;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private JPanel contentPane = new JPanel();
	private JMenuBar menuBar;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main frame = new Main();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public Main() {
		setTitle("PureSound");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Cargamos la ventana en el centro de la pantalla. */
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width / 2) - (800 / 2); // Center horizontally.
		int y = (screen.height / 2) - (600 / 2); // Center vertically.
		setBounds(x, y, 800, 600);
		
		/* Ponemos la barra de menú. */
        ponerMenu();
        
        /* Añadimos el panel al frame principal. */
        contentPane.add(new Carga(), BorderLayout.CENTER);
		setContentPane(contentPane);
        
        //cambiarPanel(carga, null);
	}
	
	private void ponerMenu() {
		menuBar = new JMenuBar();

        /* Menú Archivo */
        JMenu menu = new JMenu("Archivo");
        menu.setMnemonic(KeyEvent.VK_F);
        menuBar.add(menu);

        /* Submenú Archivo */
        JMenuItem item = new JMenuItem("Salir");
        menu.add(item);
        item.addActionListener(new MenuSalirActionListener());
        
        /* Menú Mostrar */
        menu = new JMenu("Mostrar");
        menuBar.add(menu);

        /* Submenú Mostrar */
        item = new JMenuItem("Datos");
        menu.add(item);
        item.addActionListener(new MenuDatosActionListener());
        
        /* Menú Ayuda */
        menu = new JMenu("Ayuda");
        menuBar.add(menu);

        /* Submenú Ayuda */
        item = new JMenuItem("Ayuda");
        menu.add(item);
        
        menu.addSeparator();
        
        item = new JMenuItem("Acerca de PureSound");
        menu.add(item);
        
        /* Añadimos la barra de menú al frame principal. */
        super.setJMenuBar(menuBar);
	}
	
	private class MenuSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	private class MenuDatosActionListener implements ActionListener {
		ListaArtistasFavoritos fav = ListaArtistasFavoritos.getListaArtistasFavoritos();
		ListaArtistasTotal art = ListaArtistasTotal.getListaArtistasTotal();
		public void actionPerformed(ActionEvent e) {
			cambiarPanel(new Datos(art), new User(fav));
		}
	}

	private void cambiarPanel(JPanel pPanel1, JPanel pPanel2) {
		contentPane = new JPanel();
		contentPane.setLayout(new GridLayout(1, 2));
		contentPane.add(pPanel1);
		if (pPanel2 != null)
			contentPane.add(pPanel2);
		setContentPane(contentPane);
		contentPane.updateUI();
	}
}