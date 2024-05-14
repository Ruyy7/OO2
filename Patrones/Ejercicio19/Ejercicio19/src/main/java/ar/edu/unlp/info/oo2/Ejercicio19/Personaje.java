package ar.edu.unlp.info.oo2.Ejercicio19;

import java.util.ArrayList;
import java.util.List;

import ar.edu.unlp.info.oo2.Ejercicio19.Armaduras.Armadura;
import ar.edu.unlp.info.oo2.Ejercicio19.Armas.Arma;
import ar.edu.unlp.info.oo2.Ejercicio19.Habilidades.Habilidad;

public class Personaje {
	private String nombre;
	private int hp;
	private Arma arma;
	private Armadura armadura;
	private List<Habilidad> habilidades;
	
	public Personaje(String nombre) {
		this.nombre = nombre;
		this.hp = 100;
		this.habilidades = new ArrayList<>();
	}
	
	public void añadirHabilidad(Habilidad habilidad) {
		this.habilidades.add(habilidad);
	}
	
	public void restarHp(Arma arma) {
		this.hp -= this.armadura.recibirDaño(arma);
	}
	
	public void atacar (Personaje oponente) {
		oponente.restarHp(this.arma);
	}

	public void setArma(Arma arma) {
		this.arma = arma;
	}

	public void setArmadura(Armadura armadura) {
		this.armadura = armadura;
	}
	
}
