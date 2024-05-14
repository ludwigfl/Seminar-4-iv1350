package se.kth.iv1350.module4.model;

/**
 * interface for handling keeping track of the total sum of all sales
 * @author ludwigflodin, antonhammar
 */
public interface Observer {
    
    /**
     * updates the total running sum of all total costs for all sales 
     * @param sum the running sum from the latest accumulative sale costs
     */
    void updateSum(double sum);
    
    
}
