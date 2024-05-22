package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class CreadorPersonaFisica extends CreadorCliente{

	@Override
	public Cliente crearCliente(String nombre, String numeroTelefono, String identificacion) {
		return new PersonaFisica(nombre,numeroTelefono,identificacion);
	}

}
