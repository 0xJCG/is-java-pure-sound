package gui;

import java.util.Iterator;

import puresound.Artista;
import puresound.Cancion;
import puresound.Disco;
import puresound.Evento;
import puresound.ListaArtistasFavoritos;
import puresound.ListaArtistasTotal;
import puresound.ListaCancionesFavoritas;
import puresound.ListaEventos;

public class ProjectTreeBuilder {
    public static ProjectItemNode buildPureSound() {
        ProjectItemNode pureSound = new ProjectItemNode("PureSound", ProjectItemNode.NODE_ROOT);
        ProjectItemNode artistas = new ProjectItemNode("Artistas", ProjectItemNode.NODE_PROJECT);
        Iterator<Artista> itA = ListaArtistasTotal.getListaArtistasTotal().iterator();
        while (itA.hasNext()) {
			Artista ar = itA.next();
			ProjectItemNode artista = new ProjectItemNode(ar.getNombre(), ProjectItemNode.NODE_SOURCE);
			Iterator<Disco> itD = ar.getDiscografia().iterator();
			while (itD.hasNext()) {
				Disco di = itD.next();
				ProjectItemNode disco = new ProjectItemNode(di.getNombre(), ProjectItemNode.NODE_PACKAGE);
				Iterator<Cancion> itC = di.getCanciones().iterator();
				while (itD.hasNext()) {
					Cancion ca = itC.next();
					ProjectItemNode cancion = new ProjectItemNode(ca.getNombre(), ProjectItemNode.NODE_CLASS);
					disco.addChild(cancion);
				}
				artista.addChild(disco);
			}
			artistas.addChild(artista);
		}
		pureSound.addChild(artistas);
		
		ProjectItemNode eventos = new ProjectItemNode("Eventos", ProjectItemNode.NODE_PROJECT);
		Iterator<Evento> itE = ListaEventos.getListaEventos().iterator();
        while (itE.hasNext()) {
			Evento ev = itE.next();
			ProjectItemNode evento = new ProjectItemNode(ev.getNombre(), ProjectItemNode.NODE_SOURCE);
			eventos.addChild(evento);
        }
        pureSound.addChild(eventos);
        
        return pureSound;
    }
    
    public static ProjectItemNode buildArbolUsuario() {
        ProjectItemNode panel = new ProjectItemNode("Panel de usuario", ProjectItemNode.NODE_ROOT);
        ProjectItemNode artistasF = new ProjectItemNode("Artistas favoritos", ProjectItemNode.NODE_PROJECT);
        Iterator<Artista> itA = ListaArtistasFavoritos.getListaArtistasFavoritos().iterator();
        while (itA.hasNext()) {
			Artista ar = itA.next();
			ProjectItemNode artista = new ProjectItemNode(ar.getNombre(), ProjectItemNode.NODE_SOURCE);
			Iterator<Disco> itD = ar.getDiscografia().iterator();
			while (itD.hasNext()) {
				Disco di = itD.next();
				ProjectItemNode disco = new ProjectItemNode(di.getNombre(), ProjectItemNode.NODE_PACKAGE);
				Iterator<Cancion> itC = di.getCanciones().iterator();
				while (itD.hasNext()) {
					Cancion ca = itC.next();
					ProjectItemNode cancion = new ProjectItemNode(ca.getNombre(), ProjectItemNode.NODE_CLASS);
					disco.addChild(cancion);
				}
				artista.addChild(disco);
			}
			artistasF.addChild(artista);
		}
        panel.addChild(artistasF);
		
		ProjectItemNode cancionesF = new ProjectItemNode("Canciones favoritas", ProjectItemNode.NODE_PROJECT);
		Iterator<Cancion> itC = ListaCancionesFavoritas.getListaCancionesFavoritas().iterator();
        while (itC.hasNext()) {
			Cancion ca = itC.next();
			ProjectItemNode cancion = new ProjectItemNode(ca.getNombre(), ProjectItemNode.NODE_SOURCE);
			cancionesF.addChild(cancion);
        }
        panel.addChild(cancionesF);
        
        return panel;
    }
}
