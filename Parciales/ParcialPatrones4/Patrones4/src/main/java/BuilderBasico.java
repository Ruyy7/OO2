import java.util.ArrayList;
import java.util.List;

public class BuilderBasico extends Builder{
    @Override
    public void agregarProcesador() {
        this.getEquipo().setProcesador(Catalogo.getComponente("Procesador basico"));
    }

    @Override
    public void agregarRam() {
        List<Componente> ram = new ArrayList<>();
        ram.add(Catalogo.getComponente("Ram 8gb"));
        this.getEquipo().setRam(ram);
    }

    @Override
    public void agregarDisco() {
        List<Componente> disco = new ArrayList<>();
        disco.add(Catalogo.getComponente("HDD 500gb"));
        this.getEquipo().setDisco(disco);
    }

    @Override
    public void agregarGrafica() {

    }

    @Override
    public void agregarGabinete() {
        this.getEquipo().setGabinete(Catalogo.getComponente("Gabinete Estandar"));
    }

    @Override
    public void agregarFuente() {

    }

    @Override
    public void agregarAccesorios() {

    }
}
