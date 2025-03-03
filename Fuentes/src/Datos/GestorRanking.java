package Datos;
import java.io.*;
import java.util.*;

public class GestorRanking {
    private static final String ARCHIVO_RANKING = "Ranking.txt";
    private static GestorRanking instance;

    private GestorRanking() {
    }

    public static GestorRanking getInstance() {
        if (instance == null) {
            instance = new GestorRanking();
        }
        return instance;
    }

    public static void guardarPuntaje(String nombre, int puntaje) {
        DatosJugador nuevoJugador = new DatosJugador();
        nuevoJugador.setNombreJugador(nombre);
        nuevoJugador.setPuntos(puntaje);
        List<DatosJugador> jugadores = leerRanking();
        jugadores.add(nuevoJugador);

        Collections.sort(jugadores, (j1, j2) -> Integer.compare(j2.getPuntos(), j1.getPuntos()));

        if (jugadores.size() > 5) {
            jugadores = jugadores.subList(0, 5);
        }

        try (PrintWriter pw = new PrintWriter(new FileWriter(ARCHIVO_RANKING))) {
            for (DatosJugador jugador : jugadores) {
                pw.println(jugador.getNombreJugador() + "," + jugador.getPuntos());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static List<DatosJugador> leerRanking() {
        List<DatosJugador> jugadores = new ArrayList<>();
        File archivo = new File(ARCHIVO_RANKING);

        if (!archivo.exists()) {
            try {
                archivo.createNewFile();
                return jugadores;
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        try (BufferedReader br = new BufferedReader(new FileReader(ARCHIVO_RANKING))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                if (datos.length == 2) {
                    DatosJugador jugador = new DatosJugador();
                    jugador.setNombreJugador(datos[0].trim());
                    try {
                        jugador.setPuntos(Integer.parseInt(datos[1].trim()));
                        jugadores.add(jugador);
                    } catch (NumberFormatException e) {
                        System.err.println("Error al parsear puntaje: " + datos[1]);
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

        Collections.sort(jugadores, (j1, j2) -> Integer.compare(j2.getPuntos(), j1.getPuntos()));
        return jugadores;
    }
}
