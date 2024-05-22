package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	public List<Llamada> llamadas = new ArrayList<Llamada>();
	private String nombre;
	
	public Cliente(String nombre, String numeroTelefono) {
		this.nombre = nombre;
		this.numeroTelefono = numeroTelefono;
	}

	private String numeroTelefono;
	
	public abstract double aplicarDescuento();
	
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
