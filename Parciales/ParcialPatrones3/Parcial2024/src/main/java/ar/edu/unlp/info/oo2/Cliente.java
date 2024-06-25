package ar.edu.unlp.info.oo2;

import ar.edu.unlp.info.oo2.prestamos.Prestamo;
import ar.edu.unlp.info.oo2.prestamos.Simple;
import ar.edu.unlp.info.oo2.prestamos.UVA;

import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private double salarioMensual;
    private List<Prestamo> prestamos;

    public Cliente(String nombre, double salarioMensual) {
        this.nombre = nombre;
        this.salarioMensual = salarioMensual;
        this.prestamos = new ArrayList<>();
    }

    private Prestamo solicitarPrestamo(Prestamo p){
        p.verificarCondicion(this.salarioMensual);
        this.prestamos.add(p);
        return p;
    }

    public Prestamo solcitarPrestamoSimple (double monto, int cantCuotas, Banco banco){
        return this.solicitarPrestamo(new Simple(monto,cantCuotas,banco.getTasaInteres()));
    }

    public Prestamo soliciarPrestamoUva(double monto, int cantCuotas){
        return this.solicitarPrestamo(new UVA(monto, cantCuotas));
    }
}
