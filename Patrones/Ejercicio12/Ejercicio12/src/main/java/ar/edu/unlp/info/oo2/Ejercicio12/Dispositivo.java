package ar.edu.unlp.info.oo2.Ejercicio12;

public class Dispositivo {
	private Calculator crcCalculator;
	private Ringer ringer;
	private Display display;
	private Connection connection;
	
	public Dispositivo() {
		this.ringer = new Ringer();
		this.display = new Display();
	}
	
	public String send(String data) {
		long crc = this.crcCalculator.crcFor(data);
		return this.connection.sendData(data, crc);
	}

	public String configurarCRC(Calculator crcCalculator) {
		this.crcCalculator = crcCalculator;
		return "Using new Calculator";
	}

	public String conectarCon(Connection connection) {
		this.connection = connection;
		this.display.showBanner(connection.pict());
		this.ringer.ring();
		return "Connected with " + this.display.showBanner(connection.pict());
	}
	
}
