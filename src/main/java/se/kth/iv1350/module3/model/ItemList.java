package se.kth.iv1350.module3.model;
import java.util.ArrayList;
import java.util.List;
/**
 *The class for the list of items in the sale 
 * @author ludwigflodin, antonHammar
 */
public class ItemList {
   final private List<Item> listOfItems = new ArrayList<>(); 
    
   /**
    * Gets the item from the list based on item id 
    * @param itemId the identifier of a specific type of item
    * @return the wanted item it found or null if item isn't found
    */
    public Item getItem(int itemId){
        for(Item item : listOfItems){
            if(itemId == item.getID()){
              return item;
            }
        }
        return null;
    }
    
    /**
     * Adds the specific item to the list 
     * @param item the specific type of item
     */
    public void addItem(Item item){
        listOfItems.add(item);
    }
    
    /**
     * Gets the list of items 
     * @return the list of items
     */
    public List<Item> getList(){
        return listOfItems;
    }
    
    /**
     * increase the quantity of the specific item that is looked for 
     * @param item the item that is looked for
     */
    public void increaseQuantityOfItem(Item item){
        for(Item itemInList : listOfItems){
            if(itemInList.getID() == item.getID()){
                itemInList.increaseQuantity(item.getQuantity());
           }
        }
    }
    
    /**
     * checks if item exists in list
     * @param item the item which is looked for
     * @return true if exists, false if not exists
     */
    public boolean checkforId(Item item){
        item = getItem(item.getID());
        return item != null; 
    }
}
