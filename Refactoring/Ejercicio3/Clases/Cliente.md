Sucede lo mismo que con la clase llamada.
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
	public List<Llamada> llamadas = new ArrayList<Llamada>();
	private String tipo;
	private String nombre;
	private String numeroTelefono;
	private String cuit;
	private String dni;

	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	public void setNumeroTelefono(String numeroTelefono) {
		this.numeroTelefono = numeroTelefono;
	}
	public String getCuit() {
		return cuit;
	}
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
	public String getDNI() {
		return dni;
	}
	public void setDNI(String dni) {
		this.dni = dni;
	}
}

```

(i) Se utiliza un atributo tipo en lugar de crear subclases para cada uno de estos. Ademas del uso de setters que viola el encapsulamiento del cliente.

(ii) La solución utilizada fue **"Replace Type Code with Subclasses"**.
- Primero hay que identificar si una clase tiene un atributo que represente un tipo.
- Segundo se realizan las subclases. En este caso existen dos tipos de clientes: Persona fija y Persona jurídica. Como no existen clientes sin tipo que tengan comportamiento, la clase Cliente pasa a ser abstracta.
- Movemos los atributos que le corresponden a la persona física y a la jurídica junto a los getters. **Push down field**. 

Ademas no cuentan con un constructor, se lo agregamos y eliminamos los setters.

***Aclaración***: El siguiente es código intermedio, recalco el hecho de leer el orden en que se fue refactorizando.

- PersonaJuridica
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class PersonaJuridica extends Cliente {
	private String cuit;

	public PersonaJuridica(String nombre, String numeroTelefono, String cuit) {
		super(nombre, numeroTelefono);
		this.cuit = cuit;
	}

	public String getCuit() {
		return cuit;
	}
	
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
}
```
- PersonaFisica
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class PersonaFisica extends Cliente {
	private String dni;

	public PersonaFisica(String nombre, String numeroTelefono, String dni) {
		super(nombre, numeroTelefono);
		this.dni = dni;
	}

	public String getDNI() {
		return dni;
	}
	
	public void setDNI(String dni) {
		this.dni = dni;
	}
	
}

}
```
- Cliente
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	public List<Llamada> llamadas = new ArrayList<Llamada>();
	private String nombre;
	
	public Cliente(String nombre, String numeroTelefono) {
		this.nombre = nombre;
		this.numeroTelefono = numeroTelefono;
	}

	private String numeroTelefono;
	
	public abstract double aplicarDescuento();
	
	public boolean esIgual(Cliente otroCliente) {
		return this.numeroTelefono.equals(otroCliente.getNumeroTelefono());
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	
}
```

## Post refeactorizar la clase empresa
- Cliente
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	public List<Llamada> llamadas = new ArrayList<Llamada>();
	private String nombre;
	private String numeroTelefono;

	public Cliente(String nombre, String numeroTelefono) {
		this.nombre = nombre;
		this.numeroTelefono = numeroTelefono;
	}
	
	public abstract double aplicarDescuento();
	
	public boolean esIgual(Cliente otroCliente) {
		return this.numeroTelefono.equals(otroCliente.getNumeroTelefono());
	}
	
	public String getNombre() {
		return nombre;
	}
	
	public String getNumeroTelefono() {
		return numeroTelefono;
	}
	
}
```

- PersonaFisica
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class PersonaFisica extends Cliente {
	private String dni;

	public PersonaFisica(String nombre, String numeroTelefono, String dni) {
		super(nombre, numeroTelefono);
		this.dni = dni;
	}
	
	@Override
	public double aplicarDescuento() {
		return 0;
	}

	public String getDNI() {
		return dni;
	}
	
}
```

- PersonaJuridica
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class PersonaJuridica extends Cliente {
	private String cuit;

	public PersonaJuridica(String nombre, String numeroTelefono, String cuit) {
		super(nombre, numeroTelefono);
		this.cuit = cuit;
	}
	
	@Override
	public double aplicarDescuento() {
		return 0.15;
	}
	
	public String getCuit() {
		return cuit;
	}
	
}
```

(i) En la clase Cliente además notamos que la lista de llamdas es pública, esto trae muchas complicaciones ya que viola el principio de encapsulamiento y se corren riesgos de cambios inesperados
```java
	public List<Llamada> llamadas = new ArrayList<Llamada>();
```

(ii) Aplicamos el refactoring **Encapsulate Collection** y ponemos la variable como privada, agregandole un respectivo getter para mejorar la seguridad al ser utilizada por otras clases.
(iii) El código queda de la siguiente manera:

```java

  private List<Llamada> llamadas = new ArrayList<Llamada>();

   public List<Llamada> getLlamadas(){
		return this.llamadas;
	}


```

Luego de aplicar el move method de empresa para el registro de llamadas y el calculo total de llamadas para un cliente la clase cliente quedaría tal que así.

## Cliente
```java
    	@Deprecated()
	public Llamada registrarLlamada(Cliente origen, Cliente destino, String t, int duracion) {
		Llamada llamada = new Llamada(t, origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
		llamadas.add(llamada);
		origen.llamadas.add(llamada);
		return llamada;
	}
	
	public Llamada registrarLlamada(CreadorLlamada creadorLlamada, Cliente origen, Cliente destino, int duracion) {
		Llamada llamada = creadorLlamada.crearLlamada(origen,destino,duracion);
		llamadas.add(llamada);
		origen.llamadas.add(llamada);
		return llamada;
	}

	public double calcularMontoTotalLlamadas(Cliente cliente) {
		return this.llamadas.stream()
	            .filter(llamada -> llamada.getOrigen().esIgual(cliente))
	            .mapToDouble(llamada -> llamada.calcularMontoLlamada())
	            .sum();
	    }
	
```
(i) El parametro "Cliente origen" en registrarLlamada y calcularMontoTotalLlamadas ya no es necesario, aplicaremos el refactoring solo al método que no está deprecado ya que en el caso hipotetico de que algún desarrollador sigue haciendo uso del método deprecado, este se verá afectado por los cambios que le hagamos al mismo pudiendo llegar a romper su sistema.

(ii) Aplicamos **Remove parameter** que consiste simplemente en remover los atributos que no son utilizados por el método.

```java
	// Este método esta deprecado, se debería quitar el parametro Cliente origen.
    	@Deprecated()
	public Llamada registrarLlamada(Cliente origen, Cliente destino, String t, int duracion) {
		Llamada llamada = new Llamada(t, origen.getNumeroTelefono(), destino.getNumeroTelefono(), duracion);
		llamadas.add(llamada);
		origen.llamadas.add(llamada);
		return llamada;
	}
	
	public Llamada registrarLlamada(CreadorLlamada creadorLlamada,Cliente destino, int duracion) {
		Llamada llamada = creadorLlamada.crearLlamada(origen,destino,duracion);
		this.llamadas.add(llamada);
		return llamada;
	}

	public double calcularMontoTotalLlamadas() {
		return this.llamadas.stream()
		    .filter(llamada -> llamadas.getOrigen().esIgual(this))
		    .mapToDouble(llamada -> llamada.calcularMontoLlamada())
		    .sum();
   	}
```
