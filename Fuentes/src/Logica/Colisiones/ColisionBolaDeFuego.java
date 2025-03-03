package Logica.Colisiones;
import java.awt.Rectangle;
import Logica.BolaDeFuego;
import Logica.Enemigos.Enemigo;
import Logica.Plataformas.Plataforma;

public class ColisionBolaDeFuego {
	
    public void verificarColision(BolaDeFuego bolaDeFuego, Enemigo enemigo) {
        if (bolaDeFuego.estaActiva()) {
            Rectangle bolaRect = bolaDeFuego.getHitBox();
            Rectangle enemigoRect = enemigo.getHitBox();
        
            if (bolaRect.intersects(enemigoRect)) {
                enemigo.aceptarColision(bolaDeFuego);
                bolaDeFuego.desactivar();
                if (bolaDeFuego.getObserver() != null) {
                    bolaDeFuego.getObserver().desaparecer();
                }
            }
        }
    }

    public void verificarColision(BolaDeFuego bolaDeFuego, Plataforma plataforma) {
        if (bolaDeFuego.estaActiva()) {
            Rectangle bolaRect = bolaDeFuego.getHitBox();
            Rectangle plataformaRect = plataforma.getHitBox();
        
            if (bolaRect.intersects(plataformaRect)) {
                bolaDeFuego.desactivar();
                if (bolaDeFuego.getObserver() != null) {
                    bolaDeFuego.getObserver().desaparecer();
                }
            }
        }
    }
}