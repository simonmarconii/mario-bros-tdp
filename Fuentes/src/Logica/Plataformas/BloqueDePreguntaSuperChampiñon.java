package Logica.Plataformas;

import Grafica.Sprite;
import Logica.PowerUps.PowerUp;

public class BloqueDePreguntaSuperChampiñon extends BloqueDePregunta {
	
	public BloqueDePreguntaSuperChampiñon(int x, int y, int ancho, int alto, Sprite sprite, PowerUp power_up) {
		super(x, y, ancho, alto, sprite);
		this.power_up = power_up;
	}
}
