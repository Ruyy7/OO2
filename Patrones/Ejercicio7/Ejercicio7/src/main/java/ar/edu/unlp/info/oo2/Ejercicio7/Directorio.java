package ar.edu.unlp.info.oo2.Ejercicio7;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;
import java.time.LocalDate;

public class Directorio extends FileSystem {
	private List<FileSystem> archivos;
	
	public Directorio(String nombre, LocalDate fechaCreacion) {
		super(nombre, fechaCreacion);
		this.archivos = new ArrayList<>();
	}
	
	public void agregar(FileSystem archivo) {
		this.archivos.add(archivo);
	}

	public int tamañoTotalOcupado() {
		return 32 + this.archivos.stream().mapToInt(a -> a.tamañoTotalOcupado()).sum();
	}
	
	public Archivo archivoMasGrande() {
		return this.archivos.stream().map(a -> a.archivoMasGrande()).max((a1,a2) -> Integer.compare(a1.tamañoTotalOcupado(), a2.tamañoTotalOcupado())).orElse(null);
	}

	public Archivo archivoMasNuevo() {
		return this.archivos.stream().map(a -> a.archivoMasNuevo()).max((a1,a2) -> a1.getFecha().compareTo(a2.getFecha())).orElse(null);
	}
	
	public FileSystem buscar(String nombre) {
		return this.archivos.stream().map(a -> a.archivoMasNuevo()).filter(a -> a.getNombre().equals(nombre)).findFirst().orElse(null);
	}
	
	public List<FileSystem> buscarTodos(String nombre) {
		return this.archivos.stream().map(a -> a.archivoMasNuevo()).filter(a-> a.getNombre().equals(nombre)).collect(Collectors.toList());
	}
	
//	public String listadoDeContenido() {
//		StringBuilder str = new StringBuilder();
//		str.append("/");
//	}
}
