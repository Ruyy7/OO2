import java.time.LocalDateTime;

public class TareaSimple extends Tarea{
    private int duracionEstimada;
    private LocalDateTime inicio;
    private LocalDateTime fin;
    private State estado;

    public TareaSimple(String nombre, String descripcion, int duracionEstimada) {
        super(nombre, descripcion);
        this.duracionEstimada = duracionEstimada;
        this.inicio = LocalDateTime.now();
        this.estado = new Pendiente(this);
    }

    @Override
    public int estimacionTotalTarea() {
        return this.duracionEstimada;
    }

    @Override
    public long timepoUtilizado() {
        return this.getEstado().timepoUtilizado();
    }

    @Override
    public long avanceTarea() {
        return this.duracionEstimada / this.timepoUtilizado();
    }
    
    @Override
    public void iniciarTarea() {
        this.estado.iniciar();
    }

    @Override
    public void finalizarTarea() {
        this.estado.finalizar();
    }

    public State getEstado() {
        return estado;
    }

    public LocalDateTime getInicio(){
        return inicio;
    }

    public LocalDateTime getFin() {
        return fin;
    }

    public void setEstado(State estado) {
        this.estado = estado;
    }

    public int getDuracionEstimada() {
        return duracionEstimada;
    }



}
