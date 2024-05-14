package ar.edu.unlp.info.oo2.Ejercicio2;

public class Piedra extends Opcion{
	
	public String jugar(Piedra p) {
		return "Empate";
	}
	
	public String jugar(Papel p) {
		return p.jugar(this);	}
	
	public String jugar(Tijera t) {
		return t.jugar(this);
	}

	public String jugar(Largarto l) {
		return "Piedra aplasta largarto";
	}

	public String jugar(Spock s) {
		return "Spock vaporiza piedra";
	}
}
