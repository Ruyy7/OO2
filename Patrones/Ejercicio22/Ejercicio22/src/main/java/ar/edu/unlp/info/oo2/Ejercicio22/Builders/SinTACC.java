package ar.edu.unlp.info.oo2.Ejercicio22.Builders;

public class SinTACC extends Builder {

	@Override
	public void agergarPan() {
		this.getSandwich().setPan(150);
	}

	@Override
	public void agergarAderezo() {
		this.getSandwich().setAderezo(18);
	}

	@Override
	public void agergarProteina() {
		this.getSandwich().setProteina(250);
	}

	@Override
	public void agergarAdicional() {
		this.getSandwich().setAdicional(200);
	}

}
