package controller;

import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.util.LinkedList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import model.MenuItem;
import model.MenuItemContainer;
import model.OrderTicket;
import model.OrderTicketContainer;
import view.GUI;

public class BaristaPOSController {
	
	@FXML
	private ListView<MenuItem> listViewFood;
	
	@FXML
	private ListView<MenuItem> listViewCoffee;
	
	@FXML
	private ListView<MenuItem> listViewCondimentsOther;
	
	@FXML
	private ListView<MenuItem> listViewCurrentOrderTotals;
	
	@FXML
	private Label lblTotalPriceField;
	
	@FXML
	private Button btnAddSelectedToOrder;
	
	@FXML
	private Button btnRemoveSelectedFromOrder;
	
	@FXML
	private Button btnOrder;
	
	@FXML
	private Button btnOrderHistory;
	
	@FXML
	private Button btnAdminLogin;
	
	private ObservableList<MenuItem> driverListlistViewFood = FXCollections.observableArrayList();
	private ObservableList<MenuItem> driverListlistViewCoffee = FXCollections.observableArrayList();
	private ObservableList<MenuItem> driverListlistViewCondimentsOther = FXCollections.observableArrayList();
	private ObservableList<MenuItem> driverListlistViewCurrentOrderTotals = FXCollections.observableArrayList();
	
	
	public void initialize() {
		syncLists();
	}
	public void syncLists() {
		if(GUI.loadedMenuItemContainer != new MenuItemContainer()) {
			driverListlistViewFood.clear();
			driverListlistViewCoffee.clear();
			driverListlistViewCondimentsOther.clear();
			
			for(int i = 0; i < GUI.loadedMenuItemContainer.size(); i++) {
				switch(GUI.loadedMenuItemContainer.getItem(i).getType()) {
				case(1):
					driverListlistViewFood.add(GUI.loadedMenuItemContainer.getItem(i));
				break;
				case(2):
					driverListlistViewCoffee.add(GUI.loadedMenuItemContainer.getItem(i));
				break;
				case(3):
					driverListlistViewCondimentsOther.add(GUI.loadedMenuItemContainer.getItem(i));
				break;
				case(4):
					driverListlistViewCondimentsOther.add(GUI.loadedMenuItemContainer.getItem(i));
				break;
				}
			}
			listViewCoffee.getItems().clear();
			listViewCoffee.getItems().addAll(driverListlistViewCoffee);
			listViewFood.getItems().clear();
			listViewFood.getItems().addAll(driverListlistViewFood);
			listViewCondimentsOther.getItems().clear();
			listViewCondimentsOther.getItems().addAll(driverListlistViewCondimentsOther);
		}
		if(!driverListlistViewCurrentOrderTotals.isEmpty()) {
			listViewCurrentOrderTotals.getItems().clear();
			listViewCurrentOrderTotals.getItems().addAll(driverListlistViewCurrentOrderTotals);
		}
	}
	public int getNextTicketID() {
		if(GUI.loadedOrderTicketContainer == new OrderTicketContainer()) {
			return 1;
		} else {
			return GUI.loadedOrderTicketContainer.size() + 1;
		}
	}
	public void updateOrderTotalPrice() {
		double totalPrice = 0.0;
		for(int i = 0; i < driverListlistViewCurrentOrderTotals.size(); i++) {
				totalPrice = totalPrice + driverListlistViewCurrentOrderTotals.get(i).getPrice();
		}
		lblTotalPriceField.setText(Double.toString(totalPrice));
	}
	public void btnAddSelectedToOrderClicked() {
		MenuItem coffeeSelectedItem = listViewCoffee.getSelectionModel().getSelectedItem();
		MenuItem foodSelectedItem = listViewFood.getSelectionModel().getSelectedItem();
		MenuItem condimentsOtherSelectedItem = listViewCondimentsOther.getSelectionModel().getSelectedItem();
		if(coffeeSelectedItem == null && foodSelectedItem == null && condimentsOtherSelectedItem == null) {
			Alert infoDialog = new Alert(AlertType.ERROR, "Nothing is selected to add to this order.", ButtonType.OK);
			infoDialog.showAndWait();
			return;
		}
		if(coffeeSelectedItem != null) {
			driverListlistViewCurrentOrderTotals.add(coffeeSelectedItem);
		}
		if(foodSelectedItem != null) {
			driverListlistViewCurrentOrderTotals.add(foodSelectedItem);
		}
		if(condimentsOtherSelectedItem != null) {
			driverListlistViewCurrentOrderTotals.add(condimentsOtherSelectedItem);
		}
		updateOrderTotalPrice();
		syncLists();
	}
	public void btnRemoveSelectedFromOrderClicked() {
		MenuItem selectedItem = listViewCurrentOrderTotals.getSelectionModel().getSelectedItem();
		if(selectedItem == null) {
			Alert infoDialog = new Alert(AlertType.ERROR, "No item is selected on the ticket to be removed.", ButtonType.OK);
			infoDialog.showAndWait();
			return;
		} else {
			driverListlistViewCurrentOrderTotals.remove(selectedItem);
			syncLists();
			updateOrderTotalPrice();
		}
	}
	public void btnOrderClicked() {
		if(driverListlistViewCurrentOrderTotals.isEmpty()) {
			Alert infoDialog = new Alert(AlertType.ERROR, "There are no items on this order ticket.", ButtonType.OK);
			infoDialog.showAndWait();
			return;
		} else {
			LinkedList<MenuItem> itemsOrdered = new LinkedList<MenuItem>();
			itemsOrdered.addAll(driverListlistViewCurrentOrderTotals);
			String timestamp = ZonedDateTime.now().format(DateTimeFormatter.ofPattern("uuuu.MM.dd.HH.mm.ss"));
			int ticketID = getNextTicketID();
			OrderTicket returnedTicket = new OrderTicket(itemsOrdered, timestamp, ticketID);
			GUI.loadedOrderTicketContainer.addItem(returnedTicket);
			driverListlistViewCurrentOrderTotals.clear();
			listViewCurrentOrderTotals.getItems().clear();
			Alert infoDialog = new Alert(AlertType.INFORMATION, "This order has been placed. Order ID: " + ticketID, ButtonType.OK);
			infoDialog.showAndWait();
		}
	}
	public void btnOrderHistoryClicked() {
		GUI.baristaPOSOrderHistoryStage.show();
		GUI.baristaPOSStage.close();
	}
	public void btnAdminLoginClicked() {
		GUI.baristaPOSLoginStage.show();
		GUI.baristaPOSStage.close();
	}
}
