package Logica.PowerUps;

import Grafica.Sprite;
import Logica.Mario;
import Logica.EstadosMario.MarioFlorDeFuego;

public class FlorDeFuego extends PowerUp {

	public FlorDeFuego(int x, int y, int ancho, int alto, Sprite sprite) {
		super(x, y, ancho, alto, sprite);
	}
	
	public void esAfectadoNormal(Mario mario) {
		mario.sumarPuntos(5);
		mario.setEstado(new MarioFlorDeFuego(mario));
		desactivar();
		hacerSonido();
	}

	public void esAfectadoSuper(Mario mario) {
		mario.sumarPuntos(30);
		mario.setEstado(new MarioFlorDeFuego(mario));
		desactivar();
		hacerSonido();
	}
	
	public void esAfectadoEstrella(Mario mario) {
		mario.sumarPuntos(5);
		desactivar();
		hacerSonido();
	}
	
	public void esAfectadoFlorDeFuego(Mario mario) {
		mario.sumarPuntos(50);
		desactivar();
		hacerSonido();
	}
}