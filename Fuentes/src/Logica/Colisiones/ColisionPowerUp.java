package Logica.Colisiones;

import java.awt.Rectangle;

import Logica.Plataformas.Plataforma;
import Logica.PowerUps.PowerUp;

public class ColisionPowerUp {
	
	 public void verificarColision(PowerUp powerUp, Plataforma plataforma) {
	    Rectangle rectPowerUp = powerUp.getHitBox();
	    Rectangle rectPlataforma = plataforma.getHitBox();
	    
	    if(rectPowerUp.intersects(rectPlataforma)) {
        	Rectangle intersection = rectPowerUp.intersection(rectPlataforma);
            if (colisionLateral(intersection)) {
                if (colisionaIzquierda(rectPowerUp, rectPlataforma)) {
                	powerUp.setColisionConPlataforma(true);
                } else {
                	powerUp.setColisionConPlataforma(true);
                }
            } else {    
                if (colisionaDeArriba(rectPowerUp, rectPlataforma)) {
                	powerUp.setColisionConPlataformaDesdeArriba(true);
                	if(powerUp.getColisionConPLataformaDesdeArriba()) {
                	   powerUp.setY((int) (rectPlataforma.getY() - rectPowerUp.height));
                	}
                }
            }
        }
	 }
	 
	 protected boolean colisionaIzquierda(Rectangle rectanguloPowerUp, Rectangle rectanguloPlataforma) {
	    	return rectanguloPowerUp.getX() < rectanguloPlataforma.getX();
	    }
	    
	    protected boolean colisionaDeArriba(Rectangle rectanguloPowerUp, Rectangle rectanguloPlataforma) {
	    	return rectanguloPowerUp.getY() < rectanguloPlataforma.getY();
	    }
	    
	    protected boolean colisionLateral(Rectangle interseccion) {
	    	return interseccion.getHeight() > interseccion.getWidth();
	    }

}
