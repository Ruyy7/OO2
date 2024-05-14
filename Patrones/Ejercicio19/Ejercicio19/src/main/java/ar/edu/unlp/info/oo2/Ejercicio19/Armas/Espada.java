package ar.edu.unlp.info.oo2.Ejercicio19.Armas;

import ar.edu.unlp.info.oo2.Ejercicio19.Armaduras.Acero;
import ar.edu.unlp.info.oo2.Ejercicio19.Armaduras.Cuero;
import ar.edu.unlp.info.oo2.Ejercicio19.Armaduras.Hierro;

public class Espada extends Arma {

	@Override
	public int atacar(Cuero cuero) {
		return 8;
	}

	@Override
	public int atacar(Hierro hierro) {
		return 5;
	}

	@Override
	public int atacar(Acero acero) {
		return 3;
	}

}
