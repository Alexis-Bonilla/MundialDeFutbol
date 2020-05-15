package interfaz;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Scrollbar;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.DefaultListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.ListSelectionModel;
import javax.swing.event.ListSelectionEvent;
import javax.swing.event.ListSelectionListener;

public class PanelListaSelecciones extends JPanel implements ListSelectionListener{

	
	
	private JList lista;
	private JScrollPane barra;
	private DefaultListModel modeloLista;
	
	private VentanaMundial principal;

	
	
	
	public PanelListaSelecciones(VentanaMundial p) {
	
		modeloLista= new DefaultListModel();
		principal=p;
		lista= new JList(modeloLista);
		this.setLayout(new BorderLayout());
		lista.addListSelectionListener(this);
	
		lista.setSelectionMode(ListSelectionModel.SINGLE_SELECTION);
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
	
	public void refrescarLista(ArrayList<String> nombres) {
		for (int i = 0; i < nombres.size(); i++) {
			agregarElemento(nombres.get(i));
		}
	}
	
	public void eliminarElemento(String elemento) {
		modeloLista.remove(lista.getSelectedIndex());
	
	}

	@Override
	public void valueChanged(ListSelectionEvent evento) {
		if (  !lista.isSelectionEmpty()  ){
			principal.habilitarBotonModificarSelecciones();		
			principal.habilitarBotonAgregarJugador();
			principal.actualizarListaJugadores();
			principal.habilitarBotonAgregarJugador();
			principal.habilitarBotonEliminarSeleccion();
			principal.habilitarBotonBuscarSeleccion();
			principal.habilitarBotonPintarArbol();
		}
		else {
			principal.deshabilitarBotonAgregarJugador();
			principal.deshabilitarBotonModificarSelecciones();
			principal.deshabilitarBotonBuscarSelecciones();
			principal.deshabilitarBotonEliminarSelecciones();
		}

		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
