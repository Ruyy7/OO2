package ar.edu.unlp.info.oo2.Ejercicio12;

public class FourGConnectionAdapter implements Connection {
	private FourGConnection adaptee;
	
	public FourGConnectionAdapter() {
		this.adaptee = new FourGConnection();
	}

	@Override
	public String sendData(String data, long crc) {
		return this.adaptee.transmit(data, crc);
	}

	@Override
	public String pict() {
		return this.adaptee.symb();
	}

}
