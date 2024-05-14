package ar.edu.unlp.info.oo2.Ejercicio19.Personajes;

import ar.edu.unlp.info.oo2.Ejercicio19.Builder;
import ar.edu.unlp.info.oo2.Ejercicio19.Armaduras.Cuero;
import ar.edu.unlp.info.oo2.Ejercicio19.Armaduras.Hierro;
import ar.edu.unlp.info.oo2.Ejercicio19.Armas.Baston;
import ar.edu.unlp.info.oo2.Ejercicio19.Armas.Martillo;
import ar.edu.unlp.info.oo2.Ejercicio19.Habilidades.CombateDistancia;
import ar.edu.unlp.info.oo2.Ejercicio19.Habilidades.LanzarRayos;
import ar.edu.unlp.info.oo2.Ejercicio19.Habilidades.Magia;

public class Thoor extends Builder {

	@Override
	public void equiparArmadura() {
		this.getPersonaje().setArmadura(new Hierro());
	}

	@Override
	public void equiparArma() {
		this.getPersonaje().setArma(new Martillo());
	}

	@Override
	public void otorgarHabilidades() {
		this.getPersonaje().añadirHabilidad(new CombateDistancia());
		this.getPersonaje().añadirHabilidad(new LanzarRayos());
	}

}
