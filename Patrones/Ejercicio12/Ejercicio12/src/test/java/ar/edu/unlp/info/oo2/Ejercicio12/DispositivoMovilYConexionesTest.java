package ar.edu.unlp.info.oo2.Ejercicio12;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DispositivoMovilYConexionesTest {
	Dispositivo test;
	CRC16_Calculator c16;
	CRC32_Calculator c32;
	WifiConn wificonn;
	FourGConnectionAdapter fourG;
	
	@BeforeEach
	void setUp() {
		test = new Dispositivo();
		c16 = new CRC16_Calculator(); c32 = new CRC32_Calculator();
		wificonn = new WifiConn(); fourG = new FourGConnectionAdapter();
	}
	
	@Test
	public void configurarCRCTest() {
		assertEquals("Using new Calculator", test.configurarCRC(c16));
	}
	
	@Test
	public void conectarConTest() {
		assertEquals ("Connected with Wi-Fi",test.conectarCon(wificonn));
		assertEquals ("Connected with 4G",test.conectarCon(fourG));
	}
	
	@Test
	public void sendTest() {
		test.conectarCon(wificonn); test.configurarCRC(c32);
		assertEquals("Streaming data with wifi",test.send("Hola"));
	}
}
