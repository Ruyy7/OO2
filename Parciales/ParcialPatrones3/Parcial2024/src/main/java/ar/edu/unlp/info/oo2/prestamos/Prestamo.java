package ar.edu.unlp.info.oo2.prestamos;

import ar.edu.unlp.info.oo2.estados.Estado;
import ar.edu.unlp.info.oo2.estados.Pendiente;

import java.util.ArrayList;
import java.util.List;

public abstract class Prestamo {
    private double monto;
    private int cantCuotas;
    private Estado state;
    private List<Pago> pagos;

    public Prestamo(double monto, int cantCuotas) {
        this.monto = monto;
        this.cantCuotas = cantCuotas;
        this.state = new Pendiente();
        this.pagos = new ArrayList<>();
    }

    public void verificarCondicion(double salarioMensualCliente){
        this.state.verificarCondicion(this,salarioMensualCliente,this.calcularValorCuota());
    }

    public void pagarCuotaPrestamo(){
        this.state.pagarCuotaPrestamo(this);
    }

    public void agregarPago(Pago p){
        this.pagos.add(p);
    }

    public int calcularCuotasRestantes(){
        return this.cantCuotas - this.pagos.size();
    }

    public double calcularValorCuota(){
        return (this.monto / this.cantCuotas) * this.calcularInteres();
    }

    public abstract double calcularInteres();

    public double montoPagadoHastaElMomento(){
        return this.pagos.stream().mapToDouble(pago -> pago.getMontoPagado()).sum();
    }

    public double montoRestantePorPagar(){
        return this.calcularCuotasRestantes() * this.calcularValorCuota();
    }

    public double gastosCancelacion(){
        return this.state.gastosCancelacionPrestamo(this);
    }
    public double valorAdministrativo() {
        return this.montoRestantePorPagar() * 0.1;
    }
    public abstract double valorSellado();

    public double getMonto() {
        return monto;
    }

    public int getCantCuotas() {
        return cantCuotas;
    }

    public Estado getState() {
        return state;
    }

    public void setState(Estado state) {
        this.state = state;
    }
}
