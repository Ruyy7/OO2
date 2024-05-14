package ar.edu.unlp.info.oo2.Ejercicio16;

public class RadiacionSolar extends Component {

	public RadiacionSolar(WeatherData component) {
		super(component);
	}
	
	public String displayData() {
		return super.displayData() + "Radiación solar: " + this.getRadiacionSolar() + ";";
	}
}
