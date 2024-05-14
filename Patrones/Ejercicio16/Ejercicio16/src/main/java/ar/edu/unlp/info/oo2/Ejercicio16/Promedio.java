package ar.edu.unlp.info.oo2.Ejercicio16;

public abstract class Promedio extends Component {

	public Promedio(WeatherData component) {
		super(component);
	}

	protected abstract double obtenerPromedio();
	
	public String displayData() {
		return super.displayData() + "Promedio: " +Math.round(this.obtenerPromedio()) + ";";
	}
}
