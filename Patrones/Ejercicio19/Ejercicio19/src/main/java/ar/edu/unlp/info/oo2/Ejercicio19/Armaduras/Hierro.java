package ar.edu.unlp.info.oo2.Ejercicio19.Armaduras;

import ar.edu.unlp.info.oo2.Ejercicio19.Armas.Arco;
import ar.edu.unlp.info.oo2.Ejercicio19.Armas.Arma;
import ar.edu.unlp.info.oo2.Ejercicio19.Armas.Baston;
import ar.edu.unlp.info.oo2.Ejercicio19.Armas.Espada;
import ar.edu.unlp.info.oo2.Ejercicio19.Armas.Martillo;

public class Hierro extends Armadura{

	@Override
	public int recibirDaño(Arma arma) {
		return arma.atacar(this);
	}


}
