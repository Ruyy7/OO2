package ar.edu.unlp.info.oo2.Ejercicio15;

public class DecoratorExtension extends Decorator {

	public DecoratorExtension(FileOO2 component) {
		super(component);
	}

	@Override
	public String prettyPrint() {
		return super.prettyPrint() + "." + this.getExtension() + " ";
	}

}
