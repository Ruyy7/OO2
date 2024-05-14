package ar.edu.unlp.info.oo2.Ejercicio13;

import java.time.Year;
import java.util.ArrayList;
import java.util.List;

public class Pelicula {
	private String titulo;
	private Year año;
	private double puntaje;
	private List<Pelicula> similares;
	
	public Pelicula(String titulo, Year año, double puntaje) {
		this.titulo = titulo;
		this.año = año;
		this.puntaje = puntaje;
		this.similares = new ArrayList<>();
	}
	
	public void agregarSimilar(Pelicula pelicula) {
		if (!this.similares.contains(pelicula)) {
			this.similares.add(pelicula);
			pelicula.agregarSimilar(this);
		}
	}

	public String getTitulo() {
		return titulo;
	}

	public Year getAño() {
		return año;
	}

	public double getPuntaje() {
		return puntaje;
	}

	public List<Pelicula> getSimilares() {
		return similares;
	}
	
}
