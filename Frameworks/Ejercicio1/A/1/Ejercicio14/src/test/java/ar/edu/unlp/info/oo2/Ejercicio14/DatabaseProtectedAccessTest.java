package ar.edu.unlp.info.oo2.Ejercicio14;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Arrays;
import java.util.logging.ConsoleHandler;
import java.util.logging.LogManager;
import java.util.logging.Logger;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class DatabaseProtectedAccessTest {
	DatabaseProtectedAccess proxy;
	DatabaseAccess database;
    private static Logger logger = Logger.getLogger("DataBaseLogger");
	
    @BeforeAll
    static void setUpLogger() {
    	FilterHandler  fh = new FilterHandler(new ConsoleHandler());
    	fh.getHandler().setFormatter(new JSONFormatter());
	    fh.addBannedWord("not");
	    logger.addHandler(fh);
	    
//	    MailHandler mh = new MailHandler();
//	    logger.addHandler(mh);
    }
    
	@BeforeEach
	void setUp() {
		proxy = new DatabaseProtectedAccess(new DatabaseRealAccess());
	}
	
	@Test
	public void getSearchResultsTest() {
		this.proxy.authenticate();
		assertEquals(Arrays.asList("Spiderman", "Marvel"), this.proxy.getSearchResults("select * from comics where id=1"));
		this.proxy.logOut();
		Exception getSearchResultError = assertThrows(RuntimeException.class, () -> {this.proxy.getSearchResults("select * from comics where id=1");});
		assertEquals ("Access denied. User not authenticated",getSearchResultError.getMessage());
	}
	
	@Test
	public void insertNewRowTest() {
		Exception insertNewRowError = assertThrows (RuntimeException.class, () -> this.proxy.insertNewRow(Arrays.asList("Patoruzú", "La flor")));
		assertEquals ("Access denied. User not authenticated",insertNewRowError.getMessage());
		this.proxy.authenticate();
		assertEquals(3, this.proxy.insertNewRow(Arrays.asList("Patoruzú", "La flor")));
        assertEquals(Arrays.asList("Patoruzú", "La flor"), this.proxy.getSearchResults("select * from comics where id=3"));
	}
}
