package ar.edu.unq.cpi.carService.precios;

import java.util.HashMap;
import java.util.Map;

import ar.edu.unq.cpi.carService.service.TipoServicio;

public class ListaDePrecios {

	private static ListaDePrecios laLista = new ListaDePrecios();
	
	private Map<TipoServicio, Double> precios = new HashMap<>();
	
	public static ListaDePrecios getLista() {
		return laLista;
	};
	
	public double getPrecio(TipoServicio tipo) { return this.precios.getOrDefault(tipo, 0.0); }
	
	public void setPrecio(TipoServicio tipo, double precio) {
		this.precios.put(tipo, precio);
	}
	
	public void cargarListaParaTest() {
		this.setPrecio(TipoServicio.CARGA_DE_AGUA, 300);
		this.setPrecio(TipoServicio.ALINEACION, 1800);
		this.setPrecio(TipoServicio.ELIMINACION_BOLLOS, 2000);
		this.setPrecio(TipoServicio.ELIMINACION_RAJADURAS, 3000);
		this.setPrecio(TipoServicio.PINTURA, 30000);
		this.setPrecio(TipoServicio.CARGA_ACEITE, 1200);
		this.setPrecio(TipoServicio.CARGA_NAFTA, 550);
		this.setPrecio(TipoServicio.CAMBIO_BUJIA, 200);
		this.setPrecio(TipoServicio.CAMBIO_FILTRO, 3500);
		this.setPrecio(TipoServicio.LIMPIEZA_EXTERIOR, 400);
		this.setPrecio(TipoServicio.SACAR_ACEITE, 220);
		this.setPrecio(TipoServicio.SACAR_AGUA, 40);
		this.setPrecio(TipoServicio.LIMPIAR_TANQUE_DE_NAFTA, 600);
	}
}
