package Logica;

import java.awt.Rectangle;

import Grafica.Sprite;
import Logica.Observer.EntidadLogica;
import Logica.Observer.Observer;

public abstract class Entidad implements EntidadLogica{
	
	protected int x, y, ancho, alto;
	protected Sprite sprite;
	protected Observer observer;
	protected int posicionEnCapa;
    
    public Entidad(int x, int y, int ancho, int alto, Sprite sprite) {
        this.x = x;
        this.y = y;
        this.ancho = ancho;
        this.alto = alto;
        this.sprite = sprite;
    }

    public int getX() {
    	return x;
    }
    
    public int getY() {
    	return y;
    }
    
    public int getAncho() {
    	return ancho;
    }
    
    public int getAlto() {
    	return alto;
    }
    
    public Sprite getSprite() {
    	return sprite;
    }
    
    public Rectangle getHitBox() {
        return new Rectangle(x, y, ancho, alto);
    }
    
    public int getPosicionEnCapa() {
        return posicionEnCapa;
    }
    
    public void setX(int x) {
    	this.x = x;
    }
    
    public void setY(int y) {
    	this.y = y;
    }
    
    public void setAncho(int ancho) {
    	this.ancho = ancho;
    }
    
    public void setAlto(int alto) {
    	this.alto = alto;
    }
    
    public void setSprite(Sprite sprite) {
    	this.sprite = sprite;
    }
    
    public void setObserver(Observer observer) {
    	this.observer = observer;
    }
    
    public void setPosicionEnCapa(int n) {
        posicionEnCapa = n;
    }

}
