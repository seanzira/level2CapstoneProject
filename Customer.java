//Customer class
public class Customer {
  //attributes
  private String name;
  private String contactNumber;
  private String address;
  private String location;
  private String email;

  public Customer(String name, String contactNumber, String address, String location, String email) {
	  this.name = name;
	  this.contactNumber = contactNumber;
	  this.address = address;
	  this.location = location;
	  this.email = email;  
  }

  //method for returning the name
  public String getName() {
	  return name;  
  }

  //method for returning the contact number
  public String getContactNumber() {
	  return contactNumber;  
  }

  //method for returning the address
  public String getAddress() {
	  return address;  
  }

  //method for returning the location
  public String getLocation() {
	  return location;  
  }

  //method for returning the email
  public String getEmail() {  
	  return email;  
  }
  
}