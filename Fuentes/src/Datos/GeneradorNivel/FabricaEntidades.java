package Datos.GeneradorNivel;

import java.util.concurrent.CopyOnWriteArrayList;

import Grafica.Sprite;
import Grafica.Pantalla.ConstantesPantalla;
import Logica.BolaDeFuego;
import Logica.Mario;
import Logica.Enemigos.*;
import Logica.EstadosMario.MarioNormal;
import Logica.Observer.ObserverEntidades;
import Logica.Observer.ObserverJugador;
import Logica.Plataformas.*;
import Logica.PowerUps.*;

public class FabricaEntidades {
	protected FabricaSprite fabricaSprites;
	protected Mario mario;
	
	public FabricaEntidades(FabricaSprite fabricaSprites){
		this.fabricaSprites = fabricaSprites;
	}

	public Mario getMario(int x, int y){
		Sprite spriteMarioDer = fabricaSprites.getSpriteMario();
		mario = Mario.getInstance();
		mario.setX(x);
		mario.setY(y);
		mario.setSprite(spriteMarioDer);
		MarioNormal estado = new MarioNormal(mario);
		ObserverJugador observer = new ObserverJugador(mario);
		mario.setObserverJugador(observer);
		mario.setEstado(estado);
		return mario;
	}
	
	public BuzzyBeetle getBuzzyBeetle(int x, int y) {
        Sprite sprite_buzzy_beetle = fabricaSprites.getSpriteBuzzyBeetle();
        BuzzyBeetle buzzyBeetle = new BuzzyBeetle(x,y,ConstantesPantalla.TAMAÑO_HITBOX,ConstantesPantalla.TAMAÑO_HITBOX,sprite_buzzy_beetle);
        ObserverEntidades observer = new ObserverEntidades(buzzyBeetle);
        buzzyBeetle.setObserver(observer);
        return buzzyBeetle;
    }

    public Goomba getGoomba(int x, int y) {
        Sprite sprite_goomba = fabricaSprites.getSpriteGoomba();
        Goomba goomba = new Goomba(x,y,ConstantesPantalla.TAMAÑO_HITBOX,ConstantesPantalla.TAMAÑO_HITBOX,sprite_goomba);
        ObserverEntidades observer = new ObserverEntidades(goomba);
        goomba.setObserver(observer);
        return goomba;
    }

    public KoopaTroopa getKoopaTroopa(int x, int y) {
        Sprite sprite_koopatroopa = fabricaSprites.getSpriteKoopaTroopa();
        KoopaTroopa koopaTroopa = new KoopaTroopa(x,y,ConstantesPantalla.TAMAÑO_HITBOX,ConstantesPantalla.TAMAÑO_HITBOX,sprite_koopatroopa);
        ObserverEntidades observer = new ObserverEntidades(koopaTroopa);
        koopaTroopa.setObserver(observer);
        return koopaTroopa;
    }

    public Lakitu getLakitu(int x, int y, CopyOnWriteArrayList<Enemigo> listaEnemigos) {
        Sprite sprite_lakitu = fabricaSprites.getSpriteLakitu();
        Lakitu lakitu = new Lakitu(x,y,ConstantesPantalla.TAMAÑO_HITBOX,ConstantesPantalla.TAMAÑO_HITBOX,sprite_lakitu, listaEnemigos);
        ObserverEntidades observer = new ObserverEntidades(lakitu);
        lakitu.setObserver(observer);
        return lakitu;
    }

    public PiranhaPlant getPiranhaPlant(int x, int y) {
        Sprite sprite_piranha = fabricaSprites.getSpritePiranhaPlant();
        PiranhaPlant piranha = new PiranhaPlant(x,y,ConstantesPantalla.TAMAÑO_HITBOX,ConstantesPantalla.TAMAÑO_HITBOX,sprite_piranha);
        ObserverEntidades observer = new ObserverEntidades(piranha);
        piranha.setPosicionEnCapa(0);
        piranha.setObserver(observer);
        return piranha;
    }

    public Spiny getSpiny(int x,int y) {
        Sprite sprite_spiny = fabricaSprites.getSpriteSpiny();
        Spiny spiny = new Spiny(x,y,ConstantesPantalla.TAMAÑO_HITBOX,ConstantesPantalla.TAMAÑO_HITBOX,sprite_spiny);
        ObserverEntidades observer = new ObserverEntidades(spiny);
        spiny.setObserver(observer);
        return spiny;
    }
    
    public BloqueDePregunta getBloqueDePreguntaChampiñonVerde(int x,int y) {
    	Sprite sprite_bloqueDePregunta = fabricaSprites.getSpriteBloqueDePregunta();
    	BloqueDePregunta bloqueDePregunta = new BloqueDePreguntaChampiñonVerde(x,y,ConstantesPantalla.TAMAÑO_HITBOX,ConstantesPantalla.TAMAÑO_HITBOX,sprite_bloqueDePregunta, getChampinonVerde(x + 5, y - 30));
    	ObserverEntidades observer = new ObserverEntidades(bloqueDePregunta);
        bloqueDePregunta.setObserver(observer);
    	return bloqueDePregunta;
    }
    
    public BloqueDePreguntaSuperChampiñon getBloqueDePreguntaSuperChampiñon(int x,int y) {
        Sprite sprite_bloqueDePregunta = fabricaSprites.getSpriteBloqueDePregunta();
        BloqueDePreguntaSuperChampiñon bloqueDePregunta = new BloqueDePreguntaSuperChampiñon(x,y,ConstantesPantalla.TAMAÑO_HITBOX,ConstantesPantalla.TAMAÑO_HITBOX,sprite_bloqueDePregunta,getSuperChampinon(x + 4,y - ConstantesPantalla.TAMAÑO_HITBOX));
        ObserverEntidades observer = new ObserverEntidades(bloqueDePregunta);
        bloqueDePregunta.setObserver(observer);
        return bloqueDePregunta;
    }
    
    public BloqueDePreguntaFlorDeFuego getBloqueDePreguntaFlorDeFuego(int x,int y) {
        Sprite sprite_bloqueDePregunta = fabricaSprites.getSpriteBloqueDePregunta();
        BloqueDePreguntaFlorDeFuego bloqueDePregunta = new BloqueDePreguntaFlorDeFuego(x,y,ConstantesPantalla.TAMAÑO_HITBOX,ConstantesPantalla.TAMAÑO_HITBOX,sprite_bloqueDePregunta,getFlorDeFuego(x + 4,y - ConstantesPantalla.TAMAÑO_HITBOX));
        ObserverEntidades observer = new ObserverEntidades(bloqueDePregunta);
        bloqueDePregunta.setObserver(observer);
        return bloqueDePregunta;
    }
    
    public BloqueDePreguntaEstrella getBloqueDePreguntaEstrella(int x ,int y){
        Sprite sprite_bloqueDePregunta = fabricaSprites.getSpriteBloqueDePregunta();
        BloqueDePreguntaEstrella bloqueDePregunta = new BloqueDePreguntaEstrella(x,y,ConstantesPantalla.TAMAÑO_HITBOX,ConstantesPantalla.TAMAÑO_HITBOX,sprite_bloqueDePregunta, getEstrella(x,y - ConstantesPantalla.TAMAÑO_HITBOX));
        ObserverEntidades observer = new ObserverEntidades(bloqueDePregunta);
        bloqueDePregunta.setObserver(observer);
        return bloqueDePregunta;
    }
    
    public BloqueDePregunta getBloqueDePreguntaMoneda(int x,int y) {
    	Sprite sprite_bloqueDePregunta = fabricaSprites.getSpriteBloqueDePregunta();
    	BloqueDePregunta bloqueDePregunta = new BloqueDePreguntaChampiñonVerde(x,y,ConstantesPantalla.TAMAÑO_HITBOX,ConstantesPantalla.TAMAÑO_HITBOX,sprite_bloqueDePregunta, getMoneda(x + 10, y - ConstantesPantalla.TAMAÑO_HITBOX));
    	ObserverEntidades observer = new ObserverEntidades(bloqueDePregunta);
        bloqueDePregunta.setObserver(observer);
    	return bloqueDePregunta;
    }
    
    public BloqueSolido getBloqueSolido(int x,int y) {
    	Sprite sprite_bloqueSolido = fabricaSprites.getSpriteBloqueSolido();
    	BloqueSolido bloqueSolido = new BloqueSolido(x,y,ConstantesPantalla.TAMAÑO_HITBOX,ConstantesPantalla.TAMAÑO_HITBOX,sprite_bloqueSolido);
    	ObserverEntidades observer = new ObserverEntidades(bloqueSolido);
        bloqueSolido.setObserver(observer);
    	return bloqueSolido;
    }
    
    public LadrilloSolido getLadrilloSolido(int x,int y) {
    	Sprite sprite_ladrilloSolido = fabricaSprites.getSpriteLadrilloSolido();
    	LadrilloSolido ladrilloSolido = new LadrilloSolido(x,y,ConstantesPantalla.TAMAÑO_HITBOX,ConstantesPantalla.TAMAÑO_HITBOX,sprite_ladrilloSolido);
    	ObserverEntidades observer = new ObserverEntidades(ladrilloSolido);
        ladrilloSolido.setObserver(observer);
    	return ladrilloSolido;
    }
    
    public Tuberia getTuberia(int x, int y) {
        Sprite sprite_tuberia = fabricaSprites.getSpriteTuberia();
        Tuberia tuberia = new Tuberia(x,y,ConstantesPantalla.TAMAÑO_HITBOX,ConstantesPantalla.TAMAÑO_HITBOX,sprite_tuberia);
        ObserverEntidades observer = new ObserverEntidades(tuberia);
        tuberia.setPosicionEnCapa(1);
        tuberia.setObserver(observer);
        return tuberia;
    }
    
    public ChampinonVerde getChampinonVerde(int x, int y) {
    	Sprite spriteChampinonVerde = fabricaSprites.getSpriteChampinonVerde();
    	ChampinonVerde champinonVerde = new ChampinonVerde(x,y,ConstantesPantalla.TAMAÑO_HITBOX,ConstantesPantalla.TAMAÑO_HITBOX,spriteChampinonVerde);
    	ObserverEntidades observer = new ObserverEntidades(champinonVerde);
        champinonVerde.setObserver(observer);
    	return champinonVerde;
    }
    
    public Estrella getEstrella(int x, int y) {
    	Sprite spriteEstrella = fabricaSprites.getSpriteEstrella();
    	Estrella estrella = new Estrella(x,y,ConstantesPantalla.TAMAÑO_HITBOX,ConstantesPantalla.TAMAÑO_HITBOX,spriteEstrella);
    	ObserverEntidades observer = new ObserverEntidades(estrella);
        estrella.setObserver(observer);
    	return estrella;
    }
    
    public FlorDeFuego getFlorDeFuego(int x, int y) {
    	Sprite spriteFlorDeFuego = fabricaSprites.getSpriteFlorDeFuego();
    	FlorDeFuego florDeFuego = new FlorDeFuego(x,y,ConstantesPantalla.TAMAÑO_HITBOX,ConstantesPantalla.TAMAÑO_HITBOX,spriteFlorDeFuego);
    	ObserverEntidades observer = new ObserverEntidades(florDeFuego);
        florDeFuego.setObserver(observer);
    	return florDeFuego;
    }
    
    public Moneda getMoneda(int x, int y) {
    	Sprite spriteMoneda = fabricaSprites.getSpriteMoneda();
    	Moneda moneda = new Moneda(x,y,ConstantesPantalla.TAMAÑO_HITBOX,ConstantesPantalla.TAMAÑO_HITBOX,spriteMoneda);
    	ObserverEntidades observer = new ObserverEntidades(moneda);
        moneda.setObserver(observer);
    	return moneda;
    }
    
    public SuperChampinon getSuperChampinon(int x, int y) {
    	Sprite spriteSuperChampinon = fabricaSprites.getSpriteSuperChampinon();
    	SuperChampinon superChampinon = new SuperChampinon(x,y,ConstantesPantalla.TAMAÑO_HITBOX,ConstantesPantalla.TAMAÑO_HITBOX,spriteSuperChampinon);
    	ObserverEntidades observer = new ObserverEntidades(superChampinon);
    	superChampinon.setObserver(observer);
    	return superChampinon;
    }

    public BolaDeFuego getBolaDeFuego(int x, int y, boolean direccionDerecha) {
        Sprite spriteBolaDeFuego = fabricaSprites.getSpriteBolaDeFuego();
        BolaDeFuego bolaDeFuego = new BolaDeFuego(x, y, direccionDerecha, spriteBolaDeFuego);
        ObserverEntidades observer = new ObserverEntidades(bolaDeFuego);
        bolaDeFuego.setObserver(observer);
        return bolaDeFuego;
    }
    
    public BanderaFinNivel getBanderaFinNivel(int x, int y) {
        Sprite spriteBanderaFinNivel = fabricaSprites.getSpriteBanderaFinNivel();
        BanderaFinNivel banderaFinNivel = new BanderaFinNivel(x,y,38,269,spriteBanderaFinNivel);
        ObserverEntidades observer = new ObserverEntidades(banderaFinNivel);
        banderaFinNivel.setObserver(observer);
        return banderaFinNivel;
    }

}
