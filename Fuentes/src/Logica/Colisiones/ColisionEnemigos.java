package Logica.Colisiones;

import java.awt.Rectangle;

import Logica.Enemigos.Enemigo;
import Logica.Plataformas.Plataforma;

public class ColisionEnemigos {
	
    public void verificarColision(Enemigo enemigo, Plataforma plataforma) {
        Rectangle rectEnemigo = enemigo.getHitBox();
        Rectangle rectPlataforma = plataforma.getHitBox();
        
        if(rectEnemigo.intersects(rectPlataforma)) {
        	Rectangle intersection = rectEnemigo.intersection(rectPlataforma);
            if (colisionLateral(intersection)) {
                if (colisionaIzquierda(rectEnemigo, rectPlataforma)) {
                	enemigo.setColisionConPlataforma(true);
                } else {
                	enemigo.setColisionConPlataforma(true);
                }
            } else {    
                if (colisionaDeArriba(rectEnemigo, rectPlataforma)) {
                	enemigo.setColisionConPlataformaDesdeArriba(true);
                	if(enemigo.getColisionConPLataformaDesdeArriba()) {
                	   enemigo.setY((int) (rectPlataforma.getY() - rectEnemigo.height));
                	}
                }
            }
        }
    }
    
    protected boolean colisionaIzquierda(Rectangle rectanguloEnemigo, Rectangle rectanguloPlataforma) {
    	return rectanguloEnemigo.getX() < rectanguloPlataforma.getX();
    }
    
    protected boolean colisionaDeArriba(Rectangle rectanguloEnemigo, Rectangle rectanguloPlataforma) {
    	return rectanguloEnemigo.getY() < rectanguloPlataforma.getY();
    }
    
    protected boolean colisionLateral(Rectangle interseccion) {
    	return interseccion.getHeight() > interseccion.getWidth();
    }
}