package Logica.PowerUps;

import Grafica.Sprite;
import Logica.Mario;
import Logica.EstadosMario.MarioEstrella;

public class Estrella extends PowerUp {

	public Estrella(int x, int y, int ancho, int alto, Sprite sprite) {
		super(x, y, ancho, alto, sprite);
	}

	public void esAfectadoNormal(Mario mario) {
		mario.sumarPuntos(20);
		mario.setEstado(new MarioEstrella(mario, mario.getEstadoMario()));
		desactivar();
		hacerSonido();
	}

	public void esAfectadoSuper(Mario mario) {
		mario.sumarPuntos(30);
		mario.setEstado(new MarioEstrella(mario, mario.getEstadoMario()));
		desactivar();
		hacerSonido();
	}

	public void esAfectadoEstrella(Mario mario) {
		mario.sumarPuntos(35);
		desactivar();
		hacerSonido();
	}

	public void esAfectadoFlorDeFuego(Mario mario) {
		esAfectadoSuper(mario);
	}
}
