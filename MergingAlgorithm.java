/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mergingalgorithm;

import java.util.Arrays;
import java.util.*;

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
        int[] arrayA = {-1,2,9};
        int[] arrayB = {2,3,3,5,6};
        
        //Calling the method on arrayA and arrayB
        int [] resultArray = mergeArrays(arrayA, arrayB);
        
        System.out.println("Your new array is " + Arrays.toString(resultArray));

    } // end of main method
    
    public static int[] mergeArrays(int[] arrayA, int[] arrayB) {
        
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
                System.out.println("Error. The merging failed. Either the array is not the correct type (int) or there is somethign else wrong here.");
                
            }
            
            //Figure out which array is left over
            //Take the last value and apend it
            
            if (counterA == arrayA.length - 1){
                arrayC[counterC] = arrayA[arrayA.length -1];
            } else if (counterB == arrayB.length - 1){
                arrayC[counterC] = arrayB[arrayB.length -1];
            }
        }
        
        System.out.println("ArrayC after merging is " + Arrays.toString(arrayC));
        
        return arrayC;
} // end of mergeArrays method
    
    public static int randInt(int min, int max) {

    // Usually this can be a field rather than a method variable
    Random rand = new Random();

    // nextInt is normally exclusive of the top value,
    // so add 1 to make it inclusive
    int randomNum = rand.nextInt((max - min) + 1) + min;

    return randomNum;
} //end of randInt method
    
}
