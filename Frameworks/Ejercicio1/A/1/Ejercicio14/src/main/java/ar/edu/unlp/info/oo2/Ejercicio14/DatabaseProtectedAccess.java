package ar.edu.unlp.info.oo2.Ejercicio14;

import java.util.Collection;
import java.util.List;
import java.util.logging.ConsoleHandler;
import java.util.logging.Level;
import java.util.logging.Logger;

public class DatabaseProtectedAccess implements DatabaseAccess {
	private boolean access;
	private DatabaseAccess protectionProxy;
	
	
	public DatabaseProtectedAccess(DatabaseAccess protectionProxy) {
		this.access = false;
		this.protectionProxy = protectionProxy;
	}
	
	public void authenticate() {
		this.access = true;
	}
	
	public void logOut() {
		this.access = false;
	}
	
	public boolean isAuthenticated() {
		return this.access;
	}
	
	private void loggerInvalidMessage() {
		Logger.getLogger("DataBaseLogger").log(Level.SEVERE,"Access denied. User not authenticated");
	}

	@Override
	public Collection<String> getSearchResults(String queryString) {
		if (!this.isAuthenticated()) {
			this.loggerInvalidMessage();
			throw new RuntimeException("Access denied. User not authenticated");
		}
		Logger.getLogger("DataBaseLogger").log(Level.INFO,"Valid acces");
		return this.protectionProxy.getSearchResults(queryString);
	}

	@Override
	public int insertNewRow(List<String> rowData) {
		if (!this.isAuthenticated()) {
			this.loggerInvalidMessage();
			throw new RuntimeException("Access denied. User not authenticated");
		}
		Logger.getLogger("DataBaseLogger").log(Level.WARNING,"Valid insert");
		return this.protectionProxy.insertNewRow(rowData);
	}

}
