package model;

import java.io.Serializable;
import java.util.LinkedList;
/** This class represents a customer's order.
 * 
 * @author Brenden Lynch
 *
 */
public class OrderTicket implements Serializable{
	private static final long serialVersionUID = -4577248240995098874L;
	private LinkedList<MenuItem> itemsOrdered;
	private String timestamp;
	private int ticketID;
	/** Creates a new OrderTicket object.
	 * 
	 */
	public OrderTicket() {
		this.itemsOrdered = new LinkedList<MenuItem>();
		this.timestamp = "NA";
		this.ticketID = 0;
	}
	/** Creates a new OrderTicket object.
	 * 
	 * @param itemsOrdered A LinkedList containing MenuItem objects.
	 * @param timestamp The timestamp of the order.
	 * @param ticketID	The ID number associated with this ticket.
	 */
	public OrderTicket(LinkedList<MenuItem> itemsOrdered, String timestamp, int ticketID) {
		this.itemsOrdered = itemsOrdered;
		this.timestamp = timestamp;
		this.ticketID = ticketID;
	}
	public LinkedList<MenuItem> getItemsOrdered() {
		return itemsOrdered;
	}
	public void setItemsOrdered(LinkedList<MenuItem> itemsOrdered) {
		this.itemsOrdered = itemsOrdered;
	}
	public String getTimestamp() {
		return timestamp;
	}
	public void setTimestamp(String timestamp) {
		this.timestamp = timestamp;
	}
	public int getTicketID() {
		return ticketID;
	}
	public void setTicketID(int ticketID) {
		this.ticketID = ticketID;
	}
	
}
