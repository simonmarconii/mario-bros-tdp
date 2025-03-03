package Logica.Enemigos;
import Grafica.Sprite;
import Logica.Mario;
import Logica.Observer.ObserverGrafico;

public class Spiny extends Enemigo {
	
    protected float velocidadCaida;
    protected boolean enSuelo;
    protected static final float GRAVEDAD = 0.5f;
    protected int velocidad = 2;
    protected ObserverGrafico observerGrafico;

    public Spiny(int x, int y, int ancho, int alto, Sprite sprite) {
        super(x, y, ancho, alto, sprite);
        this.velocidadCaida = 0;
        this.enSuelo = false;
        this.observerGrafico = new ObserverGrafico(this);
        puntos = 30;
        direccion = 1;
    }

    public void moverse() {
        if (!enSuelo) {
            velocidadCaida += GRAVEDAD;
            y += velocidadCaida;
        }
        if(colisionConPlataformaLateral) {
            
        	if(direccion == -1) {
            	direccion = 1;
            } else {
            		direccion = -1;
            	}
        	
                colisionConPlataformaLateral = false;
                x += velocidad * direccion;
        }
        
        x += velocidad * direccion;
        
        if (observerGrafico != null) {
            observerGrafico.actualizar();
            observer.actualizarImagen("S"+direccion);
        }
    }

    public void setColisionConPlataforma(boolean colision) {
        super.setColisionConPlataforma(colision);
    }
    
    public void setColisionConPlataformaDesdeArriba(boolean colision) {
        super.setColisionConPlataformaDesdeArriba(colision);
        if (colision) {
            enSuelo = true;
            velocidadCaida = 0;
        }
    }

    public void setVelocidadCaida(float velocidad) {
        this.velocidadCaida = velocidad;
    }

    public void esAfectado(Mario mario) {
        mario.sumarPuntos(puntos*2);
        desactivar();
        sonidoMuerte();
    }

}