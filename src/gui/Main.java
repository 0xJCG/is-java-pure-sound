package gui;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;

import javax.swing.JFrame;
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
		
		/* Creación de la barra de menús. */
		MenuBar mbarra = new MenuBar();
        Menu m = new Menu("Archivo");
        /*m.add(new MenuItem("Nuevo"));
        m.add(new MenuItem("Abrir"));
        m.add(new MenuItem("Guardar"));
        m.add(new MenuItem("Guardar como"));
        m.add(new MenuItem("Imprimir"));
        m.addSeparator();*/
        m.add(new MenuItem("Salir"));
        mbarra.add(m);
        m = new Menu("Mostrar");
        m.add(new MenuItem("Artistas"));
        m.add(new MenuItem("Eventos"));
        m.addSeparator();
        m.add(new MenuItem("Panel de usuario"));
        mbarra.add(m);
        m = new Menu("Ayuda");
        m.add(new MenuItem("Ayuda"));
        m.addSeparator();
        m.add(new MenuItem("Acerca de PureSound"));
        mbarra.add(m);
        setMenuBar(mbarra);
        
        /* Añadimos el panel al frame principal. */
		contentPane = new JPanel();
		contentPane.add(new Carga(), BorderLayout.CENTER);
		setContentPane(contentPane);
	}

}
