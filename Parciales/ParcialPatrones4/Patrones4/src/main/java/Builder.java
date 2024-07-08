public abstract class Builder {
    private Equipo equipo;

    public void crearEquipo(){
        this.equipo = new Equipo();
    }

    public Equipo cerrarEquipo(){
        return this.equipo;
    }
    public abstract void agregarProcesador();
    public abstract void agregarRam();
    public abstract void agregarDisco();
    public abstract void agregarGrafica();
    public abstract void agregarGabinete();
    public abstract void agregarFuente();
    public abstract void agregarAccesorios();

    public Equipo getEquipo() {
        return equipo;
    }
}
