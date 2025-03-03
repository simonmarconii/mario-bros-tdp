package Logica.Colisiones;

import java.awt.Rectangle;

import Grafica.Sonido;
import Grafica.Pantalla.PantallaJuego;
import Logica.Entidad;
import Logica.Mario;
import Logica.Nivel;
import Logica.Enemigos.Enemigo;
import Logica.Plataformas.BloqueDePregunta;
import Logica.Plataformas.Plataforma;
import Logica.PowerUps.PowerUp;

public class ColisionMario {
	
    protected int margenPixeles = 2;
    protected double gravedad = 0.2;
    protected PantallaJuego pantallaJuego;
    protected Nivel nivel;
    
    public ColisionMario(PantallaJuego pantallaJuego, Nivel nivel) {
        this.pantallaJuego = pantallaJuego;
        this.nivel = nivel;
    }
    
    public void verificarColision(Mario mario, Enemigo enemigo) {
        Rectangle marioRect = mario.getHitBox();
        Rectangle enemigoRect = enemigo.getHitBox();

        if (marioRect.intersects(enemigoRect) && !mario.getInvulnerable()) {
            Rectangle intersection = marioRect.intersection(enemigoRect);
            if (colisionLateral(intersection)) {
                if (colisionaIzquierda(marioRect, enemigoRect)) {
                    enemigo.aceptarColisionResta(mario);
                } else {
                    enemigo.aceptarColisionResta(mario);
                }
            } else {    
                if (colisionaDeArriba(marioRect, enemigoRect)) {
                    colisionArriba(mario, enemigo);
                    enemigo.aceptarColision(mario);
                } 
            }
            verificarMuerte(mario);
        } else {
            enemigo.finalizarColision();;
        }
    }


	public void verificarColision(Mario mario, PowerUp powerUp) {
        Rectangle marioRect = mario.getHitBox();
        Rectangle powerUpRect = powerUp.getHitBox();

        if (marioRect.intersects(powerUpRect)) {
        	powerUp.aceptarColision(mario);
        }
    }

    public void verificarColision(Mario mario, Plataforma plataforma) {
        Rectangle marioRect = mario.getHitBox();
        Rectangle plataformaRect = plataforma.getHitBox();
        
        if (marioRect.intersects(plataformaRect)) {
            Rectangle intersection = marioRect.intersection(plataformaRect);
            if (colisionLateral(intersection)) {
            	mario.setEnSuelo(false);
                if (colisionaIzquierda(marioRect, plataformaRect)) {
                	colisionIzquierda(mario, plataforma);
                } else {
                	colisionDerecha(mario, plataforma);
                }
            } else {
                if (colisionaDeArriba(marioRect, plataformaRect)) {
                    colisionArriba(mario, plataforma);
                } else {
                    colisionAbajo(mario, plataforma);
                }
            }
        }
     }
    
    private void colisionIzquierda(Mario mario, Plataforma plataforma) {
    	mario.setX(plataforma.getX() - mario.getAncho() - margenPixeles);
    }
    
    private void colisionDerecha(Mario mario, Plataforma plataforma) {
    	mario.setX(plataforma.getX() + plataforma.getAncho() + margenPixeles);
    }
    
    private void colisionArriba(Mario mario, Entidad entidad) {
    	mario.setY(entidad.getY() - mario.getAlto() - margenPixeles);
        mario.setEnSuelo(true);
    }
    
    private void colisionAbajo(Mario mario, Plataforma plataforma) {
        mario.setY(plataforma.getY() + plataforma.getAlto());
        mario.setEnSuelo(false);
        mario.setVelocidadVertical(0);
        plataforma.aceptarColision(mario);
        if(plataforma.tienePowerUp()) {
            BloqueDePregunta plat = (BloqueDePregunta) plataforma;
            PowerUp power_up = plat.getPowerUp();
            pantallaJuego.agregarEntidad(power_up);
            pantallaJuego.revalidate();
            pantallaJuego.repaint();
            nivel.setPowerUps(plat.getPowerUp());
            Sonido.getInstance().reproducir("aparece_power_up");

        }
    }
    
    protected boolean colisionaIzquierda(Rectangle rectanguloMario, Rectangle rectanguloEntidad) {
    	return rectanguloMario.getX() < rectanguloEntidad.getX();
    }
    
    protected boolean colisionaDeArriba(Rectangle rectanguloMario, Rectangle rectanguloEntidad) {
    	return rectanguloMario.getY() < rectanguloEntidad.getY();
    }
    
    protected boolean colisionLateral(Rectangle interseccion) {
    	return interseccion.getHeight() > interseccion.getWidth();
    }
    
    protected void verificarMuerte(Mario mario) {
    	if(mario.getVidas() == 0) {
            pantallaJuego.getControladorPantalla().mostrarPantallaPuntaje();
            pantallaJuego.resetearInicio();
            Sonido.getInstance().reproducir("game_over");
            Sonido.getInstance().detener("tema_principal");
        }
    }
}