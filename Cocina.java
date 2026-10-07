import java.util.ArrayList;
import java.util.List;

public class Cocina {
    private final List<Orden> ordenes = new ArrayList<>();

    public void agregarOrden(Orden orden) { ordenes.add(orden); }
    public int getCantidadOrdenes() { return ordenes.size(); }
}
