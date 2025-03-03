package Logica.Enemigos.EstadoKoopa;

import Logica.Mario;
import Logica.Enemigos.KoopaTroopa;

public abstract class EstadoKoopaTroopa {
	
	protected KoopaTroopa koopaTroopa;
	
	public EstadoKoopaTroopa(KoopaTroopa koopaTroopa) {
		this.koopaTroopa = koopaTroopa;
	}
	
	public abstract void moverse();
	
	public abstract void esAfectado(Mario mario);
}
