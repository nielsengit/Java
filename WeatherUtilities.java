import java.util.Scanner;

class WeatherUtilities {
  
  static int countGoodDays(double[] temperatures, boolean[] sunnyStatus) {
    
    int numberOfGoodDays = 0;
    
    if(temperatures.length != sunnyStatus.length) {
      throw new IllegalArgumentException();
    }
    else {
      for(int i = 0; i<temperatures.length; i++) {
        if (temperatures[i] > (-30) && sunnyStatus[i] == true) {
          numberOfGoodDays++;
        }
      }
    }
    return numberOfGoodDays;
  }
  static int countGoodDays(WeatherEntry[] weEnt) {
    
    int numberOfGoodDays = 0;
    
    for(int i = 0; i<weEnt.length; i++) {
      
      if (weEnt[i].isGoodWeather() == true) {
          numberOfGoodDays++;
      }
    }
    return numberOfGoodDays;
  }
  
  public static void main(String args[]) {
    int n = Integer.parseInt(args[0]);
    WeatherEntry[] weatherArray = new WeatherEntry[n];
    
    
      for(int i = 1; i<(n+1); i++) {
        Double temperature = null; //default unobtainable temperature value
        Boolean sunnyStatus = null; //default sunnyStatus w/ wapperClass 
        
        Scanner in = new Scanner(System.in);
        while (temperature == null) {
          System.out.println("Enter the temperature of day #" + i + ": ");
          try {
        temperature = in.nextDouble();
        }
        catch (java.util.InputMismatchException e) {
          System.out.println("Invalid input! Exception: " + e + " Please enter a valid number.");
          //Scanner in2 = new Scanner(System.in);
          //temperature =  in.next();
          in.next();
        }
      }
        while (sunnyStatus == null) {
          System.out.println("Enter the sunny status (true or false) of day #" + i + ": ");
          try{
          sunnyStatus = in.nextBoolean();
          }
          catch (java.util.InputMismatchException e) {
            System.out.println("Invalid input! Exception: " + e + " Please enter true or false");
            in.next();
       }
        }
        weatherArray[(i-1)] = new WeatherEntry(temperature, sunnyStatus);
      
    
    //catch (Exception e) {
      //System.out.println("Invalid input!" + e);
   }
    int numberOfGoodDays = countGoodDays(weatherArray);
    
    
    double highestTemp = getMaxTemp(weatherArray);
    double lowestTemp = getMinTemp(weatherArray);
    System.out.println("There were " + numberOfGoodDays + " nice days.");
    System.out.println("The highest temperature was " + highestTemp + " degrees Celsius and the lowest was " + lowestTemp + " degrees Celcius.");
    }
  
  private static double getMaxTemp(WeatherEntry[] weEnt) {
    double maxTemp = -30.0;
    for (int i = 0; i<weEnt.length; i++) {
      double tempVar = weEnt[i].getTemperatureCelsius();
      if(tempVar > maxTemp) {
        maxTemp = tempVar;
      }
      
    }
    return maxTemp;
  }
  private static double getMinTemp(WeatherEntry[] weEnt) {
    double minTemp = 30.0;
    
    for (int i = 0; i<weEnt.length; i++) {
      double tempVar = weEnt[i].getTemperatureCelsius();
      if(tempVar < minTemp) {
        minTemp = tempVar;
      }
    }
    return minTemp;
  }
}