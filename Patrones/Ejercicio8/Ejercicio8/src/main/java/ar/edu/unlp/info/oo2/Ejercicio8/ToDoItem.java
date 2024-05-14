package ar.edu.unlp.info.oo2.Ejercicio8;

import java.time.Duration;
import java.time.LocalDateTime;

public class ToDoItem {
	private String name;
	private String comentario;
	private State state;
	private LocalDateTime inicio;
	private LocalDateTime fin;
	
	public ToDoItem(String name) {
		this.name = name;
		this.comentario = "";
		this.state = new Pending(this);
		this.inicio = LocalDateTime.now();
	}
	
	public Duration workedTime() {
		return this.state.workedTime();
	}
	
	public void addComment(String comentario) {
		this.comentario += "\t" + comentario;
	}
	
	public void start() {
		this.state.start();
	}
	
	public void togglePause() {
		this.state.togglePause();
	}
	
	public void finish() {
		this.state.finish();
	}
	
	public void setState(State state) {
		this.state = state;
	}
	
	public void setFin (LocalDateTime tiempo) {
		this.fin = tiempo;
	}
	
	public LocalDateTime getInicio() {
		return inicio;
	}

	public LocalDateTime getFin() {
		return fin;
	}

	public State getState() {
		return state;
	}
	
}
