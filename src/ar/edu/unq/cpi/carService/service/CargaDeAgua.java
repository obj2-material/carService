package ar.edu.unq.cpi.carService.service;

import ar.edu.unq.cpi.carService.precios.ListaDePrecios;
import ar.edu.unq.cpi.carService.vehiculo.NivelDeVehiculo;
import ar.edu.unq.cpi.carService.vehiculo.Vehiculo;

public class CargaDeAgua extends ServiceBase {
	
	public CargaDeAgua(Vehiculo sobreQueVehiculo) {
		super(sobreQueVehiculo);
	}

	@Override
	public TipoServicio getTipo() { return TipoServicio.CARGA_DE_AGUA; }

	@Override
	public void aplicar() {
		this.getVehiculo().cargar(NivelDeVehiculo.AGUA_SAPITO, 2.0);
		this.getVehiculo().cargar(NivelDeVehiculo.AGUA_RADIADOR, 5.0);		
	}

	@Override
	public int getTiempo() { return 30; }

	@Override
	public double getPrecio() { return this.getPrecioBase(); }

	@Override
	public boolean hayQueAbrirCapot() { return true; }

}
