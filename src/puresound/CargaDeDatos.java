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
	
	private CargaDeDatos() {}

	public static CargaDeDatos getCargaDeDatos() {
		return miCargaDeDatos;
	}
	
	public void cargar() {
		 this.cargarDiscograficasArtistas();
	}
	
	/* Ejemplo del XML de Discográficas y Artistas:
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
	<discografica>
	*/
	
	@SuppressWarnings("rawtypes")
	private void cargarDiscograficasArtistas() {
		SAXBuilder builder = new SAXBuilder();
		File xmlFile = new File("D:/artistas.xml");
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
}