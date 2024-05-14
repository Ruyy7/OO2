package ar.edu.unlp.info.oo2.Ejercicio9;

public class Provisoria extends State {

	public Provisoria(Excursion excursion) {
		super(excursion);
	}

	@Override
	public void inscribir(Usuario unUsuario) {
		this.getExcursion().getInscriptos().add(unUsuario);
		if (this.getExcursion().restantesCupoMinimo() == 0) {
			this.getExcursion().setState(new Definitiva(this.getExcursion()));
		}
	}

	@Override
	public String obtenerInformacion() {
		Excursion e = this.getExcursion();
		return "Nombre excursión: " + e.getNombre() + "\t" + "Costo: "+ e.getCosto() + "\t" + "Fechas: " + e.getFechaInicio()+" / "+ e.getFechaFin()
		+ "\t" + "Punto de encuentro: " + e.getPuntoEncuentro() + "\t" +"Cantidad de usuarios restantes para cupo minimo: " + e.restantesCupoMinimo();
	}

}
