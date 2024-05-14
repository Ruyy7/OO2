package ar.edu.unlp.info.oo2.Ejercicio4;

public class Planta extends Empleado {
	private int cantAños;

	public Planta(int cantHijos, boolean casado, int cantAños) {
		super(cantHijos, casado);
		this.cantAños = cantAños;
	}

	public double sueldoBasico() {
		return 50000;
	}

	public double sueldoAdicional() {
		if (this.estaCasado()) {
			return 5000 + 2000*this.getCantHijos() + 2000*this.cantAños;
		}		
		return 2000*this.getCantHijos() + 2000*this.cantAños;
	}
}
