package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelDistribucionJugadores extends JPanel{

	private PanelBotonesJugadores panelBotonesJugadores;
	private PanelListaJugadores panelListaJugadores;
	private VentanaMundial principal;

	
	
	
	public PanelDistribucionJugadores(VentanaMundial p) {
		principal=p;
		Border b= BorderFactory.createTitledBorder("Jugadores");
		this.setBorder(b);
		this.setPreferredSize(new Dimension(300,0));
		this.setLayout(new BorderLayout());
		panelBotonesJugadores= new PanelBotonesJugadores(principal);
		panelListaJugadores = new PanelListaJugadores(principal);
		this.add(panelListaJugadores,BorderLayout.CENTER);
		this.add(panelBotonesJugadores, BorderLayout.SOUTH);
	
	}



	public void habilitarBotonAgregarJugador() {
		panelBotonesJugadores.habilitarBotonAgregarJugadores();
		
	}



	public void refrescarLista(ArrayList<String> jugadores) {
		panelListaJugadores.refrescarLista(jugadores);
		
	}



	public void borrarLista() {
		panelListaJugadores.borrarLista();
		
	}



	public void habilitarBotonEliminarJugador() {
		panelBotonesJugadores.habilitarBotonEliminarJugadores();
		
	}
	public String darJugadorSeleccionado() {
		return panelListaJugadores.darSeleccionado();
	}


	public void inhabilitarBotonEliminarJugador() {
		panelBotonesJugadores.inhabilitarBotonEliminarJugadores();
		
	}



	public void deshabilitarBotonBuscar() {
		panelBotonesJugadores.deshabilitarBotonBuscar();
		
	}



	public void deshabilitarBotonAgregar() {
		panelBotonesJugadores.deshabilitarBotonAgregar();
		
	}



	public void deshabilitarBotonEliminar() {
		panelBotonesJugadores.deshabilitarBotonEliminar();
		
	}



	public void habilitarBotonBuscar() {
		panelBotonesJugadores.habilitarBotonBuscar();
		
	}













	
	
	
}
