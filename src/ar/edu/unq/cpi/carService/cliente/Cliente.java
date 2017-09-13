package ar.edu.unq.cpi.carService.cliente;

public class Cliente {
	private boolean esVip;
	
	public Cliente(boolean _esVip) {
		super();
		this.esVip = _esVip;
	}
	
	public boolean esVip() { return this.esVip; }
}
