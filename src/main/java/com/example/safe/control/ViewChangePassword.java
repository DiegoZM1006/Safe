package com.example.safe.control;

import com.example.safe.HelloApplication;
import com.example.safe.model.FileOpenerData;
import com.example.safe.model.Password;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ViewChangePassword {

    @FXML
    private TextField txtCurrentPassword1;

    @FXML
    private TextField txtCurrentPassword2;

    @FXML
    private TextField txtCurrentPassword3;

    @FXML
    private TextField txtCurrentPassword4;

    @FXML
    private TextField txtCurrentPassword5;

    @FXML
    private TextField txtCurrentPassword6;

    @FXML
    private TextField txtNewPassword1;

    @FXML
    private TextField txtNewPassword2;

    @FXML
    private TextField txtNewPassword3;

    @FXML
    private TextField txtNewPassword4;

    @FXML
    private TextField txtNewPassword5;

    @FXML
    private TextField txtNewPassword6;

    @FXML
    void btnChangePassword(ActionEvent event) {

        String currentPassword = txtCurrentPassword1.getText() + txtCurrentPassword2.getText() + txtCurrentPassword3.getText() + txtCurrentPassword4.getText() + txtCurrentPassword5.getText() + txtCurrentPassword6.getText();
        String newPassword = txtNewPassword1.getText() + txtNewPassword2.getText() + txtNewPassword3.getText() + txtNewPassword4.getText() + txtNewPassword5.getText() + txtNewPassword6.getText();



        if(FileOpenerData.getInstance().getPassword().getPassword().equals(currentPassword) && newPassword.length() == 6 &&
                !txtCurrentPassword1.getText().equals("") && !txtCurrentPassword2.getText().equals("") && !txtCurrentPassword3.getText().equals("") &&
                !txtCurrentPassword4.getText().equals("") && !txtCurrentPassword5.getText().equals("") && !txtCurrentPassword6.getText().equals("")
        ) {
            if(!txtNewPassword1.getText().equals("") && !txtNewPassword2.getText().equals("") && !txtNewPassword3.getText().equals("") &&
                    !txtNewPassword4.getText().equals("") && !txtNewPassword5.getText().equals("") && !txtNewPassword6.getText().equals("")
            ) {
                Password myPassword = new Password(newPassword, FileOpenerData.getInstance().getPassword().getContentUser());
                FileOpenerData.getInstance().setPassword(myPassword);
                Alert alert = new Alert(Alert.AlertType.INFORMATION);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("La contraseña fue cambiada");
                alert.showAndWait();
                HelloApplication.showWindow("view-menu.fxml");
                Stage currentStage = (Stage) txtCurrentPassword1.getScene().getWindow();
                currentStage.hide();
            } else {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setHeaderText(null);
                alert.setTitle("Error");
                alert.setContentText("La nueva es incorrecta");
                alert.showAndWait();
            }
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("La contraseña no coincide con la actual o rellena todos los campos de la nueva contraseña");
            alert.showAndWait();
        }

    }

    @FXML
    void btnExit(ActionEvent event) {
        HelloApplication.showWindow("hello-view.fxml");
        Stage currentStage = (Stage) txtCurrentPassword1.getScene().getWindow();
        currentStage.hide();
    }

    @FXML
    void keyTyped(KeyEvent keyEvent) {

        if(keyEvent.getSource().equals(txtCurrentPassword1)){
            txtCurrentPassword2.requestFocus();
        }
        if(keyEvent.getSource().equals(txtCurrentPassword2)){
            txtCurrentPassword3.requestFocus();
        }
        if(keyEvent.getSource().equals(txtCurrentPassword3)){
            txtCurrentPassword4.requestFocus();
        }
        if(keyEvent.getSource().equals(txtCurrentPassword4)){
            txtCurrentPassword5.requestFocus();
        }
        if(keyEvent.getSource().equals(txtCurrentPassword5)) {
            txtCurrentPassword6.requestFocus();
        }

    }

    @FXML
    void keyTyped2(KeyEvent keyEvent) {

        if(keyEvent.getSource().equals(txtNewPassword1)){
            txtNewPassword2.requestFocus();
        }
        if(keyEvent.getSource().equals(txtNewPassword2)){
            txtNewPassword3.requestFocus();
        }
        if(keyEvent.getSource().equals(txtNewPassword3)){
            txtNewPassword4.requestFocus();
        }
        if(keyEvent.getSource().equals(txtNewPassword4)){
            txtNewPassword5.requestFocus();
        }
        if(keyEvent.getSource().equals(txtNewPassword5)) {
            txtNewPassword6.requestFocus();
        }

    }

}
