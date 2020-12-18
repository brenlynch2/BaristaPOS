package model;

import java.io.Serializable;
import java.util.LinkedList;

public class MenuItemContainer implements Serializable {
	private static final long serialVersionUID = -6775253052761280500L;
	private LinkedList<MenuItem> internalContainer;
	
	public MenuItemContainer() {
		this.internalContainer = new LinkedList<MenuItem>();
	}
	public boolean addItem(MenuItem inputItem) {
		return internalContainer.add(inputItem);
	}
	public MenuItem getItem(int index) {
		if(index < internalContainer.size()) {
			return internalContainer.get(index);
		}
		return null;
	}
	public boolean removeItem(MenuItem inputItem) {
		return internalContainer.remove(inputItem);
	}
	public int size() {
		return internalContainer.size();
	}
}
