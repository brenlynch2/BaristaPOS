package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.PasswordField;
import view.GUI;
import javafx.scene.control.Alert.AlertType;

public class BaristaPOSLoginController {
	@FXML
	private PasswordField pwdFieldAdminPasswordField;
	
	@FXML
	private Button btnLogin;
	
	public void initialize() {
		
	}
	public void btnLoginClicked() {
		if(pwdFieldAdminPasswordField.getText().isBlank()) {
			Alert infoDialog = new Alert(AlertType.ERROR, "Please enter the administrator password.", ButtonType.OK);
			infoDialog.showAndWait();
			return;
		} else {
			if(pwdFieldAdminPasswordField.getText().equals(GUI.loadedSaveContainer.getAdminPassword())){
				Alert infoDialog = new Alert(AlertType.INFORMATION, "You have been successfully logged in.", ButtonType.OK);
				infoDialog.showAndWait();
				GUI.baristaPOSAdminStage.show();
				GUI.baristaPOSLoginStage.close();
			} else {
				Alert infoDialog = new Alert(AlertType.ERROR, "That password is incorrect.", ButtonType.OK);
				infoDialog.showAndWait();
				return;
			}
		}
	}
}
