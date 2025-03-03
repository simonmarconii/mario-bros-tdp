package Logica.Enemigos;

import Grafica.Sprite;
import Logica.Mario;
import Logica.Enemigos.EstadoKoopa.EstadoKoopaTroopa;
import Logica.Enemigos.EstadoKoopa.Tortuga;

public class KoopaTroopa extends Enemigo{
	
	protected EstadoKoopaTroopa estado;
	protected boolean puedeSerAfectado;
	
	public KoopaTroopa(int x, int y, int ancho, int alto, Sprite sprite) {
		super(x, y, ancho, alto, sprite);
		estado = new Tortuga(this);
		puntos = 45;
		puedeSerAfectado = true;
	}
	
	public Sprite getSprite(){
    	return sprite;
    }
	
	public void setEstado(EstadoKoopaTroopa estado) {
		this.estado = estado;
	}
	
	public void aceptarColision(Mario mario) {
        esAfectado(mario);
    }

	public void esAfectado(Mario mario) {
		if (!estaColisionando) {
            estado.esAfectado(mario);
            estaColisionando = true;
        }
	}

	public void moverse() {
		estado.moverse();
	}
}
