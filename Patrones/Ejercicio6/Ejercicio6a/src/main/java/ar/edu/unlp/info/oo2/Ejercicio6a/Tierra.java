package ar.edu.unlp.info.oo2.Ejercicio6a;

public class Tierra extends Topografia {

	public double proporcionDeAgua() {
		return 0;
	}

	public boolean esIgual(Agua agua) {
		return false;
	}

	public boolean esIgual(Tierra tierra) {
		return true;
	}

	public boolean esIgual(Mixta mixta) {
		return false;
	}

}

