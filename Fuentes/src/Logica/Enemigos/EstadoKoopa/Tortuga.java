package Logica.Enemigos.EstadoKoopa;

import Logica.Mario;
import Logica.Enemigos.KoopaTroopa;

public class Tortuga extends EstadoKoopaTroopa{

	protected int direccion = -1;
	protected int velocidad = 2;
	
	public Tortuga(KoopaTroopa koopaTroopa) {
		super(koopaTroopa);
	}
	
	public void moverse() {
        if(koopaTroopa.getColisionConPlataforma()) {
        	if(direccion == -1) {
        		direccion = 1;
        	}else {
        		direccion = -1;
        	}
            koopaTroopa.setColisionConPlataforma(false);
            koopaTroopa.setX(koopaTroopa.getX() + velocidad * direccion);
        }
        koopaTroopa.setX(koopaTroopa.getX() + velocidad * direccion);
        koopaTroopa.getObserver().actualizarImagen("KT"+direccion);
    }

	public void esAfectado(Mario mario) {
		koopaTroopa.setEstado(new Caparazon(koopaTroopa));
		mario.desplazar(koopaTroopa);
    }		
}
