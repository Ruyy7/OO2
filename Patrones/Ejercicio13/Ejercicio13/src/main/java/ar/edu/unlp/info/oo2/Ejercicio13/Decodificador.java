package ar.edu.unlp.info.oo2.Ejercicio13;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Decodificador {
	private List<Pelicula> reproducidas = new ArrayList<>();
	private List<Pelicula> grilla = new ArrayList<>();
	private Strategy strategy;
	
	public List<Pelicula> sugerir(){
		return this.strategy.sugerir(this);
	}
	
	public void agregarPelicula(Pelicula pelicula) {
		this.grilla.add(pelicula);
	}
	
	public void reproducir(Pelicula pelicula) {
		this.reproducidas.add(pelicula);
	}
	
	public void setStrategy(Strategy strategy) {
		this.strategy = strategy;
	}

	public List<Pelicula> getReproducidas() {
		return reproducidas;
	}

	public List<Pelicula> getGrilla() {
		return grilla;
	}
	
}
