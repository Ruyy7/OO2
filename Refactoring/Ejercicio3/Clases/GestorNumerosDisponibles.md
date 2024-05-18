```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.TreeSet;
import java.util.ArrayList;
import java.util.Random;
import java.util.SortedSet;

public class GestorNumerosDisponibles {
	private SortedSet<String> lineas = new TreeSet<String>();
	private String tipoGenerador = "ultimo";

	public SortedSet<String> getLineas() {
		return lineas;
	}

	public String obtenerNumeroLibre() {
		String linea;
		switch (tipoGenerador) {
			case "ultimo":
				linea = lineas.last();
				lineas.remove(linea);
				return linea;
			case "primero":
				linea = lineas.first();
				lineas.remove(linea);
				return linea;
			case "random":
				linea = new ArrayList<String>(lineas)
						.get(new Random().nextInt(lineas.size()));
				lineas.remove(linea);
				return linea;
		}
		return null;
	}

	public void cambiarTipoGenerador(String valor) {
		this.tipoGenerador = valor;
	}
}

```
(i) Tenemos código de tipo ```private String tipoGenerador = "ultimo";``` el cual, según su estado, actua de una forma u otra.

(ii) Replace Type Code with Strategy. En vez de preguntar por su tipo utilizando switch en este caso o ifs anidados, es mejor que ese comportamiento este contenido en un objeto estrategia (Concrete strategies).

- En este caso creamos la clase **Generador** la cual será una interfaz y por consiguiente las diferentes implementaciones representando la estrategia concreta para cada caso.
- Eliminamos los condicionales y le pedimos al generador que nos otorge el numero libre.

***A considerar***: Si bien en el escenario original no exisite la clase generador, se podría discutir que la clase ```GestorNumerosDisponibles``` es una clase envidiosa la cual estaría realizando tareas que le corresponder a un "Generador".

