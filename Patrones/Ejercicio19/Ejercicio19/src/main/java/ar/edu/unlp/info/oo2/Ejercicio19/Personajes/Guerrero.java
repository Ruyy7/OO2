package ar.edu.unlp.info.oo2.Ejercicio19.Personajes;

import ar.edu.unlp.info.oo2.Ejercicio19.Builder;
import ar.edu.unlp.info.oo2.Ejercicio19.Armaduras.Acero;
import ar.edu.unlp.info.oo2.Ejercicio19.Armas.Espada;
import ar.edu.unlp.info.oo2.Ejercicio19.Habilidades.CuerpoACuerpo;

public class Guerrero extends Builder {

	@Override
	public void equiparArmadura() {
		this.getPersonaje().setArmadura(new Acero());
	}

	@Override
	public void equiparArma() {
		this.getPersonaje().setArma(new Espada());
	}

	@Override
	public void otorgarHabilidades() {
		this.getPersonaje().añadirHabilidad(new CuerpoACuerpo());
	}

}
