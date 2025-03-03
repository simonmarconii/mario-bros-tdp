package Logica.Strategy.Enemigo;

public class ComportamientoNoLanzador implements ComportamientoLanzador {

    public boolean debeLanzar() {
        return false;
    }
    
    public int[] getPosicionLanzamiento() {
        return new int[]{0, 0};
    }
}
