package model;

import java.io.Serializable;
/** This class represents an item on the coffee shop's menu.
 * 
 * @author Brenden Lynch
 *
 */
public class MenuItem implements Item,Serializable {
	private static final long serialVersionUID = -1245786502446535396L;
	private String name;
	private String menuName;
	private double price;
	private int type;
	
	/** Creates a new MenuItem object.
	 * 
	 * @param name The name of the item.
	 * @param menuName The text that will be displayed when the MenuItem is placed in a ListView.
	 * @param price The price of the item.
	 * @param type The type of the item. This is an int value from 1 to 4.
	 */
	public MenuItem(String name, String menuName, double price, int type) {
		this.name = name;
		this.menuName = menuName;
		this.price = price;
		this.type = type;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getMenuName() {
		return menuName;
	}

	public void setMenuName(String menuName) {
		this.menuName = menuName;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getType() {
		return type;
	}

	public void setType(int type) {
		this.type = type;
	}
	@Override
	public String toString() {
		return menuName;
	}
	
}
