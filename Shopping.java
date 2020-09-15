package projectone;


import java.util.Scanner;

public class Shopping {
	
	
	protected static ShoppingBag baginteraction = new ShoppingBag();
	
	public void run() { 
		Scanner scan = new Scanner(System.in);
		
		String a = scan.nextLine();
		String b[] = a.split(" ");
		while (b[0].equals("Q")== false) {
	//	System.out.print(b[0]);
		
		if (b[0].equals("A")){
			double price = Double.parseDouble(b[2]);
			boolean tax = Boolean.valueOf(b[3]);
			GroceryItem grocery = new GroceryItem(b[1], price, tax);
			baginteraction.add(grocery);
			
		}
		else if (b[0].equals("R")){
			double price = Double.parseDouble(b[2]);
			boolean tax = Boolean.valueOf(b[3]);
			GroceryItem grocery = new GroceryItem(b[1], price, tax);
			baginteraction.remove(grocery);
		}
		else if (b[0].equals("P")) {
			baginteraction.print();
			//display
		}
		else if (b[0].equals("C")) {
			//checking out
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
	}//endwhile
	//	if (b[0].equals("Q")) {
		//	return;
	//	}
		if(b[0].equals("Q") && b != null) {
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
