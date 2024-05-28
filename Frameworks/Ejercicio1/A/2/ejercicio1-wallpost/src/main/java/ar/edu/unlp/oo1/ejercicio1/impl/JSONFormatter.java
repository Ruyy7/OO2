package ar.edu.unlp.oo1.ejercicio1.impl;
import java.util.logging.Formatter;
import java.util.logging.LogRecord;

public class JSONFormatter extends Formatter{

	@Override
	public String format(LogRecord record) {
		return "{" + "message: " + record.getMessage() + ", " + "level: " + record.getLevel() +"}";
	}
}
