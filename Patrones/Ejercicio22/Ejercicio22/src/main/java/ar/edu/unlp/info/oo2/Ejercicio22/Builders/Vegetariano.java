package ar.edu.unlp.info.oo2.Ejercicio22.Builders;

public class Vegetariano extends Builder {

	@Override
	public void agergarPan() {
		this.getSandwich().setPan(120);
	}

	@Override
	public void agergarAderezo() {
		this.getSandwich().setAderezo(0);
	}

	@Override
	public void agergarProteina() {
		this.getSandwich().setProteina(200);
	}

	@Override
	public void agergarAdicional() {
		this.getSandwich().setAdicional(100);
	}

}
