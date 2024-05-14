package ar.edu.unlp.info.oo2.Ejercicio9;

public abstract class State {
	private Excursion excursion;

	public State(Excursion excursion) {
		this.excursion = excursion;
	}
	
	public Excursion getExcursion() {
		return this.excursion;
	}

	public abstract void inscribir(Usuario unUsuario);
	public abstract String obtenerInformacion();
}
