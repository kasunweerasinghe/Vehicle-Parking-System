package controllers;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import javafx.stage.Window;

import java.io.IOException;

public class ManagementLoginFormController {
    public TextField txtUserName;
    public TextField pwdPassword;
    public AnchorPane ManagementLogInFormContext;


    public void btnlogInOnAction(ActionEvent actionEvent) throws IOException {
        String tempUserName=txtUserName.getText();
        String tempPassword=pwdPassword.getText();

        if (tempUserName.equals("kasun") && tempPassword.equals("1234")) {
            //new Alert(Alert.AlertType.CONFIRMATION, "Success!").show();
            setUi("InParkingForm");

        }else{
            new Alert(Alert.AlertType.WARNING, "Try Again!").show();
        }

    }
    public void btncancelOnAction(ActionEvent actionEvent) throws IOException {
        Stage stage =(Stage) ManagementLogInFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/DriverParkingSystemForm.fxml"))));
        stage.centerOnScreen();
    }

    private void setUi(String location) throws IOException {
        Stage stage =(Stage) ManagementLogInFormContext.getScene().getWindow();
        stage.setScene(new Scene(FXMLLoader.load(getClass().getResource("../views/"+location+".fxml"))));
        stage.centerOnScreen();
    }


}
