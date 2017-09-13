package ar.edu.unq.cpi.carService.vehiculo;

import java.util.Comparator;
import java.util.Map;
import java.util.Set;

public class Vehiculo {
	public static final double VALOR_SATURACION = 1000000000;
	
	private Map<NivelDeVehiculo, Double> valoresActuales;
	private Map<NivelDeVehiculo, Double> valoresMaximos;
	private Set<Bujia> bujias;
	private Tonalidad color;
	private double superficie;
	
	public Vehiculo() {
		super();
	}
	
	public Vehiculo(Tonalidad _color, double _superficie) {
		this();
		this.color = _color;
		this.superficie = _superficie;
	}
	
	public Double getValor(NivelDeVehiculo nivel) {
		return this.valoresActuales.getOrDefault(nivel, 0.0);
	}
	
	public Double getValorMaximo(NivelDeVehiculo nivel) {
		return this.valoresMaximos.getOrDefault(nivel, VALOR_SATURACION);
	}
	
	public void medir(NivelDeVehiculo nivel, double valor) {
		this.valoresActuales.put(nivel, valor);
	}
	
	public void cargar(NivelDeVehiculo nivel, double cuanto) {
		this.valoresActuales.put(
				nivel, 
				Math.min(this.getValor(nivel) + cuanto, this.getValorMaximo(nivel))
		);
	}

	public void vaciar(NivelDeVehiculo nivel) { this.valoresActuales.put(nivel, 0.0); }

	public void setValorMaximo(NivelDeVehiculo nivel, double valor) {
		this.valoresMaximos.put(nivel, valor);
	}

	public void addToBujias(Bujia...bujiasAAgregar) {
		for (Bujia bujia : bujiasAAgregar) {
			this.bujias.add(bujia);
		}
	}
	
	public void retirarBujia(Bujia bujiaAQuitar) { this.bujias.remove(bujiaAQuitar); }
	
	public Bujia bujiaMenosPotente() {
		return this.bujias.stream().min(Comparator.comparing(Bujia::getPotencia)).get();
	}
	
	public Tonalidad getColor() { return this.color; }
	public void pintar(Tonalidad nuevoColor) { this.color = nuevoColor; }

	public double getSuperficie() { return this.superficie; }
	public void setSuperficie(double valor) { this.superficie = valor; }
}
