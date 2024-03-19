package ar.edu.unlp.info.oo2.Ejercicio2;

public class Jugador {
	private Opcion objeto;
	
	public void elegirObjeto(Opcion o) {
		this.objeto = o;
	}
	
	public Opcion getObjeto() {
		return this.objeto;
	}
}
