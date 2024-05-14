package se.kth.iv1350.module3.model;

import static java.lang.Math.round;
import java.util.ArrayList;
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
public class ItemListTest {
     private Item itemToTest;
     private List<Item> expectedList;
     private ItemList resultList;
    
    
    public ItemListTest() {
    }
    
    @BeforeEach
    public void setUp() {
        itemToTest = new Item(123, 0.06, "Big oatmeal for the family", 59.99, "BigWheel Oatmeal", 50);
        expectedList = new ArrayList<>(); 
        resultList = new ItemList();
        

    }
    
    @AfterEach
    public void tearDown() {
       
        itemToTest = null;
        expectedList = null;
        resultList = null;
                
        
       
    }
    /*
    @Test
    public void testGetItem() {
        System.out.println("getItem");
        int itemId = 0;
        ItemList instance = new ItemList();
        Item expResult = null;
        Item result = instance.getItem(itemId);
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    */
    
    @Test
    public void testAddItem() {
        expectedList.add(itemToTest);
        List<Item> expResult = expectedList;
        resultList.addItem(itemToTest);
        List<Item> result = resultList.getList();
        assertEquals(expResult, result, "Different lists, skill issue");

    }

    /*
    @Test
    public void testGetList() {
        System.out.println("getList");
        ItemList instance = new ItemList();
        List<Item> expResult = null;
        List<Item> result = instance.getList();
        assertEquals(expResult, result);
        fail("The test case is a prototype.");
    }
    */
}
