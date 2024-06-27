package ar.edu.unlp.info.oo2.Ejercicio19;

public class Director {
	private Builder builder;

	public Director(Builder builder) {
		this.builder = builder;
	}
	
	public Personaje crearPersonaje(String nombre) {
		builder.crearPersonaje(nombre);
		builder.equiparArma();
		builder.equiparArmadura();
		builder.otorgarHabilidades();
		return builder.cerrarPersonaje();
	}

	public void switchBuilder(Builder otherBuilder){
		this.builder = otherBuilder;
	}
}
