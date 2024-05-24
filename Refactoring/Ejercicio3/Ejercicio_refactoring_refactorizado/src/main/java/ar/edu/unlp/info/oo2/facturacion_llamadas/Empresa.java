package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public class Empresa {
	private List<Cliente> clientes = new ArrayList<Cliente>();
	private GestorNumerosDisponibles guia;
	
	public Empresa(GestorNumerosDisponibles guia) {
		this.guia = guia;
	}

	public Cliente registrarCliente (CreadorCliente creadorCliente, String nombre, String identificacion) {
		String numeroTelefono = this.guia.obtenerNumeroLibre();
		Cliente cliente = creadorCliente.crearCliente(nombre, numeroTelefono, identificacion);
		this.clientes.add(cliente);
		return cliente;
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
