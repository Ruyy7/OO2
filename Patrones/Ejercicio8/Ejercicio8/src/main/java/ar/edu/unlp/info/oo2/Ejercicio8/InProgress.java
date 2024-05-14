package ar.edu.unlp.info.oo2.Ejercicio8;

import java.time.LocalDateTime;

public class InProgress extends State {

	public InProgress(ToDoItem task) {
		super(task);
	}

	@Override
	public void start() {
		System.out.println("Estoy In-Progress, no hago nada");
	}

	@Override
	public void togglePause() {
		this.getTask().setState(new Paused(this.getTask()));

	}

	@Override
	public void finish() {
		this.getTask().setState(new Finished(this.getTask()));
		this.getTask().setFin(LocalDateTime.now());
	}

}
