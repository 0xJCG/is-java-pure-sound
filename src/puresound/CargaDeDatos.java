package puresound;

import java.io.File;
import java.io.IOException;
import java.util.Calendar;
import java.util.List;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class CargaDeDatos {
	private static CargaDeDatos miCargaDeDatos = new CargaDeDatos();
	private String ruta;
	
	private CargaDeDatos() {}

	public static CargaDeDatos getCargaDeDatos() {
		return miCargaDeDatos;
	}
	
	public void cargar(String ruta) {
		this.ruta = ruta;
		this.cargarDiscograficasArtistas();
		this.cargarEventos();
		this.cargarDiscos();
	}
	
	/* Ejemplo del XML de Discográficas y Artistas:
	<discograficas>
		<discografica>
			<nombre></nombre>
			<anio></anio>
			<artistas>
				<solista>
					<nombre></nombre>
					<musico>
						<nombre></nombre>
						<nacionalidad></nacionalidad>
						<rol></rol>
					</musico>
				</solista>
				<grupo>
					<nombre></nombre>
					<musicos>
						<musico>
							<nombre></nombre>
							<nacionalidad></nacionalidad>
							<rol></rol>
						</musico>
						<musico>
							<nombre></nombre>
							<nacionalidad></nacionalidad>
							<rol></rol>
						</musico>
					</musicos>
				</grupo>
			</artistas>
		</discografica>
	</discograficas>
	*/
	
	@SuppressWarnings("rawtypes")
	private void cargarDiscograficasArtistas() {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(ruta + "/artistas.xml");
		try {
			Document document = (Document) builder.build(xmlFile); // Se crea el documento a través del archivo.
			Element rootNode = document.getRootElement(); // Se obtiene la raiz.
			List list = rootNode.getChildren(); // Se obtiene la lista de hijos.
			
			/* <discograficas> */
			for (int i = 0; i < list.size(); i++) {
				Element discografica = (Element) list.get(i); // Se obtiene el elemento 'discografica'.
				String nombre = discografica.getChildTextTrim("nombre"); // Se obtiene el valor que está entre las etiquetas '<nombre></nombre>'.
				int anio = Integer.parseInt(discografica.getChildTextTrim("anio"));
				Discografica dscgrfc = new Discografica(nombre, anio);
				List list2 = discografica.getChildren("artistas");
				
				/* <discografica> */
				for (int j = 0; j < list2.size(); j++) {
					Element artistas = (Element) list2.get(j);
					List listaArtistas = artistas.getChildren();
					
					/* <artistas> */
					for (int k = 0; k < listaArtistas.size(); k++) {
						Element artista = (Element) listaArtistas.get(k);
						if (artista.getName().equals("grupo")) {
							Grupo grupo = new Grupo(artista.getChildTextTrim("nombre"), Calendar.getInstance(), dscgrfc);
	
							/* <musicos> */
							List listaMusicos = artista.getChildren("musicos");
							for (int l = 0; l < listaMusicos.size(); l++) {
								Element musico = (Element) listaMusicos.get(l);
								
								/* <musico> */
								List musicos = musico.getChildren();
								for (int n = 0; n < musicos.size(); n++) {
									Element music = (Element) musicos.get(n);
									Rol rol = Rol.valueOf(music.getChildTextTrim("rol"));
									Musico m = new Musico(music.getChildTextTrim("nombre"), Calendar.getInstance(), music.getChildTextTrim("nacionalidad"), rol);
									grupo.addIntegrante(m);
								} // </musico>
							} // </musicos>
							ListaArtistasTotal.getListaArtistasTotal().addArtista(grupo);						
						} else {
							Element musico = (Element) artista.getChildren("musico").get(0);
							Rol rol = Rol.valueOf(musico.getChildTextTrim("rol"));
							Musico m = new Musico(musico.getChildTextTrim("nombre"), Calendar.getInstance(), musico.getChildTextTrim("nacionalidad"), rol);
							Solista solista = new Solista(artista.getChildTextTrim("nombre"), Calendar.getInstance(), m, dscgrfc);
							ListaArtistasTotal.getListaArtistasTotal().addArtista(solista);
						}
					} // <artistas>				
				} // <discografica>
			} // <discograficas>
		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
	}
	
	/* Ejemplo del XML de Eventos:
	<eventos>
		<concierto tipo="pasado">
			<nombre></nombre>
			<lugar></lugar>
			<artista></artista>
			<resumen></resumen>
			<asistencia></asistencia>
		</concierto>
		<concierto tipo="futuro">
			<nombre></nombre>
			<lugar></lugar>
			<artista></artista>
			<aforo></aforo>
			<anuncio></anuncio>
		</concierto>
		<festival tipo="pasado">
			<nombre></nombre>
			<lugar></lugar>
			<resumen></resumen>
			<asistencia></asistencia>
			<artistas>
				<artista>
					<nombre>/nombre>
				</artista>
				<artista>
					<nombre></nombre>
				</artista>
			</artistas>
		</festival>
		<festival tipo="futuro">
			<nombre></nombre>
			<lugar></lugar>
			<aforo></aforo>
			<anuncio></anuncio>
			<artistas>
				<artista>
					<nombre>/nombre>
				</artista>
				<artista>
					<nombre></nombre>
				</artista>
			</artistas>
		</festival>
	</eventos>
	*/
	
	@SuppressWarnings("rawtypes")
	private void cargarEventos() {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(ruta + "/eventos.xml");
		try {
			Document document = (Document) builder.build(xmlFile); // Se crea el documento a través del archivo.
			Element rootNode = document.getRootElement(); // Se obtiene la raiz.
			List list = rootNode.getChildren(); // Se obtiene la lista de hijos.
			
			/* <eventos> */
			for (int i = 0; i < list.size(); i++) {
				Element evento = (Element) list.get(i); // Se obtiene el elemento 'discografica'.
				if (evento.getName().equals("concierto")) {
					String nombre = evento.getChildTextTrim("nombre"); // Se obtiene el valor que está entre las etiquetas '<nombre></nombre>'.
					String lugar = evento.getChildTextTrim("lugar");
					String artista = evento.getChildTextTrim("artista");
					Artista ar = ListaArtistasTotal.getListaArtistasTotal().buscarArtista(artista);
					Concierto concierto = null;
					if (evento.getAttribute("tipo").getValue().equals("pasado")) {
						String resumen = evento.getChildTextTrim("resumen");
						int asistencia = Integer.parseInt(evento.getChildTextTrim("asistencia"));
						concierto = new ConciertoPasado(nombre, Calendar.getInstance(), lugar, ar, resumen, asistencia);
					} else {
						int aforo = Integer.parseInt(evento.getChildTextTrim("aforo"));
						String anuncio = evento.getChildTextTrim("anuncio");
						concierto = new ConciertoFuturo(nombre, Calendar.getInstance(), lugar, ar, aforo, anuncio);
					}
					ListaEventos.getListaEventos().addEvento(concierto);
				} else {
					String nombre = evento.getChildTextTrim("nombre"); // Se obtiene el valor que está entre las etiquetas '<nombre></nombre>'.
					String lugar = evento.getChildTextTrim("lugar");
					Festival festival = null;
					if (evento.getAttribute("tipo").getValue().equals("pasado")) {
						String resumen = evento.getChildTextTrim("resumen");
						int asistencia = Integer.parseInt(evento.getChildTextTrim("asistencia"));
						festival = new FestivalPasado(nombre, Calendar.getInstance(), lugar, resumen, asistencia);
					} else {
						int aforo = Integer.parseInt(evento.getChildTextTrim("aforo"));
						String anuncio = evento.getChildTextTrim("anuncio");
						festival = new FestivalFuturo(nombre, Calendar.getInstance(), lugar, aforo, anuncio);
					}
					List listaArtistas = evento.getChildren("artistas");
					for (int j = 0; j < listaArtistas.size(); j++) {
						Element eArtista = (Element) listaArtistas.get(j);
						List artista = eArtista.getChildren();
						for (int k = 0; k < artista.size(); k++) {
							Element artist = (Element) artista.get(k);
							String nArtista = artist.getChildTextTrim("nombre");
							Artista ar = ListaArtistasTotal.getListaArtistasTotal().buscarArtista(nArtista);
							festival.addArtista(ar);
						}
					}
					ListaEventos.getListaEventos().addEvento(festival);
				}
			}
		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
	}
	
	/* Ejemplo de XML de discos y canciones:
	<artistas>
		<artista>
			<nombre></nombre>
			<discos>
				<disco>
					<nombre></nombre>
					<anio></anio>
					<formato></formato>
					<canciones>
						<cancion>
							<nombre></nombre>
							<genero></genero>
							<letra></letra>
						</cancion>
					</canciones>
				</disco>
			</discos>
		</artista>
	</artistas>
	*/
	
	@SuppressWarnings("rawtypes")
	private void cargarDiscos() {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File(ruta + "/discos.xml");
		try {
			Document document = (Document) builder.build(xmlFile); // Se crea el documento a través del archivo.
			Element rootNode = document.getRootElement(); // Se obtiene la raiz.
			List list = rootNode.getChildren(); // Se obtiene la lista de hijos.
			
			/* <artistas> */
			for (int i = 0; i < list.size(); i++) {
				Element artista = (Element) list.get(i); // Se obtiene el elemento 'artista'.
				String nombre = artista.getChildTextTrim("nombre"); // Se obtiene el valor que está entre las etiquetas '<nombre></nombre>'.
				Artista ar = ListaArtistasTotal.getListaArtistasTotal().buscarArtista(nombre);
				
				List discos = artista.getChildren("discos");
				for (int j = 0; j < discos.size(); j++) {
					Element disc = (Element) discos.get(j);
					List disco = disc.getChildren();
					for (int k = 0; k < disco.size(); k++) {
						Element di = (Element) disco.get(k);
						String n = di.getChildTextTrim("nombre");
						int a = Integer.parseInt(di.getChildTextTrim("anio"));
						Formato f = Formato.valueOf(di.getChildTextTrim("formato"));
						
						Disco d = new Disco(n, a, f);
						ar.addDisco(d);
						
						List canciones = di.getChildren("canciones");
						for (int l = 0; l < canciones.size(); l++) {
							Element canc = (Element) canciones.get(l);
							List cancion = canc.getChildren();
							for (int m = 0; m < cancion.size(); m++) {
								Element ca = (Element) cancion.get(m);
								String no = ca.getChildTextTrim("nombre");
								String le = ca.getChildTextTrim("letra");
								Genero ge = Genero.valueOf(ca.getChildTextTrim("genero"));
								Cancion c = new Cancion(no, null, ge, le);
								d.addCancion(c);
							}
						}
					}
				}
			}
		} catch (IOException io) {
			System.out.println(io.getMessage());
		} catch (JDOMException jdomex) {
			System.out.println(jdomex.getMessage());
		}
	}
}