package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import model.MenuItem;
import model.OrderTicket;
import view.GUI;

public class BaristaPOSOrderHistoryEntryDisplayController {
	
	private static OrderTicket thisTicket = GUI.selectedTicket;
	
	@FXML
	private ListView<MenuItem> listViewItemsOrdered;
	
	@FXML
	private Label lblTicketIDField;
	
	@FXML
	private Label lblTotalPriceField;
	
	@FXML
	private Label lblTimestampEntryField;
	
	@FXML
	private Button btnClose;
	
	@FXML
	private Button btnViewData;
	
	public void initialize() {
		if(thisTicket != null) {
			listViewItemsOrdered.getItems().clear();
			double totalPrice = 0.0;
			for(int i = 0; i < thisTicket.getItemsOrdered().size(); i++) {
				totalPrice = totalPrice + thisTicket.getItemsOrdered().get(i).getPrice();
				listViewItemsOrdered.getItems().add(thisTicket.getItemsOrdered().get(i));
			}
			lblTicketIDField.setText(Integer.toString(thisTicket.getTicketID()));
			lblTotalPriceField.setText(Double.toString(totalPrice));
			lblTimestampEntryField.setText(thisTicket.getTimestamp());
		}
	}
	public void btnCloseClicked() {
		GUI.baristaPOSOrderHistoryEntryDisplayStage.close();
		GUI.baristaPOSOrderHistoryStage.show();
	}
	public void btnViewDataClicked() {
		thisTicket = GUI.selectedTicket;
		if(thisTicket != null) {
			listViewItemsOrdered.getItems().clear();
			double totalPrice = 0.0;
			for(int i = 0; i < thisTicket.getItemsOrdered().size(); i++) {
				totalPrice = totalPrice + thisTicket.getItemsOrdered().get(i).getPrice();
				listViewItemsOrdered.getItems().add(thisTicket.getItemsOrdered().get(i));
			}
			lblTicketIDField.setText(Integer.toString(thisTicket.getTicketID()));
			lblTotalPriceField.setText(Double.toString(totalPrice));
			lblTimestampEntryField.setText(thisTicket.getTimestamp());
		}
	}
}
