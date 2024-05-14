package se.kth.iv1350.module3.controller;

import se.kth.iv1350.module3.integration.AccountingSystem;
import se.kth.iv1350.module3.model.Sale;
import se.kth.iv1350.module3.integration.InventorySystem;
import se.kth.iv1350.module3.model.Receipt;
import se.kth.iv1350.module3.integration.DiscountDatabase;
import se.kth.iv1350.module3.model.Item;
import se.kth.iv1350.module3.model.ReceiptPrinter;
import se.kth.iv1350.module3.model.SaleDTO;


/**
 * Class of controller to handle layer communication
 * @author ludwigflodin, antonHammar
 */
public class Controller {
    private Sale sale;
    final private InventorySystem invSys;
    final private DiscountDatabase disSys;
    final private AccountingSystem acctSys;
    final private ReceiptPrinter printer;
    
    /**
     * Constructor of controller to create instance of controller
     * @param invSys the inventory system
     * @param disSys the discount system
     * @param acctSys the accounting system
     */
    public Controller(InventorySystem invSys, DiscountDatabase disSys, AccountingSystem acctSys){
       this.invSys = invSys;
       this.disSys = disSys;
       this.acctSys = acctSys;
       this.printer = new ReceiptPrinter();
   }
    
    /**
     * Request the discount from the discount database
     * @param customerId identifier of the customer
     */
    public void requestDiscount(int customerId){
        disSys.getDiscount(customerId);
    }
    
    /**
     * Creates sale object
     */
   public void startSale(){
       sale = new Sale();
   }
   
   /**
    * Gets the sale object
    * @return the sale
    */
   public Sale getSale(){
       return sale;
   }

   /**
    * Responsible for scanning item checks for item
    * @param itemId The items identifier
    * @param quantity The amount of a single type of item
    * @return the item in question
    */
    public Item scanItem(int itemId, int quantity){
        Item item = invSys.getFakeItem(itemId, quantity);
        sale.editItemList(item);
        return item;
    }
    
    
    /**
     * Handles all things necessary for end of sale 
     * @param payment the amount of money customer pays for sale
     * @return SaleInfo DTO
     */
    public SaleDTO endSale(double payment){
                
        sale.createSaleDTO(payment);
        sendSaleInformation();
        handleReceipt(payment);
        
        return sale.getSaleInfo();
    }
    
    /**
     * Handles all the things necessary for receipt 
     * @param payment the amount of money customer pays for sale
     */
    private void handleReceipt(double payment){
        Receipt receipt = getSale().getReceipt();
        receipt.update(sale.getSaleInfo().getitemList().getList(), payment, sale.getTotalVat());
        printer.printReceipt(receipt);
    }
    
    /**
     * Sends information of sale to external inventory and accounting system
     */
    private void sendSaleInformation(){    
        invSys.sendInformation(sale.getSaleInfo().getitemList().getList());
        acctSys.sendInformation(sale.getTotalWithVat()); 
    }
}
