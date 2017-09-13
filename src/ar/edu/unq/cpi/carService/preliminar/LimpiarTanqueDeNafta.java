package ar.edu.unq.cpi.carService.preliminar;

import ar.edu.unq.cpi.carService.service.Service;
import ar.edu.unq.cpi.carService.service.TipoServicio;
import ar.edu.unq.cpi.carService.vehiculo.NivelDeVehiculo;

public class LimpiarTanqueDeNafta extends PreliminarParaService {
	public LimpiarTanqueDeNafta(Service _base) { super(_base); }

	@Override
	public TipoServicio getTipo() { return TipoServicio.LIMPIAR_TANQUE_DE_NAFTA; }
	
	@Override
	protected void aplicarAccionAgregada() { this.getVehiculo().vaciar(NivelDeVehiculo.CANTIDAD_NAFTA); }

	@Override
	public int getTiempoAgregado() { return 180; }

	@Override
	public double getPrecioAgregado() { return this.getPrecioBase(); }

}
