package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.TreeSet;
import java.util.SortedSet;

public class GestorNumerosDisponibles {
	private SortedSet<String> lineas = new TreeSet<String>();
	private Generador tipoGenerador;

	public SortedSet<String> getLineas() {
		return lineas;
	}
	
	public boolean agregarNumeroTelefono(String numero) {
		return this.lineas.contains(numero)? this.lineas.add(numero):false;
	}

	public String obtenerNumeroLibre() {
		return tipoGenerador.obtenerNumeroLibre(this.lineas);
	}

	public void cambiarTipoGenerador(Generador generador) {
		this.tipoGenerador = generador;
	}
}

