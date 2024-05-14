package ar.edu.unlp.info.oo2.Ejercicio21;

import java.time.LocalDate;

public interface Mamifero {
	String getIdentificador();
	void setIdentificador(String id);
	String getEspecie();
	void setEspecie(String especie);
	LocalDate getFechaNacimiento();
	void setFechaNacimiento(LocalDate fecha);
	Mamifero getPadre();
	void setPadre(Mamifero padre);
	Mamifero getMadre();
	void setMadre(Mamifero madre);
	Mamifero getAbueloMaterno();
	Mamifero getAbuelaMaterna();
	Mamifero getAbueloPaterno();
	Mamifero getAbuelaPaterna();
	boolean tieneComoAncestroA(Mamifero unMamifero);
}
