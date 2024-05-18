# 2.2 Juego
```java
public class Juego {

    public void incrementar(Jugador j) {
        j.puntuacion = j.puntuacion + 100;
    }
    public void decrementar(Jugador j) {
        j.puntuacion = j.puntuacion - 50;
    }

public class Jugador {
    public String nombre;
    public String apellido;
    public int puntuacion = 0;
}
}
```
(i) Variables publicas en clase jugador.

(ii) Inserción de getters y setters y cambio de alcanze a privado.

```java
public class Juego {

    public void incrementar(Jugador j) {
        j.puntuacion = j.puntuacion + 100;
    }
    public void decrementar(Jugador j) {
        j.puntuacion = j.puntuacion - 50;
    }
}

public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion = 0;

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
  	public int getPuntuacion() {
  		return puntuacion;
  	}
  	public void setPuntuacion(int puntuacion) {
  		this.puntuacion = puntuacion;
  	}
}
}
```

(i) Falta constructor en la clase jugador.

(ii) Ninguno en particular, quitar el valor por defecto de puntuación.

```java
public class Juego {

    public void incrementar(Jugador j) {
        j.puntuacion = j.puntuacion + 100;
    }
    public void decrementar(Jugador j) {
        j.puntuacion = j.puntuacion - 50;
    }
}

public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion;

    public Jugador (String nombre, String apellido, int puntuacion){
        this.nombre = nombre;
        this.apeliido = apellido;
        this.puntuacion = puntuacion; // O tambien quitar puntuacion del constructor y inicializarla dentro del mismo en 0.
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
  	public int getPuntuacion() {
  		return puntuacion;
  	}
  	public void setPuntuacion(int puntuacion) {
  		this.puntuacion = puntuacion;
  	}
  }
}
```

A este punto cabe recalcar que en la clase Juego, como las variables de jugador son privadas, ya seria un error semántico incrementar la puntuación accediendo a la variable fuera de la clase jugador. Además, esta tarea es deber del jugador incrementar o decrementar
la puntuación del mismo ya que es la clase contenedora de los puntos.

(i) Feature envy, nombres no descriptivos. (Aplico renombres en ambas clases).

(ii) Move method, rename method.

```java
public class Juego {
    public void incrementarPuntosJugador(Jugador j){
        j.incrementarPuntos();
    }

    public void decrementarPuntosJugador(Jugador j){
        j.decrementarPuntos();
    }
}

public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion = 0;

    public Jugador (String nombre, String apellido, int puntuacion){
        this.nombre = nombre;
        this.apeliido = apellido;
        this.puntuacion = puntuacion; // O tambien quitar puntuacion del constructor y inicializarla dentro del mismo en 0.
    }

    public void incrementarPuntos() {
        j.puntuacion += 100;
    }
    public void decrementarPuntos() {
        j.puntuacion -= 50;
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
  	public int getPuntuacion() {
  		return puntuacion;
  	}
  	public void setPuntuacion(int puntuacion) {
  		this.puntuacion = puntuacion;
  	}
  }
}
```
No hace mucho sentido cambiar el nombre y el apeliido una vez creado, podríamos quitar los setters.


```java
public class Juego {
    public void incrementarPuntosJugador(Jugador j){
        j.incrementarPuntos();
    }

    public void decrementarPuntosJugador(Jugador j){
        j.decrementarPuntos();
    }
}

public class Jugador {
    private String nombre;
    private String apellido;
    private int puntuacion = 0;

    public Jugador (String nombre, String apellido, int puntuacion){
        this.nombre = nombre;
        this.apeliido = apellido;
        this.puntuacion = puntuacion; // O tambien quitar puntuacion del constructor y inicializarla dentro del mismo en 0.
    }

    public void incrementarPuntos() {
        j.puntuacion += 100;
    }
    public void decrementarPuntos() {
        j.puntuacion -= 50;
    }

  	public String getNombre() {
  		return nombre;
  	}
  	public String getApellido() {
  		return apellido;
  	}
  	public int getPuntuacion() {
  		return puntuacion;
  	}
  	public void setPuntuacion(int puntuacion) {
  		this.puntuacion = puntuacion;
  	}
  }
}
```
