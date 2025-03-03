package Grafica.Pantalla;

import javax.swing.ImageIcon;
import javax.swing.JFrame;

import Logica.Juego;
import Logica.ManejadorEnemigosYPowerUp;
import Logica.ManejadorMario;
import Logica.Mario;
import Logica.Ranking;
import Logica.Observer.EntidadLogica;

public class ControladorPantalla extends JFrame{
	
	private static final long serialVersionUID = 1L;
	protected PantallaJuego pantallaJuego;
	protected PantallaInicio pantallaInicio;
	protected PantallaPuntaje pantallaPuntaje;
	protected PantallaNombre pantallaNombre;
	protected Ranking ranking;
	protected Juego juego;
	protected ManejadorEnemigosYPowerUp manejadorEnemigos;
	protected ManejadorMario manejadorMario;

	public ControladorPantalla(Juego juego){
		this.juego = juego;
		pantallaJuego = new PantallaJuego(this);
		pantallaInicio = new PantallaInicio(this);
		pantallaPuntaje = new PantallaPuntaje(this,juego.getRanking());
		pantallaNombre = new PantallaNombre(this);
		pantallaNombre.setRankingObserver(juego.getRanking());
		agregarIconoVentana();
		configPantalla();
	}
	
	public Juego getJuego(){
		return juego;
	}
	
	public PantallaJuego getPantallaJuego() {
		return pantallaJuego;
	}
	
	public PantallaNombre getPantallaNombre() {
		return pantallaNombre;
	}
	
	public void agregarIconoVentana() {
		ImageIcon icono = new ImageIcon("Imagenes/Sprites/Originales/IconoJuego.png");
		setIconImage(icono.getImage());
	}

	public void configPantalla(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setResizable(false);
		setTitle("Super Mario : Tdp");
		setSize(ConstantesPantalla.VENTANA_ANCHO, ConstantesPantalla.VENTANA_ALTO);
		setLocationRelativeTo(null);
		setVisible(true);
	}
	
	public void accionarIniciarOriginal(){
		juego.iniciarOriginal();
	}

	public void accionarIniciarSustituta(){
		juego.iniciarSustituta();
	}

	public void accionarMostrarPuntaje(){
		juego.mostrarPuntaje();
	}

	public void mostrarPantallaInicio(){
		setContentPane(pantallaInicio);
		actualizar();
	}

	public void mostrarPantallaOriginal(){
		setContentPane(pantallaJuego);
		manejadorMario.iniciarHilo();
		manejadorEnemigos.iniciarHilo();
		actualizar();
	}

	public void mostrarPantallaSustituta(){
		setContentPane(pantallaJuego);
		manejadorMario.iniciarHilo();
		manejadorEnemigos.iniciarHilo();
		actualizar();
	}

	public void mostrarPantallaPuntaje(){
		setContentPane(pantallaPuntaje);
		if(manejadorMario != null && manejadorEnemigos != null) {
			manejadorMario.detener();
			manejadorEnemigos.detener();
		}
		actualizar();
	}
	
	public void mostrarPantallaNombre() {
		setContentPane(pantallaNombre);
		manejadorMario.detener();
		manejadorEnemigos.detener();
		actualizar();
	}

	public void registrarEntidad(Mario mario){
		pantallaJuego.agregarEntidadMario(mario);
		actualizar();
	}
	
	public void registrarEntidad(EntidadLogica entidadLogica) {
		pantallaJuego.agregarEntidad(entidadLogica);
		actualizar();
	}

	public void actualizar(){
		revalidate();
		repaint();
	}
	
	public void crearHilos() {
        manejadorEnemigos = new ManejadorEnemigosYPowerUp(juego.getNivel(), juego.getFabricaEntidades(), pantallaJuego);
        manejadorMario = new ManejadorMario(juego.getNivel(), pantallaJuego, juego.getFabricaEntidades());
    }
}
