package ar.edu.unq.cpi.carService.service;

import ar.edu.unq.cpi.carService.precios.ListaDePrecios;
import ar.edu.unq.cpi.carService.vehiculo.NivelDeVehiculo;
import ar.edu.unq.cpi.carService.vehiculo.Vehiculo;

public class ServiceTotalChapa extends ServiceBase {

	private int bollosASacar;
	private int rajadurasASacar;

	public ServiceTotalChapa(Vehiculo sobreQueVehiculo) {
		super(sobreQueVehiculo);
		this.bollosASacar = sobreQueVehiculo.getValor(NivelDeVehiculo.CANTIDAD_BOLLOS).intValue();
		this.rajadurasASacar = sobreQueVehiculo.getValor(NivelDeVehiculo.CANTIDAD_RAJADURAS).intValue();
	}

	@Override
	public TipoServicio getTipo() { return TipoServicio.SERVICE_TOTAL_CHAPA; }


	@Override
	public void aplicar() {
		this.getVehiculo().vaciar(NivelDeVehiculo.CANTIDAD_BOLLOS);
		this.getVehiculo().vaciar(NivelDeVehiculo.CANTIDAD_RAJADURAS);
	}

	@Override
	public int getTiempo() { return this.getTiempoBollos() + this.getTiempoRajaduras(); }
	public int getTiempoBollos() { return Math.min(this.bollosASacar * 30, 120); }
	public int getTiempoRajaduras() { return ((this.rajadurasASacar + 1) / 2) * 40; }

	@Override
	public double getPrecio() { return this.getPrecioBollos() + this.getPrecioRajaduras(); }

	public double getPrecioBollos() { 
		return ListaDePrecios.getLista().getPrecio(TipoServicio.ELIMINACION_BOLLOS) * this.bollosASacar; 
	} 
	public double getPrecioRajaduras() { 
		return ListaDePrecios.getLista().getPrecio(TipoServicio.ELIMINACION_RAJADURAS) * this.rajadurasASacar; 
	} 

	@Override
	public boolean seTrabajaSobreChapa() { return true; }
	
	@Override
	public boolean incluyeServicio(TipoServicio tipo) {
		return super.incluyeServicio(tipo) 
				|| TipoServicio.ELIMINACION_BOLLOS.equals(tipo) 
				|| TipoServicio.ELIMINACION_RAJADURAS.equals(tipo); 
	}
}
