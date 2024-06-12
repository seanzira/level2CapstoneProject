//Restaurant class
public class Restaurant {
  private String restaurantName;
  private String restaurantLocation;
  private String restaurantNumber;

  public Restaurant(String restaurantName, String restaurantLocation, String restaurantNumber) {
	  this.restaurantName = restaurantName;  
	  this.restaurantLocation = restaurantLocation;  
	  this.restaurantNumber = restaurantNumber;  
  }

  //method for returning the restaurant's name
  public String getRestaurantName() {  
	  return restaurantName;  
  }

  //method for returning the restaurant location
  public String getRestaurantLocation() {  
	  return restaurantLocation;  
  }

  //method for returning the restaurant's contact number
  public String getRestaurantNumber() {  
	  return restaurantNumber;  
  }
  
}
