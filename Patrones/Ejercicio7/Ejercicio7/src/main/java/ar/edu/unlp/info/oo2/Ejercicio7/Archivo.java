package ar.edu.unlp.info.oo2.Ejercicio7;

import java.time.LocalDate;

public class Archivo extends FileSystem {
	private int tamaño;
	
	
	public Archivo(String nombre, LocalDate fechaCreacion, int tamaño) {
		super(nombre, fechaCreacion);
		this.tamaño = tamaño;
	}

	public int tamañoTotalOcupado() {
		return this.tamaño;
	}

	public Archivo archivoMasGrande() {
		return this;
	}

	public Archivo archivoMasNuevo() {
		return this;
	}

}
