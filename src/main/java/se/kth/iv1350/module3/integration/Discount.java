package se.kth.iv1350.module3.integration;

/**
 * The discount class which contains for discounts
 * @author ludwigflodin, antonHammar
 */
public class Discount {
   
    
    private double sumToBeReduced;
    private double percentageToBeReduced;
    
    /**
     * Constructor for the discount object which contains for discounts
     * @param sumToBeReduced the amount of money to be reduced from price
     * @param percentageToBeReduced the amount of percentage of the price to be removed
     */
    public Discount(double sumToBeReduced, double percentageToBeReduced){
         this.sumToBeReduced = sumToBeReduced;
         this.percentageToBeReduced = percentageToBeReduced;
         
     }
    
    /**
     * Gets the sum to be reduced from price
     * @return 
     */
    public double getsumToBeReduced(){
        return sumToBeReduced;
    }
    
    /**
     * Gets the percentage to be reduced from price
     * @return 
     */
    public double getpercentageToBeReduced(){
        return sumToBeReduced;
    }
}

