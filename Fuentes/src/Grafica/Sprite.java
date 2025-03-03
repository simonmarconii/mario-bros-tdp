package Grafica;

import java.util.HashMap;

public class Sprite {

	protected HashMap<String, String> map;
	
	public Sprite(HashMap<String,String> map) {
		this.map = map;
	}
	
	public String getRutaDeImagen(String ruta) {
		return map.get(ruta);
	}
	
}
