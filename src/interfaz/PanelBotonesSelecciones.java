package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import modelo.Seleccion;

public class PanelBotonesSelecciones extends JPanel implements ActionListener{

	public static final String BUT_AGREGAR="agregar";
	public static final String BUT_ELIMINAR="eliminar";
	public static final String BUT_BUSCAR="buscar";
	public static final String BUT_MODIFICAR="modificar";
	public static final String BUT_PINTAR_ARBOL="pintar arbol";
	
	private VentanaAgregarSeleccion ventanaAgregarSeleccion;
	private VentanaPintarArbol ventanaPintarArbol;

	
	private JButton butPintar;
	private JButton butAgregar;
	private JButton butEliminar;
	private JButton butBuscar;
	private JButton butModificar;
	
	private VentanaMundial principal;

	
	
	
	public PanelBotonesSelecciones(VentanaMundial p) {
		principal=p;
		ventanaPintarArbol= new VentanaPintarArbol(principal);
		ventanaAgregarSeleccion= new VentanaAgregarSeleccion(principal);
		
		this.setPreferredSize(new Dimension(0,55));
		this.setLayout(new GridLayout(1,5));
		this.setVisible(true);
		butAgregar=new JButton("Agregar");
		butAgregar.setActionCommand(BUT_AGREGAR);
		butAgregar.addActionListener(this);
		butAgregar.setFont(new Font("Arial", 3, 9));
		butAgregar.setBackground(Color.WHITE);
		
		butEliminar=new JButton("Eliminar");
		butEliminar.setActionCommand(BUT_ELIMINAR);
		butEliminar.addActionListener(this);
		butEliminar.setFont(new Font("Arial", 3, 9));
		butEliminar.setBackground(Color.WHITE);
		butEliminar.setEnabled(false);
		
		butPintar=new JButton("Pintar");
		butPintar.setActionCommand(BUT_PINTAR_ARBOL);
		butPintar.addActionListener(this);
		butPintar.setFont(new Font("Arial", 3, 9));
		butPintar.setBackground(Color.WHITE);
		butPintar.setEnabled(false);
		
		
		butBuscar=new JButton("Buscar");
		butBuscar.setActionCommand(BUT_BUSCAR);
		butBuscar.addActionListener(this);
		butBuscar.setFont(new Font("Arial", 3, 9));
		butBuscar.setBackground(Color.WHITE);
		butBuscar.setEnabled(false);
		
		butModificar=new JButton("Modificar");
		butModificar.setActionCommand(BUT_MODIFICAR);
		butModificar.addActionListener(this);
		butModificar.setFont(new Font("Arial", 3, 9));
		butModificar.setBackground(Color.WHITE);
		butModificar.setEnabled(false);
		
		
		this.add(butAgregar);
		this.add(butEliminar);
		this.add(butBuscar);
		this.add(butModificar);
		this.add(butPintar);
	}
	
	public void habilitarBotonModificar() {
		butModificar.setEnabled(true);
	}
	public void deshabilitarBotonModificar() {
		butModificar.setEnabled(false);
	}
	
	

	
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando= evento.getActionCommand();
		if(comando.equals(this.BUT_AGREGAR)) {
			ventanaAgregarSeleccion.asignarModificar(false);
			ventanaAgregarSeleccion.dejarEspaciosEnBlanco();
			ventanaAgregarSeleccion.habilitarCambiadoDeImagen();
			ventanaAgregarSeleccion.setVisible(true);
		}
		else if(comando.equals(this.BUT_ELIMINAR)) {
			String nombre= JOptionPane.showInputDialog("Ingrese el nombre de la seleccion");
			principal.eliminarSeleccion(nombre);
		}
		else if(comando.equals(this.BUT_BUSCAR)) {
			String nombre= JOptionPane.showInputDialog("Ingrese el nombre de la seleccion");
			Seleccion buscada=principal.buscarSeleccion(nombre);
			ventanaAgregarSeleccion.mostrarInformacionSeleccion(buscada);
			ventanaAgregarSeleccion.inhabilitarCambiadoDeImagen();
			ventanaAgregarSeleccion.setVisible(true);
		}
		else if(comando.equals(this.BUT_MODIFICAR)) {
			ventanaAgregarSeleccion.asignarModificar(true);
			ventanaAgregarSeleccion.dejarEspaciosDeModificar();
			ventanaAgregarSeleccion.habilitarCambiadoDeImagen();
			ventanaAgregarSeleccion.setVisible(true);
		}
		else if(comando.equals(BUT_PINTAR_ARBOL)) {
			ventanaPintarArbol.setVisible(true);
		}
		
	}

	public void deshabilitarBotonBuscar() {
		butBuscar.setEnabled(false);
		
	}

	public void deshabilitarBotonEliminar() {
		butEliminar.setEnabled(false);
		
	}

	public void habilitarBotonEliminar() {
		butEliminar.setEnabled(true);
		
	}

	public void habilitarBotonBuscar() {
		butBuscar.setEnabled(true);
		
	}

	public void habilitarBotonPintar() {
		butPintar.setEnabled(true);
		
	}
	
	
	
}
