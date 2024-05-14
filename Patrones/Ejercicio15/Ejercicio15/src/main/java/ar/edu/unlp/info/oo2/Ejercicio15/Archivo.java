package ar.edu.unlp.info.oo2.Ejercicio15;

import java.time.LocalDateTime;

public class Archivo implements FileOO2 {
	private String nombre;
	private String extension;
	private int tamaño;
	private LocalDateTime fechaCreacion;
	private LocalDateTime fechaModificacion;
	private String permisos;
	
	public Archivo(String nombre, String extension, int tamaño, LocalDateTime fechaCreacion,
			LocalDateTime fechaModificacion, String permisos) {
		this.nombre = nombre;
		this.extension = extension;
		this.tamaño = tamaño;
		this.fechaCreacion = fechaCreacion;
		this.fechaModificacion = fechaModificacion;
		this.permisos = permisos;
	}

	public String prettyPrint() {
		return "";
	}

	public String getNombre() {
		return nombre;
	}

	public String getExtension() {
		return extension;
	}

	public int getTamaño() {
		return tamaño;
	}

	public LocalDateTime getFechaCreacion() {
		return fechaCreacion;
	}

	public LocalDateTime getFechaModificacion() {
		return fechaModificacion;
	}

	public String getPermisos() {
		return permisos;
	}

}
