package ar.edu.unlp.info.oo2.Parcial2;
import java.util.List;

public abstract class Component extends WeatherStation{
    private WeatherStation weatherComponent;

    public Component(WeatherStation weatherComponent) {
        this.weatherComponent = weatherComponent;
    }

    @Override
    public double getPresion() {
        return this.weatherComponent.getPresion();
    }

    @Override
    public double getRadiacionSolar() {
        return this.weatherComponent.getRadiacionSolar();
    }

    @Override
    public double getTemperaturaFarenheit() {
        return this.weatherComponent.getTemperaturaFarenheit();
    }

    @Override
    public List<Double> getTemperaturasFarenheit() {
        return this.weatherComponent.getTemperaturasFarenheit();
    }

    @Override
    public String displayData() {
        return this.weatherComponent.displayData() + " ";
    }
    
    public double getTemperaturaCelcius(){
        return (this.getTemperaturaFarenheit() - 32) / 1.8;
    }
    
}
