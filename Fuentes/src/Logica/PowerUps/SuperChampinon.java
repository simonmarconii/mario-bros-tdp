package Logica.PowerUps;

import Grafica.Sprite;
import Logica.Mario;
import Logica.EstadosMario.MarioSuper;

public class SuperChampinon extends PowerUp {
	
	protected int direccion = -1;
	protected int velocidad = 2;

	public SuperChampinon(int x, int y, int ancho, int alto, Sprite sprite) {
		super(x, y, ancho, alto, sprite);
	}

	public void esAfectadoNormal(Mario mario) {
		mario.sumarPuntos(10);
		mario.setEstado(new MarioSuper(mario));
		desactivar();
		hacerSonido();
	}

	public void esAfectadoSuper(Mario mario) {
		mario.sumarPuntos(50);
		desactivar();
		hacerSonido();
	}

	public void esAfectadoEstrella(Mario mario) {
		mario.sumarPuntos(10);
		desactivar();
		hacerSonido();
	}

	public void esAfectadoFlorDeFuego(Mario mario) {
		esAfectadoSuper(mario);
	}
}
