package modelo;

import java.time.LocalDate;
import java.time.Period;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class Jugador {

	private String nombre;
	private String rutaImagen;
	private String posicion;
	private int puntajeFifa;
	private String fechaNacimiento;
	private double altura;
	
	private Jugador siguiente;
	private Jugador anterior;
	
	
	
	public Jugador(String nombre, String rutaImagen, String posicion, int puntajeFifa, String fechaNacimiento,
			double altura) {
		super();
		this.nombre = nombre;
		this.rutaImagen = rutaImagen;
		this.posicion = posicion;
		this.puntajeFifa = puntajeFifa;
		this.fechaNacimiento = fechaNacimiento;
		this.altura = altura;
		siguiente=null;
		anterior=null;
	}



	

	
	
	

	public String getNombre() {
		return nombre;
	}



	public void setNombre(String nombre) {
		this.nombre = nombre;
	}



	public String getRutaImagen() {
		return rutaImagen;
	}



	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}



	public String getPosicion() {
		return posicion;
	}



	public void setPosicion(String posicion) {
		this.posicion = posicion;
	}



	public int getPuntajeFifa() {
		return puntajeFifa;
	}



	public void setPuntajeFifa(int puntajeFifa) {
		this.puntajeFifa = puntajeFifa;
	}



	public String getFechaNacimiento() {
		return fechaNacimiento;
	}



	public void setFechaNacimiento(String fechaNacimiento) {
		this.fechaNacimiento = fechaNacimiento;
	}



	public double getAltura() {
		return altura;
	}



	public void setAltura(double altura) {
		this.altura = altura;
	}



	public Jugador getSiguiente() {
		return siguiente;
	}



	public void setSiguiente(Jugador siguiente) {
		this.siguiente = siguiente;
	}



	public Jugador getAnterior() {
		return anterior;
	}
	public int getEdad() {
		DateTimeFormatter fmt = DateTimeFormatter.ofPattern("dd/MM/yyyy");
		LocalDate fechaNac = LocalDate.parse(fechaNacimiento, fmt);
		LocalDate ahora = LocalDate.now();
		Period periodo = Period.between(fechaNac, ahora);
		int edad= periodo.getYears();
		return edad;
	}



	public void setAnterior(Jugador anterior) {
		this.anterior = anterior;
	}





	public void darNombresJugadores(ArrayList<String> arreglo, int numeroDeVeces) {
		if(numeroDeVeces==0) {
		}
		else {
			arreglo.add(this.nombre);
			if(siguiente!=null)
			this.siguiente.darNombresJugadores(arreglo,numeroDeVeces-1);
		}
	}



	public void agregarJugador(Jugador aAgregar,Jugador primero, int posicion) {
		if(posicion==1) {
			this.siguiente=aAgregar;
			aAgregar.anterior=this;
			aAgregar.siguiente=primero;
			primero.anterior=aAgregar;
		}
		else {
			this.siguiente.agregarJugador(aAgregar, primero, posicion-1);
		}
		
	}




	public void eliminarJugador(String nombre, int numJugadores) {
		if(numJugadores==0) {
		}
		else if(this.nombre.equalsIgnoreCase(nombre)) {
		anterior.siguiente=siguiente;
		siguiente.anterior=anterior;
		}
		else {
			siguiente.eliminarJugador(nombre, numJugadores-1);
		}
		
	}



	public Jugador buscarJugador(String nombre, int numJugadores) {
		if(this.nombre.equalsIgnoreCase(nombre)) {
			return this;
			}
		else if(numJugadores==0) {
			return null;
		}
		else {
			return this.siguiente.buscarJugador(nombre, numJugadores-1);
		}
		
	}


	public double darSumaAlturas(int numJugadores) {
		if(numJugadores==1) {
			return this.altura;
		}
		else {
			return altura+this.siguiente.darSumaAlturas(numJugadores-1);
		}

	}


	public double darSumaEdades(int numJugadores) {
		if(numJugadores==1) {
			return this.getEdad();
		}
		else {
			return this.getEdad()+this.siguiente.darSumaEdades(numJugadores-1);
		}

	}

	public double darSumaPuntajes(int numJugadores) {
		if(numJugadores==1) {
			return this.puntajeFifa;
		}
		else {
			return this.puntajeFifa+this.siguiente.darSumaPuntajes(numJugadores-1);
		}
	}
	
	
	
	
	
	
	
	
	
	
	
}
