package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.CheckBox;
import javafx.scene.control.TextField;
import model.MenuItem;
import view.GUI;
import javafx.scene.control.Alert.AlertType;

public class BaristaPOSAddNewItemController {
	@FXML
	private TextField textFieldItemName;
	
	@FXML
	private TextField textFieldItemMenuDisplayName;
	
	@FXML
	private TextField textFieldItemPrice;
	
	@FXML
	private TextField textFieldItemType;
	
	@FXML
	private CheckBox checkBoxSameAsItemName;
	
	@FXML
	private Button btnCreateNewItem;
	
	public void initialize() {
		
	}
	public void btnCreateNewItemClicked() {
		String itemName;
		String itemMenuDisplayName;
		double itemPrice;
		int itemType;
		
		if(textFieldItemName.getText().isBlank() || textFieldItemMenuDisplayName.getText().isBlank()
				|| textFieldItemPrice.getText().isBlank() || textFieldItemType.getText().isBlank()) {
			Alert infoDialog = new Alert(AlertType.ERROR, "Fill out all fields first.", ButtonType.OK);
			infoDialog.showAndWait();
			return;
		} else {
			itemName = textFieldItemName.getText();
			
			if(checkBoxSameAsItemName.isSelected()) {
				itemMenuDisplayName = textFieldItemName.getText();
			} else {
				itemMenuDisplayName = textFieldItemMenuDisplayName.getText();
			}
			
			try {
				itemPrice = Double.parseDouble(textFieldItemPrice.getText());
			} catch (Exception ex) {
				Alert infoDialog = new Alert(AlertType.ERROR, "Ensure the Item Price field is filled correctly. Only a double value is accepted.", ButtonType.OK);
				infoDialog.showAndWait();
				return;
			}
			
			try {
				itemType = Integer.parseInt(textFieldItemType.getText());
			} catch (Exception ex) {
				Alert infoDialog = new Alert(AlertType.ERROR, "Ensure the Item Type field is filled correctly. Only an integer value between 1 and 4 is accepted.", ButtonType.OK);
				infoDialog.showAndWait();
				return;
			}
			
			if(itemType > 4 || itemType < 1) {
				Alert infoDialog = new Alert(AlertType.ERROR, "Ensure the Item Type field is filled correctly. Only an integer value between 1 and 4 is accepted.", ButtonType.OK);
				infoDialog.showAndWait();
				return;
			}
			
			MenuItem returnedItem = new MenuItem(itemName, itemMenuDisplayName, itemPrice, itemType);
			GUI.loadedMenuItemContainer.addItem(returnedItem);
			Alert infoDialog = new Alert(AlertType.INFORMATION, "This item has been created successfully.", ButtonType.OK);
			infoDialog.showAndWait();
			GUI.baristaPOSAddNewItemStage.close();
			GUI.baristaPOSAdminStage.show();
		}
	}
	public void checkBoxSameAsItemNameClicked() {
		if(checkBoxSameAsItemName.isSelected()) {
			textFieldItemMenuDisplayName.setEditable(false);
			textFieldItemMenuDisplayName.setText(textFieldItemName.getText());
		} else {
			textFieldItemMenuDisplayName.setEditable(true);
		}
	}
	public void textFieldItemNameTextChanged() {
		if(checkBoxSameAsItemName.isSelected()) {
			textFieldItemMenuDisplayName.setText(textFieldItemName.getText());
		}
	}
}
