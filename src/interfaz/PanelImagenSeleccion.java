package interfaz;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.filechooser.FileNameExtensionFilter;

import modelo.Seleccion;


public class PanelImagenSeleccion extends JPanel implements ActionListener{
	
	public static final String BUT_IMAGEN= "imagen";
	
	private FileNameExtensionFilter filtro;
	private String rutaImagen;
	private boolean cargarImagen;
	
	
	
	private JButton butImagen;
	
	private VentanaAgregarSeleccion principal;
	
	public PanelImagenSeleccion(VentanaAgregarSeleccion p) {
		filtro= new FileNameExtensionFilter("Archivos de Imagen","jpg","png","gif");
		rutaImagen="";
		principal=p;
		Border b = BorderFactory.createTitledBorder("Imagen Seleccion");
		this.setBorder(b);
		this.setLayout(new GridLayout(3,1));
		butImagen= new JButton();
		butImagen.addActionListener(this);
		butImagen.setActionCommand(BUT_IMAGEN);
		this.add(butImagen);
		this.add(new JLabel());
		this.add(new JLabel());
		
	}
	
	public void quitarImagen() {
		butImagen.setIcon(null);
	}
	public void colocarImagen() {
		ImageIcon icono= new ImageIcon(principal.darSeleccionActual().getRutaImagen());
		Image imagen= icono.getImage();
		Image nuevaImagen= imagen.getScaledInstance(133, 133, Image.SCALE_SMOOTH);
		icono.setImage(nuevaImagen);
		butImagen.setIcon(icono);
	}
	

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando= evento.getActionCommand();
		if(comando.equals(BUT_IMAGEN)) {
			
			
			if(cargarImagen) {
			    JFileChooser selector=new JFileChooser();
			    selector.setFileFilter(filtro);
	            int estado=selector.showOpenDialog(null);
	            File archivoelegido=selector.getSelectedFile();
	            rutaImagen=archivoelegido.getPath();
	            if(estado==JFileChooser.APPROVE_OPTION);
	            {
	            	ImageIcon iconoImagen= new ImageIcon(rutaImagen);
					Image imagen= iconoImagen.getImage();
					Image nuevaImagen=imagen.getScaledInstance(133, 133, Image.SCALE_SMOOTH);
					iconoImagen.setImage(nuevaImagen);
					butImagen.setIcon(iconoImagen);
//					butImagen.setEnabled(false);
					principal.cambiarRutaImagen(rutaImagen);
	            }
			}
			else {
				
			}

				
		}
			
			
	}

	public void mostrarImagen(Seleccion buscada) {
		ImageIcon icono= new ImageIcon(buscada.getRutaImagen());
		Image imagen= icono.getImage();
		Image nuevaImagen= imagen.getScaledInstance(133, 133, Image.SCALE_SMOOTH);
		icono.setImage(nuevaImagen);
		butImagen.setIcon(icono);
		
	}

	public void habilitarCambiadoDeImagen() {
		cargarImagen=true;	
	}

	public void inhabilitarCambiadoDeImagen() {
		cargarImagen=false;
		
	}



		
}

	

