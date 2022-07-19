package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.VehicleDatabase;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;
import model.Vehicle;
import views.tm.VehicleTM;

import java.io.IOException;
import java.util.Optional;

public class AddVehicleFormController {
    public AnchorPane AddVehicleFormContext;
    public TableView<VehicleTM> tblVehicle;
    public TableColumn colVehicleNo;
    public TableColumn colVehicleType;
    public TableColumn colMaxWeight;
    public TableColumn colNoOfPassengers;
    public TableColumn colAction;
    public JFXTextField txtVehicleNo;
    public JFXTextField txtMaxWeight;
    public JFXTextField txtNoOfPassengers;
    public ComboBox<String> cmbVehicleType;
    public JFXButton btnSaveVehicle;


    public void initialize(){
        colVehicleNo.setCellValueFactory(new PropertyValueFactory("No"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory( "type"));
        colMaxWeight.setCellValueFactory(new PropertyValueFactory("weight"));
        colNoOfPassengers.setCellValueFactory(new PropertyValueFactory("noOfPassengers"));
        colAction.setCellValueFactory(new PropertyValueFactory("btn"));
        loadAllVehicle();

        tblVehicle.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->{
            if(newValue!=null){
                setData(newValue);
            }

        } );

        ObservableList<String> obList1 = FXCollections.observableArrayList();
        obList1.add("Van");
        obList1.add("Bus");
        obList1.add("Cargo Lorry");
        cmbVehicleType.setItems(obList1);

        cmbVehicleType.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->{
            colVehicleType.setCellValueFactory(new PropertyValueFactory("type"));

        } );
    }

    private void setData(VehicleTM tm) {
        btnSaveVehicle.setText("Update Vehicle");
        txtVehicleNo.setText(tm.getNo());
        cmbVehicleType.setPromptText(tm.getType());
        txtMaxWeight.setText(String.valueOf(tm.getWeight()));
        txtNoOfPassengers.setText(String.valueOf(tm.getNoOfPassengers()));
    }

    private void loadAllVehicle() {
        ObservableList<VehicleTM> obList = FXCollections.observableArrayList();
        for (Vehicle v: VehicleDatabase.vehicleTable
             ) {
            Button btn = new Button("Delete");
            VehicleTM tm = new VehicleTM(v.getNo(),v.getType(),v.getWeight(),v.getNoOfPassengers(),btn);
            obList.add(tm);
            btn.setOnAction((e)->{
                Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                        "Are you sure?",
                        ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if(buttonType.get().equals(ButtonType.YES)){
                    VehicleDatabase.vehicleTable.remove(v);
                    obList.remove(tm);
                }

            });

        }
        tblVehicle.setItems(obList);
        
    }

    public void btnSaveOnAction(ActionEvent actionEvent) {
        if(btnSaveVehicle.getText().equals("Save Vehicle")){
            Vehicle v1 = new Vehicle(
                    txtVehicleNo.getText(),
                    cmbVehicleType.getValue(),
                    Integer.parseInt(txtMaxWeight.getText()),
                    Integer.parseInt(txtNoOfPassengers.getText())
            );

            VehicleDatabase.vehicleTable.add(v1);
            loadAllVehicle();
        }else{
            for (Vehicle tm: VehicleDatabase.vehicleTable
                 ) {
                if(tm.getNo().equals(txtVehicleNo.getText())){
                     tm.setType(cmbVehicleType.getValue());
                     tm.setWeight(Integer.parseInt(txtMaxWeight.getText()));
                     tm.setNoOfPassengers(Integer.parseInt(txtNoOfPassengers.getText()));
                     loadAllVehicle();
                     return;
                }
            }
        }

    }

    public void btnNewVehicleOnAction(ActionEvent actionEvent) {
        btnSaveVehicle.setText("Save Vehicle");
    }

    public void goBackOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage = (Stage) AddVehicleFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/InParkingForm.fxml"))));
        stage.centerOnScreen();

    }
}
