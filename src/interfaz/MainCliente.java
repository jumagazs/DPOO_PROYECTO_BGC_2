package interfaz;

import modelo.Cafe;

public class MainCliente {

    public static void main(String[] args) {

        Cafe cafe = new Cafe();

        new LoginFrame(cafe); 
    }
}