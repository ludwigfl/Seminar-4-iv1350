package se.kth.iv1350.module4.view;

import java.io.FileNotFoundException;
import java.io.PrintWriter;
import se.kth.iv1350.module4.model.Observer;

/**
 * Prints the total income to a file
 * @author ludwigflodin, antonhammar
 */
public class TotalRevenueFileOutput implements Observer{
        
        String filePath = "";
        double sum;
        
        /**
         * the constructor for initializing the TotalRevenueFileOutput and attributes
         */
        public TotalRevenueFileOutput(){
        sum = 0;
        filePath = "src/main/java/se/kth/iv1350/module4/integration/TotalRevenueOfSales.txt";  
    }
        /**
         * Uploads the files for the TotalRevenue to a file according to filePath
         * @param sum the sum of the cost of the sale
         */
    @Override
    public void updateSum(double sum){
        this.sum = sum;
        try{
            PrintWriter log = new PrintWriter(filePath);
            log.println("Total amount of all sales: " + sum + "\n");
            log.close();
        }catch(FileNotFoundException filException){
            System.err.println("Was unable to locate file in ->" + filePath);
            filException.printStackTrace();
        }
    }
}
