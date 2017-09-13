package ar.edu.unq.cpi.carService.agregado;

import ar.edu.unq.cpi.carService.service.Service;
import ar.edu.unq.cpi.carService.service.TipoServicio;
import ar.edu.unq.cpi.carService.vehiculo.NivelDeVehiculo;

public class CargaDeAceite extends AgregadoPosteriorAService {

	public CargaDeAceite(Service _base) { super(_base); }

	@Override
	public TipoServicio getTipo() { return TipoServicio.CARGA_ACEITE; }
	
	@Override
	public void aplicarAccionAgregada() { this.getVehiculo().cargar(NivelDeVehiculo.CANTIDAD_ACEITE, 1); }

	@Override
	public int getTiempoAgregado() { return 20; }

	@Override
	public double getPrecioAgregado() { return this.getPrecioBase(); }

	@Override
	public boolean hayQueAbrirCapot() { return true; }
}
