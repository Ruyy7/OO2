package ar.edu.unlp.info.oo2.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Usuario {
	private String screenName;
	private List<Tweet> tweets;
	
	public Usuario(String screenName) {
		this.screenName = screenName;
		this.tweets = new ArrayList<>();
	}
	
	public Tweet tweetear(String tweet) {
		if (this.cumpleLongitud(tweet)) {
			Tweet t = new Tweet(tweet);
			this.tweets.add(t);
			return t;
		}
		return null;
	}
	
	public ReTweet reTweetear(Tweet t){
		if (this.cumpleLongitud(t.getTexto())) {
			ReTweet rt = new ReTweet(t.getTexto(),t);
			this.tweets.add(rt);
			return rt;
		}
		return null;
	}
	
	public boolean contieneTweet(Tweet tweet) {
		return this.tweets.stream().anyMatch(t -> t.equals(tweet));
	}
	
	private boolean cumpleLongitud(String texto) {
		return texto.length() >= 1 && texto.length()<= 280;
	}

	public void eliminarTweets() {
		this.tweets.clear();
	}
	
	public String getScreenName() {
		return this.screenName;
	}
	
}
