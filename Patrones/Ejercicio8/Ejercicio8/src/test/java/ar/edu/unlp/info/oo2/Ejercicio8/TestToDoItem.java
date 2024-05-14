package ar.edu.unlp.info.oo2.Ejercicio8;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class TestToDoItem {
	ToDoItem item1,item2;
	
	@BeforeEach
	void setUp() {
		item1= new ToDoItem("Item 1");
		item2= new ToDoItem("Item 2");
		item1.start();
	}
	
	@Test
	public void testStart() {
		assertTrue(item1.getState() instanceof InProgress);
		assertTrue(item2.getState() instanceof Pending);
	}
	
	@Test
	public void testTogglePause() {
		item1.togglePause();
		assertTrue(item1.getState() instanceof Paused);
		Exception togglePauseError = assertThrows(RuntimeException.class, () -> item2.togglePause());
		assertEquals ("Error, no se puede pausar un Item en estado Pending",togglePauseError.getMessage());
		item1.finish();
		Exception togglePauseError2 = assertThrows(RuntimeException.class, () -> item1.togglePause());
		assertEquals ("No se puede pausar un item finalizado",togglePauseError2.getMessage());
	}
	
	@Test
	public void workedTimeTest() {
		assertThrows(RuntimeException.class, () -> item2.workedTime());
	}
	
}
