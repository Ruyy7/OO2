package ar.edu.unlp.info.oo2.Ejercicio15;

public class DecoratorNombre extends Decorator {

	public DecoratorNombre(FileOO2 component) {
		super(component);
	}

	@Override
	public String prettyPrint() {
		return super.prettyPrint() + this.getNombre() + " ";
	}

}
