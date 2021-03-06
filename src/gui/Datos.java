package gui;

import java.awt.Color;
import java.util.Iterator;

import javax.swing.BoxLayout;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTree;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.event.TreeSelectionListener;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;

import puresound.Artista;
import puresound.Cancion;
import puresound.Concierto;
import puresound.ConciertoFuturo;
import puresound.ConciertoPasado;
import puresound.Disco;
import puresound.Evento;
import puresound.Festival;
import puresound.ListaArtistasFavoritos;
import puresound.ListaArtistasTotal;
import puresound.ListaEventos;
import java.awt.Font;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

@SuppressWarnings("serial")
public class Datos extends JPanel implements TreeSelectionListener {
	private JTree tree = null;
	private DefaultMutableTreeNode raiz = new DefaultMutableTreeNode("PureSound");
	
	public Datos() {
		this.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
		
		JLabel lblAyuda = new JLabel("Seleccione los elementos y aparecerán diferentes mensajes.");
		lblAyuda.setHorizontalAlignment(SwingConstants.CENTER);
		lblAyuda.setForeground(new Color(30, 144, 255));
		lblAyuda.setBackground(new Color(255, 255, 255));
		lblAyuda.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		this.setBackground(Color.WHITE);
		
		add(lblAyuda);
		
		tree = new JTree(raiz);
		tree.setBorder(null);
		tree.setEditable(false);
		tree.setForeground(new Color(30, 144, 255));
		tree.setFont(new Font("Segoe UI", Font.PLAIN, 15));
		
		this.pintarArbol();
		
        tree.addTreeSelectionListener(this);
        
        /* Expandimos todos los nodos para que sean visibles. */
        for (int i = 0; i < tree.getRowCount(); i++)
            tree.expandRow(i);
	}
	
	@Override
	public void valueChanged(TreeSelectionEvent e) {
		Object node = tree.getLastSelectedPathComponent();
		if (node == null)
			return;
		else {
			TreePath path = e.getPath();
			Object[] nodos = path.getPath();
			DefaultMutableTreeNode ultimoNodo = (DefaultMutableTreeNode) nodos[nodos.length-1];
			if (nodos.length != 1) { // Si no es la raíz.
				if (ultimoNodo.getParent().toString().equals("Artistas")) { // Artista seleccionado.
					if (JOptionPane.showConfirmDialog(this, "¿Añadir a " + node.toString() + " como artista favorito?") == 0) { // Si el usuario pulsa "Sí".
						Artista ar = ListaArtistasTotal.getListaArtistasTotal().buscarArtista(node.toString()); // Buscamos el artista.
						ListaArtistasFavoritos.getListaArtistasFavoritos().addArtista(ar); // Lo añadimos en la lista de favoritos.
					}
				} else if (ultimoNodo.getParent().toString().equals("Eventos")) {
					Evento ev = ListaEventos.getListaEventos().buscarEvento(node.toString());
					JOptionPane.showMessageDialog(this, "Evento: " + ev.getNombre() + ". Lugar: " + ev.getLugar() + ". " + ev.getFecha().getTime());
				} else if (nodos.length == 5) { // Canciones.
					/* Creamos un JDialog que será el reproductor y saldrá cuando pulsemos en su menú. */
					String ar = ultimoNodo.getParent().getParent().toString();
					String di = ultimoNodo.getParent().toString();
					String ca = node.toString();
					Cancion cancion = ListaArtistasTotal.getListaArtistasTotal().buscarCancionDiscoArtista(ar, di, ca);
					Reproductor reproductor = new Reproductor(cancion);
					reproductor.pack();
					reproductor.setLocationRelativeTo(this);
					reproductor.setVisible(true);
					reproductor.setAlwaysOnTop(true);
					reproductor.setSize(600, 480);
				}
			}
		}
	}
	
	private void pintarArbol() {
		DefaultMutableTreeNode artistas = new DefaultMutableTreeNode("Artistas");
		DefaultMutableTreeNode eventos = new DefaultMutableTreeNode("Eventos");
		
		raiz.add(artistas);
		
		ListaArtistasTotal.getListaArtistasTotal().OrdenarPorNombreA(); // Ordenamos los datos.
		Iterator<Artista> itA = ListaArtistasTotal.getListaArtistasTotal().iterator();
        while (itA.hasNext()) {
			Artista ar = itA.next();
			DefaultMutableTreeNode artista = new DefaultMutableTreeNode(ar.getNombre());
			artistas.add(artista);
			Iterator<Disco> itD = ar.getDiscografia().iterator();
			while (itD.hasNext()) {
				Disco di = itD.next();
				DefaultMutableTreeNode disco = new DefaultMutableTreeNode(di.getNombre());
				artista.add(disco);
				Iterator<Cancion> itC = di.getCanciones().iterator();
				while (itC.hasNext()) {
					Cancion ca = itC.next();
					DefaultMutableTreeNode cancion = new DefaultMutableTreeNode(ca.getNombre());
					disco.add(cancion);
				}
			}
        }
        
        raiz.add(eventos);
        
        ListaEventos.getListaEventos().OrdenarPorNombreE(); // Ordenamos los datos.
        Iterator<Evento> itE = ListaEventos.getListaEventos().iterator();
        while (itE.hasNext()) {
			Evento ev = itE.next();
			DefaultMutableTreeNode evento = new DefaultMutableTreeNode(ev.getNombre());
			eventos.add(evento);
			if (ev.getClass().equals(ConciertoPasado.class) || ev.getClass().equals(ConciertoFuturo.class)) {
				Concierto co = (Concierto) ev;
				DefaultMutableTreeNode artista = new DefaultMutableTreeNode(co.getArtista().getNombre());
				evento.add(artista);
			} else {
				Festival fe = (Festival) ev;
				Iterator<Artista> itArF = fe.getListaArtistas().iterator();
				while (itArF.hasNext()) {
					Artista ar = itArF.next();
					DefaultMutableTreeNode artista = new DefaultMutableTreeNode(ar.getNombre());
					evento.add(artista);
				}
			}
        }
        
        /* Diremos que salgan las barras de scroll cuando el JTree no entre en el panel. */
        JScrollPane sPane = new JScrollPane(tree, JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED, JScrollPane.HORIZONTAL_SCROLLBAR_AS_NEEDED);
        add(sPane);
	}
}