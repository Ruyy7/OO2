
import java.time.temporal.ChronoUnit;

public class Completada extends State{
    
    public Completada(TareaSimple tarea) {
        super(tarea);
    }

    @Override
    public long timepoUtilizado() {
        return ChronoUnit.MILLIS.between(this.getTarea().getInicio(), this.getTarea().getFin());
    }

    
}
