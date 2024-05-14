package ar.edu.unlp.info.oo2.Ejercicio6b;

public class Agua extends Topografia {

	public double proporcionDeAgua() {
		return 1;
	}

	public boolean esIgual(Agua agua) {
		return true;
	}

	public boolean esIgual(Tierra tierra) {
		return false;
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
