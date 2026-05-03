package interfaz;

import javax.swing.*;
import java.awt.*;
import modelo.Cafe;
import usuarios.Cliente;
import pedidos.Pedido;

public class ClienteFrame extends JFrame {

    private Cafe cafe;
    private String login;

    public ClienteFrame(Cafe cafe, String login) {
        this.cafe = cafe;
        this.login = login;

        setTitle("Cliente - " + login);
        setSize(500,400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5,1));

        JButton btnVerMenu = new JButton("Ver Menú");
        JButton btnComprarJuego = new JButton("Comprar Juego");
        JButton btnInscribirseTorneo = new JButton("Inscribirse a Torneo");
        JButton btnVerPuntos = new JButton("Ver Puntos");
        JButton btnFavoritos = new JButton("Favoritos");

        panel.add(btnVerMenu);
        panel.add(btnComprarJuego);
        panel.add(btnInscribirseTorneo);
        panel.add(btnVerPuntos);
        panel.add(btnFavoritos);

        add(panel);
        setVisible(true);

        btnVerMenu.addActionListener(e -> {
            StringBuilder menu = new StringBuilder();

            cafe.consultarMenu().forEach(p -> {
                menu.append(p.getNombre()).append(" - $").append(p.getPrecio()).append("\n");
            });

            JOptionPane.showMessageDialog(this, menu.toString());
        });

        btnComprarJuego.addActionListener(e -> comprarJuego());

        btnVerPuntos.addActionListener(e -> {
            try {
                Cliente c = (Cliente) cafe.getUsuarios().get(login);
                JOptionPane.showMessageDialog(this, "Puntos: " + c.getPuntosFidelidad());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        btnFavoritos.addActionListener(e -> {
            try {
                StringBuilder favs = new StringBuilder();
                cafe.consultarFavoritos(login).forEach(j -> {
                    favs.append(j.getNombre()).append("\n");
                });
                JOptionPane.showMessageDialog(this, favs.toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        btnInscribirseTorneo.addActionListener(e -> {
            String id = JOptionPane.showInputDialog("ID Torneo:");
            try {
                cafe.inscribirUsuarioTorneo(login, id, 1);
                JOptionPane.showMessageDialog(this, "Inscrito correctamente");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
    }

    private void comprarJuego() {
        JTextField idJuego = new JTextField();
        JTextField cantidad = new JTextField();

        Object[] campos = {
                "ID Juego:", idJuego,
                "Cantidad:", cantidad
        };

        int res = JOptionPane.showConfirmDialog(this, campos, "Compra", JOptionPane.OK_CANCEL_OPTION);

        if (res == JOptionPane.OK_OPTION) {
            try {
                cafe.comprarJuegoMesa(
                        (Cliente) cafe.getUsuarios().get(login),
                        idJuego.getText(),
                        Integer.parseInt(cantidad.getText())
                );
                JOptionPane.showMessageDialog(this,"Compra realizada");
            } catch (Exception e) {
                JOptionPane.showMessageDialog(this,e.getMessage());
            }
        }
    }
}