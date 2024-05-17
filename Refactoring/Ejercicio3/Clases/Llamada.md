```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class Llamada {
	private String tipoDeLlamada;
	private String origen;
	private String destino;
	private int duracion;

	public Llamada(String tipoLlamada, String origen, String destino, int duracion) {
		this.tipoDeLlamada = tipoLlamada;
		this.origen= origen;
		this.destino= destino;
		this.duracion = duracion;
	}

	public String getTipoDeLlamada() {
		return tipoDeLlamada;
	}

	public String getRemitente() {
		return destino;
	}

	public int getDuracion() {
		return this.duracion;
	}

	public String getOrigen() {
		return origen;
	}
}
```
(i) Lo primero que identificamos en esta clase es que se utiliza un atributo tipo en lugar de crear subclases para cada uno de estos.

(ii) La solución utilizada fue **"Replace Type Code with Subclasses"**.
- Primero hay que identificar si una clase tiene un atributo que represente un tipo.
- Segundo y último se realizan las subclases.
