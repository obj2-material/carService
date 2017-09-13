package ar.edu.unq.cpi.carService.agregado;

import ar.edu.unq.cpi.carService.service.Service;
import ar.edu.unq.cpi.carService.service.TipoServicio;
import ar.edu.unq.cpi.carService.vehiculo.NivelDeVehiculo;

public class LimpiezaExterior extends AgregadoPosteriorAService {

	public LimpiezaExterior(Service _base) { super(_base); }

	@Override
	public TipoServicio getTipo() { return TipoServicio.LIMPIEZA_EXTERIOR; }

	@Override
	protected void aplicarAccionAgregada() { this.getVehiculo().vaciar(NivelDeVehiculo.GRADO_SUCIEDAD); }

	@Override
	public int getTiempoAgregado() { return 30; }

	@Override
	public double getPrecioAgregado() { 
		return this.getServiceBase().seTrabajaSobreChapa() 
				? 0 : this.getPrecioBase(); 
	}

}
