package se.kth.iv1350.module4.model;

import static java.lang.Math.round;
import java.util.List;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.module4.controller.Controller;
import se.kth.iv1350.module4.integration.AccountingSystem;
import se.kth.iv1350.module4.integration.DatabaseNotCalledException;
import se.kth.iv1350.module4.integration.DiscountDatabase;
import se.kth.iv1350.module4.integration.InventorySystem;
import se.kth.iv1350.module4.integration.ItemNotFoundException;
import se.kth.iv1350.module4.model.ReceiptPrinter;
import se.kth.iv1350.module4.view.*;



/**
 *
 * @author ludwigflodin, antonHammar
 */
public class SaleTest {
     private Item itemToTest;
     private Controller controllerToTest;
     private InventorySystem invSys;
     private DiscountDatabase disSys;
     private AccountingSystem acctSys;
    
    
    public SaleTest() {
    }
    
    @BeforeEach
    public void setUp() {
        invSys = new InventorySystem();
        disSys = new DiscountDatabase();
        acctSys = new AccountingSystem();
        controllerToTest = new Controller(invSys, disSys, acctSys);
        controllerToTest.startSale(new TotalRevenueView(), new TotalRevenueFileOutput());
        itemToTest = new Item(123, 0.06, "Big oatmeal for the family", 59.99, "BigWheel Oatmeal", 50);

    }
    
    @AfterEach
    public void tearDown() {
        controllerToTest = null;
        itemToTest = null;
        invSys = null;
        disSys = null;
        acctSys = null;
    }
    
    /*
    @Test
    public void testGetItemList() {
        Sale instance = new Sale();
        List<Item> expResult = null;
        List<Item> result = instance.getItemList();
        assertEquals(expResult, result);
    }
    */
    
    
    @Test
    public void testAddToRunningTotal() {
        double expResult =2999.5;
        controllerToTest.getSale().addToRunningTotal(itemToTest);
         
        double result = controllerToTest.getSale().getRunningTotal();
        assertEquals(expResult, result, "Different running total values in addToRunningTotal, oh no!");

    }
   
    
    @Test
    public void testGetRunningTotal() {
        double expResult = 119.98;
        try{
        controllerToTest.scanItem(123, 2);
           }catch(ItemNotFoundException testException ){
               System.err.println(testException.printExceptionMsg());
           }catch(DatabaseNotCalledException testException2){
               System.err.println(testException2.printExceptionMsg());
           }
        double result = controllerToTest.getSale().getRunningTotal();
                
        assertEquals(expResult, result, "Different running total values in getRunningTotal, oh no!");
        
    }

    /*
        @Test
        public void testGetReceipt() {
        Sale instance = new Sale();
        Receipt expResult = null;
        Receipt result = instance.getReceipt();
        assertEquals(expResult, result);
    }
    */
    @Test
    public void testAddToTotalVAT() {
        double expResult = 6.0;
         try{
        controllerToTest.scanItem(321, 5);
           }catch(ItemNotFoundException testException ){
               System.err.println(testException.printExceptionMsg());
           }catch(DatabaseNotCalledException testException2){
               System.err.println(testException2.printExceptionMsg());
           }
         
        double result = round(controllerToTest.getSale().getTotalVat()*100)/100;
                
        assertEquals(expResult, result, "Different total VATs, oh no!");
        
    }

    
}
