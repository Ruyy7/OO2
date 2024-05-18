package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.SortedSet;

public class Ultimo implements Generador {

	@Override
	public String obtenerNumeroLibre(SortedSet<String> lineas) {
		String linea = lineas.last();
		lineas.remove(linea);
		return linea;
	}

}
