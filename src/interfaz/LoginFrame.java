package interfaz;
import javax.swing.*;
import java.awt.*;
import usuarios.*;
import modelo.*;

public class LoginFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    private JTextField txtUser;
    private JPasswordField txtPass;

    public LoginFrame() {
        setTitle("Login Café");
        setSize(300,200);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(3,2));

        panel.add(new JLabel("Usuario:"));
        txtUser = new JTextField();
        panel.add(txtUser);

        panel.add(new JLabel("Contraseña:"));
        txtPass = new JPasswordField();
        panel.add(txtPass);

        JButton btnLogin = new JButton("Ingresar");
        panel.add(btnLogin);

        add(panel);
        setVisible(true);

        btnLogin.addActionListener(e -> login());
    }

    private void login() {
        String user = txtUser.getText();

        if (user.startsWith("admin")) {
            new AdminFrame();
        } else if (user.startsWith("mesero")) {
            new MeseroFrame();
        } else if (user.startsWith("cocinero")) {
            new CocineroFrame();
        } else {
            new ClienteFrame();
        }

        dispose();
    }
}