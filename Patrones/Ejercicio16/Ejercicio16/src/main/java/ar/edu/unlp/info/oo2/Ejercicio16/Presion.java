package ar.edu.unlp.info.oo2.Ejercicio16;

public class Presion extends Component {

	public Presion(WeatherData component) {
		super(component);
	}

	public String displayData() {
		return super.displayData() + "Presión atmosf.: " + this.getPresion() + ";";
	}
}
