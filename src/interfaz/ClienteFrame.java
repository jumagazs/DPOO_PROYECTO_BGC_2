package interfaz;

import javax.swing.*;
import java.awt.*;

import modelo.Cafe;
import modelo.GestorPersistencia;

public class ClienteFrame extends JFrame {

    private Cafe cafe;
    private String login;
    private GestorPersistencia gp;

    public ClienteFrame(Cafe cafe, String login, GestorPersistencia gp) {
        this.cafe = cafe;
        this.login = login;
        this.gp = gp;

        setTitle("Cliente - " + login);
        setSize(500,400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6,1));

        JButton btnMenu = new JButton("Ver Menu");
        JButton btnMesa = new JButton("Asignar Mesa");
        JButton btnPrestamo = new JButton("Pedir Juego");
        JButton btnCompra = new JButton("Comprar Juego");

        panel.add(btnMenu);
        panel.add(btnMesa);
        panel.add(btnPrestamo);
        panel.add(btnCompra);

        add(panel);
        setVisible(true);

        btnMenu.addActionListener(e -> {
            StringBuilder sb = new StringBuilder();
            cafe.consultarMenu().forEach(p -> sb.append(p).append("\n"));
            JOptionPane.showMessageDialog(this, sb.toString());
        });

        btnMesa.addActionListener(e -> {
            try {
                int personas = Integer.parseInt(JOptionPane.showInputDialog("Personas:"));

                cafe.asignarMesaACliente(
                        (usuarios.Cliente) cafe.getUsuarios().get(login),
                        personas, false, false);

                gp.guardarTodo(cafe);

                JOptionPane.showMessageDialog(this, "Mesa asignada");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        btnPrestamo.addActionListener(e -> {
            try {
                String idJuego = JOptionPane.showInputDialog("ID Juego:");
                cafe.solicitarPrestamoJuegoFlexible(login, idJuego, true);

                gp.guardarTodo(cafe);
                JOptionPane.showMessageDialog(this, "Prestamo realizado");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        btnCompra.addActionListener(e -> {
            try {
                String idJuego = JOptionPane.showInputDialog("ID Juego:");
                int cant = Integer.parseInt(JOptionPane.showInputDialog("Cantidad:"));

                cafe.comprarJuegoMesa(
                        (usuarios.Cliente) cafe.getUsuarios().get(login),
                        idJuego,
                        cant
                );

                gp.guardarTodo(cafe);

                JOptionPane.showMessageDialog(this, "Compra realizada");

            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
    }
}