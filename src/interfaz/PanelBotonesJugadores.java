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

public class PanelBotonesJugadores extends JPanel implements ActionListener{
	public static final String BUT_AGREGAR="agregar";
	public static final String BUT_ELIMINAR="eliminar";
	public static final String BUT_BUSCAR="buscar";
	public static final String BUT_GUARDAR="guardar";
	
	
	
	private JButton butAgregar;
	private JButton butEliminar;
	private JButton butBuscar;
	private JButton butGuardar;
	
	private VentanaMundial principal;
	
	
	
	public PanelBotonesJugadores(VentanaMundial p) {
		principal=p;
		this.setPreferredSize(new Dimension(400,55));
		this.setLayout(new GridLayout(1,4));
		this.setVisible(true);
		butAgregar=new JButton("Agregar");
		butAgregar.setActionCommand(BUT_AGREGAR);
		butAgregar.addActionListener(this);
		butAgregar.setFont(new Font("Arial", 3, 9));
		butAgregar.setBackground(Color.WHITE);
		butAgregar.setEnabled(false);
		
		butEliminar=new JButton("Eliminar");
		butEliminar.setActionCommand(BUT_ELIMINAR);
		butEliminar.addActionListener(this);
		butEliminar.setFont(new Font("Arial", 3, 9));
		butEliminar.setBackground(Color.WHITE);
		butEliminar.setEnabled(false);
		
		
		butBuscar=new JButton("Buscar");
		butBuscar.setActionCommand(BUT_BUSCAR);
		butBuscar.addActionListener(this);
		butBuscar.setFont(new Font("Arial", 3, 9));
		butBuscar.setBackground(Color.WHITE);
		butBuscar.setEnabled(false);
		
		butGuardar=new JButton("Guardar");
		butGuardar.setActionCommand(BUT_GUARDAR);
		butGuardar.addActionListener(this);
		butGuardar.setFont(new Font("Arial", 3, 9));
		butGuardar.setBackground(Color.WHITE);
		butGuardar.setEnabled(false);
		
		
		this.add(butAgregar);
		this.add(butEliminar);
		this.add(butBuscar);
		this.add(butGuardar);
	}
	
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando= evento.getActionCommand();
		if(comando.equals(this.BUT_AGREGAR)) {
			principal.agregarJugador();
			butGuardar.setEnabled(true);
		}
		else if(comando.equals(this.BUT_ELIMINAR)) {
			String nombre= JOptionPane.showInputDialog("Ingrese el nombre del jugador");
			if(nombre!=null)
			principal.eliminarJugador(nombre);
		}
		else if(comando.equals(this.BUT_BUSCAR)) {
			String nombre= JOptionPane.showInputDialog("Ingrese el nombre del jugador");
			if(nombre!=null&&nombre!="") {
				principal.buscarJugador(nombre);
			}
		}
		else if(comando.equals(this.BUT_GUARDAR)) {
			principal.guardarJugador();
			principal.mostrarJugador(null);
			butGuardar.setEnabled(false);
		}
		
	}


	public void habilitarBotonAgregarJugadores() {
		butAgregar.setEnabled(true);
		
	}


	public void habilitarBotonEliminarJugadores() {
		butEliminar.setEnabled(true);
		
	}


	public void inhabilitarBotonEliminarJugadores() {
		butEliminar.setEnabled(false);
		
	}


	public void deshabilitarBotonBuscar() {
		butBuscar.setEnabled(false);
		
	}


	public void deshabilitarBotonAgregar() {
		butAgregar.setEnabled(false);
		
	}


	public void deshabilitarBotonEliminar() {
		butEliminar.setEnabled(false);
		
	}


	public void habilitarBotonBuscar() {
		butBuscar.setEnabled(true);
		
	}
	


}
