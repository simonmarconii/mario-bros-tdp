package Logica.Plataformas;

import Grafica.Sonido;
import Grafica.Sprite;
import Logica.Mario;

public class LadrilloSolido extends BloqueSolido {

	public LadrilloSolido(int x, int y, int ancho, int alto, Sprite sprite) {
		super(x, y, ancho, alto, sprite);
	}
	
	public void afectaSuper(Mario mario) {
		desactivar();
		Sonido.getInstance().reproducir("rompe_bloque");
	}
}