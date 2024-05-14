package se.kth.iv1350.module3.view;

import se.kth.iv1350.module3.controller.Controller;
import se.kth.iv1350.module3.model.Item;
import se.kth.iv1350.module3.model.SaleDTO;


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
        Item item;
        contr.startSale();
        System.out.println("A new sale has been started. \n");
        item = contr.scanItem(123, 2); //123 temp itemID, 2 temp number of item
        System.out.println(item.toString()); //Leif approved of this method :)
        item = contr.scanItem(321, 5); //123 temp itemID, 2 temp number of item
        System.out.println(item.toString()); //Leif approved of this method :)
        contr.requestDiscount(1); //1 temp customerId
        SaleDTO saleInfo = contr.endSale(payment);
        System.out.println(saleInfo.toString()); //Leif approved of this method :)
    }
    
    
}
