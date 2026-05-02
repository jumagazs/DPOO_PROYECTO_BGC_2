package interfaz;

import javax.swing.*;

public class MenuFrame extends JFrame {

    public MenuFrame() {
        setTitle("Menú");
        setSize(400,300);
        setLocationRelativeTo(null);

        JTextArea area = new JTextArea();
        area.setText("MENÚ:\n\n- Café\n- Capuccino\n- Torta\n- Chocolate");

        add(new JScrollPane(area));

        setVisible(true);
    }
}