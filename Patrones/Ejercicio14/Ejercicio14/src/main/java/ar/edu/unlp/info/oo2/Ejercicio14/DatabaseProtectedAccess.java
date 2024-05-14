package ar.edu.unlp.info.oo2.Ejercicio14;

import java.util.Collection;
import java.util.List;

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

	@Override
	public Collection<String> getSearchResults(String queryString) {
		if (!this.isAuthenticated()) {
			throw new RuntimeException("Access denied. User not authenticated");
		}
		return this.protectionProxy.getSearchResults(queryString);
	}

	@Override
	public int insertNewRow(List<String> rowData) {
		if (!this.isAuthenticated()) {
			throw new RuntimeException("Access denied. User not authenticated");
		}
		return this.protectionProxy.insertNewRow(rowData);
	}

}
