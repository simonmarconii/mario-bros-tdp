package Logica.EstadosMario;

import Grafica.Sonido;
import Grafica.Pantalla.ConstantesPantalla;
import Logica.Mario;
import Logica.Enemigos.Enemigo;
import Logica.Plataformas.Plataforma;
import Logica.PowerUps.PowerUp;

public class MarioEstrella extends EstadoMario {
	
	protected EstadoMario estadoAnterior;
	private long tiempoInicio;
	private static final long DURACION_ESTRELLA = 10000;
	
    public MarioEstrella(Mario mario, EstadoMario estadoAnterior) {
        super(mario);
        this.estadoAnterior = estadoAnterior;
        this.tiempoInicio = System.currentTimeMillis();
        hacerSonido();
    }
    
    public void hacerSonido() {
    	Sonido.getInstance().detenerTodo();
    	Sonido.getInstance().reproducir("estrella");
    }

    public void hacerInvencible(Enemigo enemigo) {
    	enemigo.esAfectado(mario);
    }
    
    public void actualizar() {
    	long tiempoActual = System.currentTimeMillis();
        if (tiempoActual - tiempoInicio >= DURACION_ESTRELLA) {
            volverEstadoAnterior();
        }
    }
    
    private void volverEstadoAnterior() {
    	mario.setEstado(estadoAnterior);
    	Sonido.getInstance().reproducir("power_up");
    	Sonido.getInstance().reproducirMusica("tema_principal");
    }
    
    public void bajar() {
        if(!mario.getSaltando()) {
            mario.setY(mario.getY() + mario.getGravedad());
        }
        mario.getObserver().actualizar();
    }
    
    public void saltar() {
        if(mario.estaEnSuelo() && mario.getVelocidadVertical() == 0) {
            mario.setVelocidadVertical(9);
            mario.setEnSuelo(false);
            mario.setSaltando(true);
            Sonido.getInstance().reproducir("salto");
        }

        if(!mario.estaEnSuelo() && mario.getSaltando()) {
            mario.setY(mario.getY() - (int) mario.getVelocidadVertical());
            mario.setVelocidadVertical(mario.getVelocidadVertical() - 0.25);
        }

        if(mario.estaEnSuelo() && mario.getSaltando()) {
            mario.setVelocidadVertical(0);
            mario.setSaltando(false);
        }
        mario.getObserver().actualizar();
    }
    
	public void moverIzquierda() {
		mario.setX(mario.getX() - ConstantesPantalla.VELOCIDAD_MARIO);
		mario.getObserver().actualizar();
		mario.getObserver().actualizarImagen("MEizquierda");
	}
	
	public void moverDerecha() {
		mario.setX(mario.getX() + ConstantesPantalla.VELOCIDAD_MARIO);
		mario.getObserver().actualizar();
		mario.getObserver().actualizarImagen("MEderecha");
	}
	
	public void quieto() {
		mario.getObserver().actualizarImagen("MEquieto");
	}

	public void afecta(PowerUp powerUp) {
		powerUp.esAfectadoEstrella(mario);
	}

	public void afecta(Plataforma plataforma) {
		plataforma.afectaNormal(mario);
	}
    
	public void serAfectado(Enemigo enemigo) {
		hacerInvencible(enemigo);
	}
}

