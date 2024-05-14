package se.kth.iv1350.module3.model;
import java.text.DecimalFormat;

/**
 *Class for specific item, a type of product in the store 
 * @author ludwigflodin, antonHammar
 */
public class Item {
    private String name;
    private double price;
    private String desc;
    private int ID;  
    private double VAT;
    private int quantity;
    
    /**
     * Constructor for specific item, a type of product in the store
     * @param itemId the item's identifier
     * @param VAT the item's vat 
     * @param desc the item's description
     * @param price the item's price 
     * @param name the item's name
     * @param quantity the amount of the item
     */
    public Item(int itemId, double VAT, String desc, double price, String name, int quantity){
        this.ID = itemId;
        this.name = name;
        this.price = price;
        this.VAT = VAT;
        this.desc = desc;
        this.quantity = quantity;
    }
    
    /**
     * gets the name of the item
     * @return name
     */
    public String getName(){
        return name;
    }
    
    /**
     * Gets the price of the item
     * @return the price of item
     */
    public double getPrice(){
        return price;
    }
    
    /**
     * gets the items description
     * @return desc
     */
    public String getDesc(){
        return desc;
    }
    
    /**
     * gives the total price of all items of that type
     * @return price*quantity
     */
    public double getItemTotalPrice(){
        return price*quantity;
    }
    
    /**
     * gets item price with VAT 
     * @return price*VAT
     */
    public double getVatPrice(){
        return price*VAT*quantity;
    }
    
    /**
     * Gets the vat of the item
     * @return the vat of the item
     */
    public double getVAT(){
        return VAT;
    }
    
    /**
     * get vat of item in integer value, only used for formatting purposes
     * @return vat*100
     */
    public double getVatForPrintOut(){
        return VAT*100;
    }
    
    /**
     * Gets the quantity of an item in list 
     * @return the amount of items
     */
    public int getQuantity(){
        return quantity;
    }
    
    /**
     * gets the id of the item
     * @return the id of the item
     */
     public int getID(){
        return ID;
    }
     /**
      * increases the quantity of the specific type of item
      * @param amount the amount of the type of item
      */
     public void increaseQuantity(int amount){
         quantity = quantity + amount;
     }  
     /**
      * formats the item info to a string
      * @return the string with the item info
      */
     @Override
     public String toString(){
         final DecimalFormat decfor = new DecimalFormat("0.00");
         
         return "Add " + quantity + " item(s) with item id " + ID + ":"
         +"\nItem ID: " + ID 
         +"\nItem name: " + name
         +"\nItem cost: " + price + " SEK"
         +"\nVat: " + VAT*100+ "%"
         +"\nItem description: " + desc
         +"\nTotal cost ( incl VAT ): " + decfor.format(price*quantity + price*VAT*quantity) + " SEK" 
         +"\nTotal VAT: " + decfor.format(price*VAT*quantity) + " SEK\n";
     }
}
