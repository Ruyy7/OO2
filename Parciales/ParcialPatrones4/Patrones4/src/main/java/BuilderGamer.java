import java.util.ArrayList;
import java.util.List;

public class BuilderGamer extends Builder{
    @Override
    public void agregarProcesador() {
        this.getEquipo().setProcesador(Catalogo.getComponente("Procesador Gamer"));
    }

    @Override
    public void agregarRam() {
        List<Componente> ram = new ArrayList<>();
        ram.add(Catalogo.getComponente("Ram 32gb")); ram.add(Catalogo.getComponente("Ram 32gb"));
        this.getEquipo().setRam(ram);
    }

    @Override
    public void agregarDisco() {
        List<Componente> disco = new ArrayList<>();
        disco.add(Catalogo.getComponente("SSD 500gb")); disco.add(Catalogo.getComponente("SSD 1TB"));
        this.getEquipo().setDisco(disco);
    }

    @Override
    public void agregarGrafica() {
        this.getEquipo().setGrafica(Catalogo.getComponente("RTX 4090"));
    }

    @Override
    public void agregarGabinete() {
        this.getEquipo().setGabinete(Catalogo.getComponente("Gabinete Gamer"));
    }

    @Override
    public void agregarFuente() {
        Double consumoPC = this.getEquipo().calcularConsumo() * 1.5;
        this.getEquipo().setFuente(Catalogo.getComponente("Fuente " + consumoPC.toString() + "w"));
    }

    @Override
    public void agregarAccesorios() {
        List<Componente> accesorios = new ArrayList<>();
        accesorios.add(Catalogo.getComponente("Pad termico")); accesorios.add(Catalogo.getComponente("Cooler"));
        this.getEquipo().setAccesorios(accesorios);
    }
}
