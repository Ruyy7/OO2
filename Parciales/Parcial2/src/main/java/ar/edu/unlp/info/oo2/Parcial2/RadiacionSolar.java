package ar.edu.unlp.info.oo2.Parcial2;
public class RadiacionSolar extends Component{

    public RadiacionSolar(WeatherStation weatherComponent) {
        super(weatherComponent);
    }

    @Override
    public String displayData() {
        return super.displayData() + "Radiacion Solar: " + this.getRadiacionSolar();
    }

}
