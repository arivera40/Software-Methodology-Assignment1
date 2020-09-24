package projectone;
/**
 * This is the class for GroceryItem
 * 
 * @author Andy Rivera and Joseph Shamma
 *
 */


public class GroceryItem {
	
	
	/**
	 * item name
	 */
	private String name;
	/**
	 * item unit price
	 */
	private double price;
	/**
	 * taxable in NJ.
	 */
	private boolean taxable;

	/**
	 * Constructor of GroceryItem
	 * 
	 * @param name    grocery item name
	 * @param price   grocery unit price
	 * @param taxable taxable in NJ
	 */

	public GroceryItem(String name, double price, boolean taxable) {
		this.name = name;
		this.price = price;
		this.taxable = taxable;
	}

	public boolean equals(Object obj) {
		if (obj instanceof GroceryItem) {
			GroceryItem item = (GroceryItem) obj;
			if (item.name.equals(this.name) && item.price == this.price && item.taxable == this.taxable) {
				return true;
			}
		}
		return false;
	}

	public String toString() {  // Formatting item information to be printed.
		return this.getName() + ": " + this.getPrice() + " : " + ((this.isTaxable()) ? "is taxable" : "tax free");
	}

	public double getPrice() {  // price of the item
		return this.price;
	}

	public boolean isTaxable() {  // to know if item is taxable
		return this.taxable;
	}

	public double getItemTax() {
		return this.price * 0.06625;  // calculating price for NJ sales tax
	}

	public String getName() {  // name of the item
		return this.name;
	}


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
	
	//Test case 3 
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
}