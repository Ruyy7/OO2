package ar.edu.unlp.info.oo2.Ejercicio15;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDateTime;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ArchivoTest {
	Archivo archivo;
	DecoratorNombre dn; DecoratorExtension de; DecoratorTamaño dt; DecoratorFechaCreacion dfc;
	DecoratorFechaModificacion dfm; DecoratorPermisos dp;
	
	@BeforeEach
	void setUp() {
		archivo = new Archivo("Minecraft","exe",2000,LocalDateTime.of(2011, 9, 6, 23, 30),LocalDateTime.now(),"Ejecucion");
	}
	
	@Test
	public void prettyPrintNombreExtensionTest() {
		dn = new DecoratorNombre(archivo);
		de = new DecoratorExtension(dn);
		assertEquals("Minecraft .exe ", de.prettyPrint());
	}
	
	@Test
//	Nombre-Extension-FechaCreacion
	public void prettyPrintNEFC() {
		dn = new DecoratorNombre(archivo);
		de = new DecoratorExtension(dn);
		dfc = new DecoratorFechaCreacion(de);
		assertEquals("Minecraft .exe 2011-09-06T23:30 ",dfc.prettyPrint());
	}
	
	@Test
//	Permisos-Nombre-Extension-Tamaño
	public void pretyPrintPNET() {
		dp = new DecoratorPermisos(archivo);
		dn = new DecoratorNombre(dp);
		de = new DecoratorExtension(dn);
		dt = new DecoratorTamaño(de);
		assertEquals("Ejecucion Minecraft .exe 2000 ",dt.prettyPrint());
	}
}
