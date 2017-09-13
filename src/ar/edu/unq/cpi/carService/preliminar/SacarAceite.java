package ar.edu.unq.cpi.carService.preliminar;

import ar.edu.unq.cpi.carService.service.Service;
import ar.edu.unq.cpi.carService.service.TipoServicio;
import ar.edu.unq.cpi.carService.vehiculo.NivelDeVehiculo;

public class SacarAceite extends PreliminarParaService {

	public SacarAceite(Service _base) { super(_base); }

	@Override
	public TipoServicio getTipo() { return TipoServicio.SACAR_ACEITE; }

	@Override
	protected void aplicarAccionAgregada() { this.getVehiculo().vaciar(NivelDeVehiculo.CANTIDAD_ACEITE);
	}

	@Override
	public int getTiempoAgregado() { return 15; }

	@Override
	public double getPrecioAgregado() { 
		return this.incluyeServicio(TipoServicio.CARGA_ACEITE) 
				? 0 : this.getPrecioBase();
	}

}
