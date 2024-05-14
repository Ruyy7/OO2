package ar.edu.unlp.info.oo2.Ejercicio16;

public class MaximoFarenheit extends Maximo {

	public MaximoFarenheit(WeatherData component) {
		super(component);
	}

	protected double obtenerMaximo() {
		return this.getTemperaturas().stream().mapToDouble(t -> t).max().orElse(0);
	}

}
