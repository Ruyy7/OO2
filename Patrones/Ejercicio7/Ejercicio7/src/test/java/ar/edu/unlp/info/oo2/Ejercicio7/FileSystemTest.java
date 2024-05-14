package ar.edu.unlp.info.oo2.Ejercicio7;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class FileSystemTest {
	Archivo a1,a2,a3,a4,a5,a6;
	Directorio raiz,directorioA,directorioB,directorioC;
	
	@BeforeEach
	void setUp() {
		a1 = new Archivo ("A.1",LocalDate.of(2024, 9, 30),48);
		a2 = new Archivo ("A.2",LocalDate.of(2024, 8, 14),32);
		a3 = new Archivo ("B.3",LocalDate.of(2024, 10, 28),100);
		a4 = new Archivo ("A.4",LocalDate.of(2024, 7, 1),120);
		a5 = new Archivo ("B.5",LocalDate.of(2024, 6, 9),70);
		a6 = new Archivo ("B.3",LocalDate.of(2024, 10, 28),99);
		raiz = new Directorio ("Home",LocalDate.of(2024, 3, 2));
		directorioA = new Directorio ("Dir A",LocalDate.of(2024, 3, 3));
		directorioB = new Directorio ("Dir B",LocalDate.of(2024, 3, 3));
		directorioC = new Directorio ("Dir C",LocalDate.of(2024, 3, 4));
		
//		Raiz
		raiz.agregar(a1);
		raiz.agregar(directorioA); raiz.agregar(directorioB);
//		Direcotorio A
		directorioA.agregar(a2); directorioA.agregar(a3);
//		Directorio B
		directorioB.agregar(a4); directorioB.agregar(directorioC);
//		Directorio C
		directorioC.agregar(a5); directorioC.agregar(a6);
	}
	
	@Test
	public void testArchivoMasGrande() {
		assertEquals(a4, raiz.archivoMasGrande());
	}
	
	@Test
	public void testArchivoMasNuevo() {
		assertEquals(a3,raiz.archivoMasNuevo());
	}
	
	@Test
	public void testBuscar() {
		assertEquals(a3,raiz.buscar("B.3"));
	}
	
	@Test
	public void testBuscarTodos() {
		assertEquals(2,raiz.buscarTodos("B.3").size());
	}
}
