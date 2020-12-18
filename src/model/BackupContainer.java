package model;

import java.io.Serializable;
import java.util.LinkedList;
/** This class provides a storage container to use when the application closes and stored data must be written to disk.
 * 
 * @author Brenden Lynch
 *
 */
public class BackupContainer implements Serializable {
	private static final long serialVersionUID = -1415931987564401155L;
	private LinkedList<Object> internalContainer;
	
	/** Creates a new BackupContainer object.
	 * 
	 */
	public BackupContainer() {
		this.internalContainer = new LinkedList<Object>();
	}
	/** Adds a new item to the container.
	 * 
	 * @param inputItem The Object to be added to the container.
	 * @param index The location in the container at which inputItem will be placed.
	 * 
	 */
	public void addItem(Object inputItem, int index) {
		internalContainer.add(index, inputItem);
	}
	/** Gets an item from the container at a specified index, if it exists.
	 * 
	 * @param index The location where the Object to be retrieved resides.
	 * @return the Object present at said index, if it exists.
	 */
	public Object getItem(int index) {
		if(index < internalContainer.size()) {
			return internalContainer.get(index);
		}
		return null;
	}
	/** Removes an item from the container, if found.
	 * 
	 * @param inputItem The Object to be removed.
	 * @return a Boolean value reflecting the success of the operation.
	 */
	public boolean removeItem(Object inputItem) {
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
