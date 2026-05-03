package interfaz;

import modelo.Cafe;
import usuarios.*;

import javax.swing.*;

public class MainMesero {

    public static void main(String[] args) {

        Cafe cafe = new Cafe();

        try {
            Administrador admin = new Administrador("admin", "123");
            cafe.getUsuarios().put("admin", admin);

            cafe.registrarMesero("admin", "mesero1", "123");

            String user = JOptionPane.showInputDialog("Login Mesero:");
            String pass = JOptionPane.showInputDialog("Contraseña:");

            Usuario u = cafe.iniciarSesion(user, pass);

            if (u instanceof Mesero) {
                new MeseroFrame(cafe, user);
            } else {
                JOptionPane.showMessageDialog(null, "No es un mesero");
            }

        } catch (Exception e) {
            JOptionPane.showMessageDialog(null, e.getMessage());
        }
    }
}