package ar.edu.unlp.info.oo2.Ejercicio16;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class HomeWeatherStationTest {
	HomeWeatherStation hws;
	List<Double> temperaturas;
	Farenheit f; Celsius c;
	Presion p;
	RadiacionSolar rs;
	PromedioFarenheit pf; PromedioCelcius pc;
	MinimoFarenheit minf; MaximoFarenheit maxf;
	MinimoCelcius minc; MaximoCelcius maxc;
	
	@BeforeEach
	void setUp() {
		temperaturas = new ArrayList<>();
		temperaturas.add(68.0);temperaturas.add(72.0);temperaturas.add(40.0);temperaturas.add(91.0);temperaturas.add(76.0);temperaturas.add(83.0);
		hws = new HomeWeatherStation(86,1008,200,temperaturas);
	}
	
//	DisplayDataDefault -> Temperatura, Presión atmosf., Radiación Solar.
	@Test
	public void displayDataDefaultTestFarenheit() {
		f = new Farenheit (hws);
		p = new Presion (f);
		rs = new RadiacionSolar(p);
		assertEquals(" Temperatura F: 86.0; Presión atmosf.: 1008.0; Radiación solar: 200.0;", rs.displayData());
	}
	
	@Test
	public void displayDataDefaultTestCelsius() {
		c = new Celsius (hws);
		p = new Presion (c);
		rs = new RadiacionSolar(p);
		assertEquals(" Temperatura C: 30; Presión atmosf.: 1008.0; Radiación solar: 200.0;", rs.displayData());
	}
	
//	DisplayDataPromedio -> Temperatura, Presión atmosf., Radiación Solar, Promedio.
	@Test
	public void displayDataPromedioFarenheit() {
		f = new Farenheit (hws);
		p = new Presion (f);
		rs = new RadiacionSolar(p);
		pf = new PromedioFarenheit(rs);
		assertEquals(" Temperatura F: 86.0; Presión atmosf.: 1008.0; Radiación solar: 200.0; Promedio: 74;", pf.displayData());
	}
	
	@Test
	public void displayDataPromedioCelcius() {
		c = new Celsius(hws);
		p = new Presion (c);
		rs = new RadiacionSolar(p);
		pc = new PromedioCelcius(rs);
		assertEquals(" Temperatura C: 30; Presión atmosf.: 1008.0; Radiación solar: 200.0; Promedio: 23;", pc.displayData());
	}
//	DisplayDataMinMax -> Temperatura, Presión atmosf., Radiación Solar, Promedio, Minimo, Maximo.
	@Test
	public void displayDataMinMaxFarenheit() {
		f = new Farenheit (hws);
		p = new Presion (f);
		rs = new RadiacionSolar(p);
		pf = new PromedioFarenheit(rs);
		minf = new MinimoFarenheit(pf);
		maxf = new MaximoFarenheit(minf);
		assertEquals(" Temperatura F: 86.0; Presión atmosf.: 1008.0; Radiación solar: 200.0; Promedio: 74; Mínimo: 40.0; Máximo: 91.0;", maxf.displayData());
	}
	
	@Test
	public void displayDataMinMaxCelcius() {
		c = new Celsius(hws);
		p = new Presion (c);
		rs = new RadiacionSolar(p);
		pc = new PromedioCelcius(rs);
		minc = new MinimoCelcius(pc);
		maxc = new MaximoCelcius(minc);
		assertEquals(" Temperatura C: 30; Presión atmosf.: 1008.0; Radiación solar: 200.0; Promedio: 23; Mínimo: 4.0; Máximo: 33.0;", maxc.displayData());
	}
}
