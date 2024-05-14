package ar.edu.unlp.info.oo2.Ejercicio16;

public abstract class Minimo extends Component{

	public Minimo(WeatherData component) {
		super(component);
	}

	protected abstract double obtenerMinimo();
	
	public String displayData() {
		return super.displayData() + "Mínimo: " + this.obtenerMinimo() + ";";
	}
}
