package Logica.Enemigos;

import Grafica.Sprite;
import Logica.Mario;
import Logica.Colisiones.Visitor;

public class PiranhaPlant extends Enemigo{
	
	protected int direccion = -1;
	protected int velocidad = 2;
	protected int posY_Inicial;

	public PiranhaPlant(int x, int y, int ancho, int alto, Sprite sprite) {
		super(x, y, ancho, alto, sprite);
		posY_Inicial = y;
		puntos = 30;
	}

	public void moverse() {
	    y += velocidad * direccion;
	    
	    if (y >= posY_Inicial + 80) {
	        y = posY_Inicial + 80;  
	        direccion = -1;         
	    }
	    else if (y <= posY_Inicial - 2) {
	        y = posY_Inicial - 2;  
	        direccion = 1;          
	    }
	}
	
	public void setColisionConPlataformaDesdeArriba(boolean colisionConPlataformaDesdeArriba) {
        this.colisionConPlataformaDesdeArriba = false;
    }
	
	public void esAfectado(Mario mario) {
		mario.sumarPuntos(puntos);
		desactivar();
		sonidoMuerte();
	}
	
	public void aceptarColisionResta(Mario mario) {
		mario.restarPuntos(puntos);
	}
	
	public void aceptarColision(Visitor visita) {
		visita.serAfectado(this);
	}
	
	public void bajar() {}

}