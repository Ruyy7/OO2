package ar.edu.unlp.info.oo2.Ejercicio14;
import java.util.ArrayList;
import java.util.List;
import java.util.logging.LogRecord;
import java.util.logging.StreamHandler;
public class FilterHandler extends StreamHandler{
	
	List<String> filtros;
	
	public FilterHandler() {
		this.filtros = new ArrayList<>();
		this.filtros.add("Access");
	}
	
	@Override
	public void publish(LogRecord record) {
		String[] texto = record.getMessage().split(" ");
		for (String t : texto) {
			if (this.filtros.contains(t)) {
				t = "***";
			}
		}
	}
}
