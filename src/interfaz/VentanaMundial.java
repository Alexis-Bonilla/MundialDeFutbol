package interfaz;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.BorderFactory;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.border.Border;

import modelo.CopaMundial;
import modelo.Jugador;
import modelo.Seleccion;

public class VentanaMundial extends JFrame{


	private PanelDistribucionInformacion panelDistribucionInformacion;
	private PanelDistribucionSelecciones panelDistribucionSelecciones;
	private PanelDistribucionJugadores panelDistribucionJugadores;
	
	private CopaMundial copaMundial;
	

	
	
	public VentanaMundial() {
	copaMundial= new CopaMundial();
	this.setTitle("Copa Mundial de la FIFA");
	this.setSize(1100, 572);
	this.setDefaultCloseOperation(this.EXIT_ON_CLOSE);
	this.setResizable(false);
	this.setLayout(new BorderLayout());
	panelDistribucionJugadores= new PanelDistribucionJugadores(this);
	panelDistribucionInformacion = new PanelDistribucionInformacion(this);
	panelDistribucionSelecciones = new PanelDistribucionSelecciones(this);
	this.add(panelDistribucionSelecciones, BorderLayout.WEST);
	
	this.add(panelDistribucionJugadores,BorderLayout.CENTER);
	
	this.add(panelDistribucionInformacion, BorderLayout.EAST);
	
	
	
		
		
		
	}
	
	public void agregarSeleccion(String nombrePais,int puntos,String rutaImagen) {
		Seleccion aAgregar= new Seleccion(nombrePais,puntos,rutaImagen);
		copaMundial.agregarSeleccion(aAgregar);
		borrarListaSelecciones();
		refrescarListaSelecciones();
		deshabilitarBotonModificarSelecciones();
	}
	
	public void refrescarListaSelecciones() {
		ArrayList<String> nombres=copaMundial.darNombresSelecciones();
		if(nombres!=null)
			panelDistribucionSelecciones.refrescarListaSelecciones(copaMundial.darNombresSelecciones());
		
	}
	
	public void borrarListaSelecciones() {
		panelDistribucionSelecciones.borrarListaSelecciones();
		
	}
	
	public void modificarSeleccion(String pais, int puntos, String imagen) {
		
		Seleccion aModificar= new Seleccion(pais,puntos,imagen);
		String nombre=panelDistribucionSelecciones.obtenerSeleccionado();
		copaMundial.modificarSeleccion(nombre,aModificar );
		borrarListaSelecciones();
		refrescarListaSelecciones();
		deshabilitarBotonModificarSelecciones();
	}
	
	
	public String darNombreSeleccionSeleccionada() {
		String nombre="";
		nombre=panelDistribucionSelecciones.obtenerSeleccionado();
		return nombre;
	}
	

	
	public void habilitarBotonModificarSelecciones() {
		panelDistribucionSelecciones.habilitarBotonModificar();
	}
	
	
	
	
	
	
	
	
	
	public static void main(String[]args) {

		
		VentanaMundial vm= new VentanaMundial();
		vm.setVisible(true);

	}
	
	public Seleccion darSeleccionActual() {
	Seleccion actual= copaMundial.buscarSeleccion(darNombreSeleccionSeleccionada());
		return actual;
	}

	public String calcularPromedioAltura(Seleccion buscada) {
		double promedio=buscada.calcularPromedioAltura();
		return promedio+"";
	}

	public String calcularPromedioEdad(Seleccion buscada) {
		double promedio= buscada.calcularPromedioEdades();
		return promedio+"";
	}

	public String calcularPromFifa(Seleccion buscada) {
		double promedio= buscada.calcularPromedioPuntajesFifa();
		return promedio+"";
	}

	public void eliminarSeleccion(String nombre) {
		copaMundial.eliminarSeleccion(nombre);
		borrarListaSelecciones();
		refrescarListaSelecciones();
		
	}

	public Seleccion buscarSeleccion(String nombre) {
		return copaMundial.buscarSeleccion(nombre);
	}

	public void agregarJugador() {
		panelDistribucionInformacion.habilitarCampos();
		
	}

	public void cambiarRutaImagenJugador(String rutaImagen) {
	 panelDistribucionInformacion.cambiarRutaImagen(rutaImagen);
		
	}

	public void habilitarBotonAgregarJugador() {
		panelDistribucionJugadores.habilitarBotonAgregarJugador();
		
	}

	public void guardarJugador() {
		String[] info= panelDistribucionInformacion.darInformacion();
		Seleccion donde= copaMundial.buscarSeleccion(darNombreSeleccionSeleccionada());
		System.out.println("Seleccion donde se va a guardar: "+donde.getPais());
		
		Jugador aGuardar= new Jugador(info[1],info[0],info[2],Integer.parseInt(info[3]),info[4],
				Double.parseDouble(info[5]));
		System.out.println("Jugador a guardar : "+aGuardar.getNombre());
		System.out.println("Se hace el llamado al metodo agregar de la clase seleccion");
		donde.agregarJugador(aGuardar);
		System.out.println("sale el metodo agregar");
		System.out.println("numero de jugadores en "+donde.getPais()+ " : "+donde.getNumJugadores());
		System.out.println("se hace llamado al metodo que retorna los nombres de una seleccion");
		
		ArrayList<String> nombres=copaMundial.darNombresJugadores(darNombreSeleccionSeleccionada());
		System.out.println("primer elemento de la lista de nombres: " +nombres.get(0));
		panelDistribucionJugadores.borrarLista();
		panelDistribucionJugadores.refrescarLista(nombres);
		habilitarModoVista();
		System.out.println("salio del metodo guardarJugador");
	
	
		
	}

	private void habilitarModoVista() {
		habilitarBotonesManejo();
		inhabilitarCampos();
		
	}

	private void inhabilitarCampos() {
		panelDistribucionInformacion.inhabilitarCampos();
		
	}

	private void habilitarBotonesManejo() {
		panelDistribucionInformacion.mostrarBotonesManejo();
		
	}

	public void mostrarJugador(String nombre) {
		Jugador aMostrar=copaMundial.buscarSeleccion(darNombreSeleccionSeleccionada()).buscarJugador(nombre);
		panelDistribucionInformacion.setActual(nombre);
		panelDistribucionInformacion.mostrarJugador(aMostrar);
		panelDistribucionInformacion.inhabilitarCampos();
		
	}

	public void actualizarListaJugadores() {
		panelDistribucionJugadores.borrarLista();
		Seleccion actual=darSeleccionActual();
		ArrayList<String> nombres=null;
		if(actual!=null) {
			 nombres=actual.darNombresJugadores();
		}

		if(nombres!=null)
		panelDistribucionJugadores.refrescarLista(darSeleccionActual().darNombresJugadores());
		
	}

	public void eliminarJugador(String nombre) {
		darSeleccionActual().eliminarJugador(nombre);
		actualizarListaJugadores();
		inhabilitarBotonEliminarJugador();
		mostrarJugador(null);
	}
	
	
	public void habilitarBotonEliminarJugador() {
		panelDistribucionJugadores.habilitarBotonEliminarJugador();
		
	}
	public void inhabilitarBotonEliminarJugador() {
		panelDistribucionJugadores.inhabilitarBotonEliminarJugador();
	}

	public void buscarJugador(String nombre) {
		darSeleccionActual().buscarJugador(nombre);
		mostrarJugador(nombre);
		
	}


	public void jugadorAnterior() {
		Jugador actual=darSeleccionActual().buscarJugador(panelDistribucionInformacion.getActual());
		panelDistribucionInformacion.mostrarJugador(actual.getAnterior());
		panelDistribucionInformacion.setActual(actual.getAnterior().getNombre());
	
	}

	public void primerJugador() {

		Jugador actual=darSeleccionActual().getPrimero();
		panelDistribucionInformacion.mostrarJugador(actual);
		panelDistribucionInformacion.setActual(actual.getNombre());
		
	}

	public void jugadorSiguiente() {
		
		Jugador actual=darSeleccionActual().buscarJugador(panelDistribucionInformacion.getActual());
		panelDistribucionInformacion.mostrarJugador(actual.getSiguiente());
		panelDistribucionInformacion.setActual(actual.getSiguiente().getNombre());
	
	}
	
	
	public void deshabilitarBotonModificarSelecciones() {
		panelDistribucionSelecciones.deshabilitarBotonModificar();
	}

	public void deshabilitarBotonBuscarSelecciones() {
		panelDistribucionSelecciones.deshabilitarBotonBuscar();
		
	}

	public void deshabilitarBotonEliminarSelecciones() {
		panelDistribucionSelecciones.deshabilitarBotonEliminar();
		
	}

	public void deshabilitarBotonBuscarJugador() {
		panelDistribucionJugadores.deshabilitarBotonBuscar();
		
	}

	public void deshabilitarBotonAgregarJugador() {
		panelDistribucionJugadores.deshabilitarBotonAgregar();
		
	}

	public void deshabilitarBotonEliminarJugadores() {
		panelDistribucionJugadores.deshabilitarBotonEliminar();
		
	}

	public void habilitarBotonEliminarSeleccion() {
		panelDistribucionSelecciones.habilitarBotonEliminar();
		
	}

	public void habilitarBotonBuscarSeleccion() {
		panelDistribucionSelecciones.habilitarBotonBusar();
		
	}

	public void habilitarBotonBuscarJugador() {
		panelDistribucionJugadores.habilitarBotonBuscar();
		
	}

	public void habilitarBotonPintarArbol() {
		panelDistribucionSelecciones.habilitarBotonPintar();
		
	}
	
	public Seleccion darRaiz() {
		return copaMundial.darRaiz();
	}
	
	
	
	
	
}
