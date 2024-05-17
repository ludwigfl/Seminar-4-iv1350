package se.kth.iv1350.module4.integration;

/**
 *Exception that occurs if the item was not found in the inventory system
 * @author ludwigflodin, antonhammar
 */
public class ItemNotFoundException extends Exception {
    
    private int ID;
    
    public ItemNotFoundException(int ID){
        this.ID = ID;
    }
    
    /**
     * Exception message for the user
     * @return message
     */
    public String printExceptionMsg(){
        return "Item with identifier: (" + ID + ") not found";
    }
    
    /**
     * Exception message for the developer
     * @return message
     */
    public String printAdminMsg(){
        return "Item error - " + java.time.LocalDateTime.now() 
               + "\nIncorrect identifier used (" + ID+ ")\n" 
               + this.getStackTrace()[0].toString()
               + "\nEnd of log\n\n";
    }
}
