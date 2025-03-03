package Grafica.Pantalla;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import Datos.DatosJugador;
import Grafica.Sonido;

import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.Timer;
import javax.swing.JPanel;

import Logica.Mario;
import Logica.Parseo;
import Logica.Observer.EntidadJugador;
import Logica.Observer.EntidadLogica;
import Logica.Observer.ObserverEntidades;
import Logica.Observer.ObserverJugador;

public class PantallaJuego extends JPanel {

	private static final long serialVersionUID = 1L;
	protected ControladorPantalla controladorPantalla;
	protected Parseo parseo;
	protected int desplazamientoX;
	protected int mitad = 640;
	protected int siguienteNivel = 2;
	protected int siguienteNivelInicio = 1;
	protected int tiempoRestante = 150;
	protected Timer timerJuego;
	
	JPanel panelPuntaje;
	JLabel imgFondo;
	JLabel labelVidas;
	JLabel labelPuntos;
	JLabel labelMonedas;
	JLabel labelNivel;
	JLabel iconoMonedas;
	JLabel iconoVidas;
    JLabel labelTiempo;
	
	public PantallaJuego(ControladorPantalla controladorPantalla){
		this.controladorPantalla = controladorPantalla;
		imgFondo = new JLabel();
		labelVidas = new JLabel();
		labelPuntos = new JLabel();
		configPantalla();
	}

	public int getMitad() {
		return mitad;
	}
	
	public void configPantalla(){
		setPreferredSize(new Dimension(ConstantesPantalla.VENTANA_ANCHO, ConstantesPantalla.VENTANA_ALTO));
		setLayout(null);
		setDoubleBuffered(true);
		agregarImagenFondo();
		agregarPanelPuntaje();
	}
	
	private void agregarImagenFondo() {
		ImageIcon fondoIcono = new ImageIcon(controladorPantalla.getJuego().
		getFabricaSprite().getSpriteNivel(1).getRutaDeImagen("imagen"));
		imgFondo.setIcon(fondoIcono);
		imgFondo.setBounds(0,0,ConstantesPantalla.PANEL_ANCHO,ConstantesPantalla.PANEL_ALTO);
		add(imgFondo);
		setComponentZOrder(imgFondo, getComponentCount() - 1);
	}
	
	public void agregarPanelPuntaje() {
	    inicializarPanelPuntaje();
	    configurarEtiquetas();
	    configurarIconos();
	    posicionarComponentes();
	    agregarComponentesAlPanel();
	}

	private void inicializarPanelPuntaje() {
	    panelPuntaje = new JPanel();
	    panelPuntaje.setLayout(null);
	    panelPuntaje.setBounds(desplazamientoX, 0, ConstantesPantalla.VENTANA_ANCHO, 80);
	    panelPuntaje.setOpaque(false);
	}

	private void configurarEtiquetas() {
	    Font pixelFont = new Font("Courier", Font.BOLD, 24);
	    Color textColor = new Color(255, 255, 255);

	    labelVidas = new JLabel("x3");
	    labelPuntos = new JLabel("Puntos: 0");
	    labelMonedas = new JLabel("x0");
	    labelNivel = new JLabel("Nivel");

	    labelVidas.setFont(pixelFont);
	    labelPuntos.setFont(pixelFont);
	    labelMonedas.setFont(pixelFont);
	    labelNivel.setFont(pixelFont);

	    labelVidas.setForeground(textColor);
	    labelPuntos.setForeground(textColor);
	    labelMonedas.setForeground(textColor);
	    labelNivel.setForeground(textColor);
	    
	    labelTiempo = new JLabel("Tiempo: " + tiempoRestante);
	    labelTiempo.setFont(pixelFont);
	    labelTiempo.setForeground(textColor);
	}

	private void configurarIconos() {
	    ImageIcon coinIcon = new ImageIcon(controladorPantalla.getJuego()
	        .getFabricaSprite().getSpriteMoneda().getRutaDeImagen("default"));
	    ImageIcon lifeIcon = new ImageIcon(controladorPantalla.getJuego()
	        .getFabricaSprite().getSpriteMario().getRutaDeImagen("quieto"));
	    iconoVidas = new JLabel(lifeIcon);
	    iconoMonedas = new JLabel(coinIcon);
	}

	private void posicionarComponentes() {
	    int startX = (ConstantesPantalla.VENTANA_ANCHO - 800) / 2;
	    
	    labelPuntos.setBounds(startX + 20, 25, 200, 30);
	    iconoMonedas.setBounds(startX + 240, 25, 30, 30);
	    labelMonedas.setBounds(startX + 280, 25, 100, 30);
	    iconoVidas.setBounds(startX + 400, 25, 30, 30);
	    labelVidas.setBounds(startX + 440, 25, 100, 30);
	    labelNivel.setBounds(startX + 560, 25, 200, 30);
	    labelTiempo.setBounds(startX + 700, 25, 200, 30);
	}

	private void agregarComponentesAlPanel() {
	    panelPuntaje.add(labelPuntos);
	    panelPuntaje.add(iconoMonedas);
	    panelPuntaje.add(labelMonedas);
	    panelPuntaje.add(iconoVidas);
	    panelPuntaje.add(labelVidas);
	    panelPuntaje.add(labelNivel);
	    panelPuntaje.add(labelTiempo);
	    imgFondo.add(panelPuntaje);
	}

	
	public void agregarEntidadMario(Mario jugador){
		ObserverJugador observerJugador = (ObserverJugador) jugador.getObserver();
		observerJugador.setPantallaJuego(this);
		imgFondo.add(observerJugador);
		actualizarInfoJugador(jugador);
	}
	
	public void agregarEntidad(EntidadLogica entidad) {
		ObserverEntidades observerEntidad = (ObserverEntidades) entidad.getObserver();
		imgFondo.add(observerEntidad, entidad.getPosicionEnCapa());
	}

	public void actualizarInfoJugador(EntidadJugador jugador){
		actualizarLabel(jugador);
		actualizarPantallaAJugador(jugador);
	}

	public void actualizarLabel(EntidadJugador jugador) {
	    int puntos = jugador.getPuntos();
	    int monedas = jugador.getMonedas();
	    int vidas = jugador.getVidas();
	    int nivel = jugador.getNivel(); 
	    
	    labelPuntos.setText(String.format("Puntos: %06d", puntos));
	    labelMonedas.setText(String.format("x%d", monedas));
	    labelVidas.setText(String.format("x%d", vidas));
	    labelNivel.setText(String.format("Nivel: %d", nivel));
	    
	    int centroX = mitad - (ConstantesPantalla.VENTANA_ANCHO / 2);
	    panelPuntaje.setBounds(centroX, 0, ConstantesPantalla.VENTANA_ANCHO, 80);
	}

	public void actualizarPantallaAJugador(EntidadJugador jugador){
		if (jugador.getX() > mitad) {
            desplazamientoX -= 2;
            imgFondo.setLocation(desplazamientoX, imgFondo.getY());
            mitad = mitad + 2;
		}
	}
	
	public ControladorPantalla getControladorPantalla() {
		return controladorPantalla;
	}
	
	public void resetear() {
	    if(siguienteNivel == 4) {
	        DatosJugador.getInstance().setNombreJugador("");
	        controladorPantalla.mostrarPantallaNombre();
	        siguienteNivel = 1;
	    }
	    imgFondo.removeAll();
	    resetearPosicionPantalla();
	    controladorPantalla.getJuego().getGeneradorNivel().generarNivel(siguienteNivel);
	    controladorPantalla.getJuego().registrarObserver();
	    siguienteNivel++;
	    agregarPanelPuntaje();
	    actualizarLabel(Mario.getInstance());
	    resetearTemporizador();
	}
	
	public void resetearInicio() {
		imgFondo.removeAll();
		resetearPosicionPantalla();
		Mario.getInstance().resetarMario();
		controladorPantalla.getJuego().getGeneradorNivel().generarNivel(siguienteNivelInicio);
		controladorPantalla.getJuego().registrarObserver();
		agregarPanelPuntaje();
		actualizarLabel(Mario.getInstance());
		Sonido.getInstance().reproducirMusica("tema_principal");
		resetearTemporizador(); 
	}
	
	public void resetearPosicionPantalla() {
        desplazamientoX = 0;
        mitad = 640;
        imgFondo.setLocation(desplazamientoX, imgFondo.getY());
        panelPuntaje.setBounds(mitad-640, 0, ConstantesPantalla.VENTANA_ANCHO, 60);
    }
	
	public void iniciarTemporizador() {
	    tiempoRestante = 150;
	    if (timerJuego != null) {
	        timerJuego.stop();
	    }
	    
	    timerJuego = new Timer(1000, new ActionListener() {
	        public void actionPerformed(ActionEvent e) {
	            if (tiempoRestante > 0) {
	                tiempoRestante--;
	                actualizarTiempo();
	            } else {
	                tiempoAgotado();
	            }
	        }
	    });
	    timerJuego.start();
	}

	private void actualizarTiempo() {
	    labelTiempo.setText("Tiempo: " + tiempoRestante);
	}

	private void tiempoAgotado() {
	    if (timerJuego != null) {
	        timerJuego.stop();
	    }
	    Mario.getInstance().setVidas(0);
	    controladorPantalla.mostrarPantallaPuntaje();
	    controladorPantalla.getPantallaJuego().resetearInicio();
	    Mario.getInstance().resetarMario();
	    Sonido.getInstance().detener("tema_principal");
	    Sonido.getInstance().reproducir("game_over");
	}

	public void detenerTemporizador() {
	    if (timerJuego != null) {
	        timerJuego.stop();
	    }
	}

	public void resetearTemporizador() {
	    tiempoRestante = 150;
	    if (timerJuego != null) {
	        timerJuego.restart();
	    } else {
	        iniciarTemporizador();
	    }
	}
}