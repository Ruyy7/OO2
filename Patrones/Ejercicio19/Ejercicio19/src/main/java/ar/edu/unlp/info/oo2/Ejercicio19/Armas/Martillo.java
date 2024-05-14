package ar.edu.unlp.info.oo2.Ejercicio19.Armas;

import ar.edu.unlp.info.oo2.Ejercicio19.Armaduras.Acero;
import ar.edu.unlp.info.oo2.Ejercicio19.Armaduras.Cuero;
import ar.edu.unlp.info.oo2.Ejercicio19.Armaduras.Hierro;

public class Martillo extends Arma {

	@Override
	public int atacar(Cuero cuero) {
		return 7;
	}

	@Override
	public int atacar(Hierro hierro) {
		return 6;
	}

	@Override
	public int atacar(Acero acero) {
		return 5;
	}

}
