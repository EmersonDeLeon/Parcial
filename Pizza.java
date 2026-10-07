public class Pizza {
    private final Orden orden;
    private boolean entregada;

    public Pizza(Orden orden) {
        this.orden = orden;
    }

    public void entregar() { entregada = true; }
    public boolean isEntregada() { return entregada; }
    public Orden getOrden() { return orden; }
}
