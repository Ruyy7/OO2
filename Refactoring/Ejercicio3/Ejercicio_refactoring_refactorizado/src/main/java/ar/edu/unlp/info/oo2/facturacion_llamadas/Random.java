package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.SortedSet;

public class Random implements Generador {

	@Override
	public String obtenerNumeroLibre(SortedSet<String> lineas) {
		String linea = new ArrayList<String>(lineas).get(new java.util.Random().nextInt(lineas.size()));
		lineas.remove(linea);
		return linea;
	}
// Por alguna razón no me dejaba usar el Random de java en la sección de imports.
}
