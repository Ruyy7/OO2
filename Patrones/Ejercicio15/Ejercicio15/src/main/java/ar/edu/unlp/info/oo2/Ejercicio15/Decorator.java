package ar.edu.unlp.info.oo2.Ejercicio15;

import java.time.LocalDateTime;

public abstract class Decorator implements FileOO2 {
	private FileOO2 component;
	
	public Decorator(FileOO2 component) {
		this.component = component;
	}

	public String getNombre() {
		return this.component.getNombre();
	}

	public String getExtension() {
		return this.component.getExtension();
	}

	public int getTamaño() {
		return this.component.getTamaño();
	}

	public LocalDateTime getFechaCreacion() {
		return this.component.getFechaCreacion();
	}

	public LocalDateTime getFechaModificacion() {
		return this.component.getFechaModificacion();
	}

	public String getPermisos() {
		return this.component.getPermisos();
	}

	public  String prettyPrint() {
		return this.component.prettyPrint();
	}
}
