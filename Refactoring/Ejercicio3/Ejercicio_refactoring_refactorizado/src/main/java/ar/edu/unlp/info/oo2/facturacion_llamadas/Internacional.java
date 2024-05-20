package ar.edu.unlp.info.oo2.facturacion_llamadas;

public class Internacional extends Llamada {

    public Internacional(Cliente origen, Cliente destino, int duracion) {
        super(origen, destino, duracion);
    }
<<<<<<< HEAD
=======

    public double calcularMontoLlamada() {
        return this.getDuracion() * 150 + (this.getDuracion() * 150 * 0.21) + 50;
    }
>>>>>>> 393a5041df2a9c2ffd4f9aa952b0d77d1235ecdf

    public double calcularMontoLlamada() {
        return this.getDuracion() * 150 + (this.getDuracion() * 150 * 0.21) + 50;
    }

}