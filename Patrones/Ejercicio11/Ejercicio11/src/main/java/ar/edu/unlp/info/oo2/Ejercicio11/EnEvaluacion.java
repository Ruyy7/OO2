package ar.edu.unlp.info.oo2.Ejercicio11;

public class EnEvaluacion extends Etapa {

	public EnEvaluacion(Proyecto proyecto) {
		super(proyecto);
	}

	public void aprobarEtapa() {
		this.getProyecto().setEtapa(new Confirmada(this.getProyecto()));
	}

	public void modificarMargenGanancia(double margen) {
		if (margen >= 0.11 && margen <= 0.15) {
			this.getProyecto().setMargenGanancia(margen);
		}
	}

}
