package ar.edu.unq.cpi.carService.service;

import ar.edu.unq.cpi.carService.precios.ListaDePrecios;
import ar.edu.unq.cpi.carService.vehiculo.Tonalidad;
import ar.edu.unq.cpi.carService.vehiculo.Vehiculo;

public class Pintura extends ServiceBase {
	private Tonalidad nuevoColor;

	public Pintura(Vehiculo sobreQueVehiculo, Tonalidad _nuevoColor) {
		super(sobreQueVehiculo);
		this.nuevoColor = _nuevoColor;
	}

	@Override
	public TipoServicio getTipo() { return TipoServicio.PINTURA; }


	@Override
	public void aplicar() {
		this.getVehiculo().pintar(this.nuevoColor);		
	}

	@Override
	public int getTiempo() { return 600; }

	@Override
	public double getPrecio() {
		return this.getPrecioBase() * this.getVehiculo().getSuperficie();
	}

	@Override
	public boolean seTrabajaSobreChapa() { return true; }
}
