package ar.edu.unlp.info.oo2.Ejercicio4;

public abstract class Empleado {
	private int cantHijos;
	private boolean casado;
	
	public Empleado(int cantHijos, boolean casado) {
		this.cantHijos = cantHijos;
		this.casado = casado;
	}
	
	public double sueldo() {
		return this.sueldoBasico() + this.sueldoAdicional() - this.descuento();
	}
	
	public double descuento() {
		return this.sueldoBasico()*0.13 + this.sueldoAdicional()*0.05;
	}
	
	public boolean estaCasado() {
		return this.casado;
	}
	
	public int getCantHijos() {
		return this.cantHijos;
	}
	
	public abstract double sueldoBasico();
	public abstract double sueldoAdicional();
}
