package Logica.Observer;

import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ObserverGrafico extends JLabel implements Observer{

	private static final long serialVersionUID = 8675613712411845136L;
	
	protected EntidadLogica entidadObservada;

	public ObserverGrafico(EntidadLogica entidadObservada){
		this.entidadObservada = entidadObservada;
		actualizarImagen("default");
	}
	
	public void actualizar() {
		actualizarPosicion();
	}

	public void actualizarImagen(String ruta){
		String ruta_imagen = entidadObservada.getSprite().getRutaDeImagen(ruta);
		ImageIcon icono = new ImageIcon(ruta_imagen);
		setIcon(icono);
	}
	
	public void actualizarPosicion(){
		int x = entidadObservada.getX();
		int y = entidadObservada.getY();
		setBounds(x,y,entidadObservada.getAncho(),entidadObservada.getAlto());
	}

	public void desaparecer() {
		setVisible(false);
	}
}
