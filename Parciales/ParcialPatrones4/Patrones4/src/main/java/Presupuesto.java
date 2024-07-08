import java.time.LocalDate;

public class Presupuesto {
    private LocalDate fecha;
    private Equipo equipo;

    public Presupuesto(Equipo equipo) {
        this.equipo = equipo;
    }

    public double calcularPrecioConIVA(){
        return this.equipo.calcularPrecio() * 1.21;
    }
}
