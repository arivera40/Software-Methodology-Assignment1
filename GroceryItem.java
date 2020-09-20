package shoppingProject;

/**
 * This is the class for GroceryItem
 * 
 * @author andy, joseph
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

	public String toString() {
		return this.getName() + ": " + this.getPrice() + " : " + ((this.isTaxable()) ? "is taxable" : "tax free");
	}

	public double getPrice() {
		return this.price;
	}

	public boolean isTaxable() {
		return this.taxable;
	}

	public double getItemTax() {
		return this.price * 0.06625;
	}

	public String getName() {
		return this.name;
	}

}
