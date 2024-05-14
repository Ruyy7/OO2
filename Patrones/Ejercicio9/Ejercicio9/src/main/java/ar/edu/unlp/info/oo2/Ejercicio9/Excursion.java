package ar.edu.unlp.info.oo2.Ejercicio9;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Excursion {
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String puntoEncuentro;
	private double costo;
	private int cupoMinimo;
	private int cupoMaximo;
	private List<Usuario> inscriptos;
	private List<Usuario> enEspera;
	private State state;
	
	public Excursion(String nombre, LocalDate fechaInicio, LocalDate fechaFin, String puntoEncuentro, double costo,
			int cupoMinimo, int cupoMaximo) {
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.puntoEncuentro = puntoEncuentro;
		this.costo = costo;
		this.cupoMinimo = cupoMinimo;
		this.cupoMaximo = cupoMaximo;
		this.inscriptos = new ArrayList<>();
		this.enEspera = new ArrayList<>();
		this.state = new Provisoria(this);
	}
	
	public void inscribir(Usuario unUsuario) {
		this.state.inscribir(unUsuario);
	}
	
	public String obtenerInformacion() {
		return this.state.obtenerInformacion();
	}
	
	public int restantesCupoMinimo() {
		if (this.cupoMinimo - this.inscriptos.size() == 0) {
			return 0;
		}
		return this.cupoMinimo - this.inscriptos.size();
	}
	
	public int restantesCupoMaximo() {
		if (this.cupoMaximo - this.inscriptos.size() == 0) {
			return 0;
		}
		return this.cupoMaximo - this.inscriptos.size();
	}
	
	public String getStringEmailUsuariosInscriptos() {
		List<String> ls = this.inscriptos.stream().map(u -> u.getEmail()).collect(Collectors.toList());
		String emailsString = "";
		for (String s:ls) {
			emailsString += s + "\t";
		}
		return emailsString;
	}
	
	public void setState(State state) {
		this.state = state;
	}

	public List<Usuario> getInscriptos() {
		return inscriptos;
	}

	public List<Usuario> getEnEspera() {
		return enEspera;
	}

	public String getNombre() {
		return nombre;
	}

	public LocalDate getFechaInicio() {
		return fechaInicio;
	}

	public LocalDate getFechaFin() {
		return fechaFin;
	}

	public String getPuntoEncuentro() {
		return puntoEncuentro;
	}

	public double getCosto() {
		return costo;
	}

	public int getCupoMinimo() {
		return cupoMinimo;
	}

	public int getCupoMaximo() {
		return cupoMaximo;
	}

	public State getState() {
		return state;
	}
	
}
