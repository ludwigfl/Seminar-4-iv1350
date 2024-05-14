package se.kth.iv1350.module4.integration;

/**
 *
 * @author ludwigflodin, antonhammar
 */
public class ItemNotFoundException extends Exception {
    
    private int ID;
    
    public ItemNotFoundException(int ID){
        this.ID = ID;
    }
    
    public String printExceptionMsg(){
        return "Item with identifier: (" + ID + ") not found";
    }
    
    public String printAdminMsg(){
        return "Item error - " + java.time.LocalDateTime.now() 
               + "\nIncorrect identifier used (" + ID+ ")\n" 
               + this.getStackTrace()[0].toString()
               + "\nEnd of log\n\n";
    }
}
