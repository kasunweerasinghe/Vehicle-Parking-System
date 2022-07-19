package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class OnDeliveryFormController {
    public AnchorPane onDeliveryFormContext;

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage =(Stage) onDeliveryFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/ManagementLoginForm.fxml"))));
        stage.centerOnScreen();
    }

    public void goInParkingOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage =(Stage) onDeliveryFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/InParkingForm.fxml"))));
        stage.centerOnScreen();
    }

    public void btnAddNewVehicleOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage =(Stage) onDeliveryFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/AddVehicleForm.fxml"))));
        stage.centerOnScreen();
    }

    public void btnAddNewDriverOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage =(Stage) onDeliveryFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/AddDriverForm.fxml"))));
        stage.centerOnScreen();
    }
}
