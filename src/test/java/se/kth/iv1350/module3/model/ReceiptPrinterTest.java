package se.kth.iv1350.module3.model;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.module3.controller.Controller;
import se.kth.iv1350.module3.integration.AccountingSystem;
import se.kth.iv1350.module3.integration.DiscountDatabase;
import se.kth.iv1350.module3.integration.InventorySystem;
import se.kth.iv1350.module3.view.View;
import java.time.LocalTime;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author ludwigflodin
 */
public class ReceiptPrinterTest {
    
    public ReceiptPrinterTest() {
    }
    
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalsysOut;
    private ReceiptPrinter instancePrinter;
    private Receipt fakeReceipt;
    private ItemList fakeList;
    
    
    
    @BeforeEach
    public void setUp() {
        
        instancePrinter = new ReceiptPrinter();
        fakeReceipt = new Receipt(LocalTime.now(), LocalDate.now());
        List <Item> fakeList = new ArrayList();
        fakeReceipt.update(fakeList, 0, 0);
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalsysOut = System.out;
        System.setOut(inMemSysOut);
    }
    
    @AfterEach
    public void tearDown() {
        
        printoutBuffer = null;
        instancePrinter = null;
        fakeReceipt = null;
        fakeList = null;
        
        System.setOut(originalsysOut);
    }

    @Test
    public void testPrintReceipt() {
        
        instancePrinter.printReceipt(fakeReceipt);
        String printout = printoutBuffer.toString();
        String expectedOutput = "------------------------------------ Begin receipt ------------------------------------";
        assertTrue(printout.contains(expectedOutput), "wrong receipt printout");
    }
    
}
