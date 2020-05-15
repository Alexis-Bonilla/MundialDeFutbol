package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import modelo.Jugador;

class testJugador {

	
	private Jugador elJugador;
	
	
	private void setupEscenario1() {
		elJugador=new Jugador("bonilla","","delantero",10,"01/02/2000",150);
	}
	
	
	@Test
	public void testGetEdad() {
		setupEscenario1();
		assertTrue(elJugador.getEdad()==18);
	}
	
	
	
	
	
}
