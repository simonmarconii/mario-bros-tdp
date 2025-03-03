package Logica.Plataformas;

import Grafica.Sprite;
import Logica.PowerUps.PowerUp;

public class BloqueDePreguntaEstrella extends BloqueDePregunta {
	
	public BloqueDePreguntaEstrella(int x, int y, int ancho, int alto, Sprite sprite, PowerUp power_up) {
		super(x, y, ancho, alto, sprite);
		this.power_up = power_up;
	}
}
