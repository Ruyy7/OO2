package ar.edu.unlp.info.oo2.facturacion_llamadas;

public abstract class CreadorLlamada {
	public abstract Llamada crearLlamada(Cliente origen, Cliente destino, int duracion);
}
