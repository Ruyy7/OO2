package ar.edu.unlp.info.oo2.Ejercicio6b;

public class Pantano extends Topografia {

	public double proporcionDeAgua() {
		return 0.7;
	}

	public boolean esIgual(Agua agua) {
		return false;
	}

	public boolean esIgual(Tierra tierra) {
		return false;
	}

	public boolean esIgual(Mixta mixta) {
		return false;
	}

	public boolean esIgual(Pantano pantano) {
		return true;
	}

}
