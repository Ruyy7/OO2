package ar.edu.unlp.info.oo2.Ejercicio4;

public class Temporario extends Empleado {
	private int cantHoras;

	public Temporario(int cantHijos, boolean casado, int cantHoras) {
		super(cantHijos, casado);
		this.cantHoras = cantHoras;
	}

	public double sueldoBasico() {
		return 20000 + this.cantHoras * 300;
	}

	public double sueldoAdicional() {
		if (this.estaCasado()) {
			return 5000 + 2000 * this.getCantHijos();
		}
		return 2000 * this.getCantHijos();
	}
}
