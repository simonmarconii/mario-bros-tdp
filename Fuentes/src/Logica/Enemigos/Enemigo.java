package Logica.Enemigos;

import java.awt.Rectangle;
import Grafica.Sonido;
import Grafica.Sprite;
import Logica.Entidad;
import Logica.Mario;
import Logica.Colisiones.Visitable;
import Logica.Colisiones.Visitor;
import Logica.Observer.ObserverEntidades;
import Logica.Strategy.Enemigo.ComportamientoLanzador;
import Logica.Strategy.Enemigo.ComportamientoNoLanzador;

public abstract class Enemigo extends Entidad implements Visitable {
	
    protected int vida;
    protected int puntos;
    protected ObserverEntidades observer;
    protected boolean colisionConPlataformaLateral;
    protected boolean colisionConPlataformaDesdeArriba;
    protected boolean activo;
    protected ComportamientoLanzador comportamientoLanzador;
    protected boolean estaColisionando;
	protected static final float GRAVEDAD = 2.0f;
	protected int direccion = -1;

    public Enemigo(int x, int y, int ancho, int alto, Sprite sprite) {
        super(x, y, ancho, alto, sprite);
        this.vida = 1;
        this.activo = true;
        this.comportamientoLanzador = new ComportamientoNoLanzador();
    }
    
    public ComportamientoLanzador getComportamientoLanzador() {
        return comportamientoLanzador;
    }
    
    public int getDireccion() {
    	return direccion;
    }
    
    protected void setComportamientoLanzador(ComportamientoLanzador comportamiento) {
        this.comportamientoLanzador = comportamiento;
    }
    
    public abstract void moverse();
    
	public void bajar() {
        y += GRAVEDAD;
        observer.actualizar();
    }

    public void aceptarColision(Visitor visitor) {
    	visitor.afecta(this);
    }
    
    public void aceptarColisionResta(Visitor visitor) {
    	visitor.serAfectado(this);
    }
    
    public int getPuntos(){
    	return puntos;
    }
    
    public boolean getColisionConPlataforma() {
    	return colisionConPlataformaLateral;
    }
    
    public boolean getColisionConPLataformaDesdeArriba() {
    	return colisionConPlataformaDesdeArriba;
    }
    
    public boolean estaActivo() {
    	return activo;
    }

    public ObserverEntidades getObserver() {
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
    
    public void setColisionConPlataforma(boolean colisionConPlataforma) {
    	this.colisionConPlataformaLateral = colisionConPlataforma;
    }
    
    public void setPuntos(int p) {
    	puntos = p;
    }

	public abstract void esAfectado(Mario mario);
	
	public void serAfectado(Mario mario) {
		mario.serAfectado(this);
	}

	public void setColisionConPlataformaDesdeArriba(boolean colisionConPlataformaDesdeArriba) {
		this.colisionConPlataformaDesdeArriba = colisionConPlataformaDesdeArriba;
	}
	
	public void finalizarColision() {
		estaColisionando = false;
    }
	
	public void sonidoMuerte() {
		Sonido.getInstance().reproducir("matar_enemigo");
	}
	
	public void desactivar() {
	    this.activo = false;
	    observer.desaparecer();
	}
	
}
