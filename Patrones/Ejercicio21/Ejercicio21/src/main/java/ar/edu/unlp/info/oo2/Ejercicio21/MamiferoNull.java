package ar.edu.unlp.info.oo2.Ejercicio21;

import java.time.LocalDate;

public class MamiferoNull implements Mamifero {

	@Override
	public String getIdentificador() {
		return null;
	}

	@Override
	public void setIdentificador(String id) {

	}

	@Override
	public String getEspecie() {
		return null;
	}

	@Override
	public void setEspecie(String especie) {

	}

	@Override
	public LocalDate getFechaNacimiento() {
		return null;
	}

	@Override
	public void setFechaNacimiento(LocalDate fecha) {

	}

	@Override
	public Mamifero getPadre() {
		return null;
	}

	@Override
	public void setPadre(Mamifero padre) {

	}

	@Override
	public Mamifero getMadre() {
		return null;
	}

	@Override
	public void setMadre(Mamifero madre) {

	}

	@Override
	public Mamifero getAbueloMaterno() {
		return null;
	}

	@Override
	public Mamifero getAbuelaMaterna() {
		return null;
	}

	@Override
	public Mamifero getAbueloPaterno() {
		return null;
	}

	@Override
	public Mamifero getAbuelaPaterna() {
		return null;
	}

	@Override
	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		return false;
	}

}
