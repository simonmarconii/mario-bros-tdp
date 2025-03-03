package Logica.Observer;

import Grafica.Pantalla.PantallaJuego;

public class ObserverJugador extends ObserverGrafico{

	private static final long serialVersionUID = -5619917727295318025L;
	
	protected PantallaJuego pantallaJuego;
	protected EntidadJugador jugadorObservado;

	public ObserverJugador(EntidadJugador jugadorObservado) {
		super(jugadorObservado);
		this.jugadorObservado = jugadorObservado;
		actualizar();
	}
	
	public PantallaJuego getPantallaJuego() {
		return pantallaJuego;
	}

	public void actualizar(){
		super.actualizar();
		if(pantallaJuego != null) {
			pantallaJuego.actualizarPantallaAJugador(jugadorObservado);
		}
	}
	
	public void setPantallaJuego(PantallaJuego pantallaJuego) {
		this.pantallaJuego = pantallaJuego;
	}
	
}
