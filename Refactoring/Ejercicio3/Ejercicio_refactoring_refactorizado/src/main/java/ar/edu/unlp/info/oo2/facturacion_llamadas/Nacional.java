package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class Nacional extends Llamada {

    public Nacional(Cliente origen, Cliente destino, int duracion) {
        super(origen, destino, duracion);
    }
    
    public double calcularMontoLlamada() {
        return  this.getDuracion() * 3 + (this.getDuracion() * 3 * 0.21);
    }

}
