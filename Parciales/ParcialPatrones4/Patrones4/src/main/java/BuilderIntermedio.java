import java.util.ArrayList;
import java.util.List;

public class BuilderIntermedio extends Builder{

    @Override
    public void agregarProcesador() {
        this.getEquipo().setProcesador(Catalogo.getComponente("Procesador Intermedio"));
    }

    @Override
    public void agregarRam() {
        List<Componente> ram = new ArrayList<>();
        ram.add(Catalogo.getComponente("Ram 16gb"));
        this.getEquipo().setRam(ram);
    }

    @Override
    public void agregarDisco() {
        List<Componente> disco = new ArrayList<>();
        disco.add(Catalogo.getComponente("SSD 500gb"));
        this.getEquipo().setRam(disco);
    }

    @Override
    public void agregarGrafica() {
        this.getEquipo().setGrafica(Catalogo.getComponente("GTX 1650"));
    }

    @Override
    public void agregarGabinete() {
        this.getEquipo().setGabinete(Catalogo.getComponente("Gabinete Intermedio"));
    }

    @Override
    public void agregarFuente() {
        this.getEquipo().setFuente(Catalogo.getComponente("Fuente 800w"));
    }

    @Override
    public void agregarAccesorios() {

    }
}
