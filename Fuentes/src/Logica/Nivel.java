package Logica;
import java.util.concurrent.CopyOnWriteArrayList;

import Datos.GeneradorNivel.FabricaEntidades;
import Logica.Enemigos.Enemigo;
import Logica.Enemigos.Spiny;
import Logica.Plataformas.Plataforma;
import Logica.PowerUps.PowerUp;

public class Nivel {
	
	protected Parseo parser;
	protected Mario mario;
    protected CopyOnWriteArrayList<Enemigo> enemigos;
    protected CopyOnWriteArrayList<Plataforma> plataformas;
    protected CopyOnWriteArrayList<PowerUp> powerUps;
    protected FabricaEntidades fabricaEntidades;

    public Nivel(FabricaEntidades fabricaEntidades) {
        enemigos = new CopyOnWriteArrayList<>();
        plataformas = new CopyOnWriteArrayList<>();
        powerUps = new CopyOnWriteArrayList<>();
        parser = new Parseo(fabricaEntidades, this);
        mario = Mario.getInstance();
        this.fabricaEntidades = fabricaEntidades;
    }
    
    public FabricaEntidades getFabricaEntidades() {
    	return fabricaEntidades;
    }
    
    public Mario getMario() {
		return mario;
	}

	public void setMario(Mario mario) {
		this.mario = mario;
	}

	public CopyOnWriteArrayList<Enemigo> getEnemigos() {
		return enemigos;
	}

	public void setEnemigos(Enemigo enemigo) {
		this.enemigos.add(enemigo);
	}

	public CopyOnWriteArrayList<Plataforma> getPlataformas() {
		return plataformas;
	}

	public void setPlataformas(Plataforma plataforma) {
		this.plataformas.add(plataforma);
	}

	public CopyOnWriteArrayList<PowerUp> getPowerUps() {
		return powerUps;
	}

	public void setPowerUps(PowerUp powerUp) {
		this.powerUps.add(powerUp);
	}
	
	public void resetear() {
    	enemigos = new CopyOnWriteArrayList<>();
        plataformas = new CopyOnWriteArrayList<>();
        powerUps = new CopyOnWriteArrayList<>();
    }

	public void agregarEnemigo(Spiny spiny) {
		enemigos.add(spiny);
	}
}

