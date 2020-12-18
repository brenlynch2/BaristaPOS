package model;

import java.io.Serializable;
import java.util.LinkedList;

public class OrderTicketContainer implements Serializable {
	private static final long serialVersionUID = 2960919650460397362L;
	private LinkedList<OrderTicket> internalContainer;
	
	public OrderTicketContainer() {
		this.internalContainer = new LinkedList<OrderTicket>();
	}
	public boolean addItem(OrderTicket inputItem) {
		return internalContainer.add(inputItem);
	}
	public OrderTicket getItem(int index) {
		if(index < internalContainer.size()) {
			return internalContainer.get(index);
		}
		return null;
	}
	public boolean removeItem(OrderTicket inputItem) {
		return internalContainer.remove(inputItem);
	}
	public int size() {
		return internalContainer.size();
	}
}
