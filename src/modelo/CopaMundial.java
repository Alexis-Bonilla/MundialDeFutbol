package modelo;

import java.util.ArrayList;

public class CopaMundial {
	
	private Seleccion raiz;
	private int numSelecciones;
	
	
	public CopaMundial() {
		
	}
	
	public void agregarSeleccion(Seleccion aAgregar) {
		if(raiz==null) {
			raiz=aAgregar;
			numSelecciones++;
		}
		else {
			raiz.agregarSeleccion(aAgregar);
			numSelecciones++;
		}
		
	
	}
	
	public void eliminarSeleccion(String nombre) {
		if(raiz==null) {
			
		}
		else {
			raiz=raiz.eliminarSeleccion(nombre);
			numSelecciones--;
		}
	}
	

	
	
	public Seleccion buscarSeleccion(String pais) {
		if(raiz==null)
			return null;
		else
		return raiz.buscarSeleccion(pais);
	}
	
	public void modificarSeleccion(String nombrePais, Seleccion nueva) {
		Seleccion aModificar= buscarSeleccion(nombrePais);
		if(aModificar!=null) {
			aModificar.setPais(nueva.getPais());
			aModificar.setPuntos(nueva.getPuntos());
			aModificar.setRutaImagen(nueva.getRutaImagen());
		}
	}
	

	
public ArrayList<String> darNombresSelecciones() {
if(raiz==null) {
	return null;
}
else {
	ArrayList<String> arreglo= new ArrayList<String>();
	 raiz.darNombresSelecciones(arreglo);
	 return arreglo;
}
}


public ArrayList<String> darNombresJugadores(String nombre) {
	Seleccion cual= buscarSeleccion(nombre);
	ArrayList<String> nombres= cual.darNombresJugadores();
	return nombres;
}

public Seleccion darRaiz() {
	return raiz;
	
}
	
	
	
	
	
	
	
	
	
	
	
	

}
