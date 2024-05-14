package ar.edu.unlp.info.oo2.Ejercicio13;

import java.util.List;
import java.util.stream.Collectors;

public class Puntaje implements Strategy {

	@Override
	public List<Pelicula> sugerir(Decodificador deco) {
		return deco.getGrilla().stream().sorted((p1,p2) -> p2.getAño().compareTo(p1.getAño()))
				.filter(p -> !deco.getReproducidas().contains(p))
				.sorted((p1,p2) -> Double.compare(p2.getPuntaje(),p1.getPuntaje()))
				.limit(3).collect(Collectors.toList());
	}
	
}
