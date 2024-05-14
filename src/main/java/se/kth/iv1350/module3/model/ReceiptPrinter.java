package se.kth.iv1350.module3.model;

import java.text.DecimalFormat;
import java.time.LocalTime;

/**
 *Class for printing the receipt of the sale
 * @author ludwigflodin, antonHammar
 */
public class ReceiptPrinter {
    private static final DecimalFormat decfor = new DecimalFormat("0.00");  

    /**
     * Prints the receipt
     * @param receipt the receipt with all the sale information
     */
    public void printReceipt(Receipt receipt){
        LocalTime time = receipt.getTime();
        time = time.plusMinutes(1).minusNanos(1).withSecond(0).withNano(0);
        
        System.out.println("------------------------------------ Begin receipt ------------------------------------");
        System.out.println("Time of Sale: " + receipt.getDate().toString() + " " + time.toString());
        
        for(Item item : receipt.getItemList()){
           System.out.println(item.getName() + "        " + item.getQuantity() + " x " + item.getPrice() + "   " + decfor.format(item.getItemTotalPrice()) + " SEK");
        }
        
         System.out.println("Total: " + decfor.format(receipt.getTotalVatPrice()) + " SEK");
         System.out.println("VAT: " + decfor.format(receipt.getTotalVat()) + " SEK");
         System.out.println("Cash: " + receipt.getPayment() + " SEK");
         System.out.println("Change: " + decfor.format(receipt.getChange()) + " SEK");
         System.out.println("------------------------------------ End receipt ------------------------------------");
         System.out.println("Change to give to customer: " + decfor.format(receipt.getChange()) + " SEK\n");
         
    }
}
