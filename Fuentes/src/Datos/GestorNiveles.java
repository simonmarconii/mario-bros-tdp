package Datos;
import java.io.*;
import java.util.*;

public class GestorNiveles {
    public static ArrayList<String> cargarNivel(String archivo) {
        ArrayList<String> contenido = new ArrayList<>();
        try (BufferedReader br = new BufferedReader(new FileReader(archivo))) {
            String linea;
            while ((linea = br.readLine()) != null) {
                contenido.add(linea);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return contenido;
    }
}
