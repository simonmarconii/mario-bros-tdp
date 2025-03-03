package Grafica.Pantalla;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import Datos.DatosJugador;
import Logica.Mario;
import Logica.Observer.RankingObserver;

public class PantallaNombre extends JPanel {

	private static final long serialVersionUID = 1L;
	protected ControladorPantalla controladorPantalla;
	protected RankingObserver rankingObserver;

	JButton botonRanking;
	JLabel mensaje;
	JTextField campoNombre;

	public PantallaNombre(ControladorPantalla controladorPantalla) {
			this.controladorPantalla = controladorPantalla;
			configPantalla();
			configMensaje();
			configTextField();
			agregarBotonRanking();
	}
	
	public String getNombre() {
		return campoNombre.getText();
	}
	
	public void setRankingObserver(RankingObserver observer) {
        this.rankingObserver = observer;
    }

	public void configPantalla() {
		setPreferredSize(new Dimension(ConstantesPantalla.VENTANA_ANCHO, ConstantesPantalla.VENTANA_ALTO));
		setLayout(null);
		setBackground(Color.BLACK);
		setDoubleBuffered(true);
	}

	public void configMensaje() {
		mensaje = new JLabel("Ingrese su Tag:");
		mensaje.setFont(new Font("Arial", Font.BOLD, 16));
		mensaje.setHorizontalAlignment(SwingConstants.CENTER);
		mensaje.setForeground(Color.WHITE);

		mensaje.setBounds(520, 100, 200, 30);
		add(mensaje);
}

	public void configTextField() {
		campoNombre = new JTextField(40);
		campoNombre.setBounds(520, 150, 200, 30);
		add(campoNombre);
	}

	public void agregarBotonRanking() {
		botonRanking = new JButton();
		decoBotonRanking();
		registrarOyenteBotonRanking();
		add(botonRanking);
	}

	public void registrarOyenteBotonRanking() {
        botonRanking.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String nombre = campoNombre.getText().trim();
                if (!nombre.isEmpty()) {
                    if (rankingObserver != null) {
                        rankingObserver.NombreIngresado(nombre, Mario.getInstance().getPuntos());
                    }
                    DatosJugador.getInstance().setNombreJugador(nombre);
                    controladorPantalla.accionarMostrarPuntaje();
                } else {
                    JOptionPane.showMessageDialog(PantallaNombre.this,
                        "Por favor ingresa un nombre",
                        "Nombre requerido",
                        JOptionPane.WARNING_MESSAGE);
                }
            }
        });
    }


	public void decoBotonRanking() {
		botonRanking.setBounds(520, 200, 200, 40);
		ImageIcon icono = new ImageIcon(controladorPantalla.getJuego()
				.getFabricaSprite().getSpriteInicio().getRutaDeImagen("botonRanking"));
		botonRanking.setIcon(icono);
		botonRanking.setBorder(null);
	}
}