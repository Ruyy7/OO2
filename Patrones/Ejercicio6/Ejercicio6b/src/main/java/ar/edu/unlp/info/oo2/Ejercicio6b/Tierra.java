package ar.edu.unlp.info.oo2.Ejercicio6b;

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

	@Override
	public boolean esIgual(Pantano pantano) {
		// TODO Auto-generated method stub
		return false;
	}

}

