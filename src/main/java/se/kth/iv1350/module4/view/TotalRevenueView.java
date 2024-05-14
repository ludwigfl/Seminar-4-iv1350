package se.kth.iv1350.module4.view;

import se.kth.iv1350.module4.model.Observer;

/**
 *TotalRevenueView shows the total income on the user interface
 * @author ludwigflodin, antonhammar
 */
public class TotalRevenueView implements Observer {
    
    private double totalAmountPaid;
    
    /**
     * constructor for initializing TotalRevenueView and attribute 
     */
    public TotalRevenueView(){
        double totalAmountPaid = 0;
    }
    
    /**
     * updates the TotalAmountPaid with the sum of the cost
     * @param sum the sum of the cost 
     */
    @Override
    public void updateSum(double sum){
        totalAmountPaid += sum;
        
        System.out.println("Total amount of all sales: " + totalAmountPaid);
    }
}
