package ar.edu.unq.cpi.carService.service;

import ar.edu.unq.cpi.carService.cliente.Cliente;
import ar.edu.unq.cpi.carService.vehiculo.Vehiculo;

public abstract class ServiceBase extends Service {
	protected Vehiculo vehiculo;
	private Cliente cliente;
	
	public ServiceBase(Vehiculo sobreQueVehiculo) {
		super();
		this.vehiculo = sobreQueVehiculo;
	}
	
	@Override
	public Vehiculo getVehiculo() { return this.vehiculo; }

	@Override
	public Cliente getCliente() { return this.cliente; }

	@Override
	public boolean hayQueAbrirCapot() { return false; }
	@Override
	public boolean seTrabajaSobreChapa() { return false; }
	
	@Override
	public boolean incluyeServicio(TipoServicio tipo) {
		return this.getTipo().equals(tipo);
	}

}
