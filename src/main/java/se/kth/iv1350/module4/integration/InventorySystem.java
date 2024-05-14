package se.kth.iv1350.module4.integration;

import java.util.List;
import se.kth.iv1350.module4.model.Item;

/**
 *
 * @author ludwigflodin, antonHammar
 */
public class InventorySystem {
    
    /**
     * 
     * @param itemId
     * @return 
     */
    public boolean itemExists(int itemId){
        return true;
    }
    
    /**
     * 
     * @param ID
     * @param quantity
     * @throws ItemNotFoundException
     * @throws DatabaseNotCalledException
     * @return 
     */
    public Item getFakeItem(int ID, int quantity) throws ItemNotFoundException, DatabaseNotCalledException{
        Item item;
        if (ID == 123){
           item = new Item(ID, 0.06, "Big oatmeal for the family", 59.99, "BigWheel Oatmeal", quantity);
           return item;
        }
        else if (ID == 321){
           item = new Item(ID, 0.03, "YouGoGo Blueberry for the family", 39.99, "YouGoGo Blueberry", quantity);
           return item;
        }
        else if(ID == 999){
            throw new DatabaseNotCalledException();
        }
        
        throw new ItemNotFoundException(ID);
    }
    
    /**
     * does nothing
     * @param itemList 
     */
    public void sendInformation(List<Item> itemList){
        //best method
    }
}
