package ar.edu.unlp.info.oo2.Ejercicio16;

public class Farenheit extends Component {

	public Farenheit(WeatherData component) {
		super(component);
	}

	public String displayData() {
		return super.displayData() + "Temperatura F: " + this.getTemperatura() + ";";
	}
}
