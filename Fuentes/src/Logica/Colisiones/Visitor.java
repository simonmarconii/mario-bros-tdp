package Logica.Colisiones;

import Logica.Enemigos.Enemigo;
import Logica.Plataformas.Plataforma;
import Logica.PowerUps.PowerUp;

public interface Visitor {
    public void afecta(Enemigo enemigo);
    public void afecta(PowerUp powerUp);
    public void afecta(Plataforma plataforma);
    public void serAfectado(Enemigo enemigo);
}
