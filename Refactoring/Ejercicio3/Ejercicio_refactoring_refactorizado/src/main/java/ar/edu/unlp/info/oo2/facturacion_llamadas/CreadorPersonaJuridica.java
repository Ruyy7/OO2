package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class CreadorPersonaJuridica extends CreadorCliente {

	@Override
	public Cliente crearCliente(String nombre, String numeroTelefono, String identificacion) {
		return new PersonaJuridica(nombre,numeroTelefono,identificacion);
	}


}
