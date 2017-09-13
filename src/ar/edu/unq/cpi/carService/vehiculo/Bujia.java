package ar.edu.unq.cpi.carService.vehiculo;

public class Bujia {
	protected double potencia;
	
	public Bujia(double potenciaInicial) { 
		super();
		this.potencia = potenciaInicial;
	}
	public double getPotencia() { return this.potencia; }
	public void setPotencia(double valor) { this.potencia = valor; }
}
