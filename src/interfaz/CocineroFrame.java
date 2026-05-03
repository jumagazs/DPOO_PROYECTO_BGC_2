package interfaz;

import javax.swing.*;
import java.awt.*;
import modelo.Cafe;

public class CocineroFrame extends JFrame {

    private Cafe cafe;
    private String login;

    public CocineroFrame(Cafe cafe, String login) {
        this.cafe = cafe;
        this.login = login;

        setTitle("Cocinero - " + login);
        setSize(400,300);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(2,1));

        JButton btnVerPedidos = new JButton("Ver Pedidos");
        JButton btnPreparar = new JButton("Preparar Pedido");

        panel.add(btnVerPedidos);
        panel.add(btnPreparar);

        add(panel);
        setVisible(true);

        btnVerPedidos.addActionListener(e -> {
            JOptionPane.showMessageDialog(this, cafe.getPedidos().toString());
        });

        btnPreparar.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("ID Pedido:");

            try {
                cafe.prepararPedido(login, id);
                JOptionPane.showMessageDialog(this,"Pedido preparado");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
    }
}