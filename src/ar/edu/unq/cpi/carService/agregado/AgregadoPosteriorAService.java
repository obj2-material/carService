package ar.edu.unq.cpi.carService.agregado;

import ar.edu.unq.cpi.carService.service.Service;

public abstract class AgregadoPosteriorAService extends AgregadoAService {

	public AgregadoPosteriorAService(Service _base) {
		super(_base);
	}
	
	@Override
	public void aplicar() {
		this.getServiceBase().aplicar();
		this.aplicarAccionAgregada();
	}

}
