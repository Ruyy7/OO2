package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private GestorNumerosDisponibles guia = new GestorNumerosDisponibles();

	public Cliente registrarCliente (CreadorCliente creadorCliente, String nombre, String numeroTelefono, String identificacion) {
		if (this.guia.agregarNumeroTelefono(numeroTelefono)){
			Cliente cliente = creadorCliente.crearCliente(nombre, numeroTelefono, identificacion);
			this.clientes.add(cliente);
		}
		return null;
	}
	
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
	
	public double calcularMontoTotalLlamadas(Cliente cliente) {
		return this.llamadas.stream()
	            .filter(llamada -> llamada.getOrigen().esIgual(cliente))
	            .mapToDouble(llamada -> llamada.calcularMontoLlamada())
	            .sum();
	    }

	public int cantidadDeUsuarios() {
		return clientes.size();
	}

	public boolean existeUsuario(Cliente persona) {
		return clientes.contains(persona);
	}

	public GestorNumerosDisponibles getGestorNumeros() {
		return this.guia;
	}
}
