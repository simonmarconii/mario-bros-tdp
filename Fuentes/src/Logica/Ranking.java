package Logica;

import javax.swing.DefaultListModel;

import Datos.DatosJugador;
import Datos.GestorRanking;
import Logica.Observer.RankingObserver;

import java.util.List;


public class Ranking implements RankingObserver {
	
    protected DefaultListModel<DatosJugador> modeloLista;
    protected GestorRanking gestorRanking;

    public Ranking() {
        modeloLista = new DefaultListModel<>();
        this.gestorRanking = GestorRanking.getInstance();
        actualizarListaJugadores();
    }

    public DefaultListModel<DatosJugador> getModeloLista() {
        return modeloLista;
    }

    public void actualizarListaJugadores() {
        modeloLista.clear();
        List<DatosJugador> jugadores = GestorRanking.leerRanking();
        for (DatosJugador jugador : jugadores) {
            modeloLista.addElement(jugador);
        }
    }

    public void NombreIngresado(String nombre, int puntaje) {
        GestorRanking.guardarPuntaje(nombre, puntaje);
        actualizarListaJugadores();
    }
}