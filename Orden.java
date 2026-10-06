import java.util.Scanner;

public enum Masas {
    SUAVE, CRUJIENTE, TOSTADA
}

public enum Salsas {
    TOMATE, PICANTE, CHAMPIÑÓN
}

public enum Toppings {
    PEPPERONI, JAMON, PIÑA, CHILE, CHAMPIÑÓN, NOTOPPING
}

public enum Quesos {
    PARMESANO, MOZARELA, ORILLA, NOQUESO
}

public class Orden {
    private int noOrden;
    private Masas masas;
    private Salsas salsas;
    private Toppings toppings;
    private Quesos quesos;
    private int cantidad;

    public void EnviarOrden(int noOrden, Masas masas, Salsas salsas, Toppings toppings, Quesos quesos){
        System.out.println("ORDEN DE PIZZA");

        System.out.println("Orden No.: ");
        noOrden = scanner.nextLine();

        System.out.println("Tipo de masa: ");
        masas = Masas.valueOf(masasTexto.toUpperCase());

        System.out.println("Tipo de salsa: ");
        salsas = Salsas.valueOf(salsasTexto.toUpperCase());

        System.out.println("Topping agregado: ");
        toppings = Toppings.valueOf(toppingsTexto.toUpperCase());

        System.out.println("Tipo de queso: ");
        quesos = Quesos.valueOf(quesosTexto.toUpperCase());
    }
}