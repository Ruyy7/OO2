# 1.3 Cálculos 
Analice el código que se muestra a continuación. Indique qué code smells encuentra y cómo pueden corregirse.						

```java
public void imprimirValores() {
	int totalEdades = 0;
	double promedioEdades = 0;
	double totalSalarios = 0;
	
	for (Empleado empleado : personal) {
		totalEdades = totalEdades + empleado.getEdad();
		totalSalarios = totalSalarios + empleado.getSalario();
	}
	promedioEdades = totalEdades / personal.size();
		
	String message = String.format("El promedio de las edades es %s y el total de salarios es %s", promedioEdades, totalSalarios);
	
	System.out.println(message);
			
}
```
Este caso se puede identificar un ***"Long method"***, es mejor separar en métodos mas pequeños que realizen cálculos mas simples y que trabajen en conjunto; de paso esto favorece al rehuso de métodos, si tenemos solo un método muy grande este sería mas difícil de ser reutilizar. 

```java
public double promedioEdades(){
	return this.personal.stream().mapToDouble(empleado -> empleado.getEdad()).average().orElse(0);
}

public double totalSalarios(){
	return this.personal.stream().mapToDouble(empleado -> empleado.getSalario()).sum();
}

public void imprimirValores(){
	System.out.println("El promedio de las edades es " + this.promedioEdades() + " y el total de salarios es " + totalSalarios());
}
```
***Aclaración***
Asumo que "personal" es una colección de empleados y, por ende, hago uso de stream(). También se puede realizar con el foreach de Java.
