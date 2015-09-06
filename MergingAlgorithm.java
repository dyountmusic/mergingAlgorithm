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
        
        //Declareing both arrays and populate them
        //For the sake of this simple program we have hardcoded them in
        //Requirements: any positive or negative number in the int class
        //Must be sorted from least to greatest before program runs
        int[] arrayA = {2,2,6};
        int[] arrayB = {5,6,6};
        
        //Declare an array with places for each of the values to be added
        // This is where we will merge the arrayA and arrayB into
        int [] arrayC = new int[arrayA.length + arrayB.length];
        System.out.println("ArrayC before merging is " + Arrays.toString(arrayC));
        
        //Declare a variable for the counter and initilize it as 0
        int counterA = 0;
        int counterB = 0;
        int counterC = 0;
        
        //Test case for if you complete an array. 
        //If you have then just apend the rest of the remaining array to arrayC
        if (counterA == (arrayA.length-1)){
            arrayC[counterC] = arrayB[counterB];
            counterB++;
            counterC++;
                
        } else if (counterB == (arrayB.length-1)) {
            arrayC[counterC] = arrayA[counterA];
            counterA++;
            counterC++;
                
        }
        
        //Begin merge
        while (counterC < (arrayA.length + arrayB.length) - 1){

            System.out.println("ArrayC after merging is " + Arrays.toString(arrayC));
            System.out.println("Counter A is " + counterA);
            System.out.println("Counter B is " + counterB);
            System.out.println("Counter C is " + counterC);
            
            System.out.println("System is comparing " + arrayA[counterA] + " and " + arrayB[counterB] + ".");
             

            //Check if the value in arrayA[counterA] is equal to  value in arrayB[counterB]
            //Iterate the [counter] value each array is checking if that array has the lesser value and it's moved
            if (arrayA[counterA] == arrayB[counterB]){
                
                //Safeguard for index overflow by checking which counter has more room
                if (counterB > counterA){
                    arrayC[counterC] = arrayA[counterA];
                    counterA++;
                    counterC++;
                    
                } else {
                    arrayC[counterC] = arrayB[counterB];
                    counterB++;
                    counterC++;
                    
                }
            
            } else if (arrayB[counterB] <= arrayA[counterA]){
                arrayC[counterC] = arrayB[counterB];
                counterB++;
                counterC++;
                
            } else if (arrayA[counterA] <= arrayB[counterB]){
                //Assign arrayA[counterA] (smaller value) to arrayC[counterC]
                arrayC[counterC] = arrayA[counterA];
                //Iterate both counterA and counterC because we used it
                counterA++;
                counterC++;
            
            } else {
                //This should never run if the sorting is proper
                System.out.println("Error. The merging failed. Either the array is not an int or the wrong type.");
                
            }
            
            //This runs and appends the last number in the left over array
            arrayC[counterC] = arrayB[arrayB.length-1];
        }
        
        System.out.println("ArrayC after merging is " + Arrays.toString(arrayC));

    } // end of main method
    
}
