package controllers;

import com.jfoenix.controls.JFXButton;
import com.jfoenix.controls.JFXTextField;
import db.DriverDatabase;
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
import model.Driver;
import views.tm.DriverTM;

import java.io.IOException;
import java.util.Optional;

public class AddDriverFormController {
    public AnchorPane AddDriverFormContext;
    public JFXTextField txtDriverName;
    public JFXTextField txtNic;
    public JFXTextField txtDriverLicenseNo;
    public JFXTextField txtAddress;
    public JFXTextField txtContact;
    public TableView<DriverTM> tblDriver;
    public TableColumn colDriverName;
    public TableColumn colNic;
    public TableColumn colDriverLicenseNo;
    public TableColumn colAddress;
    public TableColumn colContactNo;
    public TableColumn colOption;
    public JFXButton btnSaveDriver;

    public void initialize(){
        colDriverName.setCellValueFactory(new PropertyValueFactory("name"));
        colNic.setCellValueFactory(new PropertyValueFactory("nic"));
        colDriverLicenseNo.setCellValueFactory(new PropertyValueFactory("driverLicenseNo"));
        colAddress.setCellValueFactory(new PropertyValueFactory("address"));
        colContactNo.setCellValueFactory(new PropertyValueFactory("contactNo"));
        colOption.setCellValueFactory(new PropertyValueFactory("btn"));

        loadAllDriver();

        tblDriver.getSelectionModel().selectedItemProperty().addListener((observableValue, oldValue, newValue) ->{
            if(newValue!=null){
                setData(newValue);
            }

        } );
    }

    private void setData(DriverTM tm) {
        btnSaveDriver.setText("Update Driver");
        txtDriverName.setText(tm.getName());
        txtNic.setText(tm.getNic());
        txtDriverLicenseNo.setText(tm.getDriverLicenseNo());
        txtAddress.setText(tm.getAddress());
        txtContact.setText(tm.getContactNo());

    }

    private void loadAllDriver() {
        ObservableList<DriverTM> obList = FXCollections.observableArrayList();

        for (Driver d: DriverDatabase.driverTable
             ) {
            Button btn = new Button("Delete");
            DriverTM tm = new DriverTM(d.getName(),d.getNic(),d.getDriverLicenseNo(),d.getAddress(),d.getContactNo(),btn);
            obList.add(tm);

            btn.setOnAction((e)->{
               Alert alert = new Alert(Alert.AlertType.CONFIRMATION,
                       "Are you sure?",
                       ButtonType.YES, ButtonType.NO);
                Optional<ButtonType> buttonType = alert.showAndWait();
                if(buttonType.get().equals(ButtonType.YES)){
                    DriverDatabase.driverTable.remove(d);
                    obList.remove(tm);
                }else{

                }
            });
        }

        tblDriver.setItems(obList);
    }


    public void btnDriverSaveOnAction(ActionEvent actionEvent) {

        if(btnSaveDriver.getText().equals("Save Driver")){
            Driver d1 = new Driver(
                    txtDriverName.getText(),
                    txtNic.getText(),
                    txtDriverLicenseNo.getText(),
                    txtAddress.getText(),
                    txtContact.getText()
            );
            DriverDatabase.driverTable.add(d1);
            loadAllDriver();
        }else{
            for (Driver tm:DriverDatabase.driverTable
                 ) {
                if(tm.getNic().equals(txtNic.getText())){
                    tm.setName(txtDriverName.getText());
                    tm.setDriverLicenseNo(txtDriverLicenseNo.getText());
                    tm.setAddress(txtAddress.getText());
                    tm.setContactNo(txtContact.getText());
                    loadAllDriver();
                    return;
                }
            }
        }


    }

    public void btnAddNewDriverOnAction(ActionEvent actionEvent) {
        btnSaveDriver.setText("Save Driver");
    }

    public void goBackOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage =(Stage) AddDriverFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/InParkingForm.fxml"))));
        stage.centerOnScreen();
    }
}
