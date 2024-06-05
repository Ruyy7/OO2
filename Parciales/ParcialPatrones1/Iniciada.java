public class Iniciada extends State{
    
    public Iniciada(TareaSimple tarea) {
        super(tarea);
    }

    @Override
    public long timepoUtilizado() {
        return 0;
    }

    @Override
    public void finalizar() {
        this.getTarea().setEstado(new Completada(getTarea()));
    }
    
}
