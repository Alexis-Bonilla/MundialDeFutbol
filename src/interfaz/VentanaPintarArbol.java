package interfaz;

import java.awt.BorderLayout;

import javax.swing.JDialog;

import modelo.Seleccion;

public class VentanaPintarArbol extends JDialog{

	private VentanaMundial principal;
	private PanelPintar panelPintar;

	
	
	
	
	
	public VentanaPintarArbol(VentanaMundial principal) {
		
		this.principal=principal;
		this.setSize(500,500);
		this.setLayout(new BorderLayout());
		panelPintar=new PanelPintar(this);
		
		this.add(panelPintar,BorderLayout.CENTER);
			
		
		
		
	}
	
	public Seleccion darRaiz(){
		return principal.darRaiz();
	}

	
	
	
	
	
	
}
