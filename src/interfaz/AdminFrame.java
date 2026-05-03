package interfaz;

import javax.swing.*;
import java.awt.*;
import modelo.Cafe;

public class AdminFrame extends JFrame {

    private Cafe cafe;
    private String login;

    public AdminFrame(Cafe cafe, String login) {
        this.cafe = cafe;
        this.login = login;

        setTitle("Administrador - " + login);
        setSize(500,400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(5,1));

        JButton btnAgregarJuego = new JButton("Agregar Juego Prestamo");
        JButton btnRegistrarEmpleado = new JButton("Registrar Mesero");
        JButton btnVerInventario = new JButton("Inventario");
        JButton btnVerInforme = new JButton("Informe");
        JButton btnAgregarProducto = new JButton("Agregar Producto");

        panel.add(btnAgregarJuego);
        panel.add(btnRegistrarEmpleado);
        panel.add(btnVerInventario);
        panel.add(btnVerInforme);
        panel.add(btnAgregarProducto);

        add(panel);
        setVisible(true);

        // 🔹 AGREGAR JUEGO
        btnAgregarJuego.addActionListener(e -> {
            try {
                cafe.agregarJuegoPrestamo(login,
                        "Catan", 1995, "Kosmos", "Estrategia",
                        2,4,false,true,true,true,0,"Nuevo");

                JOptionPane.showMessageDialog(this,"Juego agregado");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        // 🔹 REGISTRAR MESERO
        btnRegistrarEmpleado.addActionListener(e -> {
            String user = JOptionPane.showInputDialog("Login:");
            String pass = JOptionPane.showInputDialog("Pass:");

            try {
                cafe.registrarMesero(login, user, pass);
                JOptionPane.showMessageDialog(this,"Mesero creado");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        // 🔹 INVENTARIO
        btnVerInventario.addActionListener(e -> {
            try {
                JOptionPane.showMessageDialog(this,
                        cafe.consultarInventarioVenta(login).toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        // 🔹 INFORME
        btnVerInforme.addActionListener(e -> {
            try {
                JOptionPane.showMessageDialog(this,
                        cafe.consultarInforme(login,"diario").toString());
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });

        // 🔹 PRODUCTO
        btnAgregarProducto.addActionListener(e -> {
            try {
                cafe.agregarBebida(login,"Cafe",5000,true,false,true);
                JOptionPane.showMessageDialog(this,"Producto agregado");
            } catch (Exception ex) {
                JOptionPane.showMessageDialog(this, ex.getMessage());
            }
        });
    }
}