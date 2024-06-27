package ar.edu.unlp.info.oo2.Parcial2;

import java.util.List;

public class HomeWeatherStationAdapter extends WeatherStation{
    private HomeWeatherStation homeWeatherStation;

    public HomeWeatherStationAdapter(HomeWeatherStation homeWeatherStation) {
        this.homeWeatherStation = homeWeatherStation;
    }

    @Override
    public double getTemperaturaFarenheit() {
        return this.homeWeatherStation.getTemperaturaFarenheit();
    }

    @Override
    public double getPresion() {
        return this.homeWeatherStation.getPresion();
    }

    @Override
    public double getRadiacionSolar() {
        return this.homeWeatherStation.getRadiacionSolar();
    }

    @Override
    public List<Double> getTemperaturasFarenheit() {
        return this.homeWeatherStation.getTemperaturasFarenheit();
    }

    @Override
    public String displayData(){
        return "";
    }
}
