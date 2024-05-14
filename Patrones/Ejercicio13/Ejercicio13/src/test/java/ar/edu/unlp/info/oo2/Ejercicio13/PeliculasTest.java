package ar.edu.unlp.info.oo2.Ejercicio13;

import static org.junit.jupiter.api.Assertions.*;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class PeliculasTest {
	Decodificador deco;
	Pelicula p1,p2,p3,p4,p5,p6;
	
	@BeforeEach
	void setUp() {
		deco = new Decodificador();
		p1 = new Pelicula("Thor",Year.of(2007),7.9);
		p2 = new Pelicula("Capitan America",Year.of(2016),7.8);
		p3 = new Pelicula("Iron man",Year.of(2010),7.9);
		p4 = new Pelicula("Dunkirk",Year.of(2017),7.9);
		p5 = new Pelicula("Rocky",Year.of(1976),8.1);
		p6 = new Pelicula("Rambo",Year.of(1979),7.8);
		
		p1.agregarSimilar(p2); p1.agregarSimilar(p3);
		p2.agregarSimilar(p3);
		p5.agregarSimilar(p6);
		
		deco.agregarPelicula(p1);deco.agregarPelicula(p2);deco.agregarPelicula(p3);deco.agregarPelicula(p4);deco.agregarPelicula(p5);deco.agregarPelicula(p6);
		deco.reproducir(p1); deco.reproducir(p5);
	}
	
	@Test
	public void sugerirPuntajeTest() {
		deco.setStrategy(new Puntaje());
		List<Pelicula> aux = deco.sugerir();
		List<Pelicula> aux2 = new ArrayList<>();
		aux2.add(p4); aux2.add(p3); aux2.add(p2);
		assertTrue(aux.equals(aux2));
	}
	
	@Test
	public void sugerirNovedadTest() {
		deco.setStrategy(new Novedad());
		List<Pelicula> aux = deco.sugerir();
		List<Pelicula> aux2 = new ArrayList<>();
		aux2.add(p4); aux2.add(p2); aux2.add(p3);
		assertTrue(aux.equals(aux2));
	}
	
	@Test
	public void sugerirSimilaresTest() {
		deco.setStrategy(new Similaridad());
		List<Pelicula> aux = deco.sugerir();
		List<Pelicula> aux2 = new ArrayList<>();
		aux2.add(p2); aux2.add(p3); aux2.add(p6);
		assertTrue(aux.equals(aux2));
	}
}
