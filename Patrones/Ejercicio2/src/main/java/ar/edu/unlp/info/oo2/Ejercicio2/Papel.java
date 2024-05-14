package ar.edu.unlp.info.oo2.Ejercicio2;

public class Papel extends Opcion{
	
	public String jugar(Piedra p) {
		return "Gana papel, pierde piedra";
	}
	
	public String jugar(Papel p) {
		return "Empate";
	}
	
	public String jugar(Tijera t) {
		return t.jugar(this);
	}

	public String jugar(Largarto l) {
		return "Largarto come papel";
	}

	public String jugar(Spock s) {
		return "Papel desaprueba Spock";
	}
}
