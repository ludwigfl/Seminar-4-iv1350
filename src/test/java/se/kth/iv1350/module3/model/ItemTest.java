package se.kth.iv1350.module3.model;

import static java.lang.Math.round;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.module3.controller.Controller;
import se.kth.iv1350.module3.integration.AccountingSystem;
import se.kth.iv1350.module3.integration.DiscountDatabase;
import se.kth.iv1350.module3.integration.InventorySystem;
import se.kth.iv1350.module3.model.ReceiptPrinter;



/**
 *
 * @author ludwigflodin, antonHammar
 */
public class ItemTest {
     private Item itemToTest;
    
    
    public ItemTest() {
    }
    
    @BeforeEach
    public void setUp() {
        itemToTest = new Item(123, 0.06, "Big oatmeal for the family", 59.99, "BigWheel Oatmeal", 50);

    }
    
    @AfterEach
    public void tearDown() {
       
        itemToTest = null;
       
    }

    /* @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Item instance = null;
        double expResult = 0.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }
    */

    
    /* @Test
    public void testGetVAT() {
        System.out.println("getVAT");
        Item instance = null;
        double expResult = 0.0;
        double result = instance.getVAT();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }
    */

    /* @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        Item instance = null;
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    */
    
    /* @Test
    public void testGetID() {
        System.out.println("getID");
        Item instance = null;
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    */
    
    @Test
    public void testIncreaseQuantity() {
        
        int expResult = 52;
        int result;
        itemToTest.increaseQuantity(2);
        result = itemToTest.getQuantity();
        assertEquals(expResult, result, "Different increase in quantity values, skill issue");
    }

    /* @Test
    public void testGetName() {
        System.out.println("getName");
        Item instance = null;
        String expResult = "";
        String result = instance.getName();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
   
    
    @Test
    public void testGetPrice() {
        System.out.println("getPrice");
        Item instance = null;
        double expResult = 0.0;
        double result = instance.getPrice();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }
    
    @Test
    public void testGetDesc() {
        System.out.println("getDesc");
        Item instance = null;
        String expResult = "";
        String result = instance.getDesc();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetItemTotalPrice() {
        System.out.println("getItemTotalPrice");
        Item instance = null;
        double expResult = 0.0;
        double result = instance.getItemTotalPrice();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetVatPrice() {
        System.out.println("getVatPrice");
        Item instance = null;
        double expResult = 0.0;
        double result = instance.getVatPrice();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetVAT() {
        System.out.println("getVAT");
        Item instance = null;
        double expResult = 0.0;
        double result = instance.getVAT();
        assertEquals(expResult, result, 0);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetQuantity() {
        System.out.println("getQuantity");
        Item instance = null;
        int expResult = 0;
        int result = instance.getQuantity();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }

    @Test
    public void testGetID() {
        System.out.println("getID");
        Item instance = null;
        int expResult = 0;
        int result = instance.getID();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    */
}
