package se.kth.iv1350.module4.view;

import java.io.FileWriter;
import java.io.IOException;
import java.text.DecimalFormat;
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
      * formats the item info to a string
      * @return the string with the item info
      */
     private String toStringItem(Item item){
         final DecimalFormat decfor = new DecimalFormat("0.00");
         
         return "Add " + item.getQuantity() + " item(s) with item id " + item.getID() + ":"
         +"\nItem ID: " + item.getID()  
         +"\nItem name: " + item.getName() 
         +"\nItem cost: " + item.getPrice() + " SEK"
         +"\nVat: " + item.getVAT()*100+ "%"
         +"\nItem description: " + item.getDesc()
         +"\nTotal cost ( incl VAT ): " + decfor.format(item.getItemTotalPrice() + item.getVatPrice()) + " SEK" 
         +"\nTotal VAT: " + decfor.format(item.getVatPrice()) + " SEK\n";
     }
     
     /**
     * formats the end sale info to a string
     * @return the string for printout of the end sale info
     */
    public String toStringSale(SaleDTO saleInfo){
        DecimalFormat decfor = new DecimalFormat("0.00");
        return 
        "End sale:"
        +"\nTotal cost ( incl VAT ): " + decfor.format(saleInfo.getTotal() + saleInfo.getTotalVAT())  + " SEK"
        +"\nCustomer pays " + decfor.format(saleInfo.getPayment()) + " SEK"
        +"\nTold external inventory system to decrease inventory quantity of items"
        +"\nSent sale info to external accounting system.";
    }
    
    /**
     * runs a fake execution of a sale
     */
    public void runFakeExecution(){
        
        try{
        
        
        contr.startSale(new TotalRevenueView(), new TotalRevenueFileOutput());
        System.out.println("A new sale has been started. \n");
       
        scanItem(123, 1); //123 temp itemID, 2 temp number of item
        
        
        scanItem(321, 3); //123 temp itemID, 2 temp number of item
        
        contr.requestDiscount(1); //1 temp customerId
        SaleDTO saleInfo = contr.endSale(payment);
        System.out.println(toStringSale(saleInfo)); //Leif approved of this method :)
        
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
        System.out.println(toStringItem(item));//Leif approved of this method :)
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
