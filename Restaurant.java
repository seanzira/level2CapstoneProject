//Restaurant class
public class Restaurant {
  private String name;
  private String location;
  private String contactNumber;

  public Restaurant(String name, String location, String contactNumber) {
	  this.name = name;  
	  this.location = location;  
	  this.contactNumber = contactNumber;  
  }

  //method for returning the restaurant's name
  public String getName() {  
	  return name;  
  }

  //method for returning the restaurant location
  public String getLocation() {  
	  return location;  
  }

  //method for returning the restaurant's contact number
  public String getContactNumber() {  
	  return contactNumber;  
  }
  
}