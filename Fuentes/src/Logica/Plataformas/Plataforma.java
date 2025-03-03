package Logica.Plataformas;

import java.awt.Rectangle;

import Grafica.Sprite;
import Logica.Entidad;
import Logica.Mario;
import Logica.Colisiones.Visitable;
import Logica.Colisiones.Visitor;
import Logica.Observer.Observer;
import Logica.Observer.ObserverEntidades;

public abstract class Plataforma extends Entidad implements Visitable{
	
	protected boolean activo = true;

	public Plataforma(int x, int y, int ancho, int alto, Sprite sprite) {
		super(x, y, ancho, alto, sprite);
	}
	
	public Observer getObserver() {
		return observer;
	}
	
	public Rectangle getHitBox() {
		if(!activo) {
			return new Rectangle(0,0,0,0);
		}
		return new Rectangle(x,y,ancho,alto);
	}
	
	public void setObserver(ObserverEntidades observer) {
		this.observer = observer;
	}
	
	public boolean tienePowerUp() {
		return false;
	}
	
	public void desactivar() {
		activo = false;
		observer.desaparecer();
	}
	
	public void aceptarColision(Visitor visitor) {
		visitor.afecta(this);
	}

	public void afectaNormal(Mario mario) {}

	public void afectaSuper(Mario mario) {}

}
