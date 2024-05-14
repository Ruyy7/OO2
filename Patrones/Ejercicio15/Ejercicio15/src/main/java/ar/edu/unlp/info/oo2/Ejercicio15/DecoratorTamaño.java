package ar.edu.unlp.info.oo2.Ejercicio15;

public class DecoratorTamaño extends Decorator {

	public DecoratorTamaño(FileOO2 component) {
		super(component);
	}

	@Override
	public String prettyPrint() {
		return super.prettyPrint() + this.getTamaño() + " ";
	}

}
