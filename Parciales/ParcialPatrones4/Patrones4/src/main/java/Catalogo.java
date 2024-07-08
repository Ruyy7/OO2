import java.util.List;

final class Catalogo {
    private static List<Componente> componentes;

    public static Componente getComponente(String descripcion) {
        return componentes.stream().filter(componente -> componente.getNombre().equals(descripcion)).findAny().orElse(null);
    }
}
