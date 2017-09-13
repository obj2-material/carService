package ar.edu.unq.cpi.carService.agregado;

import ar.edu.unq.cpi.carService.service.Service;
import ar.edu.unq.cpi.carService.service.TipoServicio;
import ar.edu.unq.cpi.carService.vehiculo.NivelDeVehiculo;

public class CambioDeFiltro extends AgregadoPosteriorAService {

	public CambioDeFiltro(Service _base) { super(_base); }

	@Override
	public TipoServicio getTipo() { return TipoServicio.CAMBIO_FILTRO; }

	@Override
	protected void aplicarAccionAgregada() {
		this.getVehiculo().vaciar(NivelDeVehiculo.DESGASTE_FILTRO);		
	}

	@Override
	public int getTiempoAgregado() { return 40; }

	@Override
	public double getPrecioAgregado() { return this.getCliente().esVip() ? 0 : this.getPrecioBase(); }

}
