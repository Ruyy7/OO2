package ar.edu.unlp.info.oo2.Ejercicio19.Personajes;

import ar.edu.unlp.info.oo2.Ejercicio19.Builder;
import ar.edu.unlp.info.oo2.Ejercicio19.Armaduras.Cuero;
import ar.edu.unlp.info.oo2.Ejercicio19.Armas.Baston;
import ar.edu.unlp.info.oo2.Ejercicio19.Habilidades.CombateDistancia;
import ar.edu.unlp.info.oo2.Ejercicio19.Habilidades.Magia;

public class Mago extends Builder {

	@Override
	public void equiparArmadura() {
		this.getPersonaje().setArmadura(new Cuero());
	}

	@Override
	public void equiparArma() {
		this.getPersonaje().setArma(new Baston());
	}

	@Override
	public void otorgarHabilidades() {
		this.getPersonaje().añadirHabilidad(new Magia());
		this.getPersonaje().añadirHabilidad(new CombateDistancia());
	}

}
