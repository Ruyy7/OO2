# 2.6 Películas
![image](https://github.com/Ruyy7/OO2/assets/87097965/227d4bdc-48c5-4a22-8aef-c74521df55d8)

## Clase Usuario
```java
public class Usuario {
    String tipoSubscripcion;
    // ...

    public void setTipoSubscripcion(String unTipo) {
   	 this.tipoSubscripcion = unTipo;
    }
    
    public double calcularCostoPelicula(Pelicula pelicula) {
   	 double costo = 0;
   	 if (tipoSubscripcion=="Basico") {
   		 costo = pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno();
   	 }
   	 else if (tipoSubscripcion== "Familia") {
   		 costo = (pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno()) * 0.90;
   	 }
   	 else if (tipoSubscripcion=="Plus") {
   		 costo = pelicula.getCosto();
   	 }
   	 else if (tipoSubscripcion=="Premium") {
   		 costo = pelicula.getCosto() * 0.75;
   	 }
   	 return costo;
    }
}
```
## Clase Pelicula
```java
public class Pelicula {
    LocalDate fechaEstreno;
    // ...

    public double getCosto() {
   	 return this.costo;
    }
    
    public double calcularCargoExtraPorEstreno(){
	// Si la Película se estrenó 30 días antes de la fecha actual, retorna un cargo de 0$, caso contrario, retorna un cargo extra de 300$
   	return (ChronoUnit.DAYS.between(this.fechaEstreno, LocalDate.now()) ) > 30 ? 0 : 300;
    }
}
```
(i) Se utiliza un atributo tipo, que determina según que valor tenga las acciones que debe tomar la clase (Switch statement).

(ii) Replace type code with Strategy.

## Clase Usuario

```java
public class Usuario {
	Subscripcion tipoSubscripcion;
	// ...
	
	public void setTipoSubscripcion(Subscripcion unTipo) {
		this.tipoSubscripcion = unTipo;
	}
	
	public double calcularCostoPelicula(Pelicula pelicula) {
		return this.tipoSubscripcion.calcularCostoPelicula();
	}
}
```

## Interfaz pelicula
```java
public interface Subscripcion{
	double calcularCostoPelicula (Pelicula pelicula);
}
```

## Clase Basico
```java
public class Basico implements Subscripcion{
	public double calcularCostoPelicula (Pelicula pelicula){
		return pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno();
	}
}
```

## Clase Familia
![af4469120777df5ae77da309405ba4c7d0e8783b_00](https://github.com/Ruyy7/OO2/assets/87097965/0fcf82cc-7d10-4adc-a3ca-f7be5ac1671e)

```java
public class Familia implements Subscripcion{
	public double calcularCostoPelicula (Pelicula pelicula){
		return (pelicula.getCosto() + pelicula.calcularCargoExtraPorEstreno()) * 0.90;
	}
}
```

## Clase Plus
```java
public class Plus implements Subscripcion{
	public double calcularCostoPelicula (Pelicula pelicula){
		return pelicula.getCosto();
	}
}
```

## Clase Premium
```java
public class Premium implements Subscripcion{
	public double calcularCostoPelicula (Pelicula pelicula){
		return pelicula.getCosto() * 0.75;
	}
}
```

La clase pelicula se mantiene igual.
