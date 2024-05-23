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

    	@Deprecated()
	public Llamada registrarLlamada(Cliente origen, Cliente destino, String t, int duracion) {
		Llamada llamada = new Llamada(t, origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
		llamadas.add(llamada);
		origen.llamadas.add(llamada);
		return llamada;
	}
	
	public Llamada registrarLlamada(CreadorLlamada creadorLlamada, Cliente origen, Cliente destino, int duracion) {
		Llamada llamada = creadorLlamada.crearLlamada(origen,destino,duracion);
		llamadas.add(llamada);
		origen.llamadas.add(llamada);
		return llamada;
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
