
public final class Configurador {

	private static final Configurador confg = new Configurador();
	
	private static String configuracion;
	
	public Configurador () {
		
	}
	
	public static synchronized Configurador obtenerInstancia () {
		return confg;
	}

	public String getConfiguracion() {
		return configuracion;
	}

	public void setConfiguracion(String configuracion) {
		Configurador.configuracion = configuracion;
	}
}
