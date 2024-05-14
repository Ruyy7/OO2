package ar.edu.unlp.info.oo2.Ejercicio16;

public class PromedioFarenheit extends Promedio {

	public PromedioFarenheit(WeatherData component) {
		super(component);
	}

	protected double obtenerPromedio() {
		return this.getTemperaturas().stream().mapToDouble(t -> t).average().orElse(0);
	}
}
