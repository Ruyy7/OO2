package ar.edu.unlp.info.oo2.Ejercicio16;

public class Celsius extends Component {

	public Celsius(WeatherData component) {
		super(component);
	}

	public String displayData() {
		return super.displayData() + "Temperatura C: " + Math.round((this.getTemperatura()- 32)/1.8) + ";";
	}
}
