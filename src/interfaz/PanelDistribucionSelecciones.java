package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class PanelDistribucionSelecciones extends JPanel{
	
	private PanelBotonesSelecciones panelBotonesSelecciones;
	private PanelListaSelecciones panelListaSelecciones;
	private VentanaMundial principal;
	
	
	
	public PanelDistribucionSelecciones(VentanaMundial p) {
		principal=p;
		Border b= BorderFactory.createTitledBorder("Selecciones");
		this.setBorder(b);
		this.setPreferredSize(new Dimension(400,0));
		this.setLayout(new BorderLayout());
		panelBotonesSelecciones= new PanelBotonesSelecciones(principal);
		panelListaSelecciones = new PanelListaSelecciones(principal);
		this.add(panelListaSelecciones,BorderLayout.CENTER);
		this.add(panelBotonesSelecciones, BorderLayout.SOUTH);
	
	}
	
	public void borrarListaSelecciones() {
		panelListaSelecciones.borrarLista();
	}
	
	public void refrescarListaSelecciones(ArrayList<String> nombres){
		panelListaSelecciones.refrescarLista(nombres);
	}
	
	public void habilitarBotonModificar() {
		panelBotonesSelecciones.habilitarBotonModificar();
	}
	public void deshabilitarBotonModificar() {
		panelBotonesSelecciones.deshabilitarBotonModificar();
	}
	
	
	public String obtenerSeleccionado() {
		String seleccionado="";
		seleccionado=panelListaSelecciones.darSeleccionado();
		return seleccionado;
	}

	public void deshabilitarBotonBuscar() {
		panelBotonesSelecciones.deshabilitarBotonBuscar();
		
	}

	public void deshabilitarBotonEliminar() {
		panelBotonesSelecciones.deshabilitarBotonEliminar();
		
	}

	public void habilitarBotonEliminar() {
		panelBotonesSelecciones.habilitarBotonEliminar();
		
	}

	public void habilitarBotonBusar() {
		panelBotonesSelecciones.habilitarBotonBuscar();
		
	}

	public void habilitarBotonPintar() {
		panelBotonesSelecciones.habilitarBotonPintar();
		
	}
	
	

}
