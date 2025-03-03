package Logica.Strategy.Enemigo;

import Logica.Enemigos.Enemigo;

public class ComportamientoLakitu implements ComportamientoLanzador {
	
    private long ultimoLanzamiento;
    private static final long DELAY_LANZAMIENTO = 5000;
    private final Enemigo enemigo;
    
    public ComportamientoLakitu(Enemigo enemigo) {
        this.enemigo = enemigo;
        this.ultimoLanzamiento = System.currentTimeMillis();
    }
    
    public int[] getPosicionLanzamiento() {
        return new int[]{enemigo.getX(), enemigo.getY() + enemigo.getAlto()};
    }
    
    public boolean debeLanzar() {
        long tiempoActual = System.currentTimeMillis();
        boolean lanza = false;
        if (tiempoActual - ultimoLanzamiento >= DELAY_LANZAMIENTO && enemigo.estaActivo()) {
            ultimoLanzamiento = tiempoActual;
            lanza = true;
        }
        return lanza;
    }
}
