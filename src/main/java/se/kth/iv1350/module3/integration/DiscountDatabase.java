package se.kth.iv1350.module3.integration;

import se.kth.iv1350.module3.integration.Discount;

/**
 *
 * @author ludwigflodin, antonHammar
 */
public class DiscountDatabase {
   
    
    /**
     * returns the discount based on customerId
     * @param customerId the customers personal code
     * @return new discount
     */
    public Discount getDiscount(int customerId){
        return new Discount(20, 0.9);
    }
}
