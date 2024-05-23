```java
	public double calcularMontoTotalLlamadas(Cliente cliente) {
		double c = 0;
		for (Llamada l : cliente.llamadas) {
			double auxc = 0;
			if (l.getTipoDeLlamada() == "nacional") {
				// el precio es de 3 pesos por segundo más IVA sin adicional por establecer la llamada
				auxc += l.getDuracion() * 3 + (l.getDuracion() * 3 * 0.21);
			} else if (l.getTipoDeLlamada() == "internacional") {
				// el precio es de 150 pesos por segundo más IVA más 50 pesos por establecer la llamada
				auxc += l.getDuracion() * 150 + (l.getDuracion() * 150 * 0.21) + 50;
			}

			if (cliente.getTipo() == "fisica") {
				auxc -= auxc*descuentoFis;
			} else if(cliente.getTipo() == "juridica") {
				auxc -= auxc*descuentoJur;
			}
			c += auxc;
		}
		return c;
```
(i) **Feature envy**. La clase empresa quiere realizar un calculo que le corresponde calcular a la clase llamada y a la clase cliente respectivamente. Una llamada debe saber calcular su costo en base a su tipo, lo mismo con el descuento para el cliente. Esto hace mas cohesivo el código y permite (en este ejercicio) que las clases llamada y cliente no sean Data Classes.

(ii) Aplicamos move method, el calculo de una llamada según su tipo será responsabilidad de cada subclase de llamada y para el cliente lo mismo pero para aplicar desucento.

(iii) Las clases llamada y cliente quedarían consecuentemente asi:

## Clase llamada
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

    public abstract double calcularMontoLlamada();
    
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
## Clase llamada nacional
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class Nacional extends Llamada {

    public Nacional(String origen, String destino, int duracion) {
        super(origen, destino, duracion);
    }
    
    public double calcularMontoLlamada() {
        return  this.getDuracion() * 3 + (this.getDuracion() * 3 * 0.21);
    }

}
```
## Clase llamada internacional
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class Internacional extends Llamada {

    public Internacional(String origen, String destino, int duracion) {
        super(origen, destino, duracion);
    }

    public double calcularMontoLlamada() {
        return this.getDuracion() * 150 + (this.getDuracion() * 150 * 0.21) + 50;
    }

}
```
## Clase cliente
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

import java.util.ArrayList;
import java.util.List;

public abstract class Cliente {
	public List<Llamada> llamadas = new ArrayList<Llamada>();
	private String tipo;
	private String nombre;
	private String numeroTelefono;
	private String cuit;
	private String dni;
	
	public abstract double aplicarDescuento();

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

## Clase persona física
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class PersonaFisica extends Cliente {

	@Override
	public double aplicarDescuento() {
		return 0;
	}

}
```
## Clase persona jurídica
```java
package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class PersonaJuridica extends Cliente {

	@Override
	public double aplicarDescuento() {
		return 0.15;
	}

}
```
Luego de aplicar los cambios en la clase llamada y cliente.

(i) Reinventar la rueda, uso del for en vez de aprovechar el uso de stream. Esto permite dar mucha mayor legibilidad a la hora de leer el código.

(ii) Utilizamos **Replace loop with pipeline**

```java
	public double calcularMontoTotalLlamadas(Cliente cliente) {
		return this.llamadas.stream()
	            .filter(llamada -> llamada.getOrigen().esIgual(cliente))
	            .mapToDouble(llamada -> llamada.calcularMontoLlamada())
	            .sum();
	    }
```

(i) Middle man. Se produce cuando una clase o un método ejecuta solo una acción o delega esa misma acción a otra clase.

(ii) Utilizamos **Remove middle man**, en consecuencia tendremos menos código extra innecesario.

```java
	public String obtenerNumeroLibre() {
		return guia.obtenerNumeroLibre();
	}
// Este método se borra.
```
Cambiamos la manera de obtener el número libre utilizando el atributo de guia. (En los métodos donde fue utilizado). Solo se utilizó en el método siguiente:
```java
	public Cliente registrarUsuario(String data, String nombre, String tipo) {
		Cliente var = new Cliente();
		if (tipo.equals("fisica")) {
			var.setNombre(nombre);
			String tel = this.guia.obtenerNumeroLibre();
			var.setTipo(tipo);
			var.setNumeroTelefono(tel);
			var.setDNI(data);
		}
		else if (tipo.equals("juridica")) {
			String tel = this.guia.obtenerNumeroLibre();
			var.setNombre(nombre);
			var.setTipo(tipo);
			var.setNumeroTelefono(tel);
			var.setCuit(data);
		}
		clientes.add(var);
		return var;
	}
```

(i) Después de aplicar el refactoring anterior observamos que en el método registrarUsuario la creación de instancias es larga, compleja y duplica la lógica, por lo que decidimos simplificar el código y facilitar la posible extensión de clases.

(ii) Aplicamos el refactoring **Replace Constructor With Factory Method** creando el factory method, remplazando todas las llamadas al contructor por llamadas a este y mejorando la legibilidad.

(iii) El respectivo código queda así, tenemos un solo método registrarCliente:

```java
//Método en la clase Empresa
public Cliente registrarCliente (CreadorCliente creadorCliente, String nombre, String numeroTelefono, String identificacion) {
	if (this.guia.agregarNumeroTelefono(numeroTelefono)){
		Cliente cliente = creadorCliente.crearCliente(nombre, numeroTelefono, identificacion);
  		this.clientes.add(cliente);
	}
	return null;
}


//Creator
public abstract class CreadorCliente {
	public abstract Cliente crearCliente(String nombre, String numeroTelefono, String identificacion);
}

//Concrete Creators
public class CreadorPersonaJuridica extends CreadorCliente {

	@Override
	public Cliente crearCliente(String nombre, String numeroTelefono, String identificacion) {
		return new PersonaJuridica(nombre,numeroTelefono,identificacion);
	}
}

public class CreadorPersonaFisica extends CreadorCliente{

	@Override
	public Cliente crearCliente(String nombre, String numeroTelefono, String identificacion) {
		return new PersonaFisica(nombre,numeroTelefono,identificacion);
	}

}
```

(i) Lo mismo hacemos con la clase Llamada, ya que el método registrarLlamada que se creaba utilizando el atributo tipo, al refactorizar esto en subclases aumenta la complejidad del código.

(ii) Aplicamos el refactoring **Replace Constructor With Factory Method** creando el factory method, remplazando todas las llamadas al contructor por llamadas a este y mejorando la legibilidad

(iii) El respectivo código queda así, tenemos un solo método registrarLlamada:

```java
	//Método en la clase Empresa
	public Llamada registrarLlamada(CreadorLlamada creadorLlamada, Cliente origen, Cliente destino, int duracion) {
		Llamada llamada = creadorLlamada.crearLlamada(origen,destino,duracion);
		origen.getLlamadas().add(llamada);
		return llamada;
	}

 	//Creator
	public abstract class CreadorLlamada {
		public abstract Llamada crearLlamada(Cliente origen, Cliente destino, int duracion);
	}

	//Concrete Creators
	public class CreadorLlamadaInternacional extends CreadorLlamada {

	@Override
	public Llamada crearLlamada(Cliente origen, Cliente destino, int duracion) {
		return new Internacional(origen,destino,duracion);
		}

	}

	public class CreadorLlamandaNacional extends CreadorLlamada {

	@Override
	public Llamada crearLlamada(Cliente origen, Cliente destino, int duracion) {
		return new Nacional(origen,destino,duracion);
		}

	}
```

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
```

(i) **Feature envy**. El registro de una llamada debería ser responsabilidad de un cliente, ya que el cliente es que contiene la colección de llamadas en su clase.

(ii) Aplicamos move method hacía la clase cliente.

## Clase cliente
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
	
```
