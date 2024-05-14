package ar.edu.unlp.info.oo2.Ejercicio6a;

import java.util.ArrayList;
import java.util.List;

public class Mixta extends Topografia {
	private List<Topografia> componente;

	public Mixta(Topografia c1, Topografia c2, Topografia c3, Topografia c4) {
		this.componente = new ArrayList<>();
		this.componente.add(c1);this.componente.add(c2);this.componente.add(c3);this.componente.add(c4);
	}
	
	private List<Topografia> getComponente(){
		return this.componente;
	}

	public double proporcionDeAgua() {
		return this.componente.stream().mapToDouble(h -> h.proporcionDeAgua()).average().orElse(0);
	}

	public boolean esIgual(Agua agua) {
		return false;
	}

	public boolean esIgual(Tierra tierra) {
		return false;
	}

	public boolean esIgual(Mixta mixta) {
		return this.proporcionDeAgua() == mixta.proporcionDeAgua() && this.componente.equals(mixta.getComponente());
	}

}

