package ar.edu.unlp.info.oo2.Ejercicio8;

import java.time.Duration;
import java.time.LocalDateTime;

public abstract class State {
	private ToDoItem task;

	public State(ToDoItem task) {
		this.task = task;
	}
	
	public Duration workedTime() {
		this.task.setFin(LocalDateTime.now());
		return Duration.between(task.getInicio(), task.getFin());
	}
	
	public void addComment(String comentario) {
		this.task.addComment(comentario);
	}
	
	public ToDoItem getTask() {
		return task;
	}

	public abstract void start();
	public abstract void togglePause();
	public abstract void finish();
}
