package view;

import controller.DataFunctions;
import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
import model.BackupContainer;
import model.MenuItemContainer;
import model.OrderTicket;
import model.OrderTicketContainer;

public class GUI extends Application {
	public static BackupContainer loadedSaveContainer = null;
	public static MenuItemContainer loadedMenuItemContainer = null;
	public static OrderTicketContainer loadedOrderTicketContainer = null;
	public static FXMLLoader loader0;
	public static FXMLLoader loader1;
	public static FXMLLoader loader2;
	public static FXMLLoader loader3;
	public static FXMLLoader loader4;
	public static FXMLLoader loader5;
	public static FXMLLoader loader6;
	public static Stage baristaPOSStage;
	public static Stage baristaPOSAddNewItemStage;
	public static Stage baristaPOSAdminStage;
	public static Stage baristaPOSChangeAdminPasswordStage;
	public static Stage baristaPOSLoginStage;
	public static Stage baristaPOSOrderHistoryStage;
	public static Stage baristaPOSOrderHistoryEntryDisplayStage;
	public static OrderTicket selectedTicket = null;
	
	public static void main(String [] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage stage) throws Exception {
		loader0 = new FXMLLoader(getClass().getResource("resources/BaristaPOS.fxml"));
		loader1 = new FXMLLoader(getClass().getResource("resources/BaristaPOSAddNewItem.fxml"));
		loader2 = new FXMLLoader(getClass().getResource("resources/BaristaPOSAdmin.fxml"));
		loader3 = new FXMLLoader(getClass().getResource("resources/BaristaPOSChangeAdminPassword.fxml"));
		loader4 = new FXMLLoader(getClass().getResource("resources/BaristaPOSLogin.fxml"));
		loader5 = new FXMLLoader(getClass().getResource("resources/BaristaPOSOrderHistory.fxml"));
		loader6 = new FXMLLoader(getClass().getResource("resources/BaristaPOSOrderHistoryEntryDisplay.fxml"));
		
		try {
			loadedSaveContainer = DataFunctions.readSaveFile("default");
		} catch (Exception ex) {
			Alert infoDialog = new Alert(AlertType.ERROR, "A save file could not be found.", ButtonType.OK);
			infoDialog.showAndWait();
			loadedSaveContainer = new BackupContainer();
			loadedMenuItemContainer = new MenuItemContainer();
			loadedOrderTicketContainer = new OrderTicketContainer();
		}
		
		if(!(loadedSaveContainer.getItem(0) == null)){
			if(loadedSaveContainer.getItem(0) instanceof MenuItemContainer && loadedSaveContainer.getItem(1) instanceof OrderTicketContainer) {
				loadedMenuItemContainer = (MenuItemContainer) loadedSaveContainer.getItem(0);
				loadedOrderTicketContainer = (OrderTicketContainer) loadedSaveContainer.getItem(1);
			} else {
				Alert infoDialog = new Alert(AlertType.ERROR, "There was a problem loading the save file.", ButtonType.OK);
				infoDialog.showAndWait();
				loadedMenuItemContainer = new MenuItemContainer();
				loadedOrderTicketContainer = new OrderTicketContainer();
			}
		}

		Pane pane0 = loader0.load();
		Scene scene0 = new Scene(pane0);
		baristaPOSStage = new Stage();
		baristaPOSStage.setScene(scene0);
		baristaPOSStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent e) {
				if(loadedMenuItemContainer != new MenuItemContainer()) {
					loadedSaveContainer.addItem(loadedMenuItemContainer);
				}
				if(loadedOrderTicketContainer != new OrderTicketContainer()) {
					loadedSaveContainer.addItem(loadedOrderTicketContainer);
				}
				try {
					DataFunctions.writeSaveFile(loadedSaveContainer);
				} catch (Exception ex) {
					Alert infoDialog = new Alert(AlertType.ERROR, "There was a problem writing save data.", ButtonType.OK);
					infoDialog.showAndWait();
					return;
				}
			}
		});
		
		Pane pane1 = loader1.load();
		Scene scene1 = new Scene(pane1);
		baristaPOSAddNewItemStage = new Stage();
		baristaPOSAddNewItemStage.setScene(scene1);
		baristaPOSAddNewItemStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent e) {
				baristaPOSAdminStage.show();
			}
		});
		Pane pane2 = loader2.load();
		Scene scene2 = new Scene(pane2);
		baristaPOSAdminStage = new Stage();
		baristaPOSAdminStage.setScene(scene2);
		baristaPOSAdminStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent e) {
				baristaPOSStage.show();
			}
		});
		
		Pane pane3 = loader3.load();
		Scene scene3 = new Scene(pane3);
		baristaPOSChangeAdminPasswordStage = new Stage();
		baristaPOSChangeAdminPasswordStage.setScene(scene3);
		baristaPOSChangeAdminPasswordStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent e) {
				baristaPOSAdminStage.show();
			}
		});
		
		Pane pane4 = loader4.load();
		Scene scene4 = new Scene(pane4);
		baristaPOSLoginStage = new Stage();
		baristaPOSLoginStage.setScene(scene4);
		baristaPOSLoginStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent e) {
				baristaPOSStage.show();
			}
		});
		
		Pane pane5 = loader5.load();
		Scene scene5 = new Scene(pane5);
		baristaPOSOrderHistoryStage = new Stage();
		baristaPOSOrderHistoryStage.setScene(scene5);
		baristaPOSOrderHistoryStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent e) {
				baristaPOSStage.show();
			}
		});
		
		Pane pane6 = loader6.load();
		Scene scene6 = new Scene(pane6);
		baristaPOSOrderHistoryEntryDisplayStage = new Stage();
		baristaPOSOrderHistoryEntryDisplayStage.setScene(scene6);
		baristaPOSOrderHistoryEntryDisplayStage.setOnCloseRequest(new EventHandler<WindowEvent>() {
			@Override
			public void handle(WindowEvent e) {
				baristaPOSOrderHistoryStage.show();
			}
		});
		baristaPOSStage.show();
	}
}
