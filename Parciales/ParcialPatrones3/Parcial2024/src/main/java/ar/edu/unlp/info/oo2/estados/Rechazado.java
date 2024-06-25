package ar.edu.unlp.info.oo2.estados;

import ar.edu.unlp.info.oo2.prestamos.Prestamo;

public class Rechazado extends Estado {
    @Override
    public void verificarCondicion(Prestamo p, double salarioMensual, double montoCuota) {
        System.out.println("No hago nada");
    }

    @Override
    public void pagarCuotaPrestamo(Prestamo p) {
        throw new Error("Error");
    }

    @Override
    public double gastosCancelacionPrestamo(Prestamo p) {
        throw new Error("Error");
    }
}
