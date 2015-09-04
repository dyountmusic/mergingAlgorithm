/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergingalgorithm;

import java.util.Arrays;

/**
 *
 * @author danielyount
 */
public class MergingAlgorithm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        //Declare both arrays and populate them
        int[] arrayA = {1,2,3};
        int[] arrayB = {4,5,6};
        
        //Declare an empty array
        // This is where we will merge the two previous arrays into
        int[] arrayC = {0,0,0,0,0,0};
        
        //Declare a variable for the counter and initilize it as 0
        //This is because we will always start at the first value in each array
        int counterA = 0;
        int counterB = 0;
        int counterC = 0;
        
        // Until the array is finished keep going through
        while (counterA + counterB <= (arrayA.length + arrayB.length) ) {

            // Merge the arrays
            if (arrayA[counterA] <= arrayB[counterB]){
                //arrayA is the smaller number and therefore moved to the new array
                arrayC[counterC] = arrayA[counterA];
                //iterate the counterA because we moved from arrayA
                counterA ++;
                //iterate counter because we need to keep place of where we are in the new array
                counterC ++;
            } else {
                //arrayB is the smaller number and therefore moved to the new array
                arrayC[counterC] = arrayB[counterB];
                //iterate the counterB because we moved from arrayB
                counterB ++;
                //iterate counter because we need to keep place of where we are in the new array
                counterC ++;
            }
        
    }
        
        System.out.println(arrayC);
        
    } // end of main method
    
}
