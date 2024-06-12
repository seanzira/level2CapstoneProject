//Driver class
public class Driver {
  private String driverName;
  private String driverLocation;
  private int load;

  public Driver(String driverName, String driverLocation, int load) {  
	  this.driverName = driverName;  
	  this.driverLocation = driverLocation;
	  this.load = load;  
  }

  //method for returning driver name
  public String getDriverName() {  
	  return driverName;  
  }

  //method for returning driver location
  public String getDriverLocation() {  
	  return driverLocation;  
  }

  //method for returning driver load
  public int getLoad() {  
	  return load;  
  }
  
}
