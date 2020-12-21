package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import model.MenuItem;
import model.MenuItemContainer;
import model.OrderTicket;
import model.OrderTicketContainer;
import view.GUI;

public class BaristaPOSAdminController {
	@FXML
	private ListView<OrderTicket> listViewOrderHistory;
	
	@FXML
	private ListView<MenuItem> listViewMenuItems;
	
	@FXML
	private Button btnRemoveSelectedHistoryEntry;
	
	@FXML
	private Button btnChangeAdminPassword;
	
	@FXML
	private Button btnAddNewMenuItem;
	
	@FXML
	private Button btnRemoveSelectedMenuItem;
	
	private ObservableList<OrderTicket> driverListlistViewOrderHistory = FXCollections.observableArrayList();
	private ObservableList<MenuItem> driverListlistViewMenuItems = FXCollections.observableArrayList();
	
	public void initialize() {
		syncLists();
	}
	public void syncLists() {
		driverListlistViewOrderHistory.clear();
		driverListlistViewMenuItems.clear();
		if(GUI.loadedMenuItemContainer != new MenuItemContainer()) {
			for(int i = 0; i < GUI.loadedMenuItemContainer.size(); i++) {
				driverListlistViewMenuItems.add(GUI.loadedMenuItemContainer.getItem(i));
			}
		}
		if(GUI.loadedOrderTicketContainer != new OrderTicketContainer()) {
			for(int i = 0; i < GUI.loadedOrderTicketContainer.size(); i++) {
				driverListlistViewOrderHistory.add(GUI.loadedOrderTicketContainer.getItem(i));
			}
		}
		listViewMenuItems.getItems().clear();
		listViewOrderHistory.getItems().clear();
		listViewMenuItems.getItems().addAll(driverListlistViewMenuItems);
		listViewOrderHistory.getItems().addAll(driverListlistViewOrderHistory);
	}
	public void btnRemoveSelectedHistoryEntryClicked() {
		OrderTicket selectedItem = listViewOrderHistory.getSelectionModel().getSelectedItem();
		if(selectedItem != null) {
			GUI.loadedOrderTicketContainer.removeItem(selectedItem);
			syncLists();
			Alert infoDialog = new Alert(AlertType.INFORMATION, "This order ticket was successfully deleted.", ButtonType.OK);
			infoDialog.showAndWait();
		} else {
			Alert infoDialog = new Alert(AlertType.ERROR, "No order ticket is selected.", ButtonType.OK);
			infoDialog.showAndWait();
		}
	}
	public void btnChangeAdminPasswordClicked() {
		GUI.baristaPOSChangeAdminPasswordStage.show();
		GUI.baristaPOSAdminStage.close();
	}
	public void btnAddNewMenuItemClicked() {
		GUI.baristaPOSAddNewItemStage.show();
		GUI.baristaPOSAdminStage.close();
	}
	public void btnRemoveSelectedMenuItemClicked() {
		MenuItem selectedItem = listViewMenuItems.getSelectionModel().getSelectedItem();
		if(selectedItem != null) {
			GUI.loadedMenuItemContainer.removeItem(selectedItem);
			syncLists();
			Alert infoDialog = new Alert(AlertType.INFORMATION, "This menu item was successfully deleted.", ButtonType.OK);
			infoDialog.showAndWait();
		} else {
			Alert infoDialog = new Alert(AlertType.ERROR, "No menu item is selected.", ButtonType.OK);
			infoDialog.showAndWait();
		}
	}
}
