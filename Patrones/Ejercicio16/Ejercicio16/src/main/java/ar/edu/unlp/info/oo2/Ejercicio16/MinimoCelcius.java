package ar.edu.unlp.info.oo2.Ejercicio16;

public class MinimoCelcius extends Minimo {

	public MinimoCelcius(WeatherData component) {
		super(component);
	}

	protected double obtenerMinimo() {
		return Math.round(this.getTemperaturas().stream().mapToDouble(t-> (t-32)/1.8).min().orElse(0));
	}

}
