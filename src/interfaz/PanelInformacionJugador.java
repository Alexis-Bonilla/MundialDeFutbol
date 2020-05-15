package interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;

import javax.swing.BorderFactory;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import modelo.Jugador;

public class PanelInformacionJugador extends JPanel{

	
	private JTextField txtImagen;
	private JLabel labImagen;
	
	private JTextField txtNombre;
	private JLabel labNombre;
	
	private JTextField txtPosicion;
	private JLabel labPosicion;
	
	private JTextField txtPuntaje;
	private JLabel labPuntaje;
	
	private JTextField txtFechaNacimiento;
	private JLabel labFechaNacimiento;
	
	private JTextField txtAltura;
	private JLabel labAltura;
	
	private VentanaMundial principal;

	public PanelInformacionJugador(VentanaMundial p) {
		principal=p;
		Border b= BorderFactory.createTitledBorder("");
		this.setBorder(b);
		this.setLayout(new GridLayout(6,2));
		this.setPreferredSize(new Dimension(600,675));
		
		
		txtImagen = new JTextField();
		labImagen = new JLabel ("Imagen");
		txtImagen.setEditable(false);
		
		txtNombre = new JTextField();
		labNombre = new JLabel ("Nombre");
		txtNombre.setEditable(false);
		
		txtPosicion = new JTextField();
		labPosicion = new JLabel ("Posicion");
		txtPosicion.setEditable(false);
		
		txtPuntaje = new JTextField();
		labPuntaje = new JLabel ("Puntaje FIFA");
		txtPuntaje.setEditable(false);
		
		txtFechaNacimiento = new JTextField();
		labFechaNacimiento = new JLabel ("Fecha Nac: DD/MM/AAAA");
		txtFechaNacimiento.setEditable(false);
		
		txtAltura = new JTextField();
		labAltura = new JLabel ("Altura (Cms)");
		txtAltura.setEditable(false);
		
		this.add(labImagen);
		this.add(txtImagen);
		this.add(labNombre);
		this.add(txtNombre);
		this.add(labPosicion);
		this.add(txtPosicion);
		this.add(labPuntaje);
		this.add(txtPuntaje);
		this.add(labFechaNacimiento);
		this.add(txtFechaNacimiento);
		this.add(labAltura);
		this.add(txtAltura);
		
		
		
	}

	public void habilitarCampos() {
		txtImagen.setText("");
		txtNombre.setText("");
		txtNombre.setEditable(true);
		txtPosicion.setText("");
		txtPosicion.setEditable(true);
		txtPuntaje.setText("");
		txtPuntaje.setEditable(true);
		txtFechaNacimiento.setText("");
		txtFechaNacimiento.setEditable(true);
		txtAltura.setText("");
		txtAltura.setEditable(true);
		
		
	}
	
	public String[] darInformacion() {
		String[] info= new String[6];
		info[0]=txtImagen.getText();
		info[1]=txtNombre.getText();
		info[2]=txtPosicion.getText();
		info[3]=txtPuntaje.getText();
		info[4]=txtFechaNacimiento.getText();
		info[5]=txtAltura.getText();
		return info;
	}
	

	public void cambiarRutaImagen(String rutaImagen) {
		txtImagen.setText(rutaImagen);
		
	}

	public void inhabilitarCampos() {
		txtNombre.setEditable(false);
		txtPosicion.setEditable(false);
		txtPuntaje.setEditable(false);
		txtFechaNacimiento.setEditable(false);
		txtAltura.setEditable(false);
		
	}

	public void mostrarJugador(Jugador aMostrar) {
		txtNombre.setText(aMostrar.getNombre());
		txtPosicion.setText(aMostrar.getPosicion());
		txtPuntaje.setText(aMostrar.getPuntajeFifa()+"");
		txtFechaNacimiento.setText(aMostrar.getFechaNacimiento());
		txtAltura.setText(aMostrar.getAltura()+"");
		txtImagen.setText(aMostrar.getRutaImagen());
		
	}

	public void mostrarJugadorVacio() {
		txtNombre.setText("");
		txtPosicion.setText("");
		txtPuntaje.setText("");
		txtFechaNacimiento.setText("");
		txtAltura.setText("");
		txtImagen.setText("");
		
	}
	
	
	
	
}
