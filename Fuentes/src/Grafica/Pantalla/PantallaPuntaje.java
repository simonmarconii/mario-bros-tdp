package Grafica.Pantalla;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.DefaultListCellRenderer;
import java.awt.Component;
import Datos.DatosJugador;
import Logica.Ranking;

public class PantallaPuntaje extends JPanel {

    private static final long serialVersionUID = 1L;
    protected ControladorPantalla controladorPantalla;
    protected Ranking ranking;
    protected JList<DatosJugador> listaRanking;
    
    JLabel imgFondo;
    JButton botonVolverInicio;
    JScrollPane scrollPane;

    public PantallaPuntaje(ControladorPantalla controladorPantalla, Ranking ranking) {
        this.controladorPantalla = controladorPantalla;
        this.ranking = ranking;
        configPantalla();
        agregarImgFondo();
        agregarBotonInicio();
        configLista();
    }

    private void configLista() {
        listaRanking = new JList<>(ranking.getModeloLista());


        listaRanking.setFont(new Font("Arial", Font.BOLD, 18));
        listaRanking.setFixedCellHeight(40);
        listaRanking.setOpaque(false);

        listaRanking.setFont(new Font("Arial", Font.BOLD, 18));
        listaRanking.setFixedCellHeight(40);
        listaRanking.setOpaque(false);

        listaRanking.setCellRenderer(new DefaultListCellRenderer() {
            public Component getListCellRendererComponent(JList<?> list, Object value, 
                    int index, boolean isSelected, boolean cellHasFocus) {
                super.getListCellRendererComponent(list, value, index, isSelected, cellHasFocus);
                
                DatosJugador jugador = (DatosJugador) value;
                setText((index + 1) + ". " + jugador.getNombreJugador() + " - " + 
                       jugador.getPuntos() + " puntos");
                
                setForeground(Color.WHITE);
                setFont(new Font("Arial", Font.BOLD, 20));
                
                setOpaque(false);
                
                setForeground(Color.WHITE);
                setFont(new Font("Arial", Font.BOLD, 20));
                
                setOpaque(false);
                
                return this;
            }
        });

        scrollPane = new JScrollPane(listaRanking);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);
        
        scrollPane.setBounds(505, 200, 500, 300);

        scrollPane = new JScrollPane(listaRanking);
        scrollPane.setOpaque(false);
        scrollPane.getViewport().setOpaque(false);
        scrollPane.setBorder(null);

        scrollPane.setBounds(505, 200, 500, 300);
        
        add(scrollPane);
        setComponentZOrder(scrollPane, 0);
        setComponentZOrder(scrollPane, 0);
    }


    public void configPantalla() {
        setPreferredSize(new Dimension(ConstantesPantalla.VENTANA_ANCHO, ConstantesPantalla.VENTANA_ALTO));
        setLayout(null);
        setBackground(Color.BLACK);
        setDoubleBuffered(true);
    }

    public void agregarImgFondo() {
        imgFondo = new JLabel();
        ImageIcon fondoIcono = new ImageIcon(controladorPantalla.getJuego().
        getFabricaSprite().getSpriteRanking().getRutaDeImagen("imagen"));
        imgFondo.setIcon(fondoIcono);
        imgFondo.setBounds(140, 0, ConstantesPantalla.PANEL_ANCHO, 600);
        add(imgFondo);
        setComponentZOrder(imgFondo, getComponentCount() - 1);
    }

    private void agregarBotonInicio() {
        botonVolverInicio = new JButton("Volver");
        decoBotonInicio();
        registrarOyenteBotonInicio();
        add(botonVolverInicio);
        setComponentZOrder(botonVolverInicio, 1);
    }

    private void registrarOyenteBotonInicio() {
        botonVolverInicio.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                controladorPantalla.mostrarPantallaInicio();
            }
        });
    }

    private void decoBotonInicio() {
        botonVolverInicio.setBounds(545, 600, 150, 50);
        
        botonVolverInicio.setFont(new Font("Arial", Font.BOLD, 18));
        botonVolverInicio.setForeground(Color.WHITE);
        botonVolverInicio.setBackground(new Color(255, 0, 0, 200));
        botonVolverInicio.setBorder(null);
        botonVolverInicio.setFocusPainted(false);
    }

}