package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;

import modelo.Seleccion;

public class PanelInformacionSeleccion extends JPanel implements ActionListener{
	
	public final static String BUT_GUARDAR= "guardar";
	
	private boolean modificar;
	private VentanaAgregarSeleccion principal;
	
	
private JButton butGuardar;	
	
private JLabel labPais;
private JTextField txtPais;


private JLabel	labPuntos;
private JTextField txtPuntos;


private JLabel labPromAltura;
private JTextField txtPromAltura;


private JLabel labPromEdad;
private JTextField txtPromEdad;


private JLabel labPromFifa;
private JTextField txtPromFifa;


private JLabel labImagen;
private JTextField txtImagen;
	

public PanelInformacionSeleccion(VentanaAgregarSeleccion p) {
	principal=p;
	this.setLayout(new GridLayout(7,2));
	this.setPreferredSize(new Dimension(267,0));
	Border b= BorderFactory.createTitledBorder("Informacion Seleccion");
	this.setBorder(b);
	
	butGuardar= new JButton("Guardar");
	butGuardar.setActionCommand(BUT_GUARDAR);
	butGuardar.addActionListener(this);
	
	labPais= new JLabel("Pais");
	txtPais= new JTextField();
	
	labPuntos= new JLabel("Puntos");
	txtPuntos= new JTextField();
	
	labPromAltura= new JLabel("Promedio Altura");
	txtPromAltura= new JTextField();
	txtPromAltura.setEditable(false);
	
	labPromEdad= new JLabel("Promedio edad");
	txtPromEdad= new JTextField();
	txtPromEdad.setEditable(false);
	
	labPromFifa= new JLabel("Promedio FIFA");
	txtPromFifa= new JTextField();
	txtPromFifa.setEditable(false);
	
	labImagen= new JLabel("Imagen");
	txtImagen= new JTextField("");
	txtImagen.setEditable(false);
	
	this.add(labPais);
	this.add(txtPais);
	this.add(labPuntos);
	this.add(txtPuntos);
	this.add(labPromAltura);
	this.add(txtPromAltura);
	this.add(labPromEdad);
	this.add(txtPromEdad);
	this.add(labPromFifa);
	this.add(txtPromFifa);
	this.add(labImagen);
	this.add(txtImagen);
	this.add(new JLabel());
	this.add(butGuardar);
}


public VentanaAgregarSeleccion getPrincipal() {
	return principal;
}


public void setPrincipal(VentanaAgregarSeleccion principal) {
	this.principal = principal;
}





public void setButGuardar(JButton butGuardar) {
	this.butGuardar = butGuardar;
}


public JLabel getLabPais() {
	return labPais;
}


public void setLabPais(JLabel labPais) {
	this.labPais = labPais;
}


public JTextField getTxtPais() {
	return txtPais;
}


public void setTxtPais(JTextField txtPais) {
	this.txtPais = txtPais;
}


public JLabel getLabPuntos() {
	return labPuntos;
}


public void setLabPuntos(JLabel labPuntos) {
	this.labPuntos = labPuntos;
}


public JTextField getTxtPuntos() {
	return txtPuntos;
}


public void setTxtPuntos(JTextField txtPuntos) {
	this.txtPuntos = txtPuntos;
}


public JLabel getLabPromAltura() {
	return labPromAltura;
}


public void setLabPromAltura(JLabel labPromAltura) {
	this.labPromAltura = labPromAltura;
}


public JTextField getTxtPromAltura() {
	return txtPromAltura;
}


public void setTxtPromAltura(JTextField txtPromAltura) {
	this.txtPromAltura = txtPromAltura;
}


public JLabel getLabPromEdad() {
	return labPromEdad;
}


public void setLabPromEdad(JLabel labPromEdad) {
	this.labPromEdad = labPromEdad;
}


public JTextField getTxtPromEdad() {
	return txtPromEdad;
}


public void setTxtPromEdad(JTextField txtPromEdad) {
	this.txtPromEdad = txtPromEdad;
}


public JLabel getLabPromFifa() {
	return labPromFifa;
}


public void setLabPromFifa(JLabel labPromFifa) {
	this.labPromFifa = labPromFifa;
}


public JTextField getTxtPromFifa() {
	return txtPromFifa;
}


public void setTxtPromFifa(JTextField txtPromFifa) {
	this.txtPromFifa = txtPromFifa;
}


public JLabel getLabImagen() {
	return labImagen;
}


public void setLabImagen(JLabel labImagen) {
	this.labImagen = labImagen;
}


public JTextField getTxtImagen() {
	return txtImagen;
}


public void setTxtImagen(String txtImagen) {
	this.txtImagen.setText(txtImagen);
}


public static String getButGuardar() {
	return BUT_GUARDAR;
}


public void resetearInformacion() {
	txtPais.setText("");
	txtPais.setEnabled(true);
	txtPuntos.setText("");
	txtPuntos.setEnabled(true);
	txtImagen.setText("");
	txtPromAltura.setText("0");
	txtPromEdad.setText("0");
	txtPromFifa.setText("0");
	butGuardar.setVisible(true);
	
}

public void dejarEspaciosDeModificar() {
	txtPais.setText("");
	txtPais.setEnabled(true);
	txtPuntos.setText("");
	txtPuntos.setEnabled(true);
	txtImagen.setText("");
	txtPromAltura.setText(principal.calcularPromAltura(principal.darSeleccionActual()));
	txtPromEdad.setText(principal.calcularPromEdad(principal.darSeleccionActual()));
	txtPromFifa.setText(principal.calcularPromFifa(principal.darSeleccionActual()));
	butGuardar.setVisible(true);
}


public void setModificar(boolean modificar) {
	this.modificar=modificar;
}


@Override
public void actionPerformed(ActionEvent evento) {
	String comando=evento.getActionCommand();
	if(comando.equals(BUT_GUARDAR)) {
		if(txtImagen.getText().equals("")) {
			JOptionPane.showMessageDialog(this, "Porfavor seleccione la imagen");
		}
		else {
			if(modificar) {
				principal.modificarSeleccion(txtPais.getText(),Integer.parseInt(txtPuntos.getText()),txtImagen.getText());
				principal.setVisible(false);
			}
			else {
				principal.agregarSeleccion(txtPais.getText(),Integer.parseInt(txtPuntos.getText()),txtImagen.getText());
				principal.setVisible(false);
			}
			
			
			
		}
	
	}
	
}


public void mostrarInformacionSeleccion(Seleccion buscada) {

	txtPais.setEnabled(false);
	txtPais.setText(buscada.getPais());
	txtPais.setDisabledTextColor(Color.BLACK);
	txtPuntos.setEnabled(false);
	txtPuntos.setText(buscada.getPuntos()+"");
	txtPuntos.setDisabledTextColor(Color.BLACK);
	butGuardar.setVisible(false);
	txtPromAltura.setText(principal.calcularPromAltura(buscada));
	txtPromEdad.setText(principal.calcularPromEdad(buscada));
	txtPromFifa.setText(principal.calcularPromFifa(buscada));
	txtImagen.setText(buscada.getRutaImagen());
//	principal.
	
}



	
	
}
