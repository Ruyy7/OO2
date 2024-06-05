package ar.edu.unlp.info.oo2.Parcial2;
public class Presion extends Component{

    public Presion(WeatherStation weatherComponent) {
        super(weatherComponent);
    }

    @Override
    public String displayData() {
        return super.displayData() + "Presion: " + this.getPresion();
    }

}
