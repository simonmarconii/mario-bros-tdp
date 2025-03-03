package Logica;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class ManejadorTeclado implements KeyListener{

    protected boolean saltando, izqApretado, derApretado, espacioApretado;

    
    public ManejadorTeclado() {
    }
    
    public void keyTyped(KeyEvent e) {
    }

    public void keyPressed(KeyEvent e) {
        int codigo = e.getKeyCode();
        if(codigo == KeyEvent.VK_W){
        	saltando = true;
        }
        if(codigo == KeyEvent.VK_A){
            izqApretado = true;
        }
        if(codigo == KeyEvent.VK_D){
            derApretado = true;
        }
        if(codigo == KeyEvent.VK_SPACE){
            espacioApretado = true; 
        }
    }

    public void keyReleased(KeyEvent e) {
        int codigo = e.getKeyCode();
        if(codigo == KeyEvent.VK_A){
            izqApretado = false;
        }
        if(codigo == KeyEvent.VK_D){
            derApretado = false;
        }
        if(codigo == KeyEvent.VK_SPACE){
            espacioApretado = false;
        }
    }

    public boolean getSaltando(){
        return saltando;
    }

    public boolean getIzqApretado(){
        return izqApretado;
    }

    public boolean getDerApretado(){
        return derApretado;
    }

    public boolean getEspacioApretado(){
        return espacioApretado;
    }
    
    public void setSaltando(boolean s) {
    	saltando = s;
    }

	public void setEspacioApretado(boolean e) {
		espacioApretado = e;
	}
	
	public void setDerechaApretado(boolean e) {
		derApretado  = e;
	}
	
	public void setIzquierdaApretado(boolean e) {
		izqApretado  = e;
	}
	
	public void resetearTeclas() {
		setSaltando(false);
		setEspacioApretado(false);
		setDerechaApretado(false);
		setIzquierdaApretado(false);
	}
}
