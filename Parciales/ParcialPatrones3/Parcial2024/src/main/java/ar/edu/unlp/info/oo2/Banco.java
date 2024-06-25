package ar.edu.unlp.info.oo2;

import java.util.ArrayList;
import java.util.List;

public class Banco {
    private List<Cliente> clientes;
    private double tasaInteres;

    public Banco(double tasaInteres) {
        this.clientes = new ArrayList<>();
        this.tasaInteres = tasaInteres;
    }

    public Cliente registrarCliente (String nombre, double salarioMensual){
        Cliente c = new Cliente(nombre,salarioMensual);
        this.clientes.add(c);
        return c;
    }

    public double getTasaInteres() {
        return tasaInteres;
    }

    public void setTasaInteres(double tasaInteres) {
        this.tasaInteres = tasaInteres;
    }

}
