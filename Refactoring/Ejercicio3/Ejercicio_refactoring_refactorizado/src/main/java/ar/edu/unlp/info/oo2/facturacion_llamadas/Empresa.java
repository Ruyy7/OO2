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
