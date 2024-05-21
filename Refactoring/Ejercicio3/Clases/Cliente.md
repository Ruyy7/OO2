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

(i) Se utiliza un atributo tipo en lugar de crear subclases para cada uno de estos.

(ii) La solución utilizada fue **"Replace Type Code with Subclasses"**.
- Primero hay que identificar si una clase tiene un atributo que represente un tipo.
- Segundo se realizan las subclases. En este caso existen dos tipos de clientes: Persona fija y Persona jurídica. Como no existen clientes sin tipo que tengan comportamiento, la clase Cliente pasa a ser abstracta.
- Movemos los atributos que le corresponden a la persona física y a la jurídica junto a los getters y setters.

***Aclaración***: El siguiente es código intermedio, recalco el hecho de leer el orden en que se fue refactorizando.

- PersonaFisica
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class PersonaFisica extends Cliente {
	private String cuit;

	public String getCuit() {
		return cuit;
	}
	
	public void setCuit(String cuit) {
		this.cuit = cuit;
	}
}
```
- PersonaJuridica
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class PersonaFisica extends Cliente {
	private String dni;

	public String getDNI() {
		return dni;
	}
	
	public void setDNI(String dni) {
		this.dni = dni;
	}
	
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
	
	@Override
	public double aplicarDescuento() {
		return 0.15;
	}
	
	public String getCuit() {
		return cuit;
	}
	
}
```
