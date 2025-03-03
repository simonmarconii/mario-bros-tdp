package Logica.PowerUps;

import Grafica.Sonido;
import Grafica.Sprite;
import Logica.Mario;

public class Moneda extends PowerUp {

	public Moneda(int x, int y, int ancho, int alto, Sprite sprite) {
		super(x, y, ancho, alto, sprite);
	}
	
	public void hacerSonido() {
    	Sonido.getInstance().reproducir("moneda");
    }
	
	public void esAfectadoNormal(Mario mario) {
		mario.sumarPuntos(5);
		mario.sumarMonedas(1);
		desactivar();
		hacerSonido();
	}
	
	public void esAfectadoSuper(Mario mario) {
		esAfectadoNormal(mario);
	}
	
	public void esAfectadoEstrella(Mario mario) {
		esAfectadoNormal(mario);
	}

	public void esAfectadoFlorDeFuego(Mario mario) {
		esAfectadoNormal(mario);
	}
}