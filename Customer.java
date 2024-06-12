//Customer class
public class Customer {
  //attributes
  private String customerName;
  private String customerNumber;
  private String customerAddress;
  private String customerLocation;
  private String customerEmail;

  public Customer(String customerName, String customerNumber, String customerAddress, String customerLocation, String customerEmail) {
	  this.customerName = customerName;
	  this.customerNumber = customerNumber;
	  this.customerAddress = customerAddress;
	  this.customerLocation = customerLocation;
	  this.customerEmail = customerEmail;  
  }

  //method for returning the name
  public String getCustomerName() {
	  return customerName;  
  }

  //method for returning the contact number
  public String getCustomerNumber() {
	  return customerNumber;  
  }

  //method for returning the address
  public String getCustomerAddress() {
	  return customerAddress;  
  }

  //method for returning the location
  public String getCustomerLocation() {
	  return customerLocation;  
  }

  //method for returning the email
  public String getCustomerEmail() {  
	  return customerEmail;  
  }
  
}
