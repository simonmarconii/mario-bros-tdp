package Logica.Observer;

import Grafica.Sprite;

public interface EntidadLogica {
	
	public Sprite getSprite();
	public int getX();
	public int getY();
	public int getAncho();
	public int getAlto();
	public Observer getObserver();
	public int getPosicionEnCapa();
}
