package se.kth.iv1350.module4.integration;

/**
 *Exception that occurs if the program could not reach the inventory system
 * @author ludwigflodin
 */
public class DatabaseNotCalledException extends Exception {
    
    /**
     * Exception message for the user
     * @return message
     */
    public String printExceptionMsg(){
        return "Servers are down, oopsie, try again!";
    }
    
    /**
     * Exception message for the developer
     * @return message
     */
    public String printAdminMsg(){
        return "Database error - " + java.time.LocalDateTime.now() 
               + "\nDatabase for the inventory system cannot be reached\n" 
               + this.getStackTrace()[0].toString()
               + "\nEnd of log\n\n";
    }
    
}
