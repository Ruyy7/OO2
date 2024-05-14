package ar.edu.unlp.info.oo2.Ejercicio2;

public class Largarto extends Opcion{

	public String jugar(Papel p) {
		return p.jugar(this);
	}

	public String jugar(Piedra p) {
		return p.jugar(this);
	}

	public String jugar(Tijera t) {
		return t.jugar(this);
	}

	public String jugar(Largarto l) {
		return "Empate";
	}

	public String jugar(Spock s) {
		return "Lagarto envenena Spock";
	}

}
