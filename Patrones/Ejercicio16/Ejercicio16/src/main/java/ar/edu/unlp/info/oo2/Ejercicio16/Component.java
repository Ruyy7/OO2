package ar.edu.unlp.info.oo2.Ejercicio16;

import java.util.List;

public abstract class Component implements WeatherData{
	private WeatherData component;

	public Component(WeatherData component) {
		this.component = component;
	}

	public double getTemperatura() {
		return this.component.getTemperatura();
	}

	public double getPresion() {
		return this.component.getPresion();
	}

	public double getRadiacionSolar() {
		return this.component.getRadiacionSolar();
	}

	public List<Double> getTemperaturas() {
		return this.component.getTemperaturas();
	}

	public String displayData() {
		return this.component.displayData() + " ";
	}
	
}
