package Grafica;

import Grafica.Pantalla.ControladorPantalla;
import Logica.Juego;

public class Launcher {
	protected Juego juego;
	protected ControladorPantalla pantalla;
	protected Sonido sonido;
	
    public static void main(String[] args) {
        Juego juego = new Juego();
        ControladorPantalla pantalla = new ControladorPantalla(juego);
        juego.setPantalla(pantalla);
        pantalla.mostrarPantallaInicio();
    }
}