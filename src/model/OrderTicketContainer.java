package model;

import java.io.Serializable;
import java.util.LinkedList;
/** This class provides a container for OrderTicket objects.
 * 
 * @author Brenden Lynch
 *
 */
public class OrderTicketContainer implements Serializable {
	private static final long serialVersionUID = 2960919650460397362L;
	private LinkedList<OrderTicket> internalContainer;
	
	/** Creates a new OrderTicketContainer object.
	 * 
	 */
	public OrderTicketContainer() {
		this.internalContainer = new LinkedList<OrderTicket>();
	}
	/** Adds a new item to the container.
	 * 
	 * @param inputItem The OrderTicket to be added to the container.
	 * @return a Boolean value reflecting the success of the operation
	 * 
	 */
	public boolean addItem(OrderTicket inputItem) {
		return internalContainer.add(inputItem);
	}
	/** Gets an item from the container at a specified index, if it exists.
	 * 
	 * @param index The location where the OrderTicket to be retrieved resides.
	 * @return the OrderTicket present at said index, if it exists.
	 */
	public OrderTicket getItem(int index) {
		if(index < internalContainer.size()) {
			return internalContainer.get(index);
		}
		return null;
	}
	/** Removes an item from the container, if found.
	 * 
	 * @param inputItem The OrderTicket to be removed.
	 * @return a Boolean value reflecting the success of the operation.
	 */
	public boolean removeItem(OrderTicket inputItem) {
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
