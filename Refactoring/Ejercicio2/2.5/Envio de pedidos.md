# 2.5 Envío de pedidos

### Clase Supermercado
```java
public class Supermercado {
   public void notificarPedido(long nroPedido, Cliente cliente) {
     String notificacion = MessageFormat.format(“Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección {1}”, new Object[] { nroPedido, cliente.getDireccionFormateada() });

     // lo imprimimos en pantalla, podría ser un mail, SMS, etc..
    System.out.println(notificacion);
  }
}
```
### Clase Cliente
```
public class Cliente {
   public String getDireccionFormateada() {
	return 
		this.direccion.getLocalidad() + “, ” +
		this.direccion.getCalle() + “, ” +
		this.direccion.getNumero() + “, ” +
		this.direccion.getDepartamento()
      ;
}
```

(i) Feature envy en la clase cliente, es la dirección quien debe devolver el String formateado. Data Class, la dirección solo es una clase que almacena datos y sin un usuario esta no existiría. Inappropriate Intimacy ya que cliente utiliza todos los campos de dirección
para resolver una tarea.

(ii) Move field. Move method.

### Clase Supermercado
```java
public class Supermercado {
   public void notificarPedido(long nroPedido, Cliente cliente) {
     String notificacion = MessageFormat.format(“Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección {1}”, new Object[] { nroPedido, cliente.getDireccionFormateada() });

     // lo imprimimos en pantalla, podría ser un mail, SMS, etc..
    System.out.println(notificacion);
  }
}
```
### Clase Cliente
```
public class Cliente {
    public String localidad;
    public String calle;
    public String numero;
    public String departamento;

    public String getDireccionFormateada() {
        return this.localidad + ", " + this.calle ", " + this.numero; + ", " this.departamento;
    ;
}
```

(i) Campos públicos en la clase Cliente. Deben ser encapuslados.

(ii) Encapsulate Field.

### Clase Supermercado
```java
public class Supermercado {
   public void notificarPedido(long nroPedido, Cliente cliente) {
     String notificacion = MessageFormat.format(“Estimado cliente, se le informa que hemos recibido su pedido con número {0}, el cual será enviado a la dirección {1}”, new Object[] { nroPedido, cliente.getDireccionFormateada() });

     // lo imprimimos en pantalla, podría ser un mail, SMS, etc..
    System.out.println(notificacion);
  }
}
```
### Clase Cliente
```
public class Cliente {
    private String localidad;
    private String calle;
    private String numero;
    private String departamento;

    public String getDireccionFormateada() {
        return this.localidad + ", " + this.calle ", " + this.numero; + ", " this.departamento;
    ;
}
```
En la naturaleza de este ejercicio no es necesario incluir ni getters ni setters.
