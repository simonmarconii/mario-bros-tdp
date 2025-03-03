package Datos;

public class DatosJugador {
    private static DatosJugador instance;
    private String nombreJugador = "";
    private int puntos;
 
    DatosJugador() {
    }
 
    public static DatosJugador getInstance() {
       if (instance == null) {
          instance = new DatosJugador();
       }
 
       return instance;
    }
 
    public void setNombreJugador(String nombre) {
       this.nombreJugador = nombre != null ? nombre.trim() : "";
    }
 
    public String getNombreJugador() {
       return this.nombreJugador;
    }
 
    public void setPuntos(int puntos) {
       this.puntos = puntos;
    }
 
    public int getPuntos() {
       return this.puntos;
    }
 }