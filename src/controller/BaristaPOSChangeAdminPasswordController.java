package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import view.GUI;
import javafx.scene.control.Alert.AlertType;

public class BaristaPOSChangeAdminPasswordController {
	@FXML
	private TextField textFieldNewPasswordField;
	
	@FXML
	private Button btnSaveAdminPassword;
	
	public void initialize() {
		
	}
	public void btnSaveAdminPasswordClicked() {
		if(textFieldNewPasswordField.getText().isBlank()) {
			Alert infoDialog = new Alert(AlertType.ERROR, "Please enter a new password.", ButtonType.OK);
			infoDialog.showAndWait();
			return;
		} else {
			GUI.loadedSaveContainer.setAdminPassword(textFieldNewPasswordField.getText());
			Alert infoDialog = new Alert(AlertType.INFORMATION, "The administrator password has been successfully updated.", ButtonType.OK);
			infoDialog.showAndWait();
			GUI.baristaPOSChangeAdminPasswordStage.close();
			GUI.baristaPOSAdminStage.show();
		}
	}
}
