package interfaz;

import javax.swing.*;
import java.awt.*;
import modelo.Cafe;
import pedidos.Pedido;

public class MeseroFrame extends JFrame {

    private Cafe cafe;
    private String login;

    public MeseroFrame(Cafe cafe, String login) {
        this.cafe = cafe;
        this.login = login;

        setTitle("Mesero - " + login);
        setSize(500,400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4,1));

        JButton btnAsignarMesa = new JButton("Asignar Mesa");
        JButton btnRegistrarPedido = new JButton("Registrar Pedido");
        JButton btnPrestarJuego = new JButton("Prestar Juego");
        JButton btnVerTurnos = new JButton("Ver Turnos");

        panel.add(btnAsignarMesa);
        panel.add(btnRegistrarPedido);
        panel.add(btnPrestarJuego);
        panel.add(btnVerTurnos);

        add(panel);
        setVisible(true);

        btnRegistrarPedido.addActionListener(e -> {
            String idMesa = JOptionPane.showInputDialog("ID Mesa:");

            try {
                Pedido p = cafe.registrarPedidoMesero(login, idMesa);
                JOptionPane.showMessageDialog(this,"Pedido creado: " + p.getIdPedido());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        btnPrestarJuego.addActionListener(e -> {
            String idJuego = JOptionPane.showInputDialog("ID Juego:");
            String idMesa = JOptionPane.showInputDialog("ID Mesa:");
            String idCliente = JOptionPane.showInputDialog("Login Cliente:");

            try {
                cafe.prestamoDeJuegos(idJuego, login, idMesa, idCliente);
                JOptionPane.showMessageDialog(this,"Juego prestado");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        btnVerTurnos.addActionListener(e -> {
            try {
                JOptionPane.showMessageDialog(this,
                        cafe.consultarTurnoEmpleado(login).toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
    }
}