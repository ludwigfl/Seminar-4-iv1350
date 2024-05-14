package se.kth.iv1350.module4.integration;

import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

/**
 *
 * @author ludwigflodin, antonhammar
 */
public class ItemNotFoundExceptionTest {
    private ItemNotFoundException itemException; 
    
    public ItemNotFoundExceptionTest() {
        
    }
    
    @BeforeEach
    public void setUp() {
        itemException = new ItemNotFoundException(888);
    }
    
    @AfterEach
    public void tearDown() {
        itemException = null;
    }

    @Test
    public void testPrintExceptionMsg() {
        String expectedResult = "Item with identifier: (" + 888 + ") not found";
        String result = itemException.printExceptionMsg();
        assertTrue(result.contains(expectedResult), "Exception message is incorrect");
    }

    @Test
    public void testPrintAdminMsg() {
        String expectedResult = "Item error";
        String result = itemException.printAdminMsg();
        assertTrue(result.contains(expectedResult), "Exception message is incorrect");
    }
}
