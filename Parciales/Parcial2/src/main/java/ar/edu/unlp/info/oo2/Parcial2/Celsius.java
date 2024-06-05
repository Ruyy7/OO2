package ar.edu.unlp.info.oo2.Parcial2;
public class Celsius extends Component{

    public Celsius(WeatherStation weatherComponent) {
        super(weatherComponent);
    }

    @Override
    public String displayData() {
        return super.displayData() + "Temperatura ºC: " + this.getTemperaturaCelcius();
    }

}
