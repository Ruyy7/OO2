# 2.4 Carrito de compras
![image](https://github.com/Ruyy7/OO2/assets/87097965/fb39112f-210a-4830-b5b5-c68220780f48)

```java
public class Producto {
    private String nombre;
    private double precio;
    
    public double getPrecio() {
        return this.precio;
    }
}

public class ItemCarrito {
    private Producto producto;
    private int cantidad;
        
    public Producto getProducto() {
        return this.producto;
    }
    
    public int getCantidad() {
        return this.cantidad;
    }

}

public class Carrito {
    private List<ItemCarrito> items;
    
    public double total() {
return this.items.stream().mapToDouble(item -> item.getProducto().getPrecio() * item.getCantidad()).sum();
    }
}
```
(i) El calculo de precio * cantidad tiene que ser responsabilidad de la clase ItemCarrito. Feature Envy de la clase Carrito.

(ii) Move method. Movemos la cuenta antes mencionada a la clase item carrito.

```java
public class Producto {
    private String nombre;
    private double precio;
    
    public double getPrecio() {
        return this.precio;
    }
}

public class ItemCarrito {
    private Producto producto;
    private int cantidad;
    
    public double calcularPrecioCantidadItem(){
        return this.producto.getPrecio() * this.cantidad;
    }
    
    public Producto getProducto() {
        return this.producto;
    }
    
    public int getCantidad() {
        return this.cantidad;
    }

}

public class Carrito {
    private List<ItemCarrito> items;
    
    public double total() {
        return this.items.stream().mapToDouble(item -> item.calcularPrecioCantidadItem()).sum();
    }
}
```
