package ar.edu.unlp.info.oo2.Ejercicio15;

public class DecoratorFechaModificacion extends Decorator {

	public DecoratorFechaModificacion(FileOO2 component) {
		super(component);
	}

	@Override
	public String prettyPrint() {
		return super.prettyPrint() + this.getFechaModificacion() + " ";
	}

}
