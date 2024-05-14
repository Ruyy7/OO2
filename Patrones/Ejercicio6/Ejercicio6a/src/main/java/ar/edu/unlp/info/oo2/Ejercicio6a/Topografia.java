package ar.edu.unlp.info.oo2.Ejercicio6a;

public abstract class Topografia {
	
	public double proporcionDeTierra() {
		return 1 - this.proporcionDeAgua();
	}
	
	public abstract double proporcionDeAgua();
	public abstract boolean esIgual(Agua agua);
	public abstract boolean esIgual(Tierra tierra);
	public abstract boolean esIgual(Mixta mixta);
	
}
