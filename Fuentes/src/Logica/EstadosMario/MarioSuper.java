package Logica.EstadosMario;

import Grafica.Sonido;
import Grafica.Pantalla.ConstantesPantalla;
import Logica.Mario;
import Logica.Enemigos.Enemigo;
import Logica.Plataformas.Plataforma;
import Logica.PowerUps.PowerUp;

public class MarioSuper extends EstadoMario {
		
	public MarioSuper(Mario mario) {
		super(mario);
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
		mario.getObserver().actualizarImagen("MSizquierda");
	}
	
	public void moverDerecha() {
		mario.setX(mario.getX() + ConstantesPantalla.VELOCIDAD_MARIO);
		mario.getObserver().actualizar();
		mario.getObserver().actualizarImagen("MSderecha");
	}
	
	public void quieto() {
		mario.getObserver().actualizarImagen("MSquieto");
	}

	public void afecta(PowerUp powerUp) {
		powerUp.esAfectadoSuper(mario);
	}

	public void afecta(Plataforma plataforma) {
		plataforma.afectaSuper(mario);
	}
	
	public void serAfectado(Enemigo enemigo) {
        iniciarParpadeo(mario);
        mario.setEstado(new MarioNormal(mario));
	}
	
	protected void iniciarParpadeo(final Mario mario) {
        mario.setInvulnerable(true);
        
        Thread parpadeoThread = new Thread(new Runnable() {
            public void run() {
                long tiempoInicio = System.currentTimeMillis();
                boolean visible = true;
                
                while (System.currentTimeMillis() - tiempoInicio < TIEMPO_PARPADEO) {
                    visible = !visible;
                    mario.getObserver().setVisible(visible);
                    
                    try {
                        Thread.sleep(INTERVALO_PARPADEO);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                
                mario.getObserver().setVisible(true);
                mario.setInvulnerable(false);
            }
        });
        
        parpadeoThread.start();
    }
}
