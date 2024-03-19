package ar.edu.unlp.info.oo2.Ejercicio1;

import java.util.ArrayList;
import java.util.List;

public class Tweeter {
	private List<Usuario> usuarios = new ArrayList<>();
	
	public Usuario registrarUsuario(String screenName) {
		if (!this.existeUsuario(screenName)) {
			Usuario u = new Usuario (screenName);
			this.usuarios.add(u);
			return u;
		}
		return null;
	}
	
	public boolean existeUsuario(String screenName) {
		return this.usuarios.stream().anyMatch(u -> u.getScreenName().equals(screenName));
	}
	
	public void eliminarUsuario (Usuario u) {
		if (this.existeUsuario(u.getScreenName())) {
			u.eliminarTweets();
			this.usuarios.remove(u);
		}
	}
}
