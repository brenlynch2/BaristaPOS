package model;

import java.io.Serializable;
import java.util.LinkedList;

public class BackupContainer implements Serializable {
	private static final long serialVersionUID = -1415931987564401155L;
	private LinkedList<Object> internalContainer;
	
	public BackupContainer() {
		this.internalContainer = new LinkedList<Object>();
	}
	public boolean addItem(Object inputItem) {
		return internalContainer.add(inputItem);
	}
	public Object getItem(int index) {
		if(index < internalContainer.size()) {
			return internalContainer.get(index);
		}
		return null;
	}
	public boolean removeItem(Object inputItem) {
		return internalContainer.remove(inputItem);
	}
	public int size() {
		return internalContainer.size();
	}
}
