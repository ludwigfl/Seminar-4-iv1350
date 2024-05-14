package se.kth.iv1350.module4.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ludwigflodin
 */
public class DatabaseNotCalledExceptionTest {
    private DatabaseNotCalledException dbException;
    
    @BeforeEach
    public void setUp() {
        
        dbException = new DatabaseNotCalledException();
    }
    
    @AfterEach
    public void tearDown() {
        dbException = null;
    }

    @Test
    public void testPrintExceptionMsg() {
        String expectedResult = "oopsie";
        String result = dbException.printExceptionMsg();
        assertTrue(result.contains(expectedResult), "Exception message is incorrect");
    }

    @Test
    public void testPrintAdminMsg() {
        String expectedResult = "Database error";
        String result = dbException.printAdminMsg();
        assertTrue(result.contains(expectedResult), "Exception message is incorrect");
    }
    
}
