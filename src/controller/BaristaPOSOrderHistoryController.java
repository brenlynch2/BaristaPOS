package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ListView;
import javafx.scene.control.Alert.AlertType;
import model.OrderTicket;
import model.OrderTicketContainer;
import view.GUI;

public class BaristaPOSOrderHistoryController {
	
	private ObservableList<OrderTicket> driverListlistViewOrderHistoryEntry = FXCollections.observableArrayList();
	
	@FXML
	private ListView<OrderTicket> listViewOrderHistoryEntry;
	
	@FXML
	private Button btnViewSelectedTicket;
	
	
	public void initialize() {
		syncLists();
	}
	public void syncLists() {
		driverListlistViewOrderHistoryEntry.clear();
		listViewOrderHistoryEntry.getItems().clear();
		if(GUI.loadedOrderTicketContainer != new OrderTicketContainer()) {
			for(int i = 0; i < GUI.loadedOrderTicketContainer.size(); i++) {
				driverListlistViewOrderHistoryEntry.add(GUI.loadedOrderTicketContainer.getItem(i));
			}
		}
		listViewOrderHistoryEntry.getItems().addAll(driverListlistViewOrderHistoryEntry);
	}
	public void btnViewSelectedTicketClicked() {
		OrderTicket selectedItem = listViewOrderHistoryEntry.getSelectionModel().getSelectedItem();
		if(selectedItem != null) {
			GUI.selectedTicket = selectedItem;
			GUI.baristaPOSOrderHistoryEntryDisplayStage.show();
			GUI.baristaPOSOrderHistoryStage.close();
		} else {
			Alert infoDialog = new Alert(AlertType.ERROR, "No ticket is selected.", ButtonType.OK);
			infoDialog.showAndWait();
		}
	}
}
