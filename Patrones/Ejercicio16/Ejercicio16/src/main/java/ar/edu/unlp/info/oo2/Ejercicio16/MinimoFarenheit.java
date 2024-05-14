package ar.edu.unlp.info.oo2.Ejercicio16;

public class MinimoFarenheit extends Minimo {

	public MinimoFarenheit(WeatherData component) {
		super(component);
	}
	
	protected double obtenerMinimo() {
		return this.getTemperaturas().stream().min((t1,t2) -> Double.compare(t1, t2)).orElse(null);
	}

}
