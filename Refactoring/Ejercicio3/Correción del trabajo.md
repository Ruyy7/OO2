En general los refactorings aplicados estan bien, la documentacion no muestra el paso a paso pero lista todo lo aplicado. Alguns detalles a revisar:

Las clases creadoras como esta CreadorPersonaFisica no aportan nada mas que lamar al constructor, aplicar un patron creacional aqui es innecesario y es una sobre-ingenieria del problema. Lo mismo pasa con los otros creadores aplicados.

Luego, en el generador, la guia llama de esta forma

```java
public String obtenerNumeroLibre() {

		return tipoGenerador.obtenerNumeroLibre(this.lineas);

	}
```
En este metodo le esta pasando directamente su variable de instancia  lineas y el objeto que la recibe la manipula, por ej:

```java
	public String obtenerNumeroLibre(SortedSet<String> lineas) {

..

		lineas.remove(linea);
```

Esto es un bad smell y deberia evitarse, ya que es propenso a errores. En este caso la solucion pasa por pasar por paramtro al contexto:

```java
public String obtenerNumeroLibre() {

return tipoGenerador.obtenerNumeroLibre(this);

}
```

El codigo de LlamadaInternacional y LlamadaNacional es practicamente identico, podria refactorizarse con un template method en la superclase de ambas (Llamada).

Nota: Aprobado.
