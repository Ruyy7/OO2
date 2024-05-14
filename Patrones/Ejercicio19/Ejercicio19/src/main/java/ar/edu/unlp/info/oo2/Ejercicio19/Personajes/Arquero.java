package ar.edu.unlp.info.oo2.Ejercicio19.Personajes;

import ar.edu.unlp.info.oo2.Ejercicio19.Builder;
import ar.edu.unlp.info.oo2.Ejercicio19.Armaduras.Cuero;
import ar.edu.unlp.info.oo2.Ejercicio19.Armas.Arco;
import ar.edu.unlp.info.oo2.Ejercicio19.Habilidades.CombateDistancia;

public class Arquero extends Builder {

	@Override
	public void equiparArmadura() {
		this.getPersonaje().setArmadura(new Cuero());
	}

	@Override
	public void equiparArma() {
		this.getPersonaje().setArma(new Arco());
	}

	@Override
	public void otorgarHabilidades() {
		this.getPersonaje().añadirHabilidad(new CombateDistancia());
	}

}
