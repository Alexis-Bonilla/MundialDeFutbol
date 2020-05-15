package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

import modelo.Jugador;

public class PanelListaJugadores extends JPanel implements ListSelectionListener{

	
	private JList lista;
	private JScrollPane barra;
	private DefaultListModel modeloLista;

	private VentanaMundial principal;
	
	
	public PanelListaJugadores(VentanaMundial p) {
		modeloLista= new DefaultListModel();
		principal=p;
		this.setLayout(new BorderLayout());
		this.setPreferredSize(new Dimension(400,0));
		lista= new JList(modeloLista);
		lista.addListSelectionListener(this);
		barra = new JScrollPane(lista);
		this.add(barra,BorderLayout.CENTER);
		
		
	}
	
	
	public String darSeleccionado() {
		int posicion= lista.getSelectedIndex();
		String nombre= (String)modeloLista.getElementAt(posicion);
		return nombre;
	}
	
	
	public void borrarLista() {
		modeloLista.removeAllElements();
	}
	
	public void agregarElemento(String elemento) {
		modeloLista.addElement(elemento);
	}
	
	
	public void refrescarLista(ArrayList<String> jugadores) {
		for (int i = 0; i < jugadores.size(); i++) {
			agregarElemento(jugadores.get(i));
		}
	}
	
	
	public void eliminarElemento(String elemento) {
		modeloLista.remove(lista.getSelectedIndex());
	
	}
	

	
	


	@Override
	public void valueChanged(ListSelectionEvent arg0) {
		if (  !lista.isSelectionEmpty()  ){
	
			principal.mostrarJugador((String)modeloLista.getElementAt(lista.getSelectedIndex()));
			principal.habilitarBotonEliminarJugador();
			System.out.println((String)modeloLista.getElementAt(lista.getSelectedIndex()));
			principal.habilitarBotonBuscarJugador();

		}
		else {
			principal.deshabilitarBotonEliminarJugadores();
			principal.deshabilitarBotonBuscarJugador();
		}

		
		
		
	}
	
	
}
