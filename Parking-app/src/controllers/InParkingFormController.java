package controllers;

import db.VehicleDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Vehicle;
import views.tm.VehicleTM;

import java.io.IOException;

public class InParkingFormController{
    public AnchorPane inParkingFormContext;
    public ComboBox cmbParking;
    public TableColumn colVehicleNo;
    public TableColumn colVehicleType;
    public TableColumn colParkingSlot;
    public TableColumn colParkingDate;
    public TableColumn colParkingTime;
    public TableView tblInParkingData;



    public void initialize(){


        loadAllInParkingDetails();
    }

    private void loadAllInParkingDetails() {
        ObservableList<VehicleTM> obList = FXCollections.observableArrayList();

        for (Vehicle v: VehicleDatabase.vehicleTable
             ) {
            Button btn = new Button();
            VehicleTM  tm = new VehicleTM(v.getNo(),v.getType(),v.getWeight(),v.getNoOfPassengers(),btn);
            obList.add(tm);
        }
        tblInParkingData.setItems(obList);
    }

    public void btnLogOutOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage =(Stage) inParkingFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/ManagementLoginForm.fxml"))));
        stage.centerOnScreen();
    }

    public void btnAddNewVehicleOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage =(Stage) inParkingFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/AddVehicleForm.fxml"))));
        stage.centerOnScreen();
    }

    public void btnAddNewDriverOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage =(Stage) inParkingFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/AddDriverForm.fxml"))));
        stage.centerOnScreen();
    }

    public void goOnDeliveryOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage =(Stage) inParkingFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/OnDeliveryForm.fxml"))));
        stage.centerOnScreen();
    }
}
