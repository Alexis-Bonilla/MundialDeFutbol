package interfaz;

import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.filechooser.FileNameExtensionFilter;

public class PanelImagenJugador extends JPanel implements ActionListener{
	public final static String BUT_IMAGEN ="imagen";
	
	private JButton butImagen;
	boolean imagenHabilitada;
	private FileNameExtensionFilter filtro;
	private String rutaImagen;
	
	
	private VentanaMundial principal;
	
	public PanelImagenJugador(VentanaMundial p) {
		principal=p;
		this.setLayout(new GridLayout(1,3));
		this.setPreferredSize(new Dimension(600,200));
		butImagen= new JButton();
		butImagen.addActionListener(this);
		butImagen.setActionCommand(BUT_IMAGEN);
		this.add(new JLabel());
		this.add(new JLabel());
		this.add(butImagen);
		
		
		
	}

	@Override
	public void actionPerformed(ActionEvent evento) {
		String comando=evento.getActionCommand();
		if(comando.equals(BUT_IMAGEN)) {
			if(imagenHabilitada) {
				 JFileChooser selector=new JFileChooser();
				    selector.setFileFilter(filtro);
		            int estado=selector.showOpenDialog(null);
		            if(selector.getSelectedFile()!=null) {
		            	 File archivoelegido=selector.getSelectedFile();
				            rutaImagen=archivoelegido.getPath();	
		            }
		            if(estado==JFileChooser.APPROVE_OPTION);
		            {
		            	ImageIcon iconoImagen= new ImageIcon(rutaImagen);
						Image imagen= iconoImagen.getImage();
						Image nuevaImagen=imagen.getScaledInstance(133, 200, Image.SCALE_SMOOTH);
						iconoImagen.setImage(nuevaImagen);
						butImagen.setIcon(iconoImagen);
						principal.cambiarRutaImagenJugador(rutaImagen);	
			}
		}
		else {
			
		}
	}


}

	public void habilitarBotonImagen() {
	 imagenHabilitada=true;
	 butImagen.setIcon(null);
		
	}

	public void inhabilitarBotonImagen() {
		imagenHabilitada=false;
		
	}

	public void mostrarImagen(String rutaImagen) {
		ImageIcon iconoImagen= new ImageIcon(rutaImagen);
		Image imagen= iconoImagen.getImage();
		Image nuevaImagen=imagen.getScaledInstance(133, 200, Image.SCALE_SMOOTH);
		iconoImagen.setImage(nuevaImagen);
		butImagen.setIcon(iconoImagen);
		
	}

	public void quitarImagen() {
		butImagen.setIcon(null);
		
	}
}
