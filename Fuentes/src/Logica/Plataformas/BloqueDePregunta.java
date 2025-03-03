package Logica.Plataformas;

import Grafica.Sprite;
import Logica.Mario;
import Logica.PowerUps.PowerUp;

public abstract class BloqueDePregunta extends BloqueSolido {
	protected PowerUp power_up;
	
	public BloqueDePregunta(int x, int y, int ancho, int alto, Sprite sprite) {
		super(x, y, ancho, alto, sprite);
	}
	
	public PowerUp getPowerUp() {
        return power_up;
    }
	
	public boolean tienePowerUp() {
		return true;
	}
	
	public void afectaSuper(Mario mario) {
		afectaNormal(mario);
	}
}
