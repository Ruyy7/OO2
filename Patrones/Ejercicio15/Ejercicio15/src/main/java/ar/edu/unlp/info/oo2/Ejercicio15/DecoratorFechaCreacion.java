package ar.edu.unlp.info.oo2.Ejercicio15;

public class DecoratorFechaCreacion extends Decorator {

	public DecoratorFechaCreacion(FileOO2 component) {
		super(component);
	}

	@Override
	public String prettyPrint() {
		return super.prettyPrint() + this.getFechaCreacion() + " ";
	}

}
