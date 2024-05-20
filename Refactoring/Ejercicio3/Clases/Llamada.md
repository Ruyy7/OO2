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
- Segundo y último se realizan las subclases. En este caso existen dos tipos de llamadas: Nacionales e Internacionales. Como no existen llamadas que no tengan tipo, la clase Llamada pasa a ser abstracta.

(iii)
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

public abstract class Llamada {
	private String origen;
	private String destino;
	private int duracion;

	public Llamada(String origen, String destino, int duracion) {
		this.origen= origen;
		this.destino= destino;
		this.duracion = duracion;
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
En consecuente vamos a tener las siguientes subclases de llamada.

- Nacional
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class Nacional extends Llamada {

	public Nacional(String origen, String destino, int duracion) {
		super(origen, destino, duracion);
	}

}
```

- Internacional
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class Internacional extends Llamada {

	public Internacional(String origen, String destino, int duracion) {
		super(origen, destino, duracion);
	}

}
```
(i) Origen y destino representan un numero de un cliente, esto es conocido como un data value, es mejor que la clase que contiene el atributo sea el objeto que lo representa/contiene.

(ii) Utilizamos **Replace data value with object**, actualizamos constructor y getters.

```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

public abstract class Llamada {
    private Cliente origen;
    private Cliente destino;
    private int duracion;

    public Llamada(Cliente origen, Cliente destino, int duracion) {
        this.origen= origen;
        this.destino= destino;
        this.duracion = duracion;
    }

    public abstract double calcularMontoLlamada();
    
    public Cliente getRemitente() {
        return destino;
    }

    public int getDuracion() {
        return this.duracion;
    }

    public Cliente getOrigen() {
        return origen;
    }
} 
```
