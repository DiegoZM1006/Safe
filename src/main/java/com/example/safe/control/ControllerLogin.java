package com.example.safe.control;

import com.example.safe.HelloApplication;
import com.example.safe.model.FileOpenerData;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyEvent;
import javafx.stage.Stage;

public class ControllerLogin {

    @FXML
    private TextField txt1;

    @FXML
    private TextField txt2;

    @FXML
    private TextField txt3;

    @FXML
    private TextField txt4;

    @FXML
    private TextField txt5;

    @FXML
    private TextField txt6;

    @FXML
    void btnAbrir(ActionEvent event) {

        String password = txt1.getText() + txt2.getText() + txt3.getText() + txt4.getText() + txt5.getText() + txt6.getText();
        // System.out.println(password);

        if(FileOpenerData.getInstance().getPassword().getPassword().equals(password) &&
                !txt1.getText().equals("") && !txt2.getText().equals("") && !txt3.getText().equals("") &&
                !txt4.getText().equals("") && !txt5.getText().equals("") && !txt6.getText().equals("")
        ) {
            HelloApplication.showWindow("view-menu.fxml");
            Stage currentStage = (Stage) txt1.getScene().getWindow();
            currentStage.hide();
        } else {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setHeaderText(null);
            alert.setTitle("Error");
            alert.setContentText("CONTRASEÑA INCORRECTA");
            alert.showAndWait();
        }
    }

    @FXML
    void keyTyped(KeyEvent keyEvent) {

        if(keyEvent.getSource().equals(txt1)){
            txt2.requestFocus();
        }
        if(keyEvent.getSource().equals(txt2)){
            txt3.requestFocus();
        }
        if(keyEvent.getSource().equals(txt3)){
            txt4.requestFocus();
        }
        if(keyEvent.getSource().equals(txt4)){
            txt5.requestFocus();
        }
        if(keyEvent.getSource().equals(txt5)) {
            txt6.requestFocus();
        }

    }

}