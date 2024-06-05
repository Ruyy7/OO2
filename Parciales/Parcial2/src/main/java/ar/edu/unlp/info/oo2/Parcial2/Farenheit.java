package ar.edu.unlp.info.oo2.Parcial2;
public class Farenheit extends Component{

    public Farenheit(WeatherStation weatherComponent) {
        super(weatherComponent);
    }

    @Override
    public String displayData() {
        return super.displayData() + "Temperatura F: " + this.getTemperaturaFarenheit();
    }

}
