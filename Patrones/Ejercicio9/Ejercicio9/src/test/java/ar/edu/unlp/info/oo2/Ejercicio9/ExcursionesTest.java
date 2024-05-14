package ar.edu.unlp.info.oo2.Ejercicio9;

import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class ExcursionesTest {
	Usuario u1,u2,u3;
	Excursion kayakParana,baseMarambio;
	
	@BeforeEach
	void setUp() {
		u1 = new Usuario("Matias","Cuacci","m@yahoo.com");
		u2 = new Usuario("Marcos","Bumstead","mb@yahoo.com");
		u3 = new Usuario("Ronnie","Coleman","rc@yahoo.com");
		kayakParana = new Excursion("Dos días en kayak bajando el Paraná",LocalDate.of(2024, 4, 13),LocalDate.of(2024, 4, 15),"Rosario",300,1,2);
		baseMarambio = new Excursion("Visitando la base en la Antartida",LocalDate.of(2024, 4, 13),LocalDate.of(2024, 4, 15),"Antartida",800,2,5);
		
	}
	
	@Test
	public void inscripcionTest() {
		kayakParana.inscribir(u1);
		assertTrue(kayakParana.getState() instanceof Definitiva);
		kayakParana.inscribir(u2);
		assertTrue(kayakParana.getState() instanceof DefinitivaCompleta);
		kayakParana.inscribir(u3);
		assertEquals(1,kayakParana.getEnEspera().size());
		baseMarambio.inscribir(u3);
		assertTrue(baseMarambio.getState() instanceof Provisoria);
	}
}


