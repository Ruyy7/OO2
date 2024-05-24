package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.TreeSet;
import java.util.SortedSet;

public class GestorNumerosDisponibles {
	private SortedSet<String> lineas = new TreeSet<String>();
	private Generador tipoGenerador = new Ultimo();

	public SortedSet<String> getLineas() {
		return lineas;
	}
	
	public boolean agregarNumeroTelefono(String numero) {
		if (!this.lineas.contains(numero)) {
			return this.lineas.add(numero);
		}
		return false;
	}

	public String obtenerNumeroLibre() {
		return tipoGenerador.obtenerNumeroLibre(this.lineas);
	}

	public void cambiarTipoGenerador(Generador generador) {
		this.tipoGenerador = generador;
	}
}

