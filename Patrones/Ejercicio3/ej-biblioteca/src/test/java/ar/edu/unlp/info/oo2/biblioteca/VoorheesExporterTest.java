package ar.edu.unlp.info.oo2.biblioteca;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class VoorheesExporterTest {
	List<Socio> socios;
	Socio Arya,Tyron;
	VoorheesExporter exporter;
	
	@BeforeEach
	void setUp() {
		Arya = new Socio("Arya Stark", "needle@stark.com", "5234-5");
		Tyron = new Socio("Tyron Lannister", "tyron@thelannisters.com",  "2345-2");
		exporter = new VoorheesExporter();
	}
	
	@Test
	public void testExportarListaVacia() {
		socios = new ArrayList<>();
		String test = exporter.exportar(socios);
		assertEquals(test,"[]");
	}
	
	@Test
	public void testExportarLista() {
		socios = new ArrayList<>();
		socios.add(Arya); socios.add(Tyron);
		String test = exporter.exportar(socios);
		assertEquals(test,"[\r\n"
				+ "	{\r\n"
				+ "		\"nombre\": \"Arya Stark\",\r\n"
				+ "		\"email\": \"needle@stark.com\",\r\n"
				+ "		\"legajo\": \"5234-5\"\r\n"
				+ "	},\r\n"
				+ "	{\r\n"
				+ "		\"nombre\": \"Tyron Lannister\",\r\n"
				+ "		\"email\": \"tyron@thelannisters.com\",\r\n"
				+ "		\"legajo\": \"2345-2\"\r\n"
				+ "	}\r\n"
				+ "]");
	}
}
