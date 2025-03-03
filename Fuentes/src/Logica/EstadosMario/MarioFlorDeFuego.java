package Logica.EstadosMario;

import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

import Grafica.Sonido;
import Logica.BolaDeFuego;
import Logica.Mario;

public class MarioFlorDeFuego extends MarioSuper {
	
    private static final int MAX_BOLAS_FUEGO = 100;
    private CopyOnWriteArrayList<BolaDeFuego> bolasDeFuego;
    private boolean ultimaDireccionDerecha;
    
    public MarioFlorDeFuego(Mario mario) {
        super(mario);
        bolasDeFuego = new CopyOnWriteArrayList<>();
        ultimaDireccionDerecha = true;
    }
    
    public boolean puedeDispararBolaDeFuego() {
        return bolasDeFuego.size() < MAX_BOLAS_FUEGO; 
    }
    
    public void quieto() {
		mario.getObserver().actualizarImagen("MFquieto");
	}
    
    public void moverDerecha() {
        super.moverDerecha();
        ultimaDireccionDerecha = true;
        mario.getObserver().actualizarImagen("MFderecha");
    }
    
    public void moverIzquierda() {
        super.moverIzquierda();
        ultimaDireccionDerecha = false;
        mario.getObserver().actualizarImagen("MFizquierda");
    }
    
    public void actualizarBolasDeFuego() {
        Iterator<BolaDeFuego> iterator = bolasDeFuego.iterator();
        while (iterator.hasNext()) {
            BolaDeFuego bola = iterator.next();
            if (bola.estaActiva()) {
                bola.mover();
            } else {
                if (bola.getObserver() != null) {
                    bola.getObserver().desaparecer();
                }
            }
        }
    }
    
    public CopyOnWriteArrayList<BolaDeFuego> getBolasDeFuego() {
        return bolasDeFuego;
    }
    
    public void agregarBolaDeFuego(BolaDeFuego bolaDeFuego) {
        if (bolasDeFuego.size() < MAX_BOLAS_FUEGO) {
            bolasDeFuego.add(bolaDeFuego);
            Sonido.getInstance().reproducir("bola_fuego");
        }
    }

    public boolean UltimaDireccionEsDerecha() {
        return ultimaDireccionDerecha;
    }
}