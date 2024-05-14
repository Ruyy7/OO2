package ar.edu.unlp.info.oo2.Ejercicio16;

public class PromedioCelcius extends Promedio {

	public PromedioCelcius(WeatherData component) {
		super(component);
	}
	
	protected double obtenerPromedio() {
		return this.getTemperaturas().stream().mapToDouble(t -> ((t-32)/1.8)).average().orElse(0);
	}

}
