package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class CreadorLlamadaNacional extends CreadorLlamada {

	@Override
	public Llamada crearLlamada(Cliente origen, Cliente destino, int duracion) {
		return new Nacional(origen,destino,duracion);
	}

}
