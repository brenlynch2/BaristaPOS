package model;

import java.io.Serializable;
import java.util.LinkedList;
/** This class provides a container for MenuItem objects.
 * 
 * @author Brenden Lynch
 *
 */
public class MenuItemContainer implements Serializable {
	private static final long serialVersionUID = -6775253052761280500L;
	private LinkedList<MenuItem> internalContainer;
	
	/** Creates a new MenuItemContainer object.
	 * 
	 */
	public MenuItemContainer() {
		this.internalContainer = new LinkedList<MenuItem>();
	}
	/** Adds a new item to the container.
	 * 
	 * @param inputItem The MenuItem to be added to the container.
	 * @return a Boolean value reflecting the success of the operation
	 * 
	 */
	public boolean addItem(MenuItem inputItem) {
		return internalContainer.add(inputItem);
	}
	/** Gets an item from the container at a specified index, if it exists.
	 * 
	 * @param index The location where the MenuItem to be retrieved resides.
	 * @return the MenuItem present at said index, if it exists.
	 */
	public MenuItem getItem(int index) {
		if(index < internalContainer.size()) {
			return internalContainer.get(index);
		}
		return null;
	}
	/** Removes an item from the container, if found.
	 * 
	 * @param inputItem The MenuItem to be removed.
	 * @return a Boolean value reflecting the success of the operation.
	 */
	public boolean removeItem(MenuItem inputItem) {
		return internalContainer.remove(inputItem);
	}
	/** Gets the size of the container.
	 * 
	 * @return an int value reflecting the size of the container.
	 */
	public int size() {
		return internalContainer.size();
	}
}
