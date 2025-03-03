package Logica;
import Datos.GeneradorNivel.FabricaEntidades;
import Logica.Colisiones.ColisionEnemigos;
import Logica.Colisiones.ColisionPowerUp;
import Logica.Enemigos.Enemigo;
import Logica.Enemigos.Spiny;
import Logica.Plataformas.Plataforma;
import Logica.PowerUps.PowerUp;
import Logica.Strategy.Enemigo.ComportamientoLanzador;
import Grafica.Pantalla.PantallaJuego;

public class ManejadorEnemigosYPowerUp implements Runnable {
    
	protected Thread hilo;
    protected ColisionEnemigos colisionEnemigos;
    protected ColisionPowerUp colisionPowerUp;
    protected Nivel nivel;
    protected FabricaEntidades fabricaEntidades;
    protected PantallaJuego pantallaJuego;
    
    public ManejadorEnemigosYPowerUp(Nivel nivel, FabricaEntidades fabricaEntidades, PantallaJuego pantallaJuego) {
        this.nivel = nivel;
        this.colisionEnemigos = new ColisionEnemigos();
        this.colisionPowerUp = new ColisionPowerUp();
        this.fabricaEntidades = fabricaEntidades;
        this.pantallaJuego = pantallaJuego;
    }
    
    public void run() {
    	long ultimoTiempo = System.nanoTime();
        double cantidadTicks = 30.0;
        double frecuenciaActualizacion = 1000000000 / cantidadTicks;
        double delta = 0;

        while(hilo!=null) {
        	long tiempoActual = System.nanoTime();
            delta += (tiempoActual - ultimoTiempo) / frecuenciaActualizacion;
            ultimoTiempo = tiempoActual;

            while(delta>=1) {
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
    }
    
    private void actualizar() {
    	actualizarEnemigos();
    	actualizarPowerUps();
    	verificarColisionesEnemigos();
    	verificarColisionesPowerUps();
    }
    
    public void verificarColisionesEnemigos() {
        ColisionEnemigos colisionEnemigos = new ColisionEnemigos();
     
        for(Enemigo enemigo : nivel.getEnemigos()) {
            for(Plataforma plataforma : nivel.getPlataformas()) {
                colisionEnemigos.verificarColision(enemigo, plataforma);
            }
        }
    }
    
    public void verificarColisionesPowerUps() {
    	ColisionPowerUp colisionPowerUp = new ColisionPowerUp();
        
        for(PowerUp powerUp : nivel.getPowerUps()) {
            for(Plataforma plataforma : nivel.getPlataformas()) {
                colisionPowerUp.verificarColision(powerUp, plataforma);
            }
        }
    }
    
    private void actualizarEnemigos() {
        for (Enemigo enemigo : nivel.getEnemigos()) {
            enemigo.moverse();
            enemigo.bajar();
            ComportamientoLanzador comportamiento = enemigo.getComportamientoLanzador();
            if (comportamiento.debeLanzar()) {
                int[] pos = comportamiento.getPosicionLanzamiento();
                Spiny spiny = fabricaEntidades.getSpiny(pos[0], pos[1]);
                nivel.agregarEnemigo(spiny);
                pantallaJuego.agregarEntidad(spiny);
            }
            
            if (enemigo.getObserver() != null) {
                enemigo.getObserver().actualizar();
            }
        }
    }
    
    private void actualizarPowerUps() {
    	for(PowerUp powerUp : nivel.getPowerUps()) {
    		powerUp.moverse();
    		if(powerUp.getObserver() != null) {
    			powerUp.getObserver().actualizar();
    		}
    	}
    }
}