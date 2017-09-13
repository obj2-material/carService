package ar.edu.unq.cpi.carService.preliminar;

import ar.edu.unq.cpi.carService.service.Service;
import ar.edu.unq.cpi.carService.service.TipoServicio;
import ar.edu.unq.cpi.carService.vehiculo.NivelDeVehiculo;

public class SacarAgua extends PreliminarParaService {

	public SacarAgua(Service _base) { super(_base); }

	@Override
	public TipoServicio getTipo() { return TipoServicio.SACAR_AGUA; }
	
	@Override
	protected void aplicarAccionAgregada() { 
		this.getVehiculo().vaciar(NivelDeVehiculo.AGUA_RADIADOR);
		this.getVehiculo().vaciar(NivelDeVehiculo.AGUA_SAPITO);
	}

	@Override
	public int getTiempoAgregado() { return 0; }

	@Override
	public double getPrecioAgregado() { return this.getPrecioBase(); }

}
