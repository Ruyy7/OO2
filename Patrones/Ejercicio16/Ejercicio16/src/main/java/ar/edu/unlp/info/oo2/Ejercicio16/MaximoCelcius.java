package ar.edu.unlp.info.oo2.Ejercicio16;

public class MaximoCelcius extends Maximo {

	public MaximoCelcius(WeatherData component) {
		super(component);
	}

	protected double obtenerMaximo() {
		return Math.round(this.getTemperaturas().stream().mapToDouble(t-> (t-32)/1.8).max().orElse(0));
	}

}
