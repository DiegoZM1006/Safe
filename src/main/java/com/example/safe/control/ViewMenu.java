package com.example.safe.control;

import com.example.safe.HelloApplication;
import com.example.safe.model.FileOpenerData;
import com.example.safe.model.FileUtils;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class ViewMenu implements Initializable {

    @FXML
    private TextArea txtContentUser;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle){
        txtContentUser.setText(FileOpenerData.getInstance().getPassword().getContentUser());
    }

    /*public void showInfo() {

         FileOpenerData.getInstance().getPassword().getContentUser();
         txtContentUser.setText("Hola");

    }*/

    @FXML
    void btnChangePassword(ActionEvent event) {

        HelloApplication.showWindow("view-changePassword.fxml");
        Stage currentStage = (Stage) txtContentUser.getScene().getWindow();
        currentStage.hide();
        FileOpenerData.getInstance().getPassword().setContentUser(txtContentUser.getText());
        FileUtils.fillDB();

    }

    @FXML
    void btnExit(ActionEvent event) {

        HelloApplication.showWindow("hello-view.fxml");
        Stage currentStage = (Stage) txtContentUser.getScene().getWindow();
        currentStage.hide();
        FileOpenerData.getInstance().getPassword().setContentUser(txtContentUser.getText());
        FileUtils.fillDB();

    }

}
