import java.util.ArrayList;
import java.util.List;
import java.util.Arrays;  
import java.util.concurrent.TimeUnit;

class BirthdayParadox {
  static int[] generateArray(int size, int range) {
    int[] tempArray = new int[size];
    for (int i = 0; i<size; i++) {
      tempArray[i] = ((int)(Math.random()*((range-1) - 0)));
    }
    /*System.out.println(Arrays.toString(tempArray));
    try {
    Thread.sleep(1000);                 //1000 milliseconds is one second.
} catch(InterruptedException ex) {
    Thread.currentThread().interrupt();
}  */
    return tempArray;
  }

  static int[][] generateAllData(int iterations, int size, int range) {
    int[][] twoDArray = new int[iterations][];
    for (int i = 0; i < iterations; i++) {
      int[] subArray = generateArray(size, range); //not declaring new array (only storing existing) tf no 'new' keyword required
      twoDArray[i] = subArray;
    }
    return twoDArray;
    
  }
  
  static int countElement(int[][] arrays, int element) {
   int counter = 0;
    for (int i = 0; i<arrays.length; i++) {
      for (int j = 0; j<arrays[i].length; j++) {
        if (arrays[i][j] == element) {
          counter++;
        }
      }
    }
    return counter;
  }
  static int maxDay(int[][] arrays) {
    //System.out.println(Arrays.deepToString(arrays)); //TESTTT
    
    List<Integer> elementsChecked = new ArrayList<Integer>();
    //int mode = 365;
    int mode = 0;
    int highestcount = 0;
    
    for (int i = 0; i<arrays.length; i++) { //for each array
      for (int j = 0; j<arrays[i].length; j++){ //for each element in each array
        int element = arrays[i][j];             //store the element
        int k = 0;
        while (k < elementsChecked.size()) { //compare the element to elementsChecked
          if (element != elementsChecked.get(k)) { //if the current element has not already been checked/counted
            elementsChecked.add(element);       // add the element to elementsChecked
            int count = countElement(arrays, element);  //count the times the element occurs
            if (count >= highestcount) {                 //if it occurs more than highestcount, it's the mode.
              mode = element;
              highestcount = count;
            }
           }
          k++; 
        }
      }
      
    }
   /* if (mode == 365) {   /// QUESTION: What's the best way to initialize mode? if int mode = 0, then this could be a valid birthday. Is that okay? or better to initialize a non-zero value
        System.out.println("error calculating mode"); //...in case int mode was not updated. 
        return mode ;
      }
      else { */  
        return mode;
   // } 
  }
  static boolean hasDuplicates(int[] array) {  //Question #5
    
    /*for (int i = 0; i < int[].length; i++) {
      tempElement = array[i];
      for (int j = 0; j<int[].length; j++) {
        
        if (tempElement == array[j]) {
        */
    int[][] arrayOfArray = new int[1][];  //create 2d array. Put array into element 1 of it.
    arrayOfArray[0] = array;
   // System.out.println(Arrays.deepToString(arrayOfArray)); 
      int mode = maxDay(arrayOfArray);    // therefore we can call maxDay & countElement
      int modeCount = countElement(arrayOfArray, mode);
      if (modeCount > 0) {                  // Quesiron: Do we want to return a boolean?
        return true;
      }
       return false;
    }
  static double runExperiment(int size) {
    if (size < 1) {
      throw new IllegalArgumentException("Sub-array size cannot be less than 1");
    }
    int duplicateCounter = 0;
    int[][] experimentArrays = generateAllData(200, 5, 365);
    for (int i = 0; i < experimentArrays.length; i++) {
      if (hasDuplicates(experimentArrays[i]) == true) {
        duplicateCounter++;
      }
    }
    //System.out.println("array number + counter " + experimentArrays.length + " " + duplicateCounter);
    return ((double)duplicateCounter/(double)experimentArrays.length);
  }
  
  public static void main(String args[]) {
    int size = Integer.parseInt(args[0]);
    if (size > 100) {
      System.out.println("The input size is too large. Please input a value less than or equal to 100");
    }
    else {
      for (int i = 0; i < 100; i++) {
        double outcome = runExperiment(size);
        System.out.println(i + " " + outcome);
   }
   }
}
}
  


