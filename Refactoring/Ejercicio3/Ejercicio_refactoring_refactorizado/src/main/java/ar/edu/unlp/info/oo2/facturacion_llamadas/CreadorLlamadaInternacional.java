package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class CreadorLlamadaInternacional extends CreadorLlamada {

	@Override
	public Llamada crearLlamada(Cliente origen, Cliente destino, int duracion) {
		return new Internacional(origen,destino,duracion);
	}

}
