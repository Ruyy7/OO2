package ar.edu.unlp.info.oo2.Ejercicio22.Builders;

import ar.edu.unlp.info.oo2.Ejercicio22.Sandwich;

public abstract class Builder {
	private Sandwich sandwich;
	
	public void crearSandwich() {
		this.sandwich = new Sandwich();
	}
	
	public Sandwich cerrarSandwich() {
		return this.sandwich;
	}
	
	protected Sandwich getSandwich() {
		return sandwich;
	}

	public abstract void agergarPan();
	public abstract void agergarAderezo();
	public abstract void agergarProteina();
	public abstract void agergarAdicional();
	
}
