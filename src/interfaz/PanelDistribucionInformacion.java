package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.border.Border;

import modelo.Jugador;

public class PanelDistribucionInformacion extends JPanel{
	
	private PanelInformacionJugador panelInformacionJugador;
	private PanelImagenJugador panelImagenJugador;
	private PanelBotonesInformacion panelBotonesInformacion;
	private VentanaMundial principal;
	private String actual;
	
	
	
	
	public PanelDistribucionInformacion(VentanaMundial p) {
		principal=p;
		Border b= BorderFactory.createTitledBorder("Informacion");
		this.setBorder(b);
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(400,0));
		panelInformacionJugador= new PanelInformacionJugador(principal);
		panelImagenJugador= new PanelImagenJugador(principal);
		panelBotonesInformacion= new PanelBotonesInformacion(principal);
		this.add(panelInformacionJugador,BorderLayout.CENTER);
		this.add(panelImagenJugador,BorderLayout.NORTH );
		this.add(panelBotonesInformacion, BorderLayout.SOUTH);
		
		
		
		
	}



	public void habilitarCampos() {
		panelInformacionJugador.habilitarCampos();
		panelImagenJugador.habilitarBotonImagen();
		panelBotonesInformacion.quitarBotones();
		
	}



	public void cambiarRutaImagen(String rutaImagen) {
		panelInformacionJugador.cambiarRutaImagen(rutaImagen);
		
	}



	public String[] darInformacion() {
		return panelInformacionJugador.darInformacion();
	}



	public void mostrarBotonesManejo() {
		panelBotonesInformacion.mostrarBotones();
		
	}



	public void inhabilitarCampos() {
		panelInformacionJugador.inhabilitarCampos();
		panelImagenJugador.inhabilitarBotonImagen();
		
	}



	public void mostrarJugador(Jugador aMostrar) {
		if(aMostrar!=null) {
			panelInformacionJugador.mostrarJugador(aMostrar);
			panelImagenJugador.mostrarImagen(aMostrar.getRutaImagen());
			panelBotonesInformacion.mostrarBotones();
		}
		else {
			panelInformacionJugador.mostrarJugadorVacio();
			panelBotonesInformacion.quitarBotones();
			panelImagenJugador.quitarImagen();
			inhabilitarCampos();
		}
		
		
	}
	
	
	public void setActual(String actual) {
		this.actual=actual;
	}
	public String getActual() {
		return actual;
	}
	









	
	

	
	

}
