public class Director {
    private Builder builder;

    public Director(Builder builder) {
        this.builder = builder;
    }

    public Equipo crearEquipo(){
        this.builder.crearEquipo();
        this.builder.agregarProcesador();
        this.builder.agregarRam();
        this.builder.agregarDisco();
        this.builder.agregarGrafica();
        this.builder.agregarGabinete();
        this.builder.agregarFuente();
        this.builder.agregarAccesorios();
        return this.builder.cerrarEquipo();
    }

    public void setBuilder(Builder builder) {
        this.builder = builder;
    }
}
