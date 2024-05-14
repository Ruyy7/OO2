package ar.edu.unlp.info.oo2.Ejercicio15;

public class DecoratorPermisos extends Decorator {

	public DecoratorPermisos(FileOO2 component) {
		super(component);
	}

	@Override
	public String prettyPrint() {
		return super.prettyPrint() + this.getPermisos() + " ";
	}

}
