package Logica.PowerUps;

import java.awt.Rectangle;

import Grafica.Sonido;
import Grafica.Sprite;
import Logica.Entidad;
import Logica.Mario;
import Logica.Colisiones.Visitable;
import Logica.Colisiones.Visitor;
import Logica.Observer.Observer;
import Logica.Observer.ObserverEntidades;

public abstract class PowerUp extends Entidad implements Visitable {
	
	protected boolean activo;
	protected int direccion = 1;
	protected int velocidad = 4;
	protected int velocidadCaida;
	protected static final float GRAVEDAD = 3.5f;
	protected boolean colisionConPlataformaLateral;
    protected boolean colisionConPlataformaDesdeArriba;
	
    public PowerUp(int x, int y, int ancho, int alto, Sprite sprite) {
        super(x, y, ancho, alto, sprite);
        this.activo = true;
    }

    public Observer getObserver() {
    	return observer;
    }
    
    public boolean getColisionConPlataforma() {
    	return colisionConPlataformaLateral;
    }
    
    public boolean getColisionConPLataformaDesdeArriba() {
    	return colisionConPlataformaDesdeArriba;
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
    
    public void setColisionConPlataforma(boolean colisionConPlataforma) {
    	this.colisionConPlataformaLateral = colisionConPlataforma;
    	velocidad = 0;
    }
    
    public void setColisionConPlataformaDesdeArriba(boolean colisionConPlataforma) {
    	this.colisionConPlataformaDesdeArriba = colisionConPlataforma;
    	if(colisionConPlataforma) {
    		velocidadCaida = 0;
    	}
    }
    
    public void desactivar() {
    	this.activo = false;
    	observer.desaparecer();
    }
    
    public void hacerSonido() {
    	Sonido.getInstance().reproducir("power_up");
    }
    
    public void moverse() {
    	x += velocidad * direccion;
    	y += GRAVEDAD;
    }
    
    public void aceptarColision(Visitor visitor) {
        visitor.afecta(this);
        
    }
    
    public abstract void esAfectadoNormal(Mario mario);
    
    public abstract void esAfectadoSuper(Mario mario);
    
    public abstract void esAfectadoEstrella(Mario mario);
    
    public abstract void esAfectadoFlorDeFuego(Mario mario);
}
