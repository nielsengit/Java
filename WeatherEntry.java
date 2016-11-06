class WeatherEntry {
  
  private double temperatureInCelsius;
  private boolean isSunny;
    
  public WeatherEntry(double temperatureInCelcius, boolean isSunny) { //is it best practice to match parameter names to the fields?
    this.temperatureInCelsius = temperatureInCelcius;
    this.isSunny = isSunny;
  }
    
  public double getTemperatureCelsius() {
    return this.temperatureInCelsius;
  }
  
  public boolean isGoodWeather() {
    if(isSunny == true && temperatureInCelsius > -30) {
      return true;
    }
    else {
      return false;
    }
  }
  public void display(boolean isCelsius) {
    double temp = 0.0; //declare temp variable to store typeOfTemp-dependent figure.
    String typeOfTemp = null;
    if (isCelsius == true) {
      temp = this.temperatureInCelsius;
      typeOfTemp = "Celcius";
    }
    else if (isCelsius == false) {
      temp = 32 + (this.temperatureInCelsius * 9 / 5);
      typeOfTemp = "Farenheight";
    }
    System.out.print("It is " + temp + " degrees " + typeOfTemp + ".");
    if (this.isSunny == true) {
    System.out.print("and is sunny.");
      if (this.isGoodWeather() == true) {
      System.out.println("It is a good day.");
      }
      else {
          System.out.println("It is not a good day.");
        }
     }
    else if (this.isSunny == false) {
      System.out.print("and is not sunny. It is not a good day.");
    }
  }
        // should I make temp & typeOfTemp an instance variable?
  }
