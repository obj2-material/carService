package ar.edu.unq.cpi.carService.service;

import ar.edu.unq.cpi.carService.cliente.Cliente;
import ar.edu.unq.cpi.carService.precios.ListaDePrecios;
import ar.edu.unq.cpi.carService.vehiculo.Vehiculo;

public abstract class Service {
	public abstract TipoServicio getTipo();
	
	public abstract void aplicar();
	
	public abstract int getTiempo();
	
	public abstract double getPrecio();
	
	public abstract Vehiculo getVehiculo();
	
	public abstract Cliente getCliente();
	
	public abstract boolean hayQueAbrirCapot();
	public abstract boolean seTrabajaSobreChapa();
	
	public abstract boolean incluyeServicio(TipoServicio tipo);
	
	public double getPrecioBase() { return ListaDePrecios.getLista().getPrecio(this.getTipo()); }
}
