package Logica.Enemigos;

import Grafica.Sprite;
import Logica.Mario;

public class BuzzyBeetle extends Enemigo{
	
	protected int velocidad = 2;

	public BuzzyBeetle(int x, int y, int ancho, int alto, Sprite sprite) {
		super(x, y, ancho, alto, sprite);
		puntos = 15;
	}

	public void moverse() {
		if(colisionConPlataformaLateral) {
        	if(direccion == -1) {
        		direccion = 1;
        	}else {
        		direccion = -1;
        	}
            colisionConPlataformaLateral = false;
            x += velocidad * direccion;
        }
        x += velocidad * direccion;
        observer.actualizarImagen("BB"+direccion);
	}

	public void esAfectado(Mario mario) {
		mario.sumarPuntos(puntos*2);
		desactivar();
		sonidoMuerte();
	}

}
