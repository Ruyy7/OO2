package ar.edu.unlp.info.oo2.Ejercicio1;

import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.junit.jupiter.api.Assertions.assertFalse;


import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class UsuarioTest {
	Usuario u1;
	Tweet t1,t2,t3,t4;
	ReTweet r1,r2,r3;
	
	@BeforeEach
	void setUp() {
		u1 = new Usuario ("Matias");
	}
	
	@Test
	public void tweetearTest() {
		t1 = u1.tweetear("Hola");
		t2 = u1.tweetear("c2cc2!$%2b3bb31a!cbac%33b32c$bcb%%bc!12!!aba!c$bcc2b1!%ca21a!$a1$23b1!bcc31123!%1bb$3c1a21%2%c3!!ca3!1bb%a1c3%$2$ca1c$b2ab1%%cc2$3%%2b!%!%!%3$b3%%%2a$ccc3%a1%2!a12%b$c$1c$$3%%bc1ac$1a%b21b3$31!c!a$b2!3bb2bb$%%1a11!b33$b33a!cb13%122$%3!!3$$!%cb%c1312c3a3%!2!$c2311%1113b$!2$!a31!2a");
		t3 = u1.tweetear("2zzkkzx!3k2%x!c3a2ak2$xk1z%1%a1k2%aaxk!xx2233xz$1az11kx2$%xcazzbbb3b$12$a1$xabk!acc!%$cbab2bck$3x1ak!$ack223cak2!122zka%bcx%b$bbzz$a2c3bxb3zc!1a2kba%21!z%k%bcckk%z3k$z!c$k!kxzcxz33z!2$3bkcbcxk$ka$x$k2$xaax%xkcc2%3b%z232$3bcb!!bbb2k3c%2%c%$ca!bb!kx3cabk!3bax23!kbc1zac33xaz!a!$acb$x");
		t4 = u1.tweetear("");
		
		assertTrue (u1.contieneTweet(t1));
		assertTrue (u1.contieneTweet(t2));
		assertFalse (u1.contieneTweet(t3));
		assertFalse (u1.contieneTweet(t4));
	}
	
	@Test
	public void reTweetearTest() {
		t1 = new Tweet ("Manzanas");
		t2 = new Tweet ("");
		t3 = new Tweet ("2zzkkzx!3k2%x!c3a2ak2$xk1z%1%a1k2%aaxk!xx2233xz$1az11kx2$%xcazzbbb3b$12$a1$xabk!acc!%$cbab2bck$3x1ak!$ack223cak2!122zka%bcx%b$bbzz$a2c3bxb3zc!1a2kba%21!z%k%bcckk%z3k$z!c$k!kxzcxz33z!2$3bkcbcxk$ka$x$k2$xaax%xkcc2%3b%z232$3bcb!!bbb2k3c%2%c%$ca!bb!kx3cabk!3bax23!kbc1zac33xaz!a!$acb$x");
		r1 = u1.reTweetear(t1);
		r2 = u1.reTweetear(t2);
		r3 = u1.reTweetear(t3);
		assertTrue (u1.contieneTweet(r1));
		assertFalse (u1.contieneTweet(r2));
		assertFalse (u1.contieneTweet(r3));
	}
	
	@Test
	public void eliminarTweetsTest() {
		t1 = u1.tweetear("Hola");
		t2 = u1.tweetear("Pasto");
		assertTrue (u1.contieneTweet(t1));
		assertTrue (u1.contieneTweet(t2));
		u1.eliminarTweets();
		assertFalse (u1.contieneTweet(t1));
		assertFalse (u1.contieneTweet(t2));
	}
}
