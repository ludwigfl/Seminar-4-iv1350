package se.kth.iv1350.module4.integration;

/**
 *
 * @author ludwigflodin
 */
public class DatabaseNotCalledException extends Exception {
    
    public String printExceptionMsg(){
        return "Servers are down, oopsie, try again!";
    }
    
    public String printAdminMsg(){
        return "Database error - " + java.time.LocalDateTime.now() 
               + "\nDatabase for the inventory system cannot be reached\n" 
               + this.getStackTrace()[0].toString()
               + "\nEnd of log\n\n";
    }
    
}
