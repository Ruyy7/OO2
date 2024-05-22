package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class PersonaJuridica extends Cliente {
	private String cuit;
	
	public PersonaJuridica(String nombre, String numeroTelefono, String cuit) {
		super(nombre, numeroTelefono);
		this.cuit = cuit;
	}

	@Override
	public double aplicarDescuento() {
		return 0.15;
	}
	
	public String getCuit() {
		return cuit;
	}
	
}
