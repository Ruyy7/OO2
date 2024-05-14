package ar.edu.unlp.info.oo2.Ejercicio13;

import java.util.List;
import java.util.stream.Collectors;

public class Similaridad implements Strategy {

	@Override
	public List<Pelicula> sugerir(Decodificador deco) {
		return deco.getGrilla().stream().map(p -> p.getSimilares()).flatMap(p -> p.stream()).distinct().
				sorted((p1,p2) -> p2.getAño().compareTo(p1.getAño())).
				filter(p -> !deco.getReproducidas().contains(p)).
				limit(3).collect(Collectors.toList());
	}

}
