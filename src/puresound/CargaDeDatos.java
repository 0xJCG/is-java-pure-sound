package puresound;

import java.io.File;
import java.io.IOException;
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
	
	/* EJEMPLO DEL XML
	<tables>
		<tabla nombre="Musico">
			<campo>
				<nombre>id</nombre>
				<fecnac>integer</fecnac>
				<nacionalidad>1</nacionalidad>
				<rol>GUITARRA</rol>
			</campo>
		</tabla>
		<tabla nombre="Cancion">
			<campo>
				<nombre>campo</nombre>
				<genero>varchar</genero>
				<letra>pato</letra>
			</campo>
		</tabla>
	</tables>
	*/
	
	@SuppressWarnings("rawtypes")
	public void cargar() {
		 SAXBuilder builder = new SAXBuilder();
		 File xmlFile = new File("archivo.xml");
		 try {
			 Document document = (Document) builder.build(xmlFile); // Se crea el documento a través del archivo.
			 Element rootNode = document.getRootElement(); // Se obtiene la raiz 'tables'.
			 List list = rootNode.getChildren("tabla"); // Se obtiene la lista de hijos de la raiz 'tables'.
			 
			 /* Se recorre la lista de hijos de 'tables'. */
			 for (int i = 0; i < list.size(); i++) {
				 Element tabla = (Element) list.get(i);// Se obtiene el elemento 'tabla'.
				 String nombreTabla = tabla.getAttributeValue("nombre"); // Se obtiene el atributo 'nombre' que está en la etiqueta 'tabla'.
				 System.out.println("Tabla: " + nombreTabla);
				 List lista_campos = tabla.getChildren(); // Se obtiene la lista de hijos de la etiqueta 'tabla'.
				 System.out.println("\tNombre\t\tTipo\t\tValor");
				 
				 /* Se recorre la lista de campos. */
				 for (int j = 0; j < lista_campos.size(); j++) { 
					 Element campo = (Element)lista_campos.get(j);// Se obtiene el elemento 'campo'.
					 
					 /* Se obtienen los valores que estan entre las etiquetas '<campo></campo>'. */
					 String nombre = campo.getChildTextTrim("nombre"); // Se obtiene el valor que está entre las etiquetas '<nombre></nombre>'.
					 String tipo = campo.getChildTextTrim("tipo"); // Se obtiene el valor que está entre las etiquetas '<tipo></tipo>'.
					 String valor = campo.getChildTextTrim("valor"); // Se obtiene el valor que está entre las etiquetas '<valor></valor>'.
					 System.out.println( "\t"+nombre+"\t\t"+tipo+"\t\t"+valor);
				 }
			 }
		 } catch (IOException io) {
			 System.out.println(io.getMessage());
		 } catch (JDOMException jdomex) {
			 System.out.println(jdomex.getMessage());
		 }
	}
}