package ar.edu.unq.cpi.carService.preliminar;

import ar.edu.unq.cpi.carService.agregado.AgregadoAService;
import ar.edu.unq.cpi.carService.service.Service;

public abstract class PreliminarParaService extends AgregadoAService {

	public PreliminarParaService(Service _base) { super(_base); }

	@Override
	public void aplicar() {
		this.aplicarAccionAgregada();
		this.getServiceBase().aplicar();
	}

}
