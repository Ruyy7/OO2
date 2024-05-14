package ar.edu.unlp.info.oo2.Ejercicio11;

public class Confirmada extends Etapa {

	public Confirmada(Proyecto proyecto) {
		super(proyecto);
	}

	public void aprobarEtapa() {
		System.out.println("El proyecto ya fue confirmado.");
	}

	public void modificarMargenGanancia(double margen) {
		System.out.println("El proyecto ya fue confirmado, no se puede modificar el margen de ganancia");
	}

}
