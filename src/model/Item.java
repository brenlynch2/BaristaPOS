package model;

public interface Item {
	public double getPrice();
	public String getName();
	public String getMenuName();
	public int getType();
	public void setPrice(double newPrice);
	public void setName(String newName);
	public void setMenuName(String newMenuName);
	public void setType(int newType);
	
}
