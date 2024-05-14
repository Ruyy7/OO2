package ar.edu.unlp.info.oo2.Ejercicio19;

public abstract class Builder {
	private Personaje personaje;
	public void crearPersonaje(String nombre) {
		this.personaje = new Personaje(nombre);
	}
	
	public Personaje cerrarPersonaje() {
		return this.personaje;
	}
	
	public abstract void equiparArmadura();
	public abstract void equiparArma();
	public abstract void otorgarHabilidades();

	public Personaje getPersonaje() {
		return personaje;
	}
	
}
