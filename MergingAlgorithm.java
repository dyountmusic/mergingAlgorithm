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
        int[] arrayA = {-2,4,8};
        int[] arrayB = {1,7,9};
        
        //Declare an array with places for each of the values to be added
        // This is where we will merge the two previous arrays into
        int [] arrayC = new int[arrayA.length + arrayB.length];
        System.out.println("ArrayC before merging is " + Arrays.toString(arrayC));
        
        //Declare a variable for the counter and initilize it as 0
        int counterA = 0;
        int counterB = 0;
        int counterC = 0;
        
        //Begin merge
        while (counterC < (arrayA.length + arrayB.length) - 1){

            System.out.println("ArrayC after merging is " + Arrays.toString(arrayC));
            System.out.println("Counter A is " + counterA);
            System.out.println("Counter B is " + counterB);
            System.out.println("Counter C is " + counterC);
             
            //Test case for if you complete
            if (counterA == (arrayA.length-1)){
                arrayC[counterC] = arrayB[counterB];
                counterB++;
                counterC++;
            } else if (counterB == (arrayB.length-1)) {
                arrayC[counterC] = arrayA[counterA];
                counterA++;
                counterC++;
            }
            
            //Check if the value in arrayA[0] are smaller than the value in arrayB[0]
            //Iterate the [counter] value each array is checking if that array has the lesser value and it's moved
            if (arrayA[counterA] <= arrayB[counterB]){
                //Assign arrayA[counterA] (smaller value) to arrayC[counterC]
                arrayC[counterC] = arrayA[counterA];
                //Iterate both counterA and counterC because we used it
                counterA++;
                counterC++;
            
            } else if (arrayB[counterB] <= arrayA[counterA]){
                arrayC[counterC] = arrayB[counterB];
                counterB++;
                counterC++;
                
            } else {
                System.out.println("Catch this exception, please");
                
            }
            //Appending the last number
            //Hardcoded
            arrayC[counterC] = arrayB[arrayB.length-1];
            System.out.println("While has completed a loop.");
            
        }
        
        System.out.println("ArrayC after merging is " + Arrays.toString(arrayC));
        System.out.println("This ran.");
        
        
        
    } // end of main method
    
}
