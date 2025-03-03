package Logica.PowerUps;

import Grafica.Sonido;
import Grafica.Sprite;
import Logica.Mario;

public class ChampinonVerde extends PowerUp {
	
	protected int direccion = -1;
	protected int velocidad = 2;
	protected boolean colisionConPlataformaLateral;

	public ChampinonVerde(int x, int y, int ancho, int alto, Sprite sprite) {
		super(x, y, ancho, alto, sprite);
		colisionConPlataformaLateral = false;
	}

	public void esAfectadoNormal(Mario mario) {
		mario.sumarPuntos(100);
		mario.sumarVidas(1);
		Sonido.getInstance().reproducir("suma_vida");
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
