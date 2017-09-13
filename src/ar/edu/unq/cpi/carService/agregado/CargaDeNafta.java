package ar.edu.unq.cpi.carService.agregado;

import ar.edu.unq.cpi.carService.service.Service;
import ar.edu.unq.cpi.carService.service.TipoServicio;
import ar.edu.unq.cpi.carService.vehiculo.NivelDeVehiculo;

public class CargaDeNafta extends AgregadoPosteriorAService {

	public CargaDeNafta(Service _base) { super(_base); }

	@Override
	public TipoServicio getTipo() { return TipoServicio.CARGA_NAFTA; }

	@Override
	public void aplicarAccionAgregada() {
		this.getVehiculo().cargar(NivelDeVehiculo.CANTIDAD_NAFTA, 20);
	}

	@Override
	public int getTiempoAgregado() { return this.getServiceBase().getTiempo() >= 120 ? 0 : 20; }

	@Override
	public double getPrecioAgregado() { return this.getPrecioBase(); }

}
