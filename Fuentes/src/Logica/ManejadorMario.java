package Logica;

import Datos.GeneradorNivel.FabricaEntidades;
import Grafica.Sonido;
import Grafica.Pantalla.ConstantesPantalla;
import Grafica.Pantalla.PantallaJuego;
import Logica.Colisiones.ColisionBolaDeFuego;
import Logica.Colisiones.ColisionMario;
import Logica.Enemigos.Enemigo;
import Logica.EstadosMario.EstadoMario;
import Logica.EstadosMario.MarioFlorDeFuego;
import Logica.EstadosMario.MarioNormal;
import Logica.Observer.ObserverJugador;
import Logica.Plataformas.Plataforma;
import Logica.PowerUps.PowerUp;

public class ManejadorMario implements Runnable{
	
	protected Nivel nivel;
	protected PantallaJuego pantallaJuego;
	protected ManejadorTeclado teclado;
	protected Thread hilo;
	protected FabricaEntidades fabricaEntidades;
	
	public ManejadorMario(Nivel nivel, PantallaJuego pantallaJuego, FabricaEntidades fabricaEntidades) {
		this.nivel = nivel;
		this.pantallaJuego = pantallaJuego;
		this.teclado = new ManejadorTeclado();
		pantallaJuego.setFocusable(true);
		pantallaJuego.addKeyListener(teclado);
		this.fabricaEntidades = fabricaEntidades;
	}
	
	public void run() {
		long ultimoTiempo = System.nanoTime();
        double cantidadTicks = 60.0;
        double frecuenciaActualizacion = 1000000000 / cantidadTicks;
        double delta = 0;

        while(hilo!=null) {
        	long tiempoActual = System.nanoTime();
            delta += (tiempoActual - ultimoTiempo) / frecuenciaActualizacion;
            ultimoTiempo = tiempoActual;

            while(delta>=1) {
                finNivel();
                cayoAlVacio();
                actualizar();
                delta--;
            }
        }
	}
	
	public void iniciarHilo() {
        hilo = new Thread(this);
        hilo.start();
    }
    
    public void detener() {
        if (hilo != null) {
            hilo = null;
        }
        teclado.resetearTeclas();
    } 
	
	public void actualizar() {
		pantallaJuego.requestFocusInWindow();
        verificarColisionesMario();
        verificarColisionesBolasFuego();
        Mario.getInstance().getEstadoMario().actualizar();
        
        if(nivel.getMario().getX() > pantallaJuego.getMitad() - ConstantesPantalla.MITAD_PANTALLA) {
              if(teclado.getIzqApretado()) {
            	  nivel.getMario().moverIzquierda();
              }
            }
        if(teclado.getDerApretado()) {
            nivel.getMario().moverDerecha();
            pantallaJuego.actualizarInfoJugador(nivel.getMario());
        }
        if(teclado.getSaltando()) {
            nivel.getMario().saltar();
            if(nivel.getMario().estaEnSuelo()) {
                teclado.setSaltando(false);
            }
        }
        if(nivel.getMario().getObserver() != null) {
            nivel.getMario().bajar();
        }
        if(!teclado.getDerApretado() && !teclado.getIzqApretado() && !teclado.getSaltando()) {
        	nivel.getMario().quieto();
        }
        
        manejoBolaDeFuego();
	}
	
	protected void manejoBolaDeFuego() {
		
		EstadoMario estadoActual = nivel.getMario().getEstadoMario();
        if(teclado.getEspacioApretado()) {
            if(estadoActual.puedeDispararBolaDeFuego()) {
                MarioFlorDeFuego estadoFuego = (MarioFlorDeFuego)estadoActual;
                int posX = nivel.getMario().getX() + (estadoFuego.UltimaDireccionEsDerecha() ? 
                    nivel.getMario().getAncho() : 0);
                int posY = nivel.getMario().getY() - nivel.getMario().getAlto()/2  + 15;
                BolaDeFuego nuevaBola = fabricaEntidades.getBolaDeFuego(posX, posY, estadoFuego.UltimaDireccionEsDerecha());
                
                if(nuevaBola != null && nuevaBola.getObserver() != null) {
                    estadoFuego.agregarBolaDeFuego(nuevaBola);
                    pantallaJuego.agregarEntidad(nuevaBola);
                    teclado.setEspacioApretado(false);
                }
                teclado.setEspacioApretado(false);
            }
        }

        if(estadoActual.puedeDispararBolaDeFuego()) {
            ((MarioFlorDeFuego)estadoActual).actualizarBolasDeFuego();
        }
	}
	
	protected void verificarColisionesMario() {
        ColisionMario colisionMario = new ColisionMario(pantallaJuego, nivel);

        for(Enemigo enemigo : nivel.getEnemigos()) {
            colisionMario.verificarColision(Mario.getInstance(), enemigo);
        }

        for(PowerUp powerUp : nivel.getPowerUps()) {
            colisionMario.verificarColision(Mario.getInstance(), powerUp);
        }

        for(Plataforma plataforma : nivel.getPlataformas()) {
            colisionMario.verificarColision(Mario.getInstance(), plataforma);
        }
    }
	
	protected void verificarColisionesBolasFuego() {
	    EstadoMario estadoActual = nivel.getMario().getEstadoMario();
	    if(estadoActual.puedeDispararBolaDeFuego()) {
	        ColisionBolaDeFuego colisionBola = new ColisionBolaDeFuego();
	    
	        for (BolaDeFuego bolaDeFuego : ((MarioFlorDeFuego)estadoActual).getBolasDeFuego()) {
	            for (Enemigo enemigo : nivel.getEnemigos()) {
	                colisionBola.verificarColision(bolaDeFuego, enemigo);
	            }
	            
	            for (Plataforma plataforma : nivel.getPlataformas()) {
	                colisionBola.verificarColision(bolaDeFuego, plataforma);
	            }
	        }
	    }
	}
	
	public void finNivel() {
	  if(Mario.getInstance().getX() == ConstantesPantalla.FIN_NIVEL) {
		  	EstadoMario estadoNivelAnterior = Mario.getInstance().getEstadoMario();
        	pantallaJuego.resetear();
        	Mario.getInstance().setEstado(estadoNivelAnterior);
        	Sonido.getInstance().reproducir("bandera_fin_nivel");
      }
	}
	
	public void cayoAlVacio() {
		if(Mario.getInstance().getY() >= ConstantesPantalla.LIMITE_PANTALLA_INFERIOR) {
			Mario.getInstance().restarVida();
			Mario.getInstance().setEstado(new MarioNormal(Mario.getInstance()));
			if(Mario.getInstance().getVidas() > 0) {
				Sonido.getInstance().reproducir("pierde_vida");
			}
			reiniciarPosicion(Mario.getInstance());
			Mario.getInstance().restarPuntos(15);
		}
		if(Mario.getInstance().getVidas() == 0) {
    		pantallaJuego.getControladorPantalla().mostrarPantallaPuntaje();
    		pantallaJuego.resetearInicio();
    		Mario.getInstance().resetarMario();
    		Sonido.getInstance().detener("tema_principal");
    		Sonido.getInstance().reproducir("game_over");
    	}
	}
	
	protected void reiniciarPosicion(Mario mario) {
        mario.setX(ConstantesPantalla.POSICION_X_INICIAL);
        mario.setY(ConstantesPantalla.POSICION_Y_INICIAL);
        
        PantallaJuego pantallaJuego = ((ObserverJugador)mario.getObserver()).getPantallaJuego();
        if (pantallaJuego != null) {
            pantallaJuego.resetearPosicionPantalla();
        }
        
        mario.getObserver().actualizarPosicion();
    }
}
