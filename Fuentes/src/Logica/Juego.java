package Logica;

import java.util.concurrent.CopyOnWriteArrayList;

import Datos.GeneradorNivel.FabricaEntidades;
import Datos.GeneradorNivel.FabricaOriginal;
import Datos.GeneradorNivel.FabricaSprite;
import Datos.GeneradorNivel.FabricaSustituta;
import Datos.GeneradorNivel.GeneradorNivel;
import Grafica.Pantalla.ControladorPantalla;

public class Juego {

	protected Ranking ranking;
	protected ControladorPantalla controladorPantalla;
	protected FabricaSprite fabricaSprites;
	protected FabricaEntidades fabricaEntidades;
	protected Nivel nivel;
	protected GeneradorNivel generadorNivel;

	public Juego() {
		fabricaSprites = new FabricaOriginal();
		fabricaEntidades = new FabricaEntidades(fabricaSprites);
		nivel = new Nivel(fabricaEntidades);
		generadorNivel = new GeneradorNivel(nivel);
		ranking = new Ranking();
	}
	
	public Ranking getRanking(){
		return ranking;
	}
	
	public FabricaSprite getFabricaSprite() {
		return fabricaSprites;
	}
	
	public FabricaEntidades getFabricaEntidades() {
		return fabricaEntidades;
	}
	
	public Nivel getNivel() {
		return nivel;
	}
	
	public GeneradorNivel getGeneradorNivel() {
		return generadorNivel;
	}
	
	public void setPantalla(ControladorPantalla pantalla) {
		this.controladorPantalla = pantalla;
	}
	
	private void setearJuegoEnPrimerModo() {
	    fabricaSprites = new FabricaOriginal();
	    fabricaEntidades = new FabricaEntidades(fabricaSprites);
	    nivel = new Nivel(fabricaEntidades);
	    generadorNivel = new GeneradorNivel(nivel);
	    controladorPantalla.getPantallaJuego().configPantalla();
	    controladorPantalla.crearHilos();
	}
	
	private void setearJuegoEnSegundoModo() {
	    fabricaSprites = new FabricaSustituta();
	    fabricaEntidades = new FabricaEntidades(fabricaSprites);
	    nivel = new Nivel(fabricaEntidades);
	    generadorNivel = new GeneradorNivel(nivel);
	    controladorPantalla.getPantallaJuego().configPantalla();
	    controladorPantalla.crearHilos();
	}
	
	public void mostrarPuntaje() {
		controladorPantalla.mostrarPantallaPuntaje();
	}
	
	public void iniciarOriginal() {
		setearJuegoEnPrimerModo();
		controladorPantalla.crearHilos();
        generadorNivel.generarNivel(1);
        controladorPantalla.getPantallaJuego().resetearInicio();
        registrarObserver();
        controladorPantalla.mostrarPantallaOriginal();
	}

	public void iniciarSustituta(){
		 setearJuegoEnSegundoModo();
	     generadorNivel.generarNivel(1);
	     controladorPantalla.getPantallaJuego().resetearInicio();
	     registrarObserver();
	     controladorPantalla.mostrarPantallaSustituta();
	}
	
	public void terminarJuego() {
		controladorPantalla.mostrarPantallaPuntaje();
	}

	public void registrarObserver(){
		registrarObserverMario(nivel.getMario());
		registrarObserverEntidades(nivel.getEnemigos());
		registrarObserverEntidades(nivel.getPlataformas());
		registrarObserverEntidades(nivel.getPowerUps());
	}

	private void registrarObserverMario(Mario mario) {
		controladorPantalla.registrarEntidad(mario);
	}
	
	private void registrarObserverEntidades(CopyOnWriteArrayList<? extends Entidad> entidades) {
		for(Entidad entidad : entidades) {
			controladorPantalla.registrarEntidad(entidad);
		}
	}
}
