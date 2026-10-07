enum Masas { SUAVE, CRUJIENTE, TOSTADA }
enum Salsas { TOMATE, PICANTE, CHAMPINON }
enum Toppings { PEPPERONI, JAMON, PINA, CHILE, CHAMPINON, SIN_TOPPING }
enum Quesos { PARMESANO, MOZARELA, ORILLA, SIN_QUESO }

public class Orden {
    private final int noOrden;
    private final Masas masa;
    private final Salsas salsa;
    private final Toppings topping;
    private final Quesos queso;
    private final int cantidad;

    public Orden(int noOrden, Masas masa, Salsas salsa,
                 Toppings topping, Quesos queso, int cantidad) {
        this.noOrden = noOrden;
        this.masa = masa;
        this.salsa = salsa;
        this.topping = topping;
        this.queso = queso;
        this.cantidad = cantidad;
    }

    public int getNoOrden() { return noOrden; }
    public int getCantidad() { return cantidad; }

    @Override
    public String toString() {
        return "Orden No. " + noOrden
                + "\nMasa: " + masa
                + "\nSalsa: " + salsa
                + "\nTopping: " + topping
                + "\nQueso: " + queso
                + "\nCantidad: " + cantidad;
    }
}
