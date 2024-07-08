import java.util.List;

public class Equipo {
    private Componente procesador;
    private List<Componente> ram;
    private List<Componente> disco;
    private Componente grafica;
    private Componente gabinete;
    private Componente fuente;
    private List<Componente> accesorios;

    public double calcularConsumo(){
        return this.procesador.getConsumo() + this.ram.stream().mapToDouble(ram -> ram.getConsumo()).sum()
                + this.disco.stream().mapToDouble(disco -> disco.getConsumo()).sum() + this.grafica.getConsumo()
                + this.gabinete.getConsumo() + this.fuente.getConsumo() + this.accesorios.stream().mapToDouble(accesorios -> accesorios.getConsumo()).sum();
    }

    public double calcularPrecio(){
        return this.procesador.getPrecio() + this.ram.stream().mapToDouble(ram -> ram.getPrecio()).sum()
                + this.disco.stream().mapToDouble(disco -> disco.getPrecio()).sum() + this.grafica.getPrecio()
                + this.gabinete.getPrecio() + this.fuente.getPrecio() + this.accesorios.stream().mapToDouble(accesorios -> accesorios.getPrecio()).sum();
    }

    public void setProcesador(Componente procesador) {
        this.procesador = procesador;
    }

    public void setRam(List<Componente> ram) {
        this.ram = ram;
    }

    public void setDisco(List<Componente> disco) {
        this.disco = disco;
    }

    public void setGrafica(Componente grafica) {
        this.grafica = grafica;
    }

    public void setGabinete(Componente gabinete) {
        this.gabinete = gabinete;
    }

    public void setFuente(Componente fuente) {
        this.fuente = fuente;
    }

    public void setAccesorios(List<Componente> accesorios) {
        this.accesorios = accesorios;
    }
}
