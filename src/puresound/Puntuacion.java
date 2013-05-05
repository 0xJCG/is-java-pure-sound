package puresound;

public class Puntuacion {
	private int nota;
	private String comentario;
	
	public Puntuacion(int pNota, String pComentario) {
		this.nota = pNota;
		this.comentario = pComentario;
	}

	public int getNota() {
		return this.nota;
	}

	public String getComentario() {
		return this.comentario;
	}
	
	public void mostrarDatos(){
		System.out.println("Nota:"+ this.getNota());
		System.out.println("Comentario:" + this.getComentario());
	}
}