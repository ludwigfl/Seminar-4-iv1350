package se.kth.iv1350.module3.model;

import java.time.LocalDate;
import java.time.LocalTime;
import java.text.DecimalFormat;
/**
 *
 * @author ludwigflodin, antonHammar
 */
public class SaleDTO {
    
    public ItemList itemList = new ItemList();
    private LocalTime saleTime;
    private LocalDate saleDate;
    private Receipt receipt;
    private double total;
    private double totalVAT;
    private double payment;
    
    public SaleDTO(ItemList itemList, LocalTime saleTime, LocalDate saleDate, double total, double totalVAT, double payment) {
       
        for(Item item : itemList.getList()){
            this.itemList.addItem(item);
        }
       
        this.saleTime = saleTime;
        this.saleDate = saleDate;
        this.total = total;
        this.totalVAT = totalVAT;  
        this.payment = payment;
    }  
    
    /**
     * getter for itemList
     * @return itemList
     */
    public ItemList getitemList(){
        return itemList;
    }
    
    /**
     * getter for running total
     * @return running total
     */
    public double getTotal(){
        return total;
    }
    
    /**
     * getter for the RT's vat
     * @return RT's vat
     */
    public double getTotalVAT(){
        return totalVAT;
    }
    
    /**
     * formats the end sale info to a string
     * @return the string for printout of the end sale info
     */
    @Override
    public String toString(){
        DecimalFormat decfor = new DecimalFormat("0.00");
        return 
        "End sale:"
        +"\nTotal cost ( incl VAT ): " + decfor.format(total + totalVAT)  + " SEK"
        +"\nCustomer pays " + decfor.format(payment) + " SEK"
        +"\nTold external inventory system to decrease inventory quantity of items"
        +"\nSent sale info to external accounting system.";
    }
}
