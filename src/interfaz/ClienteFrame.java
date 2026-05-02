package interfaz;

import javax.swing.*;
import java.awt.*;

public class ClienteFrame extends JFrame {

    public ClienteFrame() {
        setTitle("Cliente");
        setSize(500,400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5,1));

        JButton btnVerMenu = new JButton("Ver Menú");
        JButton btnComprarJuego = new JButton("Comprar Juego");
        JButton btnInscribirseTorneo = new JButton("Inscribirse a Torneo");
        JButton btnVerPuntos = new JButton("Ver Puntos");
        JButton btnFavoritos = new JButton("Gestionar Favoritos");

        panel.add(btnVerMenu);
        panel.add(btnComprarJuego);
        panel.add(btnInscribirseTorneo);
        panel.add(btnVerPuntos);
        panel.add(btnFavoritos);

        add(panel);
        setVisible(true);

        btnComprarJuego.addActionListener(e -> comprar());

        btnVerMenu.addActionListener(e -> new MenuFrame());
    }

    private void comprar() {
        JTextField idJuego = new JTextField();
        JTextField cantidad = new JTextField();

        Object[] campos = {
                "ID Juego:", idJuego,
                "Cantidad:", cantidad
        };

        int res = JOptionPane.showConfirmDialog(this, campos, "Compra", JOptionPane.OK_CANCEL_OPTION);

        if (res == JOptionPane.OK_OPTION) {
            JOptionPane.showMessageDialog(this,"Compra realizada");
        }
    }
}