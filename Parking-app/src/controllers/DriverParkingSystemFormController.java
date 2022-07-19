package controllers;

import db.DriverDatabase;
import db.InParkingDatabase;
import db.SlotDatabase;
import db.VehicleDatabase;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import model.Driver;
import model.Vehicle;
import views.tm.DriverTM;
import views.tm.VehicleTM;

import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class DriverParkingSystemFormController {
    public AnchorPane ParkingSystemFormContext;
    public ComboBox<String> cmbSelectVehicle;
    public ComboBox<String> cmbSelectDriver;
    public Label lblDate;
    public Label lblTime;
    public TextField txtSelectedVehicle;
    public TextField txtSlotNo;
    public Button btnPark;
    public Button btnDelivery;

    public void initialize() {

        displayTime();
        //Get Vehicle Data
        ObservableList<VehicleTM> obList = FXCollections.observableArrayList();
        for (Vehicle v : VehicleDatabase.vehicleTable
        ) {
            //Add VehicleNo to Combo Box
            ObservableList<String> obList1 = FXCollections.observableArrayList();
            obList1.add(v.getNo());
            cmbSelectVehicle.getItems().addAll(obList1);

            cmbSelectVehicle.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) -> {
                //Fill automatically vehicle type data

                for (Vehicle vehicle : VehicleDatabase.vehicleTable) {
                    if (newValue.equals(vehicle.getNo())) {
                        txtSelectedVehicle.setText(vehicle.getType());
                        break;
                    }
                }
                findSlot();
            });
        }
        //Get Driver Name
        ObservableList<DriverTM> obList2 = FXCollections.observableArrayList();
        for (Driver d : DriverDatabase.driverTable
        ) {
            //Add Driver name to Combo Box
            ObservableList<String> obList3 = FXCollections.observableArrayList();
            obList3.add(d.getName());
            cmbSelectDriver.getItems().addAll(obList3);

        }
    }

    private void setSlot(String VehicleType) {
        for (int i = 0; i < SlotDatabase.slotTable.size(); i++) {
            for (int j = 0; j < SlotDatabase.slotTable.size(); j--) {
                if (VehicleType.equals(SlotDatabase.slotTable.get(i).getVehicleType()) && SlotDatabase.slotTable.get(i).getOption("notUse").equals("notUse")) {
                    txtSlotNo.setText(SlotDatabase.slotTable.get(i).getSlotNo());
                    return;
                }
            }
        }
        clearSlottbl();
    }

    private void clearSlottbl() {
        for(int i = 0; i<InParkingDatabase.parkingTable.size(); i++){
            if(InParkingDatabase.parkingTable.get(i).getNo().equals(cmbSelectVehicle.getValue())){
                txtSlotNo.setText(" ");
            }
        }

    }
    public void clearFields() {
        txtSelectedVehicle.clear();
        cmbSelectVehicle.getSelectionModel().clearSelection();
        cmbSelectDriver.getSelectionModel().clearSelection();
    }



    private void findSlot() {
        switch (txtSelectedVehicle.getText()) {
            case "Van": {
                setSlot("Van");
            }
            break;
            case "Cargo Lorry": {
                setSlot("Cargo Lorry");
            }
            break;
            case "Bus": {
                setSlot("Bus");
            }
            break;
        }
    }

    private void displayTime() {
        Timeline clock = new Timeline(new KeyFrame(Duration.ZERO, e -> {
            DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyy-MM-dd");
            DateTimeFormatter formatter1 = DateTimeFormatter.ofPattern("HH-mm-ss");
            lblDate.setText(LocalDateTime.now().format(formatter));
            lblTime.setText(LocalDateTime.now().format(formatter1));
        }), new KeyFrame(Duration.seconds(1)));
        clock.setCycleCount(Animation.INDEFINITE);
        clock.play();
    }

    public void btnManagementLogOnAction(ActionEvent actionEvent) throws IOException {
        setUi("ManagementLoginForm");
    }

    private void setUi(String location) throws IOException {
        Stage stage = (Stage) ParkingSystemFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/" + location + ".fxml"))));
        stage.centerOnScreen();
    }

    public void parkVehicleOnAction(ActionEvent actionEvent) {
        for(int k=0; k<SlotDatabase.slotTable.size(); k++){
            if(txtSlotNo.getText().equals(SlotDatabase.slotTable.get(k).getSlotNo())){
                SlotDatabase.slotTable.get(k).setOption("Use");
            }
        }
        parkTest();

    }

    private void parkTest() {
        cmbSelectVehicle.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->{
            btnPark.setDisable(false);
            String temp = String.valueOf(newValue);
            for(int i=0; i<InParkingDatabase.parkingTable.size(); i++){
                boolean b=InParkingDatabase.parkingTable.get(i).getNo().contains(temp);
                if (b==true){
                    btnPark.setDisable(true);
                }
            }
        } );
        boolean b = false;
        if(b==false){
            
        }
    }

    public void onDeliveryShiftOnAction(ActionEvent actionEvent) {
        try{
            for(int k=0; k<InParkingDatabase.parkingTable.size(); k++){
                if(cmbSelectVehicle.getValue().equals(InParkingDatabase.parkingTable.get(k).getNo())){
                    setnotuse(InParkingDatabase.parkingTable.get(k).getSlotNo());
                }
            }
        }catch (Throwable e){
            System.out.println(e);
        }

    }

    public void setnotuse(String slotnmbr){
        for(int i=0; i<SlotDatabase.slotTable.size(); i++){
            if(SlotDatabase.slotTable.get(i).getSlotNo().equals(slotnmbr)){
                SlotDatabase.slotTable.get(i).setOption("notUse");
            }
        }
    }

}
