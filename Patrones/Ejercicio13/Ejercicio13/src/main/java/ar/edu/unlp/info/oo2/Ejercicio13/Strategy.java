package ar.edu.unlp.info.oo2.Ejercicio13;

import java.util.List;

public interface Strategy {
	List<Pelicula> sugerir(Decodificador deco);
}
