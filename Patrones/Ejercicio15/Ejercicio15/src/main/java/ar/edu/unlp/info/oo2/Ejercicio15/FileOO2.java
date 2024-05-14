package ar.edu.unlp.info.oo2.Ejercicio15;

import java.time.LocalDateTime;

public interface FileOO2 {
	String getNombre();
	String getExtension();
	int getTamaño();
	LocalDateTime getFechaCreacion();
	LocalDateTime getFechaModificacion();
	String getPermisos();
	String prettyPrint();
}
