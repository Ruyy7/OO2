package ar.edu.unlp.info.oo2.Ejercicio16;

public abstract class Maximo extends Component {

	public Maximo(WeatherData component) {
		super(component);
	}
	
	protected abstract double obtenerMaximo();

	public String displayData() {
		return super.displayData() + "Máximo: " + this.obtenerMaximo() + ";";
	}
}
