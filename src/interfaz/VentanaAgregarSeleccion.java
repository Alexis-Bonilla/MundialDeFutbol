package interfaz;

import java.awt.BorderLayout;

import javax.swing.JButton;
import javax.swing.JDialog;
import javax.swing.JFrame;

import modelo.Seleccion;

public class VentanaAgregarSeleccion extends JDialog {
	
	
private PanelInformacionSeleccion panelInformacionSeleccion;	
private PanelImagenSeleccion panelImagenSeleccion;
private VentanaMundial principal;

public VentanaAgregarSeleccion(VentanaMundial p) {
//	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	principal=p;
	this.setTitle("Agregar Seleccion");
	panelInformacionSeleccion= new PanelInformacionSeleccion(this);
	panelImagenSeleccion= new PanelImagenSeleccion(this);
	this.setLayout(new BorderLayout());
	this.setSize(400,400);
	this.setResizable(false);
	this.add(panelImagenSeleccion,BorderLayout.CENTER);
	this.add(panelInformacionSeleccion, BorderLayout.EAST);
}

public void modificarSeleccion(String pais,int puntos, String ruta) {
	principal.modificarSeleccion(pais, puntos, ruta);
}

public void asignarModificar(boolean modificar) {
	panelInformacionSeleccion.setModificar(modificar);
}

public void agregarSeleccion(String nombrePais,int puntos,String rutaImagen) {
principal.agregarSeleccion(nombrePais, puntos, rutaImagen);
panelImagenSeleccion.habilitarCambiadoDeImagen();

this.setVisible(false);	
}
public void cambiarRutaImagen(String ruta) {
	panelInformacionSeleccion.setTxtImagen(ruta);
}

public void dejarEspaciosEnBlanco() {
	panelInformacionSeleccion.resetearInformacion();
	panelImagenSeleccion.quitarImagen();
}

public void dejarEspaciosDeModificar() {
	panelInformacionSeleccion.dejarEspaciosDeModificar();
	panelImagenSeleccion.colocarImagen();
	
}
public Seleccion darSeleccionActual() {
	Seleccion actual=principal.darSeleccionActual();
	return actual;
}

public String calcularPromAltura(Seleccion buscada) {
	String promAltura= principal.calcularPromedioAltura(buscada);
	return promAltura;
}

public String calcularPromEdad(Seleccion buscada) {
	String promEdad= principal.calcularPromedioEdad(buscada);
	return promEdad;
}

public String calcularPromFifa(Seleccion buscada) {
	String promFifa= principal.calcularPromFifa(buscada);
	return promFifa;
}

public void mostrarInformacionSeleccion(Seleccion buscada) {
	panelInformacionSeleccion.mostrarInformacionSeleccion(buscada);
	panelImagenSeleccion.mostrarImagen(buscada);
	
}

public void habilitarCambiadoDeImagen() {
 panelImagenSeleccion.habilitarCambiadoDeImagen();
	
}

public void inhabilitarCambiadoDeImagen() {
 panelImagenSeleccion.inhabilitarCambiadoDeImagen();
	
}


}
