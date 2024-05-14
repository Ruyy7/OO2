package ar.edu.unlp.info.oo2.Ejercicio22;

public class Sandwich {
	private double pan;
	private double aderezo;
	private double proteina;
	private double adicional;
	
	public double precio() {
		return this.pan + this.aderezo + this.proteina + this.adicional;
	}

	public void setPan(double pan) {
		this.pan = pan;
	}

	public void setAderezo(double aderezo) {
		this.aderezo = aderezo;
	}

	public void setProteina(double proteina) {
		this.proteina = proteina;
	}

	public void setAdicional(double adicional) {
		this.adicional = adicional;
	}
	
}
