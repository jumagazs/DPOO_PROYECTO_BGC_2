package interfaz;

import javax.swing.*;
import java.awt.*;

public class CocineroFrame extends JFrame {

    public CocineroFrame() {
        setTitle("Cocinero");
        setSize(400,300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3,1));

        JButton btnVerPedidos = new JButton("Ver Pedidos");
        JButton btnPreparar = new JButton("Preparar Pedido");
        JButton btnTurnos = new JButton("Ver Turnos");

        panel.add(btnVerPedidos);
        panel.add(btnPreparar);
        panel.add(btnTurnos);

        add(panel);
        setVisible(true);

        btnPreparar.addActionListener(e -> JOptionPane.showMessageDialog(this,"Pedido preparado"));
    }
}