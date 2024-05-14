package ar.edu.unlp.info.oo2.Ejercicio4;

public class Pasante extends Empleado {
	private int cantExamenes;
	
	public Pasante(int cantHijos, boolean casado, int cantExamenes) {
		super(cantHijos, casado);
		this.cantExamenes = cantExamenes;
	}

	public double sueldoBasico() {
		return 20000;
	}

	public double sueldoAdicional() {
		return 2000 * this.cantExamenes;
	}
}
