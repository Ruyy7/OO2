package ar.edu.unlp.info.oo2.Parcial2;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;

public class TestHomeWeather {
    HomeWeatherStation homeWeatherStation;
    HomeWeatherStationAdapter homeWeatherStationAdapter;
    Presion presionAtmosferica;
    RadiacionSolar radiacionSolar;

    @BeforeEach
    void setUp() {
    	List<Double> temperaturas= new ArrayList<>();
    	temperaturas.add(80.0); temperaturas.add(75.0); temperaturas.add(64.0);
        homeWeatherStation = new HomeWeatherStation(84.0, 1000, 500, temperaturas);
    	homeWeatherStationAdapter = new HomeWeatherStationAdapter(homeWeatherStation);
    }
    
    @Test
    public void ejemploParcial(){
    	presionAtmosferica = new Presion(homeWeatherStationAdapter);
    	radiacionSolar = new RadiacionSolar(presionAtmosferica);
    	System.out.print(radiacionSolar.displayData());
    }
}
