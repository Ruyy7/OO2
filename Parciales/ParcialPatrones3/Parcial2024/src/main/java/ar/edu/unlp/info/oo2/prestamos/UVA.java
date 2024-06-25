package ar.edu.unlp.info.oo2.prestamos;

public class UVA extends Prestamo{
    private Indec indec;
    public UVA(double monto, int cantCuotas) {
        super(monto, cantCuotas);
        this.indec = new Indec(4.5);
    }

    @Override
    public double calcularInteres() {
        return this.indec.getIndiceInflacion();
    }
    @Override
    public double valorSellado() {
        return 0;
    }

}
