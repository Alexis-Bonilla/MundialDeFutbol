package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modelo.Jugador;
import modelo.Seleccion;

class testSeleccion {

	private Seleccion laSeleccion;
	
	private Jugador jugador1;
	private Jugador jugador2;
	private Jugador jugador3;
	
	
	private void setupEscenario1() {
		laSeleccion=new Seleccion("colombia",1,"");
		jugador1 = new Jugador("jeiner","","delantero",10,"01/02/2000",150);
		jugador2=new Jugador("alexis","","delantero",10,"01/02/2000",150);
		jugador3=new Jugador("bonilla","","delantero",10,"01/02/2000",150);
	}
	
	private void setupEscenario2(){
		laSeleccion=new Seleccion("colombia",1,"");
		jugador1 = new Jugador("jeiner","","delantero",1000,"01/02/2000",180);
		jugador2=new Jugador("alexis","","delantero",2000,"01/02/1999",150);
		jugador3=new Jugador("bonilla","","delantero",3000,"01/02/1998",160);
		laSeleccion.agregarJugador(jugador1);
		laSeleccion.agregarJugador(jugador2);
		laSeleccion.agregarJugador(jugador3);
			
	}
	
	@Test
	public void testAgregarJugador() {
		setupEscenario1();
		laSeleccion.agregarJugador(jugador1);
		laSeleccion.agregarJugador(jugador2);
		laSeleccion.agregarJugador(jugador3);
		assertTrue(laSeleccion.getPrimero().getNombre().equals("jeiner"));
		assertTrue(laSeleccion.getPrimero().getSiguiente().getNombre().equals("alexis"));
		assertTrue(laSeleccion.getPrimero().getSiguiente().getSiguiente().getNombre().equals("bonilla"));

	}
	
	
	@Test
	public void testEliminarJugador() {
		setupEscenario2();
		laSeleccion.eliminarJugador("alexis");
		ArrayList<String> nombres= laSeleccion.darNombresJugadores();
		for (int i = 0; i < nombres.size(); i++) {
			System.out.println(nombres.get(i));
		}
		assertTrue(laSeleccion.getPrimero().getNombre().equals("jeiner"));
		assertTrue(laSeleccion.getPrimero().getSiguiente().getNombre().equals("bonilla"));
	}
	

	
	@Test
	public void testBuscarJugador() {
		setupEscenario2();
		assertTrue(laSeleccion.buscarJugador("alexis").getNombre().equals("alexis"));
		assertTrue(laSeleccion.buscarJugador("bonilla").getNombre().equals("bonilla"));
		assertTrue(laSeleccion.buscarJugador("jeiner").getNombre().equals("jeiner"));
	}
	
	
	@Test
	public void testModificarJugador() {
		setupEscenario2();
		laSeleccion.modificarJugador("bonilla", jugador1);
		assertTrue(laSeleccion.getPrimero().getSiguiente().getSiguiente().getNombre().equals("jeiner"));
	}
	
	@Test
	public void testCalcularPromedioAltura() {
		setupEscenario2();
		double promedio=laSeleccion.calcularPromedioAltura();
		assertTrue(promedio==(150+180.0+160)/3);
	}
	
	
	@Test
	public void testCalcularPromedioEdades() {
		setupEscenario2();
		double promedio=laSeleccion.calcularPromedioEdades();
		assertTrue(promedio==(18+19+20)/3);
	}
	
	@Test
	public void testCalcularPromedioPuntajesFifa() {
		setupEscenario2();
		double promedio=laSeleccion.calcularPromedioPuntajesFifa();
		assertTrue(promedio==2000);
	}
	
	
	
	@Test
	public void testDarNombresJugadores() {
		setupEscenario2();
		ArrayList<String> nombres=laSeleccion.darNombresJugadores();
		assertTrue(nombres.get(0).equals("jeiner"));
		assertTrue(nombres.get(1).equals("alexis"));
		assertTrue(nombres.get(2).equals("bonilla"));
	}
	
	
	
	
	
	
	
	

	
	

}
