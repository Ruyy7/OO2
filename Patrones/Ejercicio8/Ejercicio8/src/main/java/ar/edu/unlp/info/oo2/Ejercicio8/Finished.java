package ar.edu.unlp.info.oo2.Ejercicio8;

import java.time.Duration;

public class Finished extends State {

	public Finished(ToDoItem task) {
		super(task);
	}

	@Override
	public void start() {
		System.out.println("Ya finalicé, no puedo volver a empezar");
	}

	@Override
	public void togglePause() {
		throw new RuntimeException("No se puede pausar un item finalizado");
	}

	@Override
	public void finish() {
		System.out.println("Ya finalicé, vuelva pronto");
	}

	@Override
	public void addComment(String comment) {
		System.out.println("Ya finalicé, puedo agregar comentarios");
	}
	
	@Override
	public Duration workedTime() {
		return Duration.between(this.getTask().getInicio(), this.getTask().getFin());
	}
}
