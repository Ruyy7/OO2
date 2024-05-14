package ar.edu.unlp.info.oo2.Ejercicio21;

import java.time.LocalDate;

public class MamiferoReal implements Mamifero {
	private String id;
	private String especie;
	private LocalDate fechaNacimiento;
	private Mamifero padre;
	private Mamifero madre;

	@Override
	public String getIdentificador() {
		return this.id;
	}

	@Override
	public void setIdentificador(String id) {
		this.id = id;
	}

	@Override
	public String getEspecie() {
		return this.especie;
	}

	@Override
	public void setEspecie(String especie) {
		this.especie = especie;
	}

	@Override
	public LocalDate getFechaNacimiento() {
		return this.fechaNacimiento;
	}

	@Override
	public void setFechaNacimiento(LocalDate fecha) {
		this.fechaNacimiento = fecha;
	}

	@Override
	public Mamifero getPadre() {
		return this.padre;
	}

	@Override
	public void setPadre(Mamifero padre) {
		this.padre = padre;
	}

	@Override
	public Mamifero getMadre() {
		return this.madre;
	}

	@Override
	public void setMadre(Mamifero madre) {
		this.madre = madre;
	}

	@Override
	public Mamifero getAbueloMaterno() {
		return this.madre.getPadre();
	}

	@Override
	public Mamifero getAbuelaMaterna() {
		return this.madre.getMadre();
	}

	@Override
	public Mamifero getAbueloPaterno() {
		return this.padre.getPadre();
	}

	@Override
	public Mamifero getAbuelaPaterna() {
		return this.padre.getMadre();
	}

	@Override
	public boolean tieneComoAncestroA(Mamifero unMamifero) {
		return (tieneAncestro(this.getMadre(), unMamifero) || tieneAncestro(this.getPadre(), unMamifero));
	}
	
	private boolean tieneAncestro (Mamifero pariente, Mamifero unMamifero) {
		return (unMamifero.equals(pariente) || pariente.tieneComoAncestroA(unMamifero));
	}

}
