//Driver class
public class Driver {
  private String name;
  private String location;
  private int load;

  public Driver(String name, String location, int load) {  
	  this.name = name;  
	  this.location = location;
	  this.load = load;  
  }

  //method for returning driver name
  public String getName() {  
	  return name;  
  }

  //method for returning driver location
  public String getLocation() {  
	  return location;  
  }

  //method for returning driver load
  public int getLoad() {  
	  return load;  
  }
  
}
