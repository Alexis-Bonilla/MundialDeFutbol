package interfaz;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JPanel;

public class PanelBotonesInformacion extends JPanel implements ActionListener{

	public static final String BUT_ANTERIOR= "anterior";
	public static final String BUT_SIGUIENTE= "siguiente";
	public static final String BUT_PRIMERO= "primero";
	
	private JButton butAnterior;
	private JButton butSiguiente;
	private JButton butPrimero;
	
	private VentanaMundial principal;
	
	public PanelBotonesInformacion(VentanaMundial p) {
		principal=p;
		this.setLayout(new GridLayout(1,3));
		this.setPreferredSize(new Dimension(0,55));
		
		
		
		butAnterior= new JButton("Anterior");
		butAnterior.setActionCommand(BUT_ANTERIOR);
		butAnterior.addActionListener(this);
		butAnterior.setFont(new Font("Arial", 3, 9));
		butAnterior.setBackground(Color.WHITE);
		
		
		butSiguiente= new JButton("Siguiente");
		butSiguiente.setActionCommand(BUT_SIGUIENTE);
		butSiguiente.addActionListener(this);
		butSiguiente.setFont(new Font("Arial", 3, 9));
		butSiguiente.setBackground(Color.WHITE);
		
		
		butPrimero = new JButton("Primero");
		butPrimero.setActionCommand(BUT_PRIMERO);
		butPrimero.addActionListener(this);
		butPrimero.setFont(new Font("Arial", 3, 9));
		butPrimero.setBackground(Color.WHITE);
		
		this.add(butAnterior);
		this.add(butPrimero);
		this.add(butSiguiente);
		quitarBotones();
	}
	
	
	
	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando = evento.getActionCommand();
		if(comando.equals(this.BUT_ANTERIOR)) {
			principal.jugadorAnterior();
		}
		else if(comando.equals(this.BUT_PRIMERO)) {
			principal.primerJugador();
		}
		else if (comando.equals(this.BUT_SIGUIENTE)) {
			principal.jugadorSiguiente();
		}
		
	}



	public void quitarBotones() {
		butAnterior.setVisible(false);
		butSiguiente.setVisible(false);
		butPrimero.setVisible(false);
		
	}



	public void mostrarBotones() {
		butAnterior.setVisible(true);
		butSiguiente.setVisible(true);
		butPrimero.setVisible(true);
		
	}
	

}
