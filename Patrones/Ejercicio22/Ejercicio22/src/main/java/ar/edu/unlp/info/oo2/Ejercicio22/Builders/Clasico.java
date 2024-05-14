package ar.edu.unlp.info.oo2.Ejercicio22.Builders;

public class Clasico extends Builder{

	@Override
	public void agergarPan() {
		this.getSandwich().setPan(100);
	}

	@Override
	public void agergarAderezo() {
		this.getSandwich().setAderezo(20);
	}

	@Override
	public void agergarProteina() {
		this.getSandwich().setProteina(300);
	}

	@Override
	public void agergarAdicional() {
		this.getSandwich().setAdicional(80);
	}
	
}
