package se.kth.iv1350.module3.view;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;
import se.kth.iv1350.module3.controller.Controller;
import se.kth.iv1350.module3.integration.AccountingSystem;
import se.kth.iv1350.module3.integration.InventorySystem;
import se.kth.iv1350.module3.integration.DiscountDatabase;
import se.kth.iv1350.module3.model.ReceiptPrinter;

/**
 *
 * @author ludwigflodin, antonHammar
 */
public class ViewTest {
    private View instanceToTest;
    private ByteArrayOutputStream printoutBuffer;
    private PrintStream originalsysOut;
    private InventorySystem invSys;
    private DiscountDatabase disSys;
    private AccountingSystem acctSys;
    
    @BeforeEach
    public void setUp() {
        invSys = new InventorySystem();
        disSys = new DiscountDatabase();
        acctSys = new AccountingSystem();
        Controller contr = new Controller(invSys, disSys, acctSys);
        instanceToTest = new View(contr);
        
        printoutBuffer = new ByteArrayOutputStream();
        PrintStream inMemSysOut = new PrintStream(printoutBuffer);
        originalsysOut = System.out;
        System.setOut(inMemSysOut);
    }
    
    @AfterEach
    public void tearDown() {
        instanceToTest = null;
        printoutBuffer = null;
        invSys = null;
        disSys = null;
        acctSys = null;
        System.setOut(originalsysOut);
    }

    @Test
    public void testRunFakeExecution() {
        instanceToTest.runFakeExecution();
        String printout = printoutBuffer.toString();
        String expectedOutput = "started";
        assertTrue(printout.contains(expectedOutput), "UI did not start");
    }
    
}
