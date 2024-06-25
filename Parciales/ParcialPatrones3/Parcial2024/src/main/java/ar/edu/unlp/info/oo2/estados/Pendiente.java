package ar.edu.unlp.info.oo2.estados;

import ar.edu.unlp.info.oo2.prestamos.Prestamo;

public class Pendiente extends Estado {

    @Override
    public void verificarCondicion(Prestamo p, double salarioMensual, double montoCuota) {
        if (this.puedePagarCuota(salarioMensual,montoCuota)){
            p.setState(new Aceptado());
        }
        else{
            p.setState(new Rechazado());
        }
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
