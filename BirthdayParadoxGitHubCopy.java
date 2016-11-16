//import java.util.*;

class BirthdayParadoxGitHubCopy {
  static int[] generateArray(int size, int range) {
    int[] tempArray = new int[size];
    for (int i = 0; i<size; i++) {
      tempArray[i] = (int)(Math.random()*(range));
    }
    return tempArray;
  }

  static int[][] generateAllData(int iterations, int size, int range) {
    int[][] twoDArray = new int[iterations][]; //// Can change empty [] to SIZE if wanted
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
    int mostOccurrences = 1;
    int mode = 0;
    int i = 0;
   
    while (i<365) {
      int occurrences = countElement(arrays, i);
      if (occurrences > mostOccurrences) {
        mostOccurrences = occurrences;
        mode = i;
      }
      i++;
    }
    return mode;
  }
  static boolean hasDuplicates(int[] array) {  //Question #5
    int [][] oneToTwoDArray = new int[1][array.length];
    
    for (int i = 0; i < array.length; i++) {
      oneToTwoDArray[0][i] = array[i];// turn array into a 2D array. 
    }
    if(maxDay(oneToTwoDArray) != 0) { //if mode is not default value of 0, then an integer in the array has occured more than 1 time (>mostOccurrences). 
      return true;
    }
    else if (countElement(oneToTwoDArray, 0) > 1){ //If mode is default value of 0, check if 0 (jan 1st) occured more than once.
        return true;
    }
    else {
      return false; // if mode is 0 and the # of 0 occurrences is not greater than 1, there are no duplicates. 
    }
  }
   /* 
    ///THIS WORKS FOR FINDING DUPLICATES BUT DOESN'T USE OTHER PROGRAM METHODS.
    Set<Integer> set = new HashSet<Integer>();
    for ( int i = 0; i < array.length; i++ ) {
        if ( set.contains( array[i])) {
            return true;
        }
        else {
            set.add(array[i]); 
        }
    }
    return false;
    }
   */
  static double runExperiment(int size) {
    if (size < 1) {
      throw new IllegalArgumentException("Sub-array size cannot be less than 1");
    }
    int duplicateCounter = 0; //counts # of arrays with duplicats
    
    int[][] experimentArrays = generateAllData(200, size, 365); 
    for (int i = 0; i < experimentArrays.length; i++) { //for each array
      if ((hasDuplicates(experimentArrays[i])) == true) {  //if array has duplicates, increment duplicateCounter.
        duplicateCounter++;
      }
    }
    return ((double)duplicateCounter/(double)experimentArrays.length); 
  }
  
  public static void main(String args[]) {
    int size = 100; 
    for (int i = 1; i <= size; i++) {   //run experiment 100 times, incrementing the size argument each time. 
      double outcome = runExperiment(i); //store the outcome
      System.out.println(i + " " + outcome);
    }
  }
}