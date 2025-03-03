package Grafica;

import javax.sound.sampled.*;
import java.io.File;
import java.util.HashMap;
import java.util.Map;

public class Sonido {
    private static Sonido instance;
    private Map<String, Clip> sonidos;
    private boolean musicaActivada = true;
    private boolean efectosActivados = true;
    private float volumenMusica = 0.2f;
    private float volumenEfectos = 0.2f;

    private Sonido() {
        sonidos = new HashMap<>();
        cargarSonidos();
    }

    public static Sonido getInstance() {
        if (instance == null) {
            instance = new Sonido();
        }
        return instance;
    }

    private void cargarSonidos() {
        try {
            cargarSonido("tema_principal", "Fuentes/src/Sonidos/soundtrackJuego.wav");
            
            cargarSonido("salto", "Fuentes/src/Sonidos/saltoMario.wav");
            cargarSonido("moneda", "Fuentes/src/Sonidos/Moneda.wav");
            cargarSonido("power_up", "Fuentes/src/Sonidos/powerUp.wav");
            cargarSonido("game_over", "Fuentes/src/Sonidos/game_over.wav");
            cargarSonido("bola_fuego", "Fuentes/src/Sonidos/bola_fuego.wav");
            cargarSonido("estrella", "Fuentes/src/Sonidos/estrella.wav");
            cargarSonido("pierde_vida", "Fuentes/src/Sonidos/pierde_vida.wav");
            cargarSonido("bandera_fin_nivel", "Fuentes/src/Sonidos/bandera_fin_nivel.wav");
            cargarSonido("suma_vida", "Fuentes/src/Sonidos/suma_vida.wav");
            cargarSonido("aparece_power_up", "Fuentes/src/Sonidos/aparece_power_up.wav");
            cargarSonido("rompe_bloque", "Fuentes/src/Sonidos/rompe_bloque.wav");
            cargarSonido("matar_enemigo", "Fuentes/src/Sonidos/matar_enemigo.wav");

        } catch (Exception e) {
            System.err.println("Error al cargar los sonidos: " + e.getMessage());
        }
    }

    private void cargarSonido(String nombre, String ruta) {
        try {
            File archivo = new File(ruta);
            AudioInputStream audioStream = AudioSystem.getAudioInputStream(archivo);
            Clip clip = AudioSystem.getClip();
            clip.open(audioStream);
            sonidos.put(nombre, clip);
        } catch (Exception e) {
            System.err.println("Error al cargar el sonido " + nombre + ": " + e.getMessage());
        }
    }
    
    public void reproducir(String nombre) {
        if (!efectosActivados) return;
        
        Clip clip = sonidos.get(nombre);
        if (clip != null) {
            clip.setFramePosition(0);
            ajustarVolumen(clip, nombre.equals("tema_principal") ? volumenMusica : volumenEfectos);
            clip.start();
        }
    }

    public void reproducirMusica(String nombre) {
        if (!musicaActivada) return;
        
        Clip clip = sonidos.get(nombre);
        if (clip != null) {
            clip.setFramePosition(0);
            ajustarVolumen(clip, volumenMusica);
            clip.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void detener(String nombre) {
        Clip clip = sonidos.get(nombre);
        if (clip != null && clip.isRunning()) {
            clip.stop();
        }
    }

    public void detenerTodo() {
        for (Clip clip : sonidos.values()) {
            if (clip.isRunning()) {
                clip.stop();
            }
        }
    }

    private void ajustarVolumen(Clip clip, float volumen) {
        if (clip.isControlSupported(FloatControl.Type.MASTER_GAIN)) {
            FloatControl gainControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);
            float dB = (float) (Math.log(volumen) / Math.log(10.0) * 20.0);
            gainControl.setValue(dB);
        }
    }

    public void setMusicaActivada(boolean activada) {
        this.musicaActivada = activada;
        if (!activada) {
            detener("tema_principal");
        }
    }

    public void setEfectosActivados(boolean activados) {
        this.efectosActivados = activados;
    }

    public void setVolumenMusica(float volumen) {
        this.volumenMusica = Math.max(0.0f, Math.min(1.0f, volumen));
    }

    public void setVolumenEfectos(float volumen) {
        this.volumenEfectos = Math.max(0.0f, Math.min(1.0f, volumen));
    }
}
