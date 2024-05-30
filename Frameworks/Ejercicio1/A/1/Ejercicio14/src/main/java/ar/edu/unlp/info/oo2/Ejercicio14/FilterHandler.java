package ar.edu.unlp.info.oo2.Ejercicio14;

import java.util.ArrayList;
import java.util.List;
import java.util.logging.Handler;
import java.util.logging.LogRecord;

public class FilterHandler extends Handler{
	private Handler handler;
	private List<String> blackListOfWords;

	public FilterHandler(Handler handler) {
		this.handler = handler;
		this.blackListOfWords = new ArrayList<>();
	}
	
	private String censoredRecord(String message) {
		for (String word:blackListOfWords) {
			if (message.contains(word)) {
				message = message.replaceAll(word, "***");
			}
		}
		return message;
	}
	
	public void addBannedWord(String word) {
		this.blackListOfWords.add(word);
	}

	@Override
	public void publish(LogRecord record) {
		record.setMessage(this.censoredRecord(record.getMessage()));
		this.handler.publish(record);
	}

	@Override
	public void flush() {
		this.handler.flush();
	}

	@Override
	public void close() throws SecurityException {
		this.handler.close();
	}

	public Handler getHandler() {
		return handler;
	}

}
