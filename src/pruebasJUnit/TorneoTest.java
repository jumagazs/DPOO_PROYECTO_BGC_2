package pruebasJUnit;

import static org.junit.jupiter.api.Assertions.*;
import java.time.DayOfWeek;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import juegos.JuegoMesaPrestamo;
import torneos.Torneo;
import torneos.TorneoAmistoso;
import usuarios.Cliente;

public class TorneoTest {

    private JuegoMesaPrestamo juego;
    private Torneo torneo;
    private Cliente cliente;

    @BeforeEach
    public void setup() {
        juego = new JuegoMesaPrestamo(
            "Parques", 2012, "Mattel", "Juego de mesa",
            2, 10, false, true, true,
            "JP33", true, 0, "Bueno"
        );

        torneo = new TorneoAmistoso("TOR1", 4, juego, DayOfWeek.FRIDAY, 0.1);
        cliente = new Cliente("cliente1", "1234");
    }

    @Test
    public void testInscribirUsuario() throws Exception {
        torneo.inscribirUsuario(cliente, 1);

        assertTrue(torneo.getInscritosRegulares().containsKey("cliente1"));
        assertEquals(1, torneo.getInscritosRegulares().get("cliente1"));
    }

    @Test
    public void testBloqueoPorCupos() {
        Exception e = assertThrows(Exception.class, () -> {
            torneo.inscribirUsuario(cliente, 4);
        });

        assertEquals("Se permiten entre 1 y 3 cupos por usuario.", e.getMessage());
    }
}