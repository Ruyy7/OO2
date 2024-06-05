package ar.edu.unlp.info.oo2.Parcial2;
public class PromedioFarenheit extends Component{

    public PromedioFarenheit(WeatherStation weatherComponent) {
        super(weatherComponent);
    }

    @Override
    public String displayData() {
        return super.displayData() + "Promedio F: " + this.getTemperaturasFarenheit().stream().mapToDouble(temperatura -> temperatura).average().orElse(0);
    }

}
