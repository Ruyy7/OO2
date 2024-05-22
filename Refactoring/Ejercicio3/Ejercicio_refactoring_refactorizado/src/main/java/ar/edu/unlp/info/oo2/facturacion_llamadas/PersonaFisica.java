package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class PersonaFisica extends Cliente {
	private String dni;
	
	public PersonaFisica(String nombre, String numeroTelefono, String dni) {
		super(nombre, numeroTelefono);
		this.dni = dni;
	}

	@Override
	public double aplicarDescuento() {
		return 0;
	}

	public String getDNI() {
		return dni;
	}
	
}
