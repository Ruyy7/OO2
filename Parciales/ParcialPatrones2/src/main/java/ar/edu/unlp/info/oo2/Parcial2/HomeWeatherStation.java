package ar.edu.unlp.info.oo2.Parcial2;
import java.util.List;

public class HomeWeatherStation{
    private double temperatura;
    private double presion;
    private double radiacionSolar;
    private List<Double> temperaturas;

    public HomeWeatherStation(double temperatura, double presion, double radiacionSolar, List<Double> temperaturas) {
        this.temperatura = temperatura;
        this.presion = presion;
        this.radiacionSolar = radiacionSolar;
        this.temperaturas = temperaturas;
        this.temperaturas.add(temperatura);
    }

    public double getTemperaturaFarenheit() {
        return temperatura;
    }

    public double getPresion() {
        return presion;
    }

    public double getRadiacionSolar() {
        return radiacionSolar;
    }

    public List<Double> getTemperaturasFarenheit() {
        return temperaturas;
    }

}

