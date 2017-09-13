package ar.edu.unq.cpi.carService.service;

import ar.edu.unq.cpi.carService.vehiculo.NivelDeVehiculo;
import ar.edu.unq.cpi.carService.vehiculo.Vehiculo;

public class Alineacion extends ServiceBase {

	public Alineacion(Vehiculo sobreQueVehiculo) {
		super(sobreQueVehiculo);
	}

	@Override
	public TipoServicio getTipo() { return TipoServicio.ALINEACION; }

	@Override
	public void aplicar() {
		this.getVehiculo().vaciar(NivelDeVehiculo.DESVIO_ALINEACION);
	}

	@Override
	public int getTiempo() { return 120; }

	@Override
	public double getPrecio() { return this.getPrecioBase(); }
	
}
