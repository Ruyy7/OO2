package ar.edu.unlp.info.oo2.estados;

import ar.edu.unlp.info.oo2.prestamos.Pago;
import ar.edu.unlp.info.oo2.prestamos.Prestamo;

public class Aceptado extends Estado {
    @Override
    public void verificarCondicion(Prestamo p, double salarioMensual, double montoCuota) {
        System.out.println("No hago nada");
    }

    @Override
    public void pagarCuotaPrestamo(Prestamo p) {
        p.agregarPago(new Pago(p.calcularValorCuota()));
        if (p.calcularCuotasRestantes() == 0){
            p.setState(new Finalizado());
        }
    }

    @Override
    public double gastosCancelacionPrestamo(Prestamo p) {
        return p.montoRestantePorPagar() + p.valorAdministrativo() + p.valorSellado();
    }
}
