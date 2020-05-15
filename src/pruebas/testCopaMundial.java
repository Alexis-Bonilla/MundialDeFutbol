package pruebas;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import modelo.CopaMundial;
import modelo.Jugador;
import modelo.Seleccion;

class testCopaMundial {

	private CopaMundial copaMundial;
	private Seleccion seleccion1;
	private Seleccion seleccion2;
	private Seleccion seleccion3;
	
	
	
	private void setupEscenario1() {
		copaMundial=new CopaMundial();
		seleccion1= new Seleccion("colombia",1,"");
		seleccion2= new Seleccion("argentina",2,"");
		seleccion3= new Seleccion("peru",3,"");
	}
	
	private void setupEscenario2() {
		copaMundial=new CopaMundial();
		seleccion1= new Seleccion("colombia",1,"");
		seleccion2= new Seleccion("argentina",2,"");
		seleccion3= new Seleccion("peru",3,"");
		copaMundial.agregarSeleccion(seleccion1);
		copaMundial.agregarSeleccion(seleccion2);
		copaMundial.agregarSeleccion(seleccion3);
	}
	
	private void setupEscenario3() {
		copaMundial=new CopaMundial();
		seleccion1= new Seleccion("colombia",1,"");
		seleccion2= new Seleccion("argentina",2,"");
		seleccion3= new Seleccion("peru",3,"");
		copaMundial.agregarSeleccion(seleccion1);
		copaMundial.agregarSeleccion(seleccion2);
		copaMundial.agregarSeleccion(seleccion3);
		copaMundial.darRaiz().setPrimero(new Jugador("alexis","","delantero",10,"01/02/2000",150));
		copaMundial.darRaiz().getHijoDerecho().setPrimero(new Jugador("bonilla","","delantero",10,"01/02/2000",150));
		copaMundial.darRaiz().setNumJugadores(1);
		copaMundial.darRaiz().getHijoDerecho().setNumJugadores(1);
		
	}
	

	
	
	@Test
	public void testAgregarSeleccion() {
		setupEscenario1();
		copaMundial.agregarSeleccion(seleccion1);
		copaMundial.agregarSeleccion(seleccion2);
		copaMundial.agregarSeleccion(seleccion3);
		assertTrue(copaMundial.darRaiz().getPais().equals("colombia"));
		assertTrue(copaMundial.darRaiz().getHijoDerecho().getPais().equals("argentina"));
		assertTrue(copaMundial.darRaiz().getHijoDerecho().getHijoDerecho().getPais().equals("peru"));	
	}
	
	
	@Test
	public void testEliminarSeleccion() {
		setupEscenario2();
		copaMundial.eliminarSeleccion("colombia");
		assertTrue(copaMundial.darRaiz().getPais().equals("argentina"));
		assertTrue(copaMundial.darRaiz().getHijoDerecho().getPais().equals("peru"));
		assertTrue(copaMundial.darRaiz().getHijoDerecho().getHijoDerecho()==null);
	
	}
	
	
	

	
	
	@Test
	public void testBuscarSeleccion() {
		setupEscenario2();
		assertTrue(copaMundial.buscarSeleccion("peru").getPais().equals("peru"));
		assertTrue(copaMundial.buscarSeleccion("argentina").getPais().equals("argentina"));
		assertTrue(copaMundial.buscarSeleccion("colombia").getPais().equals("colombia"));
	}
	
	
	
	@Test
	public void testModificarSeleccion() {
		setupEscenario2();
		copaMundial.modificarSeleccion("peru", seleccion1);
		assertTrue(copaMundial.darRaiz().getPais().equals("colombia"));
		assertTrue(copaMundial.darRaiz().getHijoDerecho().getPais().equals("argentina"));
		assertTrue(copaMundial.darRaiz().getHijoDerecho().getHijoDerecho().getPais().equals("colombia"));	
	}
	
	@Test
	public void testDarNombresSelecciones() {
		setupEscenario2();
		ArrayList<String> nombres=copaMundial.darNombresSelecciones();
		assertTrue(nombres.get(0).equals("colombia"));
		assertTrue(nombres.get(1).equals("argentina"));
		assertTrue(nombres.get(2).equals("peru"));
		
		
	}
	
	@Test
	public void testDarNombresJugadores() {
		setupEscenario3();
		ArrayList<String> nombresColombia=copaMundial.darNombresJugadores("colombia");
		ArrayList<String> nombresArgentina=copaMundial.darNombresJugadores("argentina");
		assertTrue(nombresColombia.get(0).equals("alexis"));
		assertTrue(nombresArgentina.get(0).equals("bonilla"));
	}

}
