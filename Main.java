import java.awt.*;
import javax.swing.*;

public class Main extends JFrame {
    private final JTextField campoNumero = new JTextField(12);
    private final JComboBox<Masas> comboMasa = new JComboBox<>(Masas.values());
    private final JComboBox<Salsas> comboSalsa = new JComboBox<>(Salsas.values());
    private final JComboBox<Toppings> comboTopping = new JComboBox<>(Toppings.values());
    private final JComboBox<Quesos> comboQueso = new JComboBox<>(Quesos.values());
    private final JSpinner campoCantidad = new JSpinner(new SpinnerNumberModel(1, 1, 100, 1));
    private final JTextArea resultado = new JTextArea(9, 30);
    private final Cocina cocina = new Cocina();

    public Main() {
        super("Pizzería - Nueva orden");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(520, 570);
        setLocationRelativeTo(null);
        setResizable(false);
        construirInterfaz();
    }

    private void construirInterfaz() {
        JPanel principal = new JPanel(new BorderLayout(12, 12));
        principal.setBorder(BorderFactory.createEmptyBorder(18, 18, 18, 18));

        JLabel titulo = new JLabel("ORDEN DE PIZZA", JLabel.CENTER);
        titulo.setFont(new Font("SansSerif", Font.BOLD, 24));
        principal.add(titulo, BorderLayout.NORTH);

        JPanel formulario = new JPanel(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(7, 7, 7, 7);
        gbc.fill = GridBagConstraints.HORIZONTAL;

        agregarFila(formulario, gbc, 0, "Número de orden:", campoNumero);
        agregarFila(formulario, gbc, 1, "Tipo de masa:", comboMasa);
        agregarFila(formulario, gbc, 2, "Tipo de salsa:", comboSalsa);
        agregarFila(formulario, gbc, 3, "Topping:", comboTopping);
        agregarFila(formulario, gbc, 4, "Tipo de queso:", comboQueso);
        agregarFila(formulario, gbc, 5, "Cantidad:", campoCantidad);

        JButton enviar = new JButton("Enviar orden");
        JButton limpiar = new JButton("Limpiar");
        enviar.addActionListener(e -> enviarOrden());
        limpiar.addActionListener(e -> limpiarFormulario());

        JPanel botones = new JPanel();
        botones.add(enviar);
        botones.add(limpiar);
        gbc.gridx = 0;
        gbc.gridy = 6;
        gbc.gridwidth = 2;
        formulario.add(botones, gbc);

        resultado.setEditable(false);
        resultado.setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

        JPanel centro = new JPanel(new BorderLayout(8, 8));
        centro.add(formulario, BorderLayout.NORTH);
        centro.add(new JScrollPane(resultado), BorderLayout.CENTER);
        principal.add(centro, BorderLayout.CENTER);
        add(principal);
    }

    private void agregarFila(JPanel panel, GridBagConstraints gbc, int fila,
                             String texto, Component componente) {
        gbc.gridwidth = 1;
        gbc.gridx = 0;
        gbc.gridy = fila;
        gbc.weightx = 0;
        panel.add(new JLabel(texto), gbc);
        gbc.gridx = 1;
        gbc.weightx = 1;
        panel.add(componente, gbc);
    }

    private void enviarOrden() {
        try {
            int numero = Integer.parseInt(campoNumero.getText().trim());
            if (numero <= 0) throw new NumberFormatException();

            Orden orden = new Orden(numero,
                    (Masas) comboMasa.getSelectedItem(),
                    (Salsas) comboSalsa.getSelectedItem(),
                    (Toppings) comboTopping.getSelectedItem(),
                    (Quesos) comboQueso.getSelectedItem(),
                    (Integer) campoCantidad.getValue());

            cocina.agregarOrden(orden);
            resultado.setText("ORDEN ENVIADA A COCINA\n\n" + orden
                    + "\n\nÓrdenes recibidas: " + cocina.getCantidadOrdenes());
            JOptionPane.showMessageDialog(this, "Orden registrada correctamente.");
        } catch (NumberFormatException ex) {
            JOptionPane.showMessageDialog(this,
                    "Escribe un número de orden entero mayor que cero.",
                    "Dato incorrecto", JOptionPane.ERROR_MESSAGE);
            campoNumero.requestFocus();
        }
    }

    private void limpiarFormulario() {
        campoNumero.setText("");
        comboMasa.setSelectedIndex(0);
        comboSalsa.setSelectedIndex(0);
        comboTopping.setSelectedIndex(0);
        comboQueso.setSelectedIndex(0);
        campoCantidad.setValue(1);
        resultado.setText("");
        campoNumero.requestFocus();
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new Main().setVisible(true));
    }
}
