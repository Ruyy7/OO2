package ar.edu.unlp.info.oo2.Ejercicio6a;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TopografiasTest {
	Agua agua;
	Tierra tierra;
	Mixta mixtaC,mixtaD;
	
	@BeforeEach
	void setUp() {
		agua = new Agua();
		tierra = new Tierra();
		mixtaC = new Mixta (agua,tierra,tierra,agua);
		mixtaD = new Mixta (agua,tierra,tierra,mixtaC);
	}
	
	@Test
	public void testProporciones() {
		assertEquals(1,agua.proporcionDeAgua());
		assertEquals(0,tierra.proporcionDeAgua());
		assertEquals(0.5,mixtaC.proporcionDeAgua());
		assertEquals(0.375,mixtaD.proporcionDeAgua());
	}
	
	@Test
	public void testIgualdad() {
		assertFalse(mixtaC.esIgual(mixtaD));
		Mixta mixtaSimple = new Mixta (agua,tierra,tierra,agua);
		assertTrue(mixtaSimple.esIgual(mixtaC));
	}
}
