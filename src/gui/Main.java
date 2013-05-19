package gui;

import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import puresound.CargaDeDatos;
import puresound.ListaArtistasFavoritos;

@SuppressWarnings("serial")
public class Main extends JFrame {
	private JPanel contentPane = new JPanel();
	private JMenuBar menuBar;
	private JDialog ayuda = new Ayuda();
	private JDialog buscar = new Busqueda();
	
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
	
	public Main() {
		setResizable(false);
		this.setTitle("PureSound");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		/* Cargamos la ventana en el centro de la pantalla. */
		Dimension screen = Toolkit.getDefaultToolkit().getScreenSize();
		int x = (screen.width / 2) - (800 / 2); // Center horizontally.
		int y = (screen.height / 2) - (600 / 2); // Center vertically.
		this.setBounds(x, y, 800, 600);
		
		/* Ponemos la barra de menú. */
        this.ponerMenu();
        
        /* Añadimos el panel al frame principal. */
        contentPane.setBackground(Color.WHITE);
        this.setContentPane(this.contentPane);
        
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{164, 455, 0};
		gbl_contentPane.rowHeights = new int[]{287, 0, 342, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
		JButton btnCargar = new JButton("Cargar");
		btnCargar.setAlignmentX(Component.CENTER_ALIGNMENT);
		btnCargar.setForeground(new Color(30, 144, 255));
		btnCargar.setBackground(Color.WHITE);
		btnCargar.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		btnCargar.addActionListener(new BtnCargaClick());
		
		JLabel lblPuresound = new JLabel("PureSound");
		lblPuresound.setForeground(new Color(30, 144, 255));
		lblPuresound.setFont(new Font("Segoe UI", Font.PLAIN, 35));
		lblPuresound.setBackground(new Color(255, 255, 255));
		GridBagConstraints gbc_lblPuresound = new GridBagConstraints();
		gbc_lblPuresound.insets = new Insets(0, 0, 5, 0);
		gbc_lblPuresound.gridx = 1;
		gbc_lblPuresound.gridy = 0;
		contentPane.add(lblPuresound, gbc_lblPuresound);
		JLabel lblSeleccionaLaCarpeta = new JLabel("Seleccione la carpeta que contiene los archivos XML:");
		lblSeleccionaLaCarpeta.setFont(new Font("Segoe UI", Font.PLAIN, 20));
		lblSeleccionaLaCarpeta.setForeground(new Color(30, 144, 255));
		lblSeleccionaLaCarpeta.setAlignmentX(Component.CENTER_ALIGNMENT);
		GridBagConstraints gbc_lblSeleccionaLaCarpeta = new GridBagConstraints();
		gbc_lblSeleccionaLaCarpeta.anchor = GridBagConstraints.SOUTH;
		gbc_lblSeleccionaLaCarpeta.insets = new Insets(0, 0, 5, 0);
		gbc_lblSeleccionaLaCarpeta.gridx = 1;
		gbc_lblSeleccionaLaCarpeta.gridy = 1;
		this.contentPane.add(lblSeleccionaLaCarpeta, gbc_lblSeleccionaLaCarpeta);
		GridBagConstraints gbc_btnCargar = new GridBagConstraints();
		gbc_btnCargar.anchor = GridBagConstraints.NORTH;
		gbc_btnCargar.gridx = 1;
		gbc_btnCargar.gridy = 2;
		this.contentPane.add(btnCargar, gbc_btnCargar);
		
		/* Creamos un JDialog que será la ayuda y saldrá cuando pulsemos en su menú. */
		ayuda.pack();
		ayuda.setLocationRelativeTo(this);
		ayuda.setVisible(false);
		ayuda.setSize(600, 480);
		
		/* Creamos un JDialog que será la búsqueda y saldrá cuando pulsemos en su menú. */
		buscar.pack();
		buscar.setLocationRelativeTo(this);
		buscar.setVisible(false);
		buscar.setSize(600, 480);		
	}
	
	private void ponerMenu() {
		this.menuBar = new JMenuBar();
		menuBar.setBorderPainted(false);
		menuBar.setBackground(new Color(255, 255, 255));
		menuBar.setForeground(new Color(30, 144, 255));

        /* Menú Archivo */
        JMenu menu = new JMenu("Archivo");
        menu.setBackground(new Color(255, 255, 255));
		menu.setForeground(new Color(30, 144, 255));
        menu.setMnemonic(KeyEvent.VK_F);
        this.menuBar.add(menu);

        /* Submenú Archivo */
        JMenuItem item = new JMenuItem("Salir");
        item.setBackground(new Color(255, 255, 255));
        item.setForeground(new Color(30, 144, 255));
        menu.add(item);
        item.addActionListener(new MenuSalirActionListener());

        /* Menú Mostrar */
        menu = new JMenu("Mostrar");
        menu.setBackground(new Color(255, 255, 255));
		menu.setForeground(new Color(30, 144, 255));
        this.menuBar.add(menu);
        
        item = new JMenuItem("Búsqueda");
        item.setBackground(new Color(255, 255, 255));
        item.setForeground(new Color(30, 144, 255));
        menu.add(item);
        item.addActionListener(new MenuBuscarActionListener());
        
        /* Menú Ayuda */
        menu = new JMenu("Ayuda");
        menu.setBackground(new Color(255, 255, 255));
		menu.setForeground(new Color(30, 144, 255));
        this.menuBar.add(menu);

        /* Submenú Ayuda */
        item = new JMenuItem("Ayuda");
        item.setBackground(new Color(255, 255, 255));
        item.setForeground(new Color(30, 144, 255));
        menu.add(item);
        item.addActionListener(new MenuAyudaActionListener());
        
        menu.addSeparator();
        
        item = new JMenuItem("Acerca de PureSound");
        item.setBackground(new Color(255, 255, 255));
        item.setForeground(new Color(30, 144, 255));
        menu.add(item);
        item.addActionListener(new MenuAcercaDePureSoundListener());
        
        /* Añadimos la barra de menú al frame principal. */
        super.setJMenuBar(this.menuBar);
        this.menuBar.setVisible(false); // Desactivamos el menú hasta no cargar los datos.
	}
	
	private class MenuSalirActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			System.exit(0);
		}
	}
	
	private class MenuBuscarActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (buscar.isVisible())
				buscar.setVisible(false);
			else
				buscar.setVisible(true);
		}
	}
	
	private class MenuAyudaActionListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			if (ayuda.isVisible())
				ayuda.setVisible(false);
			else
				ayuda.setVisible(true);
		}
	}
	
	private class MenuAcercaDePureSoundListener implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			showDialog("Programa realizado por Yuriy Andzheyevskiy y Jonathan Castro.", "Acerca de PureSound");
		}
	}
	
	private class BtnCargaClick implements ActionListener {
		public void actionPerformed(ActionEvent arg0) {
			JFileChooser chooser = new JFileChooser();
			chooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
			chooser.setAcceptAllFileFilterUsed(false);
			int opcion = chooser.showSaveDialog(chooser);
			if (opcion == JFileChooser.APPROVE_OPTION) {
				CargaDeDatos.getCargaDeDatos().cargar(chooser.getSelectedFile().getAbsolutePath());
				ListaArtistasFavoritos fav = ListaArtistasFavoritos.getListaArtistasFavoritos();
				cambiarPanel(new Datos(), new User(fav));
				menuBar.setVisible(true); // Activamos el menú.
			}
		}
	}

	private void cambiarPanel(JPanel pPanel1, JPanel pPanel2) {
		this.contentPane = new JPanel();
		this.contentPane.setLayout(new GridLayout(2, 1));
		this.contentPane.add(pPanel1);
		this.contentPane.add(pPanel2);
		this.setContentPane(contentPane);
		this.contentPane.updateUI();
	}
	
	private void showDialog(String pTexto, String pTitulo) {
		JOptionPane.showMessageDialog(this, pTexto, pTitulo, JOptionPane.PLAIN_MESSAGE);
	}
}