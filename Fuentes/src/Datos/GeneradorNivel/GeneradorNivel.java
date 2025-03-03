package Datos.GeneradorNivel;

import Grafica.Pantalla.ConstantesPantalla;
import Logica.Mario;
import Logica.Nivel;
import Logica.Parseo;

public class GeneradorNivel {

	protected FabricaEntidades fabricaEntidades;
	protected Parseo parseo;
    protected Nivel nivel;
	
    public GeneradorNivel(Nivel nivel){
        this.nivel = nivel;
        fabricaEntidades = nivel.getFabricaEntidades();
        parseo = new Parseo(fabricaEntidades, nivel);
    }
    public void generarNivel(int numero){
    	nivel.resetear();
    	fabricaEntidades.getMario(ConstantesPantalla.POSICION_X_INICIAL, ConstantesPantalla.POSICION_Y_INICIAL);
        switch(numero) {
             case 1 ->{
            	 parseo.getArchivo("nivel1.txt");
             }
             case 2 ->{
            	 parseo.getArchivo("nivel2.txt");
            	 Mario.getInstance().siguienteNivel();
             }
             case 3 ->{
            	 parseo.getArchivo("nivel3.txt");
            	 Mario.getInstance().siguienteNivel();
             }
        }
    }
}
