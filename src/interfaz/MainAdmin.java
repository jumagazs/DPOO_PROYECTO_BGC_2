package interfaz;

import modelo.Cafe;
import usuarios.*;

import javax.swing.*;

public class MainAdmin {

    public static void main(String[] args) {

        Cafe cafe = new Cafe();

        try {
            Administrador admin = new Administrador("admin", "123");
            cafe.getUsuarios().put("admin", admin);

            String user = JOptionPane.showInputDialog("Login Admin:");
            String pass = JOptionPane.showInputDialog("Contraseña:");

            Usuario u = cafe.iniciarSesion(user, pass);

            if (u instanceof Administrador) {
                new AdminFrame(cafe, user);
            } else {
                JOptionPane.showMessageDialog(null, "No es administrador");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}