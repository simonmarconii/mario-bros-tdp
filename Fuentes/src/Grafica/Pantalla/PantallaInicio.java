package Grafica.Pantalla;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class PantallaInicio extends JPanel{
	
	private static final long serialVersionUID = 1L;
	protected ControladorPantalla controladorPantalla;
	
	JLabel imgFondo;
	JButton btnInicioOriginal;
	JButton btnInicioSustituto;
	JButton botonRanking;
	
	public PantallaInicio(ControladorPantalla controladorPantalla){
		this.controladorPantalla = controladorPantalla;
		configPantalla();
		agregarImgFondo();
		agregarBotonInicioOriginal();
		agregarBotonInicioSustituta();
		agregarBotonRanking();
	}

	public void configPantalla(){
		setPreferredSize(new Dimension(ConstantesPantalla.VENTANA_ANCHO, ConstantesPantalla.VENTANA_ALTO));
		setLayout(null);
		setBackground(Color.BLACK);
		setDoubleBuffered(true);
	}

	public void agregarImgFondo(){
		imgFondo = new JLabel();
		ImageIcon icono = new ImageIcon(controladorPantalla.getJuego().getFabricaSprite()
				.getSpriteInicio().getRutaDeImagen("imagen"));
		imgFondo.setIcon(icono);
		imgFondo.setBounds(120,-70,ConstantesPantalla.VENTANA_ANCHO,ConstantesPantalla.VENTANA_ALTO);
		add(imgFondo);
		setComponentZOrder(imgFondo, getComponentCount() - 1);
	}

	public void agregarBotonInicioOriginal(){
		btnInicioOriginal = new JButton();
		decoBotonIniciarOriginal();
		registrarOyenteBotonIniciarOriginal();
		imgFondo.add(btnInicioOriginal);
	}

	public void agregarBotonInicioSustituta(){
		btnInicioSustituto = new JButton();
		decoBotonIniciarSustituta();
		registrarOyenteBotonIniciarSustituta();
		imgFondo.add(btnInicioSustituto);
	}

	public void agregarBotonRanking(){
		botonRanking = new JButton();
		decoBotonRanking();
		registrarOyenteBotonRanking();
		imgFondo.add(botonRanking);
	}

	public void registrarOyenteBotonIniciarOriginal(){
		btnInicioOriginal.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				controladorPantalla.accionarIniciarOriginal();
			}
		});
	}

	public void registrarOyenteBotonIniciarSustituta(){
		btnInicioSustituto.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				controladorPantalla.accionarIniciarSustituta();
			}
		});
	}

	public void registrarOyenteBotonRanking(){
		botonRanking.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e){
				controladorPantalla.accionarMostrarPuntaje();
			}
		});
	}

	public void decoBotonIniciarOriginal(){
		btnInicioOriginal.setBounds(412, 580, 200, 40);
		ImageIcon icono = new ImageIcon(controladorPantalla.getJuego()
				.getFabricaSprite().getSpriteInicio().getRutaDeImagen("botonOriginal"));
		btnInicioOriginal.setIcon(icono);
		btnInicioOriginal.setBorder(null);
	}

	public void decoBotonIniciarSustituta(){
		btnInicioSustituto.setBounds(412, 630, 200, 40);
		ImageIcon icono = new ImageIcon(controladorPantalla.getJuego()
				.getFabricaSprite().getSpriteInicio().getRutaDeImagen("botonSustituto"));
		btnInicioSustituto.setIcon(icono);
		btnInicioSustituto.setBorder(null);
	}

	public void decoBotonRanking(){
		botonRanking.setBounds(412, 680, 200, 40);
		ImageIcon icono = new ImageIcon(controladorPantalla.getJuego()
				.getFabricaSprite().getSpriteInicio().getRutaDeImagen("botonRanking"));
		botonRanking.setIcon(icono);
		botonRanking.setBorder(null);
	}
}
