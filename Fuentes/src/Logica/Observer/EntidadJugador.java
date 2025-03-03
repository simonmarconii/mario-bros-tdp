package Logica.Observer;

import Logica.EstadosMario.EstadoMario;

public interface EntidadJugador extends EntidadLogica{
	
    public int getVidas();
    public int getPuntos();
    public int getMonedas();
    public EstadoMario getEstadoMario();
	public int getNivel();
}
