package interfaz;

import javax.swing.*;
import java.awt.*;

import modelo.Cafe;
import usuarios.*;

public class LoginFrame extends JFrame {

    private static final long serialVersionUID = 1L;

    private JTextField txtUser;
    private JPasswordField txtPass;

    private Cafe cafe;

    public LoginFrame(Cafe cafe) {
        this.cafe = cafe;

        setTitle("Login Café");
        setSize(350,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(4,2));

        panel.add(new JLabel("Usuario:"));
        txtUser = new JTextField();
        panel.add(txtUser);

        panel.add(new JLabel("Contraseña:"));
        txtPass = new JPasswordField();
        panel.add(txtPass);

        JButton btnLogin = new JButton("Ingresar");
        JButton btnRegistro = new JButton("Registrarse");

        panel.add(btnLogin);
        panel.add(btnRegistro);

        add(panel);
        setVisible(true);

        btnLogin.addActionListener(e -> login());
        btnRegistro.addActionListener(e -> registrarCliente());
    }

    private void login() {
        String user = txtUser.getText();
        String pass = new String(txtPass.getPassword());

        try {
            Usuario u = cafe.iniciarSesion(user, pass);

            if (u instanceof Administrador) {
                new AdminFrame(cafe, user);
            } else if (u instanceof Mesero) {
                new MeseroFrame(cafe, user);
            } else if (u instanceof Cocinero) {
                new CocineroFrame(cafe, user);
            } else if (u instanceof Cliente) {
                new ClienteFrame(cafe, user);
            }

            dispose();

        } catch (Exception e) {
            JOptionPane.showMessageDialog(this, e.getMessage());
        }
    }

    private void registrarCliente() {

        JTextField user = new JTextField();
        JPasswordField pass = new JPasswordField();

        Object[] campos = {
                "Nuevo usuario:", user,
                "Contraseña:", pass
        };

        int res = JOptionPane.showConfirmDialog(
                this,
                campos,
                "Registro Cliente",
                JOptionPane.OK_CANCEL_OPTION
        );

        if (res == JOptionPane.OK_OPTION) {
            try {
                cafe.registrarCliente(
                        user.getText(),
                        new String(pass.getPassword())
                );

                JOptionPane.showMessageDialog(this, "Cliente registrado correctamente");

            } catch (Exception e) {
                JOptionPane.showMessageDialog(this, e.getMessage());
            }
        }
    }
}