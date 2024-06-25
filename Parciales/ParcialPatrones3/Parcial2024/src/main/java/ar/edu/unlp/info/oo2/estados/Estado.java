package ar.edu.unlp.info.oo2.estados;

import ar.edu.unlp.info.oo2.prestamos.Prestamo;

public abstract class Estado {
    public boolean puedePagarCuota (double salarioMensual, double montoCuota){
        return  (salarioMensual >= montoCuota * 0.3);
    }

    public abstract void verificarCondicion(Prestamo p, double salarioMensual, double montoCuota);
    public abstract void pagarCuotaPrestamo(Prestamo p);
    public abstract double gastosCancelacionPrestamo(Prestamo p);
}
