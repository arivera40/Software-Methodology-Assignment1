package shoppingProject;

public class ShoppingBag {
	private GroceryItem[] bag;
	private int size;
	private int capacity;

	public ShoppingBag() {
		bag = new GroceryItem[5];
		size = 0;
		capacity = 5;
	}

	private int find(GroceryItem item) { // helper method to find an item
		for (int i = 0; i < size; i++) {
			if (bag[i].equals(item)) {
				return i;
			}
		}
		return -1;
	}

	private void grow() { // helper method to grow the capacity
		GroceryItem[] largerBag = new GroceryItem[capacity + 5];
		System.arraycopy(bag, 0, largerBag, 0, bag.length);
		bag = largerBag;
		capacity += 5;
	}

	public void add(GroceryItem item) {
		bag[size] = item;
		size++;

		if (size == capacity) { // this can go before or after adding item to list
			grow();
		}
	}

	public boolean remove(GroceryItem item) {
		int itemIndex = find(item);
		if (itemIndex == -1) {
			return false;
		}
		bag[itemIndex] = bag[size - 1];
		bag[size - 1] = null;
		size--;
		return true;
	}

	public double salesPrice() {
		double totalPrice = 0;
		for (int i = 0; i < size; i++) {
			totalPrice += bag[i].getPrice();
		}
		return totalPrice;
	}

	public double salesTax() {
		double totalTax = 0;
		for (int i = 0; i < size; i++) {
			if (bag[i].isTaxable()) {
				totalTax += bag[i].getItemTax();
			}
		}
		return totalTax;
	}

	public void print() {
		System.out.println("**You have " + size + " item(s) in the bag:");
		for (int i = 0; i < size; i++) {
			System.out.println(bag[i].toString());
		}
		System.out.println("**End of list");
	}

	public void checkout() {
		System.out.println("**Checking out " + size + " items.");
		for (int i = 0; i < size; i++) {
			System.out.println(bag[i].toString());
		}
	}
	
	public int getSize() {
		return size;
	}

	public int getCapacity() {
		return capacity;
	}
}
