import java.util.Arrays;
import java.util.Scanner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;


public class quickFoodV2 {
    
    public static void main (String [] args) throws IOException {
	
	 
	//Declaring array for driver location  
	String[] driverLocation = new String[]
		{"Cape Town",
			"Durban",
			"Johannesburg",
			"Potchefstroom",
			"Springbok",
			"Port Elizabeth",
			"Bloemfontein",
			"Witbank"};
	
	
	//Array of each driver in each location
	String[] capeTown = {"Miranda","Cayson","Aaron","Julie","Aya"};
	String[] durban = {"Eugene","Karol","Umayr","Abul"};
	String[] johannesburg = {"Eisa","Gemma","Tyron","Spike"};
	String[] potchefstroom = {"Jaidan"};
	String[] springbok = {"Johan","Liya","Blaine"};
	String[] portElizabeth = {"Ana","Kealan","Lily","Clement"};
	String[] bloemfontein = {"Kailan","Kaelan","Trevor"};
	String[] witbank = {"Eshan","Adelina","Caitlin","Huma","Kallum"};
			
	
	try (//Individual questions for customer
	Scanner customerInfo = new Scanner(System.in)) {
	    System.out.println("Enter your name: ");
	    String customerName = customerInfo.nextLine(); 
	    
	    System.out.println("Enter your email address: ");
	    String emailAddress = customerInfo.nextLine();
	    
	    System.out.println("Enter your phone number: ");
	    String phoneNumber = customerInfo.nextLine();
	    
	    //customer location to see if they are in an area where there is a driver
	    System.out.println("Enter your city: ");
	    String customerLocation = customerInfo.nextLine();
	    
	    System.out.println("Enter your address: ");
	    String customerAddress = customerInfo.nextLine();
	    
	    //Menu of pizzas with prices
	    System.out.println("Please enter the number of the pizza you like from the menu below eg. 1: \n\n"
	    	+ "1. Pepperoni _______ R99 \n"
	    	+ "2. Margerita _______ R68 \n"
	    	+ "3. Hawaiian ________ R85 \n"
	    	+ "4. Meaty Feast _____ R120");
	    String pricePerPizza = customerInfo.nextLine();
	    
	    //How many pizzas 
	    System.out.println("How many " + pricePerPizza + " would you like: ");
	    String howManyPizzas = customerInfo.nextLine();
	    
	    
	    //converting howManyPizzas to an integer to calculate total 
	    int pizzaTotal = 0;
	    int noOfPizzas = Integer.parseInt(howManyPizzas);
	    int pizzaItem = Integer.parseInt(pricePerPizza);
	    
	      //Pizza menu
	    /*calculating the total but multiplying the pizza 
	    price by the number of pizzas they want*/
	    if (pizzaItem == 1) {
	    	pizzaTotal = (99 * noOfPizzas);
	        }
	    else if (pizzaItem == 2) {
	    	pizzaTotal = (68 * noOfPizzas);
	        }
	    else if (pizzaItem == 3) {
	    	pizzaTotal = (85 * noOfPizzas);
	        }
	    else {
	    	pizzaTotal = (120 * noOfPizzas);
	        }

	    
	    //Creating a string nameOfPizza so I can display it on the invoice.
	    String nameOfPizza;
	    
	    //linking the number of the pizza to the name of the pizza for the invoice
	    if (pizzaItem == 1) {
	        nameOfPizza = "Pepperoni";
	    }
	    else if (pizzaItem == 2) {
	        nameOfPizza = "Margerita";
	    }
	    else if (pizzaItem == 3) {
	        nameOfPizza = "Hawaiian";
	    }
	    else {
	        nameOfPizza = "Meaty Feast";
	    }
	    
	    

	    String toSearch = customerLocation;
	    //if location does not match driverLocation, print "We do not deliver to your area"
	    if (Arrays.toString(driverLocation).contains(toSearch)){
	        
	        
	        	String driver;
	    	//if statement to choose a driver based on location
	    	if (toSearch.equals("Cape Town")) {
	    	    driver = capeTown[(int) Math.floor(Math.random()*capeTown.length)];
	    	}
	    	else if (toSearch.equals("Durban")) {
	    	    driver = durban[(int) Math.floor(Math.random()*durban.length)];
	    	}
	    	else if (toSearch.equals("Johannesburg")) {
	    	    driver = johannesburg[(int) Math.floor(Math.random()*johannesburg.length)];   
	    	}
	    	else if (toSearch.equals("Potchefstroom")) {
	    	    driver = potchefstroom[(int) Math.floor(Math.random()*potchefstroom.length)];
	    	}
	    	else if (toSearch.equals("Springbok")) {
	    	    driver = springbok[(int) Math.floor(Math.random()*springbok.length)];
	    	}
	    	else if (toSearch.equals("Port Elizabeth")) {
	    	    driver = portElizabeth[(int) Math.floor(Math.random()*portElizabeth.length)];
	    	 }
	    	else if (toSearch.equals("Bloemfontein")) {
	    	    driver = bloemfontein[(int) Math.floor(Math.random()*bloemfontein.length)];
	    	}
	    	else {
	    	    driver = witbank[(int) Math.floor(Math.random()*witbank.length)];
	    	}
	    	    
	    	    
	        try {
	    	      File myObj = new File("invoice.txt");
	    	      if (myObj.createNewFile()) {
	    		  try {
	    		      FileWriter myWriter = new FileWriter("invoice.txt");
	    		      
	    		      
	    		    myWriter.write("Order number 1234 \n"
	    		      	+ "Customer: " + customerName + "\n"
	    		      	+ "Email:" + emailAddress + "\n"
	    		      	+ "Phone number: " + phoneNumber + "\n"
	    		      	+ "Location: " + customerLocation + "\n\n"
	    		      	+ "You have ordered the following from Quick Food Pizza in " + customerLocation + ": \n"
	    		      	+ howManyPizzas + "x " + nameOfPizza + "\n"
	    		      	+ "Total: R" + pizzaTotal + ".00" + "\n"
	    		      	+ driver + " is nearest to the restaurant and so he/she will be delivering your\n"
	    		      	+ "order to you at: " + customerAddress + "\n\n"
	    		      	
	    		      	
	    		      	+ "If you need to contact the restaurant, their number is 098 765 4321.");
	    		      
	    		      
	    		      myWriter.close();
	    		      System.out.println("Successfully wrote to the file.");
	    		    } catch (IOException e) {
	    		      System.out.println("An error occurred.");
	    		      e.printStackTrace();
	    		    }
	        
	    	        System.out.println("File created: " + myObj.getName());
	    	      } else {
	    	        System.out.println("File already exists.");
	    	      }
	    	    } catch (IOException e) {
	    	      System.out.println("An error occurred.");
	    	      e.printStackTrace();
	        
	        
	    	    }
	    }
	    else {
	        System.out.println("Sorry! Our drivers are too "
	        	+ "far away from you to be able to "
	        	+ "deliver to your location.");
	    }
	} catch (NumberFormatException e) {
	    // TODO Auto-generated catch block
	    e.printStackTrace();
	}
	    
    }  
}