package shoppingProject;

import java.util.Scanner;

public class Shopping {

	protected static ShoppingBag baginteraction = new ShoppingBag();
	
	public static void main(String[] args) {
		//Test case 1
		ShoppingBag bag = new ShoppingBag();

		GroceryItem input1 = new GroceryItem("apple", 1.99, false);
		GroceryItem input2 = new GroceryItem("cookies", 2.99, true);
		GroceryItem input3 = new GroceryItem("ice-cream", 4.99, true);
		bag.add(input1);
		bag.add(input2);
		bag.add(input3);
		
		System.out.println("Case #1: add() method, Expected Ouput: getSize() returns 3, "
				+ "Actual Output: getSize() returns " + bag.getSize());
		
		//Test case 2
		GroceryItem input4 = new GroceryItem("pie", 3.99, true);
		GroceryItem input5 = new GroceryItem("water", 2.99, false);
		GroceryItem input6 = new GroceryItem("soda", 2.99, true);
		bag.add(input4);
		bag.add(input5);
		bag.add(input6);
		
		System.out.println("Case #2: grow() method, Expected Ouput: getSize() returns 6, getCapacity() returns 10, "
				+ "Actual Ouput: getSize() returns " + bag.getSize() + ", getCapacity() returns " + bag.getCapacity());
		
		//Test case 3 Math.round(checkingouttotal * 100.0) / 100.0
		System.out.println("Case #3: salesTax() method, Expected Output: salesTax() returns 0.99, "
				+ "Actual Output: salesTax() returns " + (Math.round(bag.salesTax() * 100.0) / 100.0));
		
		//Test case 4
		System.out.println("Case #4: salesPrice() method, Expected Output: salesPrice() returns 19.94, "
				+ "Actual Output: salesPrice() returns " + (Math.round(bag.salesPrice() * 100.0) / 100.0));
		
		//Test case 5
		boolean finderOutput = bag.remove(new GroceryItem("paper-towels", 1.99, false));
		System.out.println("Case #5: finder() method, Expected Output: remove() returns false, "
				+ "Actual Output: remove() returns " + finderOutput);
		
		//Test case 6
		bag.remove(input1);
		bag.remove(input2);
		bag.remove(input3);
		bag.remove(input4);
		bag.remove(input5);
		bag.remove(input6);
		
		System.out.println("Case #6: remove() method, Expected Output: getSize() returns 0, "
				+ "Actual Output: getSize() returns " + bag.getSize());
	}

	public void run() {
		Scanner scan = new Scanner(System.in);

		String a = scan.nextLine();
		String b[] = a.split(" ");
		while (b[0].equals("Q") == false) {
			// System.out.print(b[0]);

			if (b[0].equals("A")) {
				double price = Double.parseDouble(b[2]);
				boolean tax = Boolean.valueOf(b[3]);
				GroceryItem grocery = new GroceryItem(b[1], price, tax);
				baginteraction.add(grocery);

			} else if (b[0].equals("R")) {
				double price = Double.parseDouble(b[2]);
				boolean tax = Boolean.valueOf(b[3]);
				GroceryItem grocery = new GroceryItem(b[1], price, tax);
				baginteraction.remove(grocery);
			} else if (b[0].equals("P")) {
				baginteraction.print();
				// display
			} else if (b[0].equals("C")) {
				// checking out
				double checkingouttotal = baginteraction.salesPrice() + baginteraction.salesTax();
				double roundOffCheckTotal = Math.round(checkingouttotal * 100.0) / 100.0;
				baginteraction.checkout();
				System.out.println("*Sales total: $" + baginteraction.salesPrice());
				System.out.println("*Sales tax: $" + baginteraction.salesTax());
				System.out.println("* Total amount paid: $" + roundOffCheckTotal);

			}

			else {
				System.out.println("Invalid Command!");
			}
			a = scan.nextLine();
			b = a.split(" ");
		}
		scan.close();

		if (b[0].equals("Q") && b != null) {
			double checkingouttotal = baginteraction.salesPrice() + baginteraction.salesTax();
			double roundOffCheckTotal = Math.round(checkingouttotal * 100.0) / 100.0;
			baginteraction.checkout();
			System.out.println("*Sales total: $" + baginteraction.salesPrice());
			System.out.println("*Sales tax: $" + baginteraction.salesTax());
			System.out.println("* Total amount paid: $" + roundOffCheckTotal);
			System.out.println("Thanks for shopping with us!");
		}
	}
}
