package ar.edu.unlp.info.oo2.Ejercicio1;

public class ReTweet extends Tweet{
	private Tweet tweetPrincipal;

	public ReTweet(String texto, Tweet tweetPrincipal) {
		super(texto);
		this.tweetPrincipal = tweetPrincipal;
	}

	public Tweet getTweetPrincipal() {
		return this.tweetPrincipal;
	}
	
}
