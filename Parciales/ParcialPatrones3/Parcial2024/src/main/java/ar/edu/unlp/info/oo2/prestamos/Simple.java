package ar.edu.unlp.info.oo2.prestamos;

public class Simple extends Prestamo{
    private double tasaInteres;

    public Simple(double monto, int cantCuotas, double tasaInteres) {
        super(monto, cantCuotas);
        this.tasaInteres = tasaInteres;
    }

    @Override
    public double calcularInteres() {
        return this.tasaInteres;
    }
    @Override
    public double valorSellado() {
        return 5000;
    }
}
