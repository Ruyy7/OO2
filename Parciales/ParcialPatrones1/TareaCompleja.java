import java.util.List;

public class TareaCompleja extends Tarea{
    private List<Tarea> tareas;

    public TareaCompleja(String nombre, String descripcion, List<Tarea> tareas) {
        super(nombre, descripcion);
        this.tareas = tareas;
    }

    @Override
    public int estimacionTotalTarea() {
        return this.tareas.stream().mapToInt(tarea -> tarea.estimacionTotalTarea()).sum();
    }

    @Override
    public long timepoUtilizado() {
        return this.tareas.stream().mapToLong(tarea -> tarea.timepoUtilizado()).sum();
    }

    @Override
    public long avanceTarea() {
        return this.tareas.stream().mapToLong(tarea -> tarea.avanceTarea()).sum() / this.tareas.size();
    }

    @Override
    public void iniciarTarea() {
        this.tareas.stream().forEach(tarea -> tarea.iniciarTarea());
    }

    @Override
    public void finalizarTarea() {
        this.tareas.stream().forEach(tarea -> tarea.finalizarTarea());
    }

}
