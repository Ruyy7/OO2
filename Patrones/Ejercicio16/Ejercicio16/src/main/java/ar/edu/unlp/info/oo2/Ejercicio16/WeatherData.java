package ar.edu.unlp.info.oo2.Ejercicio16;

import java.util.List;

public interface WeatherData {
	double getTemperatura();
	double getPresion();
	double getRadiacionSolar();
	List<Double> getTemperaturas();
	String displayData();
}
