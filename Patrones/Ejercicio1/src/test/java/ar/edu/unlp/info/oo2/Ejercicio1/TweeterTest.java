package ar.edu.unlp.info.oo2.Ejercicio1;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TweeterTest {
	Usuario u1,u2,u3;
	Tweet t1,t2,t3,t4;
	ReTweet r1,r2,r3;
	Tweeter system;
	@BeforeEach
	void setUp() {
		system = new Tweeter();
		u1 = system.registrarUsuario("Matias");
		u2 = system.registrarUsuario("Marco");
		u3 = system.registrarUsuario("Mayra");
		t1 = u1.tweetear("Hola");
		t2 = u1.tweetear("Termo");
		t3 = u2.tweetear("Atrheus");
		t4 = u3.tweetear("Gomitas");
		r1 = u2.reTweetear(t2);
		r2 = u3.reTweetear(t3);
		r3 = u1.reTweetear(t4);
	}
	
	@Test
	public void registrarUsuarioTest() {
		assertNotNull(system.registrarUsuario("Jorge"));
		assertNull(system.registrarUsuario("Mayra"));
	}
	
	@Test
	public void eliminarUsuarioTest() {
		system.eliminarUsuario(u2);
		assertFalse(system.existeUsuario("Marco"));
	}
}
