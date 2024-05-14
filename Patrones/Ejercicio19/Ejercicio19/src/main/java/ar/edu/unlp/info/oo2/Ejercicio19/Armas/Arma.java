package ar.edu.unlp.info.oo2.Ejercicio19.Armas;

import ar.edu.unlp.info.oo2.Ejercicio19.Armaduras.Acero;
import ar.edu.unlp.info.oo2.Ejercicio19.Armaduras.Armadura;
import ar.edu.unlp.info.oo2.Ejercicio19.Armaduras.Cuero;
import ar.edu.unlp.info.oo2.Ejercicio19.Armaduras.Hierro;

public abstract class Arma {
	public abstract int atacar(Cuero cuero);
	public abstract int atacar(Hierro hierro);
	public abstract int atacar(Acero acero);
}
