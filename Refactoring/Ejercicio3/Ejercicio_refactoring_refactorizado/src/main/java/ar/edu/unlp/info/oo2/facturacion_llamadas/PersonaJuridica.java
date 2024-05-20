package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class PersonaJuridica extends Cliente {

	@Override
	public double aplicarDescuento() {
		return 0.15;
	}
}
