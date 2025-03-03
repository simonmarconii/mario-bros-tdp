package Logica.Plataformas;


import Grafica.Sprite;
import Logica.Observer.Observer;

public class BanderaFinNivel extends Plataforma {
	
	public BanderaFinNivel(int x, int y, int ancho, int alto, Sprite sprite) {
		super(x, y, ancho, alto, sprite);
		activo = false;
	}

	public Observer getObserver() {
		return observer;
	}
}
