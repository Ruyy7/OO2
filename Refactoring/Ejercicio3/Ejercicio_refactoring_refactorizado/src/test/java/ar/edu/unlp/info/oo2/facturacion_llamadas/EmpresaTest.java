package ar.edu.unlp.info.oo2.facturacion_llamadas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class EmpresaTest {
	Empresa sistema;
	GestorNumerosDisponibles guia;
	CreadorPersonaFisica creadorPersonaFisica;
	CreadorPersonaJuridica creadorPersonaJuridica;
	CreadorLlamadaNacional creadorLlamadaNacional;
	CreadorLlamadaInternacional creadorLlamadaInternacional;

	@BeforeEach
	public void setUp() {
		this.sistema = new Empresa();
		this.guia = new GestorNumerosDisponibles();
		this.creadorPersonaFisica = new CreadorPersonaFisica();
		this.creadorPersonaJuridica = new CreadorPersonaJuridica();
		this.creadorLlamadaNacional = new CreadorLlamadaNacional();
		this.creadorLlamadaInternacional = new CreadorLlamadaInternacional();
		this.guia.agregarNumeroTelefono("2214444554");
		this.guia.agregarNumeroTelefono("2214444555");
		this.guia.agregarNumeroTelefono("2214444556");
		this.guia.agregarNumeroTelefono("2214444557");
		this.guia.agregarNumeroTelefono("2214444558");
		this.guia.agregarNumeroTelefono("2214444559");
	}

	@Test
	void testcalcularMontoTotalLlamadas() {
		Cliente emisorPersonaFisca = sistema.registrarCliente(creadorPersonaFisica, "11555666", "Brendan Eich");
		Cliente remitentePersonaFisica = sistema.registrarCliente(creadorPersonaFisica, "00000001", "Doug Lea");
		Cliente emisorPersonaJuridica = sistema.registrarCliente(creadorPersonaJuridica, "17555222", "Nvidia Corp");
		Cliente remitentePersonaJuridica = sistema.registrarCliente(creadorPersonaJuridica, "25765432", "Sun Microsystems");

		emisorPersonaJuridica.registrarLlamada(creadorLlamadaNacional, remitentePersonaFisica, 10);
		emisorPersonaJuridica.registrarLlamada(creadorLlamadaInternacional, remitentePersonaFisica, 8);
		emisorPersonaJuridica.registrarLlamada(creadorLlamadaNacional, remitentePersonaJuridica, 5);
		emisorPersonaJuridica.registrarLlamada(creadorLlamadaInternacional, remitentePersonaJuridica, 7);
		emisorPersonaFisca.registrarLlamada(creadorLlamadaNacional, remitentePersonaFisica, 15);
		emisorPersonaFisca.registrarLlamada(creadorLlamadaInternacional, remitentePersonaFisica, 45);
		emisorPersonaFisca.registrarLlamada(creadorLlamadaNacional,remitentePersonaJuridica, 13);
		emisorPersonaFisca.registrarLlamada(creadorLlamadaInternacional, remitentePersonaJuridica, 17);

		assertEquals(11454.64, emisorPersonaFisca.calcularMontoTotalLlamadas(), 0.01);
		assertEquals(2445.40, emisorPersonaJuridica.calcularMontoTotalLlamadas(), 0.01);
		assertEquals(0, remitentePersonaFisica.calcularMontoTotalLlamadas());
		assertEquals(0, remitentePersonaJuridica.calcularMontoTotalLlamadas());
	}

	@Test
	void testAgregarUsuario() {
		assertEquals(this.sistema.cantidadDeUsuarios(), 0);
		this.guia.agregarNumeroTelefono("2214444558"); 
		Cliente nuevaPersona = this.sistema.registrarCliente(creadorPersonaFisica,"2444555","Alan Turing");

		assertEquals(1, this.sistema.cantidadDeUsuarios());
		assertTrue(this.sistema.existeUsuario(nuevaPersona));
	}

	@Test
	void obtenerNumeroLibre() {
		// por defecto es el ultimo
		assertEquals("2214444559", this.guia.obtenerNumeroLibre());

		this.guia.cambiarTipoGenerador(new Primero());
		assertEquals("2214444554", this.guia.obtenerNumeroLibre());

		this.guia.cambiarTipoGenerador(new Random());
		assertNotNull(this.guia.obtenerNumeroLibre());
	}
}
