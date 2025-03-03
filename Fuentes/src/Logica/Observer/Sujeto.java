package Logica.Observer;

import java.util.LinkedList;

public interface Sujeto {
	
	public LinkedList<Observer> observers = new LinkedList<>();
	public void notificarCambio();	
	public void AdjuntarObserver(Observer o) ;
	public void desadjuntarObserver(Observer o);
}
