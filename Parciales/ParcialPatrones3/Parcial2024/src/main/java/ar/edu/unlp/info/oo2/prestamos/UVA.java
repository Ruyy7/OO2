package ar.edu.unlp.info.oo2.prestamos;

public class UVA extends Prestamo{
    public UVA(double monto, int cantCuotas) {
        super(monto, cantCuotas);
    }

    @Override
    public double calcularInteres() {
        return Indec.getIndiceInflacion();
    }
    @Override
    public double valorSellado() {
        return 0;
    }

}
