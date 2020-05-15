package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;

import modelo.Seleccion;

public class PanelPintar extends JPanel {

	private VentanaPintarArbol principal;
	
	public PanelPintar(VentanaPintarArbol v) {
		principal=v;
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(500,500));
		this.setBorder(BorderFactory.createTitledBorder("Arbol de Selecciones"));
		
	
		
		
		
	}
	
	public void paintComponent(Graphics g) {
		System.out.println(principal.darRaiz().getPais());
		Seleccion raiz= principal.darRaiz();
		int separacion=(int)Math.pow(2, raiz.darAltura())*50;
		pintar(g,raiz,this.getWidth()/2,separacion/2,separacion);
	}
	
	public void pintar(Graphics g,Seleccion aPintar, int aumentoEnX, int aumentoEnY, int separacionActual) {
	if(aPintar!=null) {
		ImageIcon icono1=new ImageIcon(aPintar.getRutaImagen());
		g.drawImage(icono1.getImage(),aumentoEnX, aumentoEnY,50,50, this);
		if(aPintar.getHijoIzquierdo()!=null) {
			pintar(g,aPintar.getHijoIzquierdo(),aumentoEnX-separacionActual,aumentoEnY+100,separacionActual/2);
			g.drawLine(aumentoEnX+25, aumentoEnY+50, aumentoEnX-separacionActual+50, aumentoEnY+100);
			
		}
		if(aPintar.getHijoDerecho()!=null) {
			pintar(g,aPintar.getHijoDerecho(),aumentoEnX+separacionActual,aumentoEnY+100,separacionActual/2);
			g.drawLine(aumentoEnX+25, aumentoEnY+50, aumentoEnX+separacionActual, aumentoEnY+100);
			
		}
		
	}
	}
	
		
		
	}
	

	
	
	
	
