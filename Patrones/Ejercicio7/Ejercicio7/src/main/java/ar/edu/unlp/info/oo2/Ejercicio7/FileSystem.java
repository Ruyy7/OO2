package ar.edu.unlp.info.oo2.Ejercicio7;

import java.time.LocalDate;

public abstract class FileSystem {
	private String nombre;
	private LocalDate fechaCreacion;
	
	public FileSystem(String nombre, LocalDate fechaCreacion) {
		this.nombre = nombre;
		this.fechaCreacion = fechaCreacion;
	}
	
	public LocalDate getFecha() {
		return this.fechaCreacion;
	}
	
	public String getNombre() {
		return this.nombre;
	}
	
	public abstract int tamañoTotalOcupado();
	public abstract Archivo archivoMasGrande();
	public abstract Archivo archivoMasNuevo();
}
