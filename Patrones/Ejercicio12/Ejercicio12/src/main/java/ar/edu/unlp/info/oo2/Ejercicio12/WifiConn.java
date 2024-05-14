package ar.edu.unlp.info.oo2.Ejercicio12;

public class WifiConn implements Connection {
	private String pict;
	
	public WifiConn () {
		this.pict = "Wi-Fi";
	}

	@Override
	public String sendData(String data, long crc) {
		return "Streaming data with wifi";
	}

	@Override
	public String pict() {
		return this.pict;
	}

}
