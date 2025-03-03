package Logica.EstadosMario;

import Logica.Mario;
import Logica.Enemigos.Enemigo;
import Logica.Plataformas.Plataforma;
import Logica.PowerUps.PowerUp;

public abstract class EstadoMario {
	
	protected static final int TIEMPO_PARPADEO = 1500;
    protected static final int INTERVALO_PARPADEO = 200;
    protected Mario mario;

    public EstadoMario(Mario mario) {
        this.mario = mario;
    }
    
    public abstract void moverDerecha();
    
    public abstract void moverIzquierda();
    
    public abstract void saltar();
    
    public abstract void bajar();
   
    public abstract void quieto();
    
	public abstract void afecta(PowerUp powerUp);
	
	public boolean puedeDispararBolaDeFuego() {
        return false; 
    }

	public abstract void afecta(Plataforma plataforma);

	public abstract void serAfectado(Enemigo enemigo);
	
	public void actualizar() {
    }
}

