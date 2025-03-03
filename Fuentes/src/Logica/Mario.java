package Logica;

import Grafica.Sprite;
import Grafica.Pantalla.ConstantesPantalla;
import Logica.Colisiones.Visitor;
import Logica.Enemigos.Enemigo;
import Logica.EstadosMario.EstadoMario;
import Logica.EstadosMario.MarioNormal;
import Logica.Observer.EntidadJugador;
import Logica.Observer.ObserverJugador;
import Logica.Plataformas.Plataforma;
import Logica.PowerUps.PowerUp;

public class Mario extends Entidad implements Personaje, Visitor, EntidadJugador {
	
    protected int puntos, vidas, monedas;
    protected EstadoMario estado;
    protected ObserverJugador observer;
    protected boolean enSuelo;
    protected static Mario instancia;
    protected double velocidadVertical;
    protected boolean saltando = false;
    protected int gravedad = 3;
    protected boolean invulnerable;
    protected int numeroNivel;
    
    private Mario(int x, int y, int ancho, int alto, Sprite sprite) {
        super(x, y, ancho, alto, sprite);
        this.puntos = 0;
        this.vidas = 3;
        this.monedas = 0;
        this.ancho = ancho;
        this.alto = alto;
    	this.estado = new MarioNormal(this);
    	this.sprite = sprite;
    	this.enSuelo = true;
    	this.invulnerable = false;
    	this.numeroNivel = 1;
    }
    
    public static Mario getInstance() {
		 if (instancia == null) {
	            instancia = new Mario(ConstantesPantalla.POSICION_X_INICIAL, ConstantesPantalla.POSICION_Y_INICIAL, ConstantesPantalla.TAMAÑO_HITBOX, ConstantesPantalla.TAMAÑO_HITBOX, null);
	        }
		 return instancia;
    }
    
    public int getGravedad() {
    	return gravedad;
    }
    
    public boolean getSaltando() {
    	return saltando;
    }
    
    public ObserverJugador getObserver() {
    	return observer;
    }
    
    public double getVelocidadVertical() {
    	return velocidadVertical;
    }
    
    public int getPuntos() {
    	return puntos;
    }
    
    public int getVidas() {
    	return vidas;
    }
    
    public int getMonedas() {
    	return monedas;
    }
    
    public Sprite getSprite(){
    	return sprite;
    }
    
    public EstadoMario getEstadoMario() {
		return estado;
	}
    
    public int getX() {
    	return x;
    }
    
    public int getY() {
    	return y;
    }
    
    public boolean getInvulnerable(){
    	return invulnerable;
    }
    
    public void setSaltando(boolean saltando) {
    	this.saltando = saltando;
    }
    
    public void setVelocidadVertical(double velocidadVertical) {
        this.velocidadVertical = velocidadVertical;
    }

    public void setSprite(Sprite sprite) {
    	this.sprite = sprite;
    }
    
    public void setObserverJugador(ObserverJugador obs) {
    	observer = obs;
    }
    
    public void setVidas(int vidas) {
    	this.vidas = vidas;
    }
    
    public void setEstado(EstadoMario estado) {
        this.estado = estado;
    }
    
    public void setX(double x) {
    	this.x = (int) x;
    }
    
    public void setY(double d) {
    	this.y = (int) d;
    }
    
    public void setEnSuelo(boolean enSuelo){
        this.enSuelo = enSuelo;
    }
    
    public void moverIzquierda() {
    	estado.moverIzquierda();
    }

    public void moverDerecha() {
    	estado.moverDerecha();
    }
    
    public void bajar() {
    	estado.bajar();
    }
    
    public void saltar() {
    	estado.saltar();
    }
    
    public void quieto() {
    	estado.quieto();
    }

    public void sumarPuntos(int puntos) {
    	this.puntos += puntos;
    }
    
    public void sumarVidas(int vidas) {
    	this.vidas += vidas;
    }
    
    public void sumarMonedas(int monedas) {
    	this.monedas += monedas;
    }
    
    public void restarPuntos(int puntos) {
  	  if(this.puntos >= 0 && !((this.puntos - puntos) < 0)) {
  		this.puntos -= puntos;
  	  }else this.puntos = 0;
  }

    public void restarVida() {
        this.vidas--;
    }
    
    public boolean estaEnSuelo() {
        return enSuelo;
    }
    
    public boolean estaInvulnerable() {
        return invulnerable;
    }
    
    public void setInvulnerable(boolean invulnerable) {
        this.invulnerable = invulnerable;
    }
   
    public void serAfectado(Enemigo enemigo) {
    	estado.serAfectado(enemigo);
    }
    
    public void afecta(Enemigo enemigo) {
    	enemigo.esAfectado(this);
    }
	
	public void afecta(PowerUp powerUp) {
        estado.afecta(powerUp);
    }
	
	public void afecta(Plataforma plataforma) {
		estado.afecta(plataforma);
	}
	
	public void resetarMario() {
		vidas = 3;
		monedas = 0;
		puntos = 0;
		
	}

	public int getNivel() {
		return numeroNivel;
	}
	
	public void siguienteNivel() {
		this.numeroNivel++;
	}

	public void desplazar(Enemigo enemigo) {
		x -= 30*enemigo.getDireccion();
	}
}




