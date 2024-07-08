import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String nombre;
    private List<Presupuesto> presupuestos;

    public Cliente(String nombre) {
        this.nombre = nombre;
        this.presupuestos = new ArrayList<>();
    }

    public Presupuesto solicitarPresupuesto(Director director){
        Presupuesto presupuesto = new Presupuesto(director.crearEquipo());
        this.presupuestos.add(presupuesto);
        return presupuesto;
    }
}
