package Logica.Observer;

public class ObserverEntidades extends ObserverGrafico {

	private static final long serialVersionUID = -1660464462031736589L;

	public ObserverEntidades(EntidadLogica entidad_observada) {
        super(entidad_observada);
        actualizar();
    }

}
