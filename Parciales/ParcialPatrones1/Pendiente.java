public class Pendiente extends State{
    
    public Pendiente(TareaSimple tarea) {
        super(tarea);
    }

    @Override
    public long timepoUtilizado() {
        return 0;
    }

    @Override
    public void iniciar() {
        this.getTarea().setEstado(new Iniciada(this.getTarea()));
    }
    
}
