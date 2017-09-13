package ar.edu.unq.cpi.carService.agregado;

import ar.edu.unq.cpi.carService.cliente.Cliente;
import ar.edu.unq.cpi.carService.service.Service;
import ar.edu.unq.cpi.carService.service.TipoServicio;
import ar.edu.unq.cpi.carService.vehiculo.Vehiculo;

public abstract class AgregadoAService extends Service {

	protected Service serviceBase;

	public AgregadoAService(Service _base) {
		super();
		this.serviceBase = _base;
	}

	public Service getServiceBase() { return this.serviceBase; }

	protected abstract void aplicarAccionAgregada();

	@Override
	public int getTiempo() { return this.getServiceBase().getTiempo() + this.getTiempoAgregado(); }
	public abstract int getTiempoAgregado();

	@Override
	public double getPrecio() { return this.getServiceBase().getPrecio() + this.getPrecioAgregado(); }
	public abstract double getPrecioAgregado();

	@Override
	public Vehiculo getVehiculo() { return this.getServiceBase().getVehiculo(); }

	@Override
	public Cliente getCliente() { return this.getServiceBase().getCliente(); }

	@Override
	public boolean hayQueAbrirCapot() { return this.getServiceBase().hayQueAbrirCapot(); }

	@Override
	public boolean seTrabajaSobreChapa() { return this.getServiceBase().seTrabajaSobreChapa(); }

	@Override
	public boolean incluyeServicio(TipoServicio tipo) {
		return this.getTipo().equals(tipo) || this.getServiceBase().incluyeServicio(tipo);
	}
}
