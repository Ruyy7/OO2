package ar.edu.unlp.info.oo2.Ejercicio9;

public class DefinitivaCompleta extends State {

	public DefinitivaCompleta(Excursion excursion) {
		super(excursion);
	}

	@Override
	public void inscribir(Usuario unUsuario) {
		this.getExcursion().getEnEspera().add(unUsuario);
	}

	@Override
	public String obtenerInformacion() {
		Excursion e = this.getExcursion();
		return "Nombre excursión: " + e.getNombre() + "\t" + "Costo: "+ e.getCosto() + "\t" + "Fechas: " + e.getFechaInicio()+" / "+ e.getFechaFin()
		+ "\t" + "Punto de encuentro: " + e.getPuntoEncuentro();
	}

}
