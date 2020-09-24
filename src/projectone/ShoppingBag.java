package projectone;

/**
 * This is the class for ShoppingBag
 * 
 * @author Andy Rivera and Joseph Shamma
 *
 */

public class ShoppingBag {
	private GroceryItem[] bag;
	private int size;
	private int capacity;
	
	
	public ShoppingBag() {
		bag = new GroceryItem[5];
		size = 0;                  // setting the initial size of bag
		capacity = 5;              // setting the initial capacity of the bag
	}
	
	private int find(GroceryItem item) {	//helper method to find an item
		for(int i=0; i < size; i++) {
			if(bag[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

	private void grow() {	//helper method to grow the capacity
		GroceryItem[] largerBag = new GroceryItem[capacity + 5];
		System.arraycopy(bag, 0, largerBag, 0, bag.length);
		bag = largerBag;
		capacity += 5; 
	}
	
	public void add(GroceryItem item) {
		bag[size] = item;       // adding item to the bag
		String output = item.getName();
		System.out.println( output + " has been added to the cart");
		size++;                  // adding to the size of the bag
		if(size == capacity) {	
			grow();
		}
	}
	
	public boolean remove(GroceryItem item) {
		int itemIndex = find(item);

		/* This is to check if an item is contained
		 * in the bag.
		 */
		
		if(itemIndex == -1) {
			System.out.println("Unable to Remove, this item is not in the bag.");
			return false;
		}
		String output = bag[itemIndex].getName();
		bag[itemIndex] = bag[size - 1];
		bag[size - 1] = null;
		System.out.println( output + " has been removed from the cart");
		size--;    // subtracting from the size of the bag after item is removed
		return true;
	}
	
	public double salesPrice() {
		double totalPrice = 0;
		for(int i=0; i < size; i++) {
			totalPrice += bag[i].getPrice(); // calculating the total price
		}
		totalPrice = Math.round(totalPrice * 100.0) / 100.0; // rounding the total price
		return totalPrice;
	}
	
	public double salesTax() {
		double totalTax = 0;
		for(int i=0; i < size; i++) {
			if(bag[i].isTaxable()) {
				totalTax += bag[i].getItemTax(); // calculating tax using getItemTax method
			}
		}
		return totalTax;
	}
	/* Printing all the items contained in 
	 * the grocery bag.
	 */
	public void print() {
		System.out.println("**You have " + size + " item(s) in the bag:");
		for(int i=0; i < size; i++) {
			System.out.println(bag[i].toString());
		}
		System.out.println("**End of list");
	}
	/* Checking out all of items 
	 * in the grocery.
	 */
	public void checkout() {
		System.out.println("**Checking out " + size + " items.");
		for(int i=0; i < size; i++) {
			System.out.println(bag[i].toString());
		}
	}
	
	public int getSize() {  // returning the size of the bag
		return size;
	}
	
	public int getCapacity() {
		return capacity;
	}
}