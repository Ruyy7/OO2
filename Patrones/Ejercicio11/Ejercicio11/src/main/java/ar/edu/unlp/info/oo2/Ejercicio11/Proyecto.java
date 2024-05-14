package ar.edu.unlp.info.oo2.Ejercicio11;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class Proyecto {
	private String nombre;
	private LocalDate fechaInicio;
	private LocalDate fechaFin;
	private String objetivo;
	private int numIntegrantes;
	private double margenGanancia;
	private double montoPago;
	private Etapa etapa;
	
	public Proyecto(String nombre, LocalDate fechaInicio, LocalDate fechaFin, String objetivo, int numIntegrantes, double montoPago) {
		this.nombre = nombre;
		this.fechaInicio = fechaInicio;
		this.fechaFin = fechaFin;
		this.objetivo = objetivo;
		this.numIntegrantes = numIntegrantes;
		this.margenGanancia = 0.07;
		this.montoPago = montoPago;
		this.etapa = new EnConstruccion(this);
	}
	
	public void aprobarEtapa() {
		this.etapa.aprobarEtapa();
	}
	
	public double costoProyecto() {
		return (this.numIntegrantes * this.montoPago) * (ChronoUnit.DAYS.between(this.fechaInicio,this.fechaFin));
	}
	
	public double precioProyecto() {
		return this.costoProyecto() + (this.costoProyecto() * this.margenGanancia);
	}
	
	public void modificarMargenGanancia(double margen) {
		this.etapa.modificarMargenGanancia(margen);
	}
	
	public void cancelarProyecto() {
		if (!this.objetivo.contains("(Cancelado)")) {
			this.objetivo += " (Cancelado)";
		}
	}

	public void setMargenGanancia(double margenGanancia) {
		this.margenGanancia = margenGanancia;
	}

	public void setEtapa(Etapa etapa) {
		this.etapa = etapa;
	}

	public Etapa getEtapa() {
		return etapa;
	}

	public double getMargenGanancia() {
		return margenGanancia;
	}
	
	
}
