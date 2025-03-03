package Logica.Enemigos;

import java.util.concurrent.CopyOnWriteArrayList;
import Grafica.Sprite;
import Logica.Mario;
import Logica.Strategy.Enemigo.ComportamientoLakitu;

public class Lakitu extends Enemigo {
	
    protected int velocidad = 2;
    protected int xInicial;
    protected CopyOnWriteArrayList<Enemigo> listaEnemigos;
    
    public Lakitu(int x, int y, int ancho, int alto, Sprite sprite, CopyOnWriteArrayList<Enemigo> listaEnemigos) {
        super(x, y, ancho, alto, sprite);
        xInicial = x;
        this.listaEnemigos = listaEnemigos;
        setComportamientoLanzador(new ComportamientoLakitu(this));
        puntos = 60;
    }
    
    public void moverse() {
        if(x < xInicial - 60) {
            if(direccion == -1) {
                direccion = 1;
            } else {
                direccion = -1;
            }
            x += velocidad * direccion;
        } else if(x > xInicial + 60) {
            direccion = -1;
        }
        x += velocidad * direccion;
    }
    
    public void esAfectado(Mario mario) {
        mario.sumarPuntos(60);
        desactivar();
        sonidoMuerte();
    }
    
    public void bajar() {}
    
}