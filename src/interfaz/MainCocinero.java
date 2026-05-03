package interfaz;

import modelo.Cafe;
import usuarios.*;

import javax.swing.*;

public class MainCocinero {

    public static void main(String[] args) {

        Cafe cafe = new Cafe();

        try {
            Administrador admin = new Administrador("admin", "123");
            cafe.getUsuarios().put("admin", admin);

            cafe.registrarCocinero("admin", "cocinero1", "123");

            String user = JOptionPane.showInputDialog("Login Cocinero:");
            String pass = JOptionPane.showInputDialog("Contraseña:");

            Usuario u = cafe.iniciarSesion(user, pass);

            if (u instanceof Cocinero) {
                new CocineroFrame(cafe, user);
            } else {
                JOptionPane.showMessageDialog(null, "No es un cocinero");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}