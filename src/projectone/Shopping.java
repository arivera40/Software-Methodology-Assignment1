package projectone;

/**
 * This is the class for Shopping
 * 
 * @author Andy Rivera and Joseph Shamma
 *
 */

import java.util.Scanner;

public class Shopping {
	
	/* Creating "baginteraction" to be able to interact with our shopping bag
	 * 
	 */
	
	protected static ShoppingBag baginteraction = new ShoppingBag();
	
	

	public void run() {
		Scanner scan = new Scanner(System.in);  // creating a scanner for input

		String a = scan.nextLine();   // taking in the user input as a string
		String b[] = a.split(" ");    // splitting the string into an array
		while (b[0].equals("Q") == false) {
			
			/* b[0] is where the commands "A,R,C,P, and Q" are taken.
			 * The following are instructions on how to handle these commands.
			 */

			if (b[0].equals("A")) {   // adding
				double price = Double.parseDouble(b[2]);
				boolean tax = Boolean.valueOf(b[3]);
				GroceryItem grocery = new GroceryItem(b[1], price, tax);
				baginteraction.add(grocery);

			} else if (b[0].equals("R")) {  // removing
				double price = Double.parseDouble(b[2]);
				boolean tax = Boolean.valueOf(b[3]);
				GroceryItem grocery = new GroceryItem(b[1], price, tax);
				baginteraction.remove(grocery);
			} else if (b[0].equals("P")) {  // printing
				baginteraction.print();
				// display
			} else if (b[0].equals("C")) {  // checking out
				// checking out
				double checkingouttotal = baginteraction.salesPrice() + baginteraction.salesTax();
				double roundOffCheckTotal = Math.round(checkingouttotal * 100.0) / 100.0;
				baginteraction.checkout();
				System.out.println("*Sales total: $" + baginteraction.salesPrice());
				System.out.println("*Sales tax: $" + Math.round(baginteraction.salesTax() * 100.0) / 100.0 );
				System.out.println("* Total amount paid: $" + roundOffCheckTotal);

			}

			else {  
				System.out.println("Invalid Command!");
			}
			a = scan.nextLine();
			b = a.split(" ");
		}
		scan.close();  // closing the scanner

		if (b[0].equals("Q") && b != null) { // checking out if bag is not empty
			double checkingouttotal = baginteraction.salesPrice() + baginteraction.salesTax();
			double roundOffCheckTotal = Math.round(checkingouttotal * 100.0) / 100.0;
			baginteraction.checkout();
			System.out.println("*Sales total: $" + baginteraction.salesPrice());
			System.out.println("*Sales tax: $" + Math.round(baginteraction.salesTax() * 100.0) / 100.0 );
			System.out.println("* Total amount paid: $" + roundOffCheckTotal);
			System.out.println("Thanks for shopping with us!");
		}
	}
}