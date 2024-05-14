package ar.edu.unlp.info.oo2.Ejercicio12;

public class FourGConnection {
	private String symb;
	
	public FourGConnection() {
		this.symb = "4G";
	}
	
	public String transmit(String data, long crc) {
		return "Streaming data with 4G";
	}
	
	public String symb() {
		return this.symb;
	}
	
}
