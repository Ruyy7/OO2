package ar.edu.unlp.info.oo2.Ejercicio11;

public class EnConstruccion extends Etapa {

	public EnConstruccion(Proyecto proyecto) {
		super(proyecto);
	}

	public void aprobarEtapa() {
		if (this.getProyecto().precioProyecto() > 0) {
			this.getProyecto().setEtapa(new EnEvaluacion(this.getProyecto()));
		}
		else {
			throw new RuntimeException("El precio del proyecto es 0");
		}
	}

	public void modificarMargenGanancia(double margen) {
		if (margen >= 0.08 && margen <= 0.1) {
			this.getProyecto().setMargenGanancia(margen);
		}
	}
}
