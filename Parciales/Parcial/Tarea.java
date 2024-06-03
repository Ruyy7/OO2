public abstract  class Tarea {
    private String nombre;
    private String descripcion;
    
    public Tarea(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }

    public abstract int estimacionTotalTarea();
    public abstract long timepoUtilizado();
    public abstract long avanceTarea();
    public abstract void iniciarTarea();
    public abstract void finalizarTarea();

    public String getNombre() {
        return nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

}

