package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;

@SuppressWarnings("serial")
public class Main extends JFrame {

	private JPanel contentPane;

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
		setBounds(100, 100, 450, 300);
		
		/* Ponemos la barra de menú. */
        ponerMenu();
        
        /* Añadimos el panel al frame principal. */
        cambiarPanel(new Carga());
	}
	
	private void ponerMenu() {
		JMenuBar menuBar = new JMenuBar();

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
        item = new JMenuItem("Artistas");
        menu.add(item);
        item.addActionListener(new MenuArtistasActionListener());
        
        item = new JMenuItem("Eventos");
        menu.add(item);
        item.addActionListener(new MenuEventosActionListener());
        
        menu.addSeparator(); // Separador entre submenús.
        
        item = new JMenuItem("Panel de usuario");
        menu.add(item);
        item.addActionListener(new MenuUsuarioActionListener());
        
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
	
	private class MenuArtistasActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cambiarPanel(new Artistas());
		}
	}
	
	private class MenuEventosActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cambiarPanel(new Eventos());
		}
	}
	
	private class MenuUsuarioActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			cambiarPanel(new User());
		}
	}

	private void cambiarPanel(JPanel pPanel) {
		contentPane = new JPanel();
		contentPane.add(pPanel, BorderLayout.CENTER);
		setContentPane(contentPane);
		contentPane.updateUI();
	}
}