package ar.edu.unlp.info.oo2.Ejercicio11;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestProyecto {
	Proyecto vacacionesInvierno,vacacionesVerano;
	
	@BeforeEach
	void setUp() {
		vacacionesInvierno = new Proyecto("Vacaciones de invierno",LocalDate.of(2024, 4, 15),LocalDate.of(2024, 4, 18),"salir con amigos",3,300);
		vacacionesVerano = new Proyecto("Vacaciones de verano",LocalDate.of(2024, 4, 15),LocalDate.of(2024, 4, 18),"tomar sol",0,300);
	}
	
	@Test
	public void aprobarEtapaTest() {
		vacacionesInvierno.aprobarEtapa();
		assertTrue(vacacionesInvierno.getEtapa() instanceof EnEvaluacion);
		Exception aprobarEtapaError = assertThrows (RuntimeException.class, () -> {vacacionesVerano.aprobarEtapa();});
		assertEquals("El precio del proyecto es 0",aprobarEtapaError.getMessage());
	}
	
	@Test
	public void modificarMargenGananciaTest() {
		vacacionesInvierno.aprobarEtapa();
		vacacionesInvierno.modificarMargenGanancia(0.2);
		assertEquals(0.07,vacacionesInvierno.getMargenGanancia());
		vacacionesInvierno.modificarMargenGanancia(0.12);
		assertEquals(0.12,vacacionesInvierno.getMargenGanancia());
	}
}

