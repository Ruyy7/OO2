public abstract class State {
    private TareaSimple tarea;

    public State (TareaSimple tarea){
        this.tarea = tarea;
    }

    public abstract long timepoUtilizado();

    public void iniciar(){
        System.out.println("Esta tarea ya fue inicializada");
    }

    public void finalizar(){
        System.out.println("No se puede finalizar esta tarea");
    }

    public TareaSimple getTarea() {
        return tarea;
    }

}
