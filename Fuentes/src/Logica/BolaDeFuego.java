package Logica;

import Grafica.Sprite;
import Logica.Colisiones.Visitor;
import Logica.Enemigos.Enemigo;
import Logica.Observer.Observer;
import Logica.Observer.ObserverEntidades;
import Logica.Plataformas.Plataforma;
import Logica.PowerUps.PowerUp;

public class BolaDeFuego extends Entidad implements Visitor {
    
	protected int velocidad;
    protected boolean direccionDerecha;
    protected boolean activa;
    
    public BolaDeFuego(int x, int y, boolean direccionDerecha, Sprite sprite) {
        super(x, y, 16, 16, sprite);
        this.velocidad = 5;
        this.direccionDerecha = direccionDerecha;
        this.activa = true;
        this.observer = new ObserverEntidades(this);
    }
     
    public void mover() {
        if (activa) {
            if (direccionDerecha) {
                x += velocidad;
            } else {
                x -= velocidad;
            }
        }
        if (observer != null) {
            observer.actualizar();
        }
    }
    
    public void desactivar() {
        activa = false;
    }
    
    public boolean estaActiva() {
        return activa;
    }

	public Observer getObserver() {
		return observer;
	}

	public void afecta(PowerUp powerUp) {

	}

	public void afecta(Plataforma plataforma) {

	}

	public void serAfectado(Enemigo enemigo) {
		afecta(enemigo);
	}

	public void afecta(Enemigo enemigo) {
		if (activa) {
            enemigo.esAfectado(Mario.getInstance());
        }
	}


}
