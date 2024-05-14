package ar.edu.unlp.info.oo2.Ejercicio4;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class sueldosEmpleadosTest {
	Temporario t1,t2;
	Pasante pasante;
	Planta p1,p2;
	
	@BeforeEach
	void setUp() {
		t1 = new Temporario(2,false,20);
		t2 = new Temporario(1,true,26);
		pasante = new Pasante (3,true,5);
		p1 = new Planta (1,false,3);
		p2 = new Planta (0,true,5);
	}
	
	@Test
	public void testTemporariosSueldos() {
		assertEquals(t1.sueldo(), 30000-3380-200);
		assertEquals(t2.sueldo(),34800-3614-350);
	}
	
	@Test
	public void testPasanteSueldo() {
		assertEquals(pasante.sueldo(),30000-2600-500);
	}
	
	@Test
	public void testPlantaSueldos() {
		assertEquals(p1.sueldo(),58000-6500-400);
		assertEquals(p2.sueldo(),65000-6500-750);
	}
}
