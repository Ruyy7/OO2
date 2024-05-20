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
(i) Tenemos código de tipo ```private String tipoGenerador = "ultimo";``` el cual, según su valor, actua de una forma u otra.

(ii) Replace Type Code with Strategy. En vez de preguntar por su tipo utilizando switch en este caso o ifs anidados, es mejor que ese comportamiento este contenido en un objeto estrategia (Concrete strategies).

- En este caso creamos la clase **Generador** la cual será una interfaz y por consiguiente las diferentes implementaciones representando la estrategia concreta para cada caso.
- Eliminamos los condicionales y le pedimos al generador que nos otorge el numero libre.

***A considerar***: Si bien en el escenario original no exisite la clase generador, se podría discutir que la clase ```GestorNumerosDisponibles``` es una clase envidiosa la cual estaría realizando tareas que le corresponder a un "Generador".

- Interfaz Generador
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.SortedSet;

public interface Generador {
	String obtenerNumeroLibre(SortedSet<String> lineas);
}
```

- Ultimo
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.SortedSet;

public class Ultimo implements Generador {

	@Override
	public String obtenerNumeroLibre(SortedSet<String> lineas) {
		String linea = lineas.last();
		lineas.remove(linea);
		return linea;
	}

}
```
- Primero
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.SortedSet;

public class Primero implements Generador {

	@Override
	public String obtenerNumeroLibre(SortedSet<String> lineas) {
		String linea = lineas.first();
		lineas.remove(linea);
		return linea;
	}

}
```
- Random
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.SortedSet;

public class Random implements Generador {

	@Override
	public String obtenerNumeroLibre(SortedSet<String> lineas) {
		String linea = new ArrayList<String>(lineas).get(new java.util.Random().nextInt(lineas.size()));
		lineas.remove(linea);
		return linea;
	}
// Por alguna razón no me dejaba usar el Random de java en la sección de imports.
}
```

Una vez implementadas todas las **Concrete Strategy** procedemos a cambiar el código de la clase ```GestorNumerosDisponibles```

- Se cambia ```private String tipoGenerador = "ultimo";``` a ```private Generador tipoGenerador;```
- El setter se cambia
```java
	public void cambiarTipoGenerador(String valor) {
		this.tipoGenerador = valor;
	}
// Nuevo setter
	public void cambiarTipoGenerador(Generador generador) {
		this.tipoGenerador = generador;
	}
```

Por último la clase resultante queda tal que asi:
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.TreeSet;
import java.util.SortedSet;

public class GestorNumerosDisponibles {
	private SortedSet<String> lineas = new TreeSet<String>();
	private Generador tipoGenerador;

	public SortedSet<String> getLineas() {
		return lineas;
	}

	public String obtenerNumeroLibre() {
		return tipoGenerador.obtenerNumeroLibre(lineas);
	}

	public void cambiarTipoGenerador(Generador generador) {
		this.tipoGenerador = generador;
	}
}
```
Borramos los imports que ya no forman parte de la lógica de la clase.
