package ar.edu.unlp.info.oo2.Ejercicio2;

public class Tijera extends Opcion{
	
	public String jugar(Piedra p) {
		return "Pierde tijera, gana piedra";
	}
	
	public String jugar(Papel p) {
		return "Gana tijera, pierde papel";
	}
	
	public String jugar(Tijera t) {
		return "Empate";
	}

	public String jugar(Largarto l) {
		return "Tijera decapita largarto";
	}

	public String jugar(Spock s) {
		return "Spock rompe tijera";
	}
	
}
