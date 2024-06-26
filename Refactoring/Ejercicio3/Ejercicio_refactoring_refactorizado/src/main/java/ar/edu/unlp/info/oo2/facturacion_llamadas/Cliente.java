package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	public List<Llamada> llamadas = new ArrayList<Llamada>();
	private String nombre;
	private String numeroTelefono;
	
	public Cliente(String nombre, String numeroTelefono) {
		this.nombre = nombre;
		this.numeroTelefono = numeroTelefono;
	}

	public abstract double aplicarDescuento();

	// Este método esta deprecado, se debería quitar el parametro Cliente origen.
//    	@Deprecated()
//	public Llamada registrarLlamada(Cliente origen, Cliente destino, String tipo, int duracion) {
//		Llamada llamada = new Llamada(tipo, origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
//		llamadas.add(llamada);
//		origen.llamadas.add(llamada);
//		return llamada;
//	}
	
	public Llamada registrarLlamada(CreadorLlamada creadorLlamada,Cliente destino, int duracion) {
		Llamada llamada = creadorLlamada.crearLlamada(this,destino,duracion);
		this.llamadas.add(llamada);
		return llamada;
	}

	public double calcularMontoTotalLlamadas() {
		double montoTotal = this.llamadas.stream()
			    .filter(llamada -> llamada.getOrigen().esIgual(this))
			    .mapToDouble(llamada -> llamada.calcularMontoLlamada())
			    .sum();
		montoTotal -= montoTotal * this.aplicarDescuento();
		return montoTotal;
   	}
	
	public boolean esIgual(Cliente otroCliente) {
		return this.numeroTelefono.equals(otroCliente.getNumeroTelefono());
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	
}
