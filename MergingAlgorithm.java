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
        
        //Create a variable to randomiz the size of the arrays created
        int sizeOfArray = randInt(3, 10);
        
        //Declare an array with the randomized size
        int[] randomArray = new int[sizeOfArray];
        int[] randomArray2 = new int[sizeOfArray];
        
        //Loop through each array and place a new randomized integer in
        for (int i = 0; i < sizeOfArray; i++){
            int number = randInt(1,9);
            int number2 = randInt(1,9);
            randomArray[i] = number;
            randomArray2[i] = number2;
        }
        
        //Sort each array ensuring that the resulting array is sorted from small to large
        Arrays.sort(randomArray);
        Arrays.sort(randomArray2);
        
        //Report the size of the array to the console
        //Also report the randomized values in each array
        System.out.println("RandomArray contains " + sizeOfArray + " elements and those elements are " + Arrays.toString(randomArray));
        System.out.println("RandomArray2 contains " + sizeOfArray + " elements and those elements are " + Arrays.toString(randomArray2));
        
        //Call the mergeArrays method which takes two arrays (in this case two random arrays created above) and returns one array which is a merged array
        int [] resultArray = mergeArrays(randomArray, randomArray2);
         
        //Report the resuting array
        System.out.println("Your result array is " + Arrays.toString(resultArray));
        

        //Commented out for use of randomArrays
        //These are hardcoded values for testing
        /**
        int[] arrayA = {-1,2,9};
        int[] arrayB = {2,3,3,5,6};
        
        //Calling the method on arrayA and arrayB
        int [] resultArray = mergeArrays(arrayA, arrayB);
        
        System.out.println("Your new array is " + Arrays.toString(resultArray));
        */

    } // end of main method
    
    public static int[] mergeArrays(int[] arrayA, int[] arrayB) {
        
        //Declare an array with places for each of the values to be added
        // This is where we will merge the arrayA and arrayB into
        int [] arrayC = new int[arrayA.length + arrayB.length];
        
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
        
        //Begin merge loop
        while (counterC < (arrayA.length + arrayB.length) - 1){
            
            //Check if the value in arrayA[counterA] is equal to  value in arrayB[counterB]
            //Iterate the [counter] value each array is checking if that array has the lesser value and it's moved
            if (arrayA[counterA] == arrayB[counterB]){
                
                //Safeguard for index overflow by checking which counter has more room
                if (counterB > arrayA.length-1){
                    arrayC[counterC] = arrayA[counterA];
                    counterA++;
                    counterC++;
                    
                } else {
                    arrayC[counterC] = arrayB[counterB];
                    counterB++;
                    counterC++;
                }
            
            //Check if the value in arrayB is less than or equal to the value in arrayA
            } else if (arrayB[counterB] < arrayA[counterA]){
                arrayC[counterC] = arrayB[counterB];
                counterB++;
                counterC++;
                
            //Check if the value in arrayA is less than or equal to the value in arrayB    
            } else if (arrayA[counterA] < arrayB[counterB]){
                arrayC[counterC] = arrayA[counterA];
                counterA++;
                counterC++;
            
            } else {
                //This should never run if the merging method executes without error
                System.out.println("Error. The merging failed. Either the array is not the correct type (int) or there is somethign else wrong here.");
                
            }
            
            //Figure out which array is left over
            //Take the remaining values and apend it
            
            //Something fishy is going on in this looping process causing an index out of bounds error
            //Probably need to impliment a loop which ensures that if two values are left over you apend both instead of stopping at one
            if (counterA == arrayA.length - 1){
                arrayC[counterC] = arrayA[arrayA.length -1];
            } else if (counterB == arrayB.length - 1){
                arrayC[counterC] = arrayB[arrayB.length -1];
            }
        }
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
