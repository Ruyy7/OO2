# 2.1 Empleados
```java
public class EmpleadoTemporario {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public double horasTrabajadas = 0;
    public int cantidadHijos = 0;

    public double sueldo() {
        return this.sueldoBasico + (this.horasTrabajadas * 500) + (this.cantidadHijos * 1000)  - (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPlanta {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    public int cantidadHijos = 0;
    
    public double sueldo() {
        return this.sueldoBasico + (this.cantidadHijos * 2000)- (this.sueldoBasico * 0.13);
    }
}

public class EmpleadoPasante {
    public String nombre;
    public String apellido;
    public double sueldoBasico = 0;
    
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
}
```

(i) Todas las variables de las clases son publicas.

(ii) No hay un refactoring específico para este caso, se deberia hacer uso de getters y setters en su contraparte.

```java
public class EmpleadoTemporario {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    private double horasTrabajadas = 0;
    private int cantidadHijos = 0;

    public double sueldo() {
      return this.sueldoBasico + (this.horasTrabajadas * 500) + (this.cantidadHijos * 1000)  - (this.sueldoBasico * 0.13);
    }

    public String getNombre() {
		  return nombre;
	  }
  	public void setNombre(String nombre) {
  		this.nombre = nombre;
  	}
  	public String getApellido() {
  		return apellido;
  	}
  	public void setApellido(String apellido) {
  		this.apellido = apellido;
  	}
  	public double getSueldoBasico() {
  		return sueldoBasico;
  	}
  	public void setSueldoBasico(double sueldoBasico) {
  		this.sueldoBasico = sueldoBasico;
  	}
  	public double getHorasTrabajadas() {
  		return horasTrabajadas;
  	}
  	public void setHorasTrabajadas(double horasTrabajadas) {
  		this.horasTrabajadas = horasTrabajadas;
  	}
  	public int getCantidadHijos() {
  		return cantidadHijos;
  	}
  	public void setCantidadHijos(int cantidadHijos) {
  		this.cantidadHijos = cantidadHijos;
  	}

}

public class EmpleadoPlanta {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    private int cantidadHijos = 0;
    
    public double sueldo() {
        return this.sueldoBasico + (this.cantidadHijos * 2000)- (this.sueldoBasico * 0.13);
    }

  public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public double getSueldoBasico() {
		return sueldoBasico;
	}
	public void setSueldoBasico(double sueldoBasico) {
		this.sueldoBasico = sueldoBasico;
	}

	public int getCantidadHijos() {
		return cantidadHijos;
	}
	public void setCantidadHijos(int cantidadHijos) {
		this.cantidadHijos = cantidadHijos;
	}
}

public class EmpleadoPasante {
    private String nombre;
    private String apellido;
    private double sueldoBasico = 0;
    
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }
  	public String getNombre() {
  		return nombre;
  	}
  	public void setNombre(String nombre) {
  		this.nombre = nombre;
  	}
  	public String getApellido() {
  		return apellido;
  	}
  	public void setApellido(String apellido) {
  		this.apellido = apellido;
  	}
  	public double getSueldoBasico() {
  		return sueldoBasico;
  	}
  	public void setSueldoBasico(double sueldoBasico) {
  		this.sueldoBasico = sueldoBasico;
  	}
}
```

(i) Todas las clases comparten nombre, apellido y sueldo básico, además del método sueldo(). Código duplicado.

(ii) Pull Up method.

```java
public abstract class Empleado{
    private String nombre;
    private String apellido;
    private double sueldoBasico;

    public abstract Empleado(String nombre, String apellido, double sueldoBasico) {
    		this.nombre = nombre;
    		this.apellido = apellido;
    		this.sueldoBasico = sueldoBasico;
    	}

    public abstract double sueldo();

  	public String getNombre() {
  		return nombre;
  	}

  	public void setNombre(String nombre) {
  		this.nombre = nombre;
  	}

  	public String getApellido() {
  		return apellido;
  	}

  	public void setApellido(String apellido) {
  		this.apellido = apellido;
  	}

  	public double getSueldoBasico() {
  		return sueldoBasico;
  	}

  	public void setSueldoBasico(double sueldoBasico) {
  		this.sueldoBasico = sueldoBasico;
  	}

  }

public class EmpleadoTemporario {
    private double horasTrabajadas;
    private int cantidadHijos;

  	public EmpleadoTemporario(String nombre, String apellido, double sueldoBasico, double horasTrabajadas, int cantidadHijos) {
  		super(nombre,apellido,sueldoBasico);
  		this.horasTrabajadas = horasTrabajadas;
  		this.cantidadHijos = cantidadHijos;
  	}

    public double sueldo() {
        return this.sueldoBasico + (this.horasTrabajadas * 500) + (this.cantidadHijos * 1000)  - (this.sueldoBasico * 0.13);
    }

    public double getHorasTrabajadas() {
		  return horasTrabajadas;
	  }
	  public void setHorasTrabajadas(double horasTrabajadas) {
		  this.horasTrabajadas = horasTrabajadas;
	  }

    public int getCantidadHijos() {
		  return cantidadHijos;
	  }
	  public void setCantidadHijos(int cantidadHijos) {
		  this.cantidadHijos = cantidadHijos;
	  }

}

public class EmpleadoPlanta {
    private int cantidadHijos;

    public EmpleadoPlanta(String nombre, String apellido, double sueldoBasico, int cantidadHijos) {
  		super(nombre,apellido,sueldoBasico);
  		this.cantidadHijos = cantidadHijos;
  	}
    
    public double sueldo() {
        return this.sueldoBasico + (this.cantidadHijos * 2000)- (this.sueldoBasico * 0.13);
    }

    public int getCantidadHijos() {
    		return cantidadHijos;
    }

    public void setCantidadHijos(int cantidadHijos) {
    		this.cantidadHijos = cantidadHijos;
    }
}

public class EmpleadoPasante {

    public EmpleadoTemporario(String nombre, String apellido, double sueldoBasico) {
  		super(nombre,apellido,sueldoBasico);
    }
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }

}
```
Antes de continuar podríamos discutir que Empleado Temporario y Planta podría aplicarse Pull Up Method por la variable cantHijos. En este caso no lo veo tan conveniente, podría ser un caso de sobre ingenieria.

(i) Las variables estan inicializadas en vez de usar constructores.

(ii) No hay como tal un refactoring que trate esto.

(iii) Sin querer lo aplique en el ejemplo anterior :P es facil darse cuenta aún asi. Repito el código.

```java
public abstract class Empleado{
    private String nombre;
    private String apellido;
    private double sueldoBasico;

    public abstract Empleado(String nombre, String apellido, double sueldoBasico) {
    		this.nombre = nombre;
    		this.apellido = apellido;
    		this.sueldoBasico = sueldoBasico;
    	}

    public abstract double sueldo();

  	public String getNombre() {
  		return nombre;
  	}

  	public void setNombre(String nombre) {
  		this.nombre = nombre;
  	}

  	public String getApellido() {
  		return apellido;
  	}

  	public void setApellido(String apellido) {
  		this.apellido = apellido;
  	}

  	public double getSueldoBasico() {
  		return sueldoBasico;
  	}

  	public void setSueldoBasico(double sueldoBasico) {
  		this.sueldoBasico = sueldoBasico;
  	}

  }

public class EmpleadoTemporario {
    private double horasTrabajadas;
    private int cantidadHijos;

  	public EmpleadoTemporario(String nombre, String apellido, double sueldoBasico, double horasTrabajadas, int cantidadHijos) {
  		super(nombre,apellido,sueldoBasico);
  		this.horasTrabajadas = horasTrabajadas;
  		this.cantidadHijos = cantidadHijos;
  	}

    public double sueldo() {
        return this.sueldoBasico + (this.horasTrabajadas * 500) + (this.cantidadHijos * 1000)  - (this.sueldoBasico * 0.13);
    }

    public double getHorasTrabajadas() {
		  return horasTrabajadas;
	  }
	  public void setHorasTrabajadas(double horasTrabajadas) {
		  this.horasTrabajadas = horasTrabajadas;
	  }

    public int getCantidadHijos() {
		  return cantidadHijos;
	  }
	  public void setCantidadHijos(int cantidadHijos) {
		  this.cantidadHijos = cantidadHijos;
	  }

}

public class EmpleadoPlanta {
    private int cantidadHijos;

    public EmpleadoPlanta(String nombre, String apellido, double sueldoBasico, int cantidadHijos) {
  		super(nombre,apellido,sueldoBasico);
  		this.cantidadHijos = cantidadHijos;
  	}
    
    public double sueldo() {
        return this.sueldoBasico + (this.cantidadHijos * 2000)- (this.sueldoBasico * 0.13);
    }

    public int getCantidadHijos() {
    		return cantidadHijos;
    }

    public void setCantidadHijos(int cantidadHijos) {
    		this.cantidadHijos = cantidadHijos;
    }
}

public class EmpleadoPasante {

    public EmpleadoTemporario(String nombre, String apellido, double sueldoBasico) {
  		super(nombre,apellido,sueldoBasico);
    }
    public double sueldo() {
        return this.sueldoBasico - (this.sueldoBasico * 0.13);
    }

}
```
(i) Se aplica el mismo descuento en todos los empleados.

(ii) Aplico Extract Method para el descuento y el mismo aplico Pull Up enviandolo a la clase empleado ***(A chequear la explicación que di)***. Y por último From Template Method para calcular el sueldo de cualquier empleado.

```java
public abstract class Empleado{
    private String nombre;
    private String apellido;
    private double sueldoBasico;

    public abstract Empleado(String nombre, String apellido, double sueldoBasico) {
    		this.nombre = nombre;
    		this.apellido = apellido;
    		this.sueldoBasico = sueldoBasico;
    	}

    protected abstract double sueldo();
    
    public double calcularSueldo(){
      return this.sueldo() - (this.sueldoBasico * 0.13);
    }
    

  	public String getNombre() {
  		return nombre;
  	}

  	public void setNombre(String nombre) {
  		this.nombre = nombre;
  	}

  	public String getApellido() {
  		return apellido;
  	}

  	public void setApellido(String apellido) {
  		this.apellido = apellido;
  	}

  	public double getSueldoBasico() {
  		return sueldoBasico;
  	}

  	public void setSueldoBasico(double sueldoBasico) {
  		this.sueldoBasico = sueldoBasico;
  	}

  }

public class EmpleadoTemporario {
    private double horasTrabajadas;
    private int cantidadHijos;

  	public EmpleadoTemporario(String nombre, String apellido, double sueldoBasico, double horasTrabajadas, int cantidadHijos) {
  		super(nombre,apellido,sueldoBasico);
  		this.horasTrabajadas = horasTrabajadas;
  		this.cantidadHijos = cantidadHijos;
  	}

    public double sueldo() {
        return this.sueldoBasico + (this.horasTrabajadas * 500) + (this.cantidadHijos * 1000);
    }

    public double getHorasTrabajadas() {
		  return horasTrabajadas;
	  }
	  public void setHorasTrabajadas(double horasTrabajadas) {
		  this.horasTrabajadas = horasTrabajadas;
	  }

    public int getCantidadHijos() {
		  return cantidadHijos;
	  }
	  public void setCantidadHijos(int cantidadHijos) {
		  this.cantidadHijos = cantidadHijos;
	  }

}

public class EmpleadoPlanta {
    private int cantidadHijos;

    public EmpleadoPlanta(String nombre, String apellido, double sueldoBasico, int cantidadHijos) {
  		super(nombre,apellido,sueldoBasico);
  		this.cantidadHijos = cantidadHijos;
  	}
    
    public double sueldo() {
        return this.sueldoBasico + (this.cantidadHijos * 2000);
    }

    public int getCantidadHijos() {
    		return cantidadHijos;
    }

    public void setCantidadHijos(int cantidadHijos) {
    		this.cantidadHijos = cantidadHijos;
    }
}

public class EmpleadoPasante {

    public EmpleadoTemporario(String nombre, String apellido, double sueldoBasico) {
  		super(nombre,apellido,sueldoBasico);
    }
    public double sueldo() {
        return this.sueldoBasico;
    }

}
```
