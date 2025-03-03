package Logica;

import Logica.Observer.Observer;
import Logica.Observer.Sujeto;

public class Jugador implements Sujeto{
	protected int puntos;
	protected String nombre;
	protected Ranking observer;	
	
	public Jugador(String nombre){
		this.nombre = nombre;
		this.puntos = 0;
	}
	
	public void notificarCambio() {
		for(Observer observer : observers) {
			observer.actualizar();
		}
	}
	
	public void AdjuntarObserver(Observer observer) {
		observers.add(observer);
	}
	
	public void desadjuntarObserver(Observer observer) {
		observers.remove(observer);
	}
	
}
