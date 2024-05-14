package se.kth.iv1350.module4.view;

import java.io.FileWriter;
import java.io.IOException;
import se.kth.iv1350.module4.controller.Controller;
import se.kth.iv1350.module4.integration.ItemNotFoundException;
import se.kth.iv1350.module4.integration.DatabaseNotCalledException;
import se.kth.iv1350.module4.model.Item;
import se.kth.iv1350.module4.model.SaleDTO;


/**
 * The view class, represents the user interface
 * @author ludwigflodin, antonHammar
 */
public class View {
     
    final private Controller contr;
    double payment;
    
    /**
     * Constructor that creates the instance of view 
     * @param contr controller variable which handles communication between layers
     */
    public View( Controller contr){
        this.contr = contr;
        payment = 400;
    }
    
    /**
     * runs a fake execution of a sale
     */
    public void runFakeExecution(){
        
        try{
        
        
        contr.startSale();
        System.out.println("A new sale has been started. \n");
       
        scanItem(888, 2); //123 temp itemID, 2 temp number of item
        
        
        scanItem(999, 5); //123 temp itemID, 2 temp number of item
        
        contr.requestDiscount(1); //1 temp customerId
        SaleDTO saleInfo = contr.endSale(payment);
        System.out.println(saleInfo.toString()); //Leif approved of this method :)
        
        }catch(IOException ioE){
            ioE.printStackTrace();
        }
    } 

    private void scanItem(int itemId, int quantity)throws IOException{
        FileWriter fileLogger = null;
        fileLogger = new FileWriter("src/main/java/se/kth/iv1350/module4/integration/ErrorLog.txt", true);  
        Item item;
        
        try{
        item = contr.scanItem(itemId, quantity); //123 temp itemID, 2 temp number of item
        System.out.println(item.toString());//Leif approved of this method :)
        }catch(ItemNotFoundException itemException){ 
           System.err.println(itemException.printExceptionMsg());
           fileLogger.write(itemException.printAdminMsg());
        }catch(DatabaseNotCalledException dbasException){
            System.err.println(dbasException.printExceptionMsg()); 
            fileLogger.write(dbasException.printAdminMsg());
        }
        fileLogger.close();
    }
}
