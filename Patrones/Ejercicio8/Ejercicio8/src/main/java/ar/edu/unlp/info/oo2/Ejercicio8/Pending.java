package ar.edu.unlp.info.oo2.Ejercicio8;

import java.time.Duration;

public class Pending extends State {

	public Pending(ToDoItem task) {
		super(task);
	}

	@Override
	public void start() {
		this.getTask().setState(new InProgress(this.getTask()));
	}

	@Override
	public void togglePause() {
		throw new RuntimeException("Error, no se puede pausar un Item en estado Pending");

	}

	@Override
	public void finish() {
		System.out.println("Estoy en pending, no puedo pasar a finished entonces no hago nada");
	}

	@Override
	public Duration workedTime() {
		throw new RuntimeException("El Item no se inició, no puede calcularse el tiempo trabajado");
	}
}
