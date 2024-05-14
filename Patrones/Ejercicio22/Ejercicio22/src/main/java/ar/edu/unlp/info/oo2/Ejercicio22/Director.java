package ar.edu.unlp.info.oo2.Ejercicio22;

import ar.edu.unlp.info.oo2.Ejercicio22.Builders.Builder;

public class Director {
	private Builder builder;

	public Director(Builder builder) {
		this.builder = builder;
	}
	
	public Sandwich hacerSandwich() {
		this.builder.crearSandwich();
		this.builder.agergarPan();
		this.builder.agergarAderezo();
		this.builder.agergarProteina();
		this.builder.agergarAdicional();
		return this.builder.cerrarSandwich();
	}
	
	public void switchBuilder (Builder otherBuilder) {
		this.builder = otherBuilder;
	}
}
