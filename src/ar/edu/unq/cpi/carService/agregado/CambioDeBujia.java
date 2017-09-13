package ar.edu.unq.cpi.carService.agregado;

import ar.edu.unq.cpi.carService.service.Service;
import ar.edu.unq.cpi.carService.service.TipoServicio;
import ar.edu.unq.cpi.carService.vehiculo.Bujia;

public class CambioDeBujia extends AgregadoPosteriorAService {

	private Bujia bujiaACambiar;
	private boolean seSeleccionoBujia = false;

	public CambioDeBujia(Service _base) { 
		super(_base);
	}

	@Override
	public TipoServicio getTipo() { return TipoServicio.CAMBIO_BUJIA; }

	private void seleccionarBujia() {
		if (!this.seSeleccionoBujia) {
			this.seSeleccionoBujia = true;
			this.bujiaACambiar = this.getVehiculo().bujiaMenosPotente();
			if (this.bujiaACambiar.getPotencia() > 5) { this.bujiaACambiar = null; }
		}
	}
	
	public boolean hayQueHacerAlgo() {
		this.seleccionarBujia();
		return this.bujiaACambiar != null; 
	}

	@Override
	protected void aplicarAccionAgregada() { 
		if (this.hayQueHacerAlgo()) {
			this.getVehiculo().retirarBujia(this.bujiaACambiar);
			this.getVehiculo().addToBujias(new Bujia(10));
		}
	}

	@Override
	public int getTiempoAgregado() { return this.getServiceBase().hayQueAbrirCapot() ? 0 : 60; }

	@Override
	public double getPrecioAgregado() {
		double precio = this.hayQueHacerAlgo() ? this.getPrecioBase() : 0;
		if (this.getCliente().esVip()) { precio *= 0.8; }
		return precio;
	}

	@Override
	public boolean hayQueAbrirCapot() { return true; }
}
