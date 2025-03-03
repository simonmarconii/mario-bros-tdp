package Datos.GeneradorNivel;

import java.util.HashMap;

import Grafica.Sprite;

public class FabricaSprite {

	protected String ruta_de_carpeta;
	
	public FabricaSprite(String ruta_de_carpeta){
		this.ruta_de_carpeta = ruta_de_carpeta;
	}
	
	public Sprite getSpriteInicio() {
		HashMap<String, String> map = new HashMap<>();
		map.put("imagen", ruta_de_carpeta + "FondoPantallaInicio.gif");
		map.put("botonOriginal", ruta_de_carpeta + "FondoBotonOriginal.png");
		map.put("botonSustituto", ruta_de_carpeta + "FondoBotonSustituta.png");
		map.put("botonRanking", ruta_de_carpeta + "FondoBotonRanking.png");
		return new Sprite(map);
	}
	
	public Sprite getSpriteNivel(int numNivel) {
		HashMap<String, String> map = new HashMap<>();
		map.put("imagen", ruta_de_carpeta + numNivel + ".png");
		return new Sprite(map);
	}
	
	public Sprite getSpriteRanking() {
		HashMap<String, String> map = new HashMap<>();
		map.put("imagen", ruta_de_carpeta +  "FondoRanking.gif");
		return new Sprite(map);
	}
	
	public Sprite getSpriteMario() {
		HashMap<String, String> map = new HashMap<>();
		map.put("default", ruta_de_carpeta + "MarioDer.gif");
		map.put("derecha", ruta_de_carpeta + "MarioDer.gif");
		map.put("izquierda", ruta_de_carpeta + "MarioIzq.gif");
		map.put("quieto", ruta_de_carpeta + "MarioQuieto.png");
		map.put("MFderecha", ruta_de_carpeta + "MarioFuegoDer.gif");
		map.put("MFizquierda", ruta_de_carpeta + "MarioFuegoIzq.gif");
		map.put("MFquieto", ruta_de_carpeta + "MarioFuegoQuieto.png");
		map.put("MSderecha", ruta_de_carpeta + "MarioSuperDer.gif");
		map.put("MSizquierda", ruta_de_carpeta + "MarioSuperIzq.gif");
		map.put("MSquieto", ruta_de_carpeta + "MarioSuperQuieto.png");
		map.put("MEderecha", ruta_de_carpeta + "MarioEstrellaDer.gif");
		map.put("MEizquierda", ruta_de_carpeta + "MarioEstrellaIzq.gif");
		map.put("MEquieto", ruta_de_carpeta + "MarioEstrellaQuieto.gif");
		return new Sprite(map);
	}
	
	public Sprite getSpriteLakitu(){
		HashMap<String, String> map = new HashMap<>();
		map.put("default", ruta_de_carpeta + "Enemigos/LakituDer.gif");
		return new Sprite(map);
	}

	public Sprite getSpriteKoopaTroopa(){
		HashMap<String, String> map = new HashMap<>();
		map.put("default", ruta_de_carpeta + "Enemigos/KoopaTroopaDer.gif");
		map.put("KT1", ruta_de_carpeta + "Enemigos/KoopaTroopaDer.gif");
		map.put("KT-1", ruta_de_carpeta + "Enemigos/KoopaTroopaIzq.gif");
		map.put("caparazon", ruta_de_carpeta + "Enemigos/KoopaTroopaCaparazon.png");
		return new Sprite(map);
	}

	public Sprite getSpriteSpiny(){
		HashMap<String, String> map = new HashMap<>();
		map.put("default", ruta_de_carpeta + "Enemigos/SpinyDer.gif");
		map.put("S1", ruta_de_carpeta + "Enemigos/SpinyDer.gif");
		map.put("S-1", ruta_de_carpeta + "Enemigos/SpinyIzq.gif");
		return new Sprite(map);
	}

	public Sprite getSpriteBuzzyBeetle(){
		HashMap<String, String> map = new HashMap<>();
		map.put("default", ruta_de_carpeta + "Enemigos/BuzzyBeetleDer.gif");
		map.put("BB1", ruta_de_carpeta + "Enemigos/BuzzyBeetleDer.gif");
		map.put("BB-1", ruta_de_carpeta + "Enemigos/BuzzyBeetleIzq.gif");
		return new Sprite(map);
	}

	public Sprite getSpriteGoomba(){
		HashMap<String, String> map = new HashMap<>();
		map.put("default", ruta_de_carpeta + "Enemigos/LittleGoomba.gif");
		return new Sprite(map);
	}

	public Sprite getSpritePiranhaPlant(){
		HashMap<String, String> map = new HashMap<>();
		map.put("default", ruta_de_carpeta + "Enemigos/PiranhaPlant.gif");
		return new Sprite(map);
	}

	public Sprite getSpriteMoneda(){
		HashMap<String, String> map = new HashMap<>();
		map.put("default", ruta_de_carpeta + "PowerUps/Moneda.gif");
		return new Sprite(map);
	}

	public Sprite getSpriteChampinonVerde(){
		HashMap<String, String> map = new HashMap<>();
		map.put("default", ruta_de_carpeta + "PowerUps/ChampinonVerde.png");
		return new Sprite(map);
	}

	public Sprite getSpriteEstrella(){
		HashMap<String, String> map = new HashMap<>();
		map.put("default", ruta_de_carpeta + "PowerUps/Estrella.gif");
		return new Sprite(map);
	}

	public Sprite getSpriteFlorDeFuego(){
		HashMap<String, String> map = new HashMap<>();
		map.put("default", ruta_de_carpeta + "PowerUps/FlorDeFuego.gif");
		return new Sprite(map);
	}

	public Sprite getSpriteSuperChampinon(){
		HashMap<String, String> map = new HashMap<>();
		map.put("default", ruta_de_carpeta + "PowerUps/SuperChampinon.png");
		return new Sprite(map);
	}

	public Sprite getSpriteBloqueDePregunta(){
		HashMap<String, String> map = new HashMap<>();
		map.put("default", ruta_de_carpeta + "Plataformas/BloqueDePregunta.png");
		return new Sprite(map);
	}

	public Sprite getSpriteLadrilloSolido(){
		HashMap<String, String> map = new HashMap<>();
		map.put("default", ruta_de_carpeta + "Plataformas/LadrilloSolido.png");
		return new Sprite(map);
	}

	public Sprite getSpriteBloqueSolido(){
		HashMap<String, String> map = new HashMap<>();
		map.put("default", ruta_de_carpeta + "Plataformas/BloqueSolido.png");
		return new Sprite(map);
	}

	public Sprite getSpriteTuberia(){
		HashMap<String, String> map = new HashMap<>();
		map.put("default", ruta_de_carpeta + "Plataformas/Tuberia.gif");
		return new Sprite(map);
	}

	public Sprite getSpriteBolaDeFuego() {
		HashMap<String, String> map = new HashMap<>();
		map.put("default", ruta_de_carpeta + "bola_fuego.gif");
		return new Sprite(map);
	}
	
	public Sprite getSpriteBanderaFinNivel() {
        HashMap<String, String> map = new HashMap<>();
        map.put("default", ruta_de_carpeta + "BanderaFinNivel.png");
        return new Sprite(map);
    }
}
