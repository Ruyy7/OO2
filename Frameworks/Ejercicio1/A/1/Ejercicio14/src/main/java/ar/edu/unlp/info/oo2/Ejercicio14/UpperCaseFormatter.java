package ar.edu.unlp.info.oo2.Ejercicio14;
import java.util.logging.LogRecord;
import java.util.logging.SimpleFormatter;

public class UpperCaseFormatter extends SimpleFormatter {
	@Override
	public String format(LogRecord record) {
		return super.format(record).toUpperCase();
	}
}
