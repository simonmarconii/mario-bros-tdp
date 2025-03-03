package Logica.Enemigos.EstadoKoopa;

import Logica.Mario;
import Logica.Enemigos.KoopaTroopa;

public class Caparazon extends EstadoKoopaTroopa{
	
	protected int direccion = -1;
	protected int velocidad = 4;
	
	public Caparazon(KoopaTroopa koopaTroopa) {
		super(koopaTroopa);
		koopaTroopa.setPuntos(30);
	}

	public void moverse() {
        if(koopaTroopa.getColisionConPlataforma()) {
        	if(direccion == -1) {
        		direccion = 1;
        	} else {
        		direccion = -1;
        	}
            koopaTroopa.setColisionConPlataforma(false);
            koopaTroopa.setX(koopaTroopa.getX() + velocidad * direccion);
        }
        koopaTroopa.setX(koopaTroopa.getX() + velocidad * direccion);
        koopaTroopa.getObserver().actualizarImagen("caparazon");
    }
	
	public void esAfectado(Mario mario) {
		mario.sumarPuntos(koopaTroopa.getPuntos());
		koopaTroopa.desactivar();
		koopaTroopa.sonidoMuerte();
	}
}