package interfaz;

import javax.swing.*;
import java.awt.*;

public class MeseroFrame extends JFrame {

    public MeseroFrame() {
        setTitle("Mesero");
        setSize(500,400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5,1));

        JButton btnAsignarMesa = new JButton("Asignar Mesa");
        JButton btnRegistrarPedido = new JButton("Registrar Pedido");
        JButton btnPrestamoJuego = new JButton("Prestar Juego");
        JButton btnExplicarJuego = new JButton("Explicar Juego");
        JButton btnVerTurnos = new JButton("Ver Turnos");

        panel.add(btnAsignarMesa);
        panel.add(btnRegistrarPedido);
        panel.add(btnPrestamoJuego);
        panel.add(btnExplicarJuego);
        panel.add(btnVerTurnos);

        add(panel);
        setVisible(true);

        btnRegistrarPedido.addActionListener(e -> registrarPedido());
    }

    private void registrarPedido() {
        JTextField id = new JTextField();
        JTextField fecha = new JTextField();

        Object[] campos = {
                "ID Pedido:", id,
                "Fecha:", fecha
        };

        int res = JOptionPane.showConfirmDialog(this, campos, "Nuevo Pedido", JOptionPane.OK_CANCEL_OPTION);

        if (res == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(this,"Pedido registrado");
        }
    }
}