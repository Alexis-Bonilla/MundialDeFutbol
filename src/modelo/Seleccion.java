package modelo;

import java.util.ArrayList;

public class Seleccion implements Comparable<Seleccion>{

	private String pais;
	private int puntos;
	private String rutaImagen;
	
	
	


	private int numJugadores;
	
	

	private Seleccion hijoDerecho;
	private Seleccion hijoIzquierdo;
	
	
	private Jugador primero;
	
	
	public Seleccion(String pais, int puntos,  String rutaImagen) {
		super();
		this.pais = pais;
		this.puntos = puntos;

		this.rutaImagen = rutaImagen;
		hijoIzquierdo= null;
		hijoDerecho=null;
		
	}
	
	
	public void agregarJugador(Jugador aAgregar) {

		if(primero==null) {
			primero=aAgregar;
			primero.setSiguiente(primero);
			primero.setAnterior(primero);
			numJugadores++;
		}
		else {
			Jugador esta= buscarJugador(aAgregar.getNombre());
			if(esta==null) {
				primero.agregarJugador(aAgregar,primero,numJugadores);
				numJugadores++;
			}
			else {
				this.modificarJugador(esta.getNombre(), aAgregar);
			}
			
		}
	}
	

	
	public void eliminarJugador(String nombre) {
		if(primero==null) {
			}
		
			else {
				primero.eliminarJugador(nombre,numJugadores);
			}

	}
	

	
	
	public Jugador getPrimero() {
		return primero;
	}


	public void setPrimero(Jugador primero) {
		this.primero = primero;
		
	}


	public	Jugador buscarJugador(String nombre) {
		Jugador buscado=null;
		if(primero==null) {
		}
		else {
			buscado= primero.buscarJugador(nombre,numJugadores);
		}
		return buscado;
	}
	
	public void modificarJugador(String nombreJugador,Jugador nuevo) {

		Jugador aModificar= buscarJugador(nombreJugador);
		aModificar.setNombre(nuevo.getNombre());
		aModificar.setRutaImagen(nuevo.getRutaImagen());
		aModificar.setPosicion(nuevo.getPosicion());
		aModificar.setPuntajeFifa(nuevo.getPuntajeFifa());
		aModificar.setFechaNacimiento(nuevo.getFechaNacimiento());
		aModificar.setAltura(nuevo.getAltura());
		
	}
	
	
	public Jugador darSiguiente(String nombre) {
		return buscarJugador(nombre).getSiguiente();
	}
	
	public Jugador darAnterior(String nombre) {
		return buscarJugador(nombre).getAnterior();
	}
	

	
	public double calcularPromedioAltura() {
		double promedioAltura;
		if(primero==null) {
			promedioAltura=0;
		}
		else {
			promedioAltura=primero.darSumaAlturas(numJugadores)/numJugadores;
		}
		return promedioAltura;
	}
	
	public double calcularPromedioEdades() {
		double promedioEdades;
		if(primero==null) {
			promedioEdades=0;
		}
		else {
			promedioEdades=primero.darSumaEdades(numJugadores)/numJugadores;
		}
		return promedioEdades;
	}
	
	
	public double calcularPromedioPuntajesFifa() {
		double promedioPuntajes;
		if(primero==null) {
			promedioPuntajes=0;
		}
		else {
			promedioPuntajes=primero.darSumaPuntajes(numJugadores)/numJugadores;
		}
		return promedioPuntajes;
	}
	
	
	
	
	public ArrayList<String> darNombresJugadores() {
		if(primero==null) {
			return null;
		}
		else {
			ArrayList<String> arreglo= new ArrayList<String>();
			 primero.darNombresJugadores(arreglo,numJugadores);
			 return arreglo;
		}
		}
	
	
	
	
	


	public String getPais() {
		return pais;
	}


	public void setPais(String pais) {
		this.pais = pais;
	}


	public int getPuntos() {
		return puntos;
	}


	public void setPuntos(int puntos) {
		this.puntos = puntos;
	}
	
	public int getNumJugadores() {
		return numJugadores;
	}
	
	public void setNumJugadores(int numJugadores) {
		this.numJugadores = numJugadores;
	}


	


	public String getRutaImagen() {
		return rutaImagen;
	}


	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}



	public Seleccion getHijoDerecho() {
		return hijoDerecho;
	}


	public void setHijoDerecho(Seleccion hijoDerecho) {
		this.hijoDerecho = hijoDerecho;
	}


	public Seleccion getHijoIzquierdo() {
		return hijoIzquierdo;
	}


	public void setHijoIzquierdo(Seleccion hijoIzquierdo) {
		this.hijoIzquierdo = hijoIzquierdo;
	}


	public void agregarSeleccion(Seleccion aAgregar) {
		
		if(this.compareTo(aAgregar)==1) {
			if(this.hijoIzquierdo==null)
				this.hijoIzquierdo=aAgregar;
			else
			this.hijoIzquierdo.agregarSeleccion(aAgregar);
			
		}
		else {
			if(this.hijoDerecho==null)
				this.hijoDerecho=aAgregar;
			else
			this.hijoDerecho.agregarSeleccion(aAgregar);
		}
		
	}



	@Override
	public int compareTo(Seleccion aComparar) {
		int retorno;
		if(this.puntos==aComparar.puntos) {
			retorno=0;
		}
		else if(this.puntos<aComparar.puntos) {
			retorno=-1;
		}
		else {
			retorno=1;
		}
		return retorno;
		
		
		
	}


	public Seleccion buscarSeleccion(String pais) {
		if(this.pais.equalsIgnoreCase(pais))
			return this;
		else if(this.hijoIzquierdo!=null)
			return this.hijoIzquierdo.buscarSeleccion(pais);
		else if(this.hijoDerecho!=null)
			return this.hijoDerecho.buscarSeleccion(pais);
			return null;
	}


	public boolean soyHoja() {
		return this.hijoIzquierdo==null&&this.hijoDerecho==null;
	}
	
	
	public Seleccion eliminarSeleccion(String nombre) {
		if(soyHoja())
			return null;	
		if(this.pais.compareToIgnoreCase(nombre)==0) {
			if(this.hijoDerecho==null)
				return hijoIzquierdo;
			if(this.hijoIzquierdo==null)
				return hijoDerecho;	
			Seleccion sucesor=hijoDerecho.darMenor();
			hijoDerecho=hijoDerecho.eliminarSeleccion(sucesor.pais);
			sucesor.hijoDerecho=hijoDerecho;
			sucesor.hijoIzquierdo=hijoIzquierdo;
			return sucesor;			
		}
		else if(this.pais.compareToIgnoreCase(nombre)>0) 
			 hijoIzquierdo=hijoIzquierdo.eliminarSeleccion(nombre);			
		else 
			 hijoDerecho=hijoDerecho.eliminarSeleccion(nombre);	
		return this;
	}
	
	
	public Seleccion darMenor() {
		return this.hijoIzquierdo==null?this:hijoIzquierdo.darMenor();
	}
	
	public void darNombresSelecciones(ArrayList<String> arreglo) {
		if(hijoIzquierdo!=null)
			hijoIzquierdo.darNombresSelecciones(arreglo);
		arreglo.add(this.pais);
		if(hijoDerecho!=null)
			hijoDerecho.darNombresSelecciones(arreglo);
	}
	
	
	public int darAltura() {
		if(soyHoja()) {
			return 1;
		}
		else {
			int a1= (hijoIzquierdo!=null)?hijoIzquierdo.darAltura():0;
			int a2= (hijoDerecho!=null)?hijoDerecho.darAltura():0;
			return Math.max(a1, a2);
		}
	}
	
	
	
	
	
	
		
	
	
	
	
}
