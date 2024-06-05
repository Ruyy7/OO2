package ar.edu.unlp.info.oo2.Parcial2;
public class PromedioCelcius extends Component{

    public PromedioCelcius(WeatherStation weatherComponent) {
        super(weatherComponent);
    }

    @Override
    public String displayData() {
        return super.displayData() + "Promedio C: " + this.getTemperaturasFarenheit().stream().mapToDouble(temperatura -> (temperatura - 32) / 1.8 ).average().orElse(0);
    }
    
}
