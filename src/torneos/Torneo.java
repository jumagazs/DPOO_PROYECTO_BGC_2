package torneos;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Map;
import juegos.*;
import mesas.*;
import pedidos.*;
import prestamos.*;
import productos.*;
import sugerencias.*;
import usuarios.*;
import ventas.*;

public abstract class Torneo {
	
	
	private int cuposFanaticos;
	private int cuposRegulares;
	private JuegoMesaPrestamo juego;
	private LocalDateTime horaInicio;
	private Map<Usuario,Integer> inscritos;
	public Torneo(int cuposFanaticos, int cuposRegulares, JuegoMesaPrestamo juego, LocalDateTime horaInicio) {
		super();
		this.cuposFanaticos = cuposFanaticos;
		this.cuposRegulares = cuposRegulares;
		this.juego = juego;
		this.horaInicio = horaInicio;
		this.inscritos = new HashMap<Usuario, Integer>();
	}
	


}
