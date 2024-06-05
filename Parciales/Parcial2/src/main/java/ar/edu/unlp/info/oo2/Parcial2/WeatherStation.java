package ar.edu.unlp.info.oo2.Parcial2;

import java.util.List;

public abstract class WeatherStation {
    public abstract double getTemperaturaFarenheit();
    public abstract double getPresion();
    public abstract double getRadiacionSolar();
    public abstract List<Double> getTemperaturasFarenheit();

    public String displayData(){
        return "";
    }
}
