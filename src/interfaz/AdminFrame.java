package interfaz;

import javax.swing.*;
import java.awt.*;

public class AdminFrame extends JFrame {

    public AdminFrame() {
        setTitle("Administrador");
        setSize(500,400);
        setLocationRelativeTo(null);

        JPanel panel = new JPanel(new GridLayout(6,1));

        JButton btnAgregarJuego = new JButton("Agregar Juego");
        JButton btnRegistrarEmpleado = new JButton("Registrar Empleado");
        JButton btnCrearTorneo = new JButton("Crear Torneo");
        JButton btnAprobarSugerencia = new JButton("Aprobar Sugerencias");
        JButton btnVerInforme = new JButton("Ver Informe");
        JButton btnGestionInventario = new JButton("Inventario");

        panel.add(btnAgregarJuego);
        panel.add(btnRegistrarEmpleado);
        panel.add(btnCrearTorneo);
        panel.add(btnAprobarSugerencia);
        panel.add(btnVerInforme);
        panel.add(btnGestionInventario);

        add(panel);
        setVisible(true);

        // EVENTOS
        btnAgregarJuego.addActionListener(e -> JOptionPane.showMessageDialog(this,"Agregar Juego"));
        btnRegistrarEmpleado.addActionListener(e -> JOptionPane.showMessageDialog(this,"Registrar Empleado"));
        btnCrearTorneo.addActionListener(e -> JOptionPane.showMessageDialog(this,"Crear Torneo"));
        btnAprobarSugerencia.addActionListener(e -> JOptionPane.showMessageDialog(this,"Aprobar Sugerencia"));
        btnVerInforme.addActionListener(e -> JOptionPane.showMessageDialog(this,"Informe"));
        btnGestionInventario.addActionListener(e -> JOptionPane.showMessageDialog(this,"Inventario"));
    }
}