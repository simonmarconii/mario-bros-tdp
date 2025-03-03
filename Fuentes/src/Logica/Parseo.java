package Logica;

import java.io.BufferedReader;
import java.io.InputStream;
import java.io.InputStreamReader;

import Datos.GeneradorNivel.FabricaEntidades;
import Grafica.Pantalla.ConstantesPantalla;
import Logica.Enemigos.Enemigo;
import Logica.Plataformas.Plataforma;
import Logica.PowerUps.PowerUp;

public class Parseo {
	
	protected int mapaDeDatos [][];
	protected FabricaEntidades fabricaEntidades;
	protected Nivel nivel;
	protected Entidad entidades[];
	
	public Parseo(FabricaEntidades fabricaEntidades, Nivel nivel) {
		this.fabricaEntidades = fabricaEntidades;
		this.nivel = nivel;
		mapaDeDatos = new int[ConstantesPantalla.MAX_COLUMNA_PANTALLA][ConstantesPantalla.MAX_FILA_PANTALLA];
		entidades = new Entidad[100];
	}
	
	public void getArchivo(String nivel) {
		try {
            InputStream is = getClass().getResourceAsStream(nivel);
            BufferedReader lector = new BufferedReader(new InputStreamReader(is));

            int col = 0;
            int fila = 0;
            int x = 0;
            int y = 0;

            while(col < ConstantesPantalla.MAX_COLUMNA_PANTALLA && fila < ConstantesPantalla.MAX_FILA_PANTALLA) {
                String linea = lector.readLine();

                while(col < ConstantesPantalla.MAX_COLUMNA_PANTALLA) {
                    String numeros[] = linea.split(" ");
                    int numero = Integer.parseInt(numeros[col]);
                    mapaDeDatos[col][fila] = numero;
                    generarEntidad(numero,x,y);
                    x += 32;
                    col++;
                }

                if (col == ConstantesPantalla.MAX_COLUMNA_PANTALLA) {
                    col = 0;
                    x = 0;
                    y += 32;
                    fila++;
                }
            }
				lector.close();
        } catch(Exception e) {
        }
	}
	
	
	public Nivel generarEntidad(int identificadorEntidad, int x, int y){
		
        Entidad entidad = null;

        switch (identificadorEntidad) {
        	case 1 -> {	
        		entidad = fabricaEntidades.getGoomba(x, y);
        		nivel.setEnemigos((Enemigo) entidad);
            }
        	case 2 -> {	
        		entidad = fabricaEntidades.getKoopaTroopa(x, y);
            	nivel.setEnemigos((Enemigo) entidad);
            }
            case 3 -> {	
            	entidad = fabricaEntidades.getLakitu(x, y, nivel.getEnemigos());
            	nivel.setEnemigos((Enemigo) entidad);
            }
            case 4 -> {	
            	entidad = fabricaEntidades.getPiranhaPlant(x + 6, y);
            	nivel.setEnemigos((Enemigo) entidad);
            }
            case 5 -> { 
            	entidad = fabricaEntidades.getSpiny(x, y);
            	nivel.setEnemigos((Enemigo) entidad);
            }
            case 6 -> {	
            	entidad = fabricaEntidades.getBuzzyBeetle(x, y);
            	nivel.setEnemigos((Enemigo) entidad);
            }
            case 7 -> {	
            	entidad = fabricaEntidades.getBloqueSolido(x, y);
            	nivel.setPlataformas((Plataforma) entidad);
            }
            case 8 -> {	
            	entidad = fabricaEntidades.getLadrilloSolido(x, y);
            	nivel.setPlataformas((Plataforma) entidad); 
            }
            case 9 -> {	
            	entidad = fabricaEntidades.getTuberia(x, y);
            	nivel.setPlataformas((Plataforma) entidad);
            }
            case 10 ->{	
            	entidad = fabricaEntidades.getBloqueDePreguntaMoneda(x, y);
            	nivel.setPlataformas((Plataforma) entidad);
            }
            case 11 ->{
            	entidad = fabricaEntidades.getBanderaFinNivel(x, y);
            	nivel.setPlataformas((Plataforma) entidad);
            }
            case 12 ->{
            	entidad = fabricaEntidades.getChampinonVerde(x, y);
            	nivel.setPowerUps((PowerUp) entidad);
            }
            case 13 ->{ 
            	entidad = fabricaEntidades.getEstrella(x, y);
            	nivel.setPowerUps((PowerUp) entidad);
            }
            case 14 ->{ 
            	entidad = fabricaEntidades.getFlorDeFuego(x, y);
            	nivel.setPowerUps((PowerUp) entidad);
            }
            case 15 ->{
            	entidad = fabricaEntidades.getMoneda(x, y);
            	nivel.setPowerUps((PowerUp) entidad);
            }
            case 16 ->{ 
            	entidad = fabricaEntidades.getSuperChampinon(x, y);
            	nivel.setPowerUps((PowerUp) entidad);
            }
            case 17 ->{
                entidad = fabricaEntidades.getBloqueDePreguntaChampiñonVerde(x, y);
                nivel.setPlataformas((Plataforma) entidad);
            }
            case 18->{
                entidad = fabricaEntidades.getBloqueDePreguntaSuperChampiñon(x, y);
                nivel.setPlataformas((Plataforma) entidad);
            }
            case 19->{
                entidad = fabricaEntidades.getBloqueDePreguntaFlorDeFuego(x,y);
                nivel.setPlataformas((Plataforma) entidad);
            }
            case 20->{
                entidad = fabricaEntidades.getBloqueDePreguntaEstrella(x, y);
                nivel.setPlataformas((Plataforma) entidad);
            }
            default ->{
            	entidad=null;
            }
        }
        return nivel;
    }
}
