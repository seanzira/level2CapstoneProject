import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class InvoiceGenerated {
  public static void main(String[] args) throws IOException {
	  Scanner scanner = new Scanner(System.in);

	  // Capture customer details
	  Customer customer = createCustomer(scanner);

	  // Capture restaurant details
	  Restaurant restaurant = createRestaurant(scanner);

	  // Read drivers from file
	  Driver[] drivers = readDrivers("src/driver-info.txt");

	  // Find nearest driver
	  Driver nearestDriver = findNearestDriver(customer, drivers);

	  // Generate invoice
	  String invoice = generateInvoice(customer, restaurant, nearestDriver);

	  // Write invoice to file
	  writeInvoice(invoice, "src/invoice.txt");

	  System.out.println("Invoice created successfully!");
	  scanner.close();

  }

  /*
  * method for writing the information received by the user into the invoice file
  */
  private static void writeInvoice(String invoice, String file) throws IOException {
	  FileWriter writer = null;
	  try {
		  // Create FileWriter object for the specified file
		  writer = new FileWriter(file);

		  // Write the invoice to the file
		  writer.write(invoice);

	  } finally {
		  // Ensure the writer is closed even if an exception occurs
		  if (writer != null) {
			  try {
				  writer.close();
			  } catch (IOException e) {
				  // Log or handle the exception
				  e.printStackTrace();

			  }

		  }

	  }

  }

  /*
  * method for creating the customer object using the user's input
  */
  private static Customer createCustomer(Scanner scanner) {
	  System.out.println("Enter customer details:");

	  System.out.print("Name: ");
	  String customerName = scanner.nextLine();

	  System.out.print("Contact number: ");
	  String customerNumber = scanner.nextLine();

	  System.out.print("Address: ");
	  String customerAddress = scanner.nextLine();

	  System.out.print("Location (city): ");
	  String customerLocation = scanner.nextLine();

	  System.out.print("Email address: ");
	  String customerEmail = scanner.nextLine();

	  return new Customer(customerName, customerNumber, customerAddress, customerLocation, customerEmail);
	  
  }

  // method for creating the restaurant class using the user input
  private static Restaurant createRestaurant(Scanner scanner) {
	  System.out.println("Enter restaurant details:");

	  System.out.print("Name: ");
	  String restaurantName = scanner.nextLine();

	  System.out.print("Location (city): ");
	  String restaurantLocation = scanner.nextLine();

	  System.out.print("Contact number: ");
	  String restaurantNumber = scanner.nextLine();

	  return new Restaurant(restaurantName, restaurantLocation, restaurantNumber);

  }

  // method for reading the drivers file
  private static Driver[] readDrivers(String fileName) throws IOException {
	  BufferedReader reader = null;
		
	  try {
		  
		  // Open the file for reading
		  reader = new BufferedReader(new FileReader(fileName));

		  // Count the number of drivers in the file
		  int numDrivers = 0;
		  String line;

		  //Read each line from the reader until there are no more lines (null),
		  //incrementing the number of drivers for each line read
		  while ((line = reader.readLine()) != null) {
			  numDrivers++;
		  }

		  // Close the file
		  reader.close();

		  // Reopen the file for reading
		  reader = new BufferedReader(new FileReader(fileName));

		  // Create an array to store the drivers
		  Driver[] drivers = new Driver[numDrivers];
		  int i = 0;

		  // Read each line from the file and parse driver information
		  while ((line = reader.readLine()) != null) {
				
			  // Split the line into parts
			  String[] parts = line.split(",");

			  // Extract name, location, and load from the parts
			  String driverName = parts[0].trim();
			  String driverLocation = parts[1].trim();
			  int load = Integer.parseInt(parts[2].trim());

			  // Create a new Driver object and add it to the array
			  drivers[i++] = new Driver(driverName, driverLocation, load);

		  }

		  // Return the array of drivers
		  return drivers;

	  } finally {
		  // Ensure the reader is closed even if an exception occurs
		  if (reader != null) {
			  try {
				  reader.close();
				  } catch (IOException e) {
					  // Log or handle the exception
					  e.printStackTrace();
				  }
		
		  }
		
	  }
	
  }

  /* Method for finding the nearest driver based on customer's location. */
  private static Driver findNearestDriver(Customer customer, Driver[] drivers) {

	  Driver nearestDriver = null;
	  int minLoad = Integer.MAX_VALUE;
		
	  // iterate through each driver in the array
	  for (Driver driver : drivers) {
			
		  // check if the driver's location matches the customer's location
		  if (driver.getDriverLocation().equals(customer.getCustomerLocation())) {
			  if (driver.getLoad() < minLoad) {
				  nearestDriver = driver;
				  minLoad = driver.getLoad();
			  }
			
		  }

	  }

	  return nearestDriver;

  }

  /*
  * Method for generating an invoice based on customer, restaurant, and driver
  * details.
  */
  private static String generateInvoice(Customer customer, Restaurant restaurant, Driver driver) {		
	  StringBuilder invoice = new StringBuilder();

	  invoice.append("Order number 1234\n");
	  invoice.append("Customer: ").append(customer.getCustomerName()).append("\n");
	  invoice.append("Email: ").append(customer.getCustomerEmail()).append("\n");
	  invoice.append("Phone number: ").append(customer.getCustomerNumber()).append("\n");
	  invoice.append("Location: ").append(customer.getCustomerLocation()).append("\n");
	  invoice.append("You have ordered the following from ").append(restaurant.getRestaurantName()).append(" in ")		
	  .append(restaurant.getRestaurantLocation()).append(":\n");
	  invoice.append("1 x Pepperoni pizza (R78.00)\n");
	  invoice.append("2 x Hawaiian pizza (R82.00)\n");
	  invoice.append("Special instructions: Extra tomato base on the Pepperoni pizza\n");
	  invoice.append("Total: R242.00\n");

	  if (driver != null) {
		  invoice.append(driver.getDriverName())
		  .append(" is nearest to the restaurant and so they will be delivering your order to you at:\n");
		  invoice.append(customer.getCustomerAddress()).append("\n");
		  invoice.append("If you need to contact the restaurant, their number is ")
		  .append(restaurant.getRestaurantNumber()).append(".\n");
	  } else {
		  invoice.append("Sorry! Our drivers are too far away from you to be able to deliver to your location.\n");
	  }

	  return invoice.toString();

  }

}
