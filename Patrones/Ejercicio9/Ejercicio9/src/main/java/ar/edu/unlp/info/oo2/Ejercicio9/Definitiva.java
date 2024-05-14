package ar.edu.unlp.info.oo2.Ejercicio9;

public class Definitiva extends State {

	public Definitiva(Excursion excursion) {
		super(excursion);
	}

	@Override
	public void inscribir(Usuario unUsuario) {
		this.getExcursion().getInscriptos().add(unUsuario);
		if (this.getExcursion().restantesCupoMaximo() == 0) {
			this.getExcursion().setState(new DefinitivaCompleta(this.getExcursion()));
		}
		
	}

	@Override
	public String obtenerInformacion() {
		Excursion e = this.getExcursion();
		return "Nombre excursión: " + e.getNombre() + "\t" + "Costo: "+ e.getCosto() + "\t" + "Fechas: " + e.getFechaInicio()+" / "+ e.getFechaFin()
		+ "\t" + "Punto de encuentro: " + e.getPuntoEncuentro() + "Emails: " + e.getStringEmailUsuariosInscriptos();
	}

}
