package com.example.foodo.graphic.guiclass;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;

public class AlertControllerGUI {
    @FXML
    public Label labelMsg;
    @FXML
    public Label labelName;

    public void setLabelMSG(String msg){
        this.labelMsg.setText(msg);
    }

    public void closeAction(ActionEvent event) {
        ((Node)event.getSource()).getScene().getWindow().hide();
    }


}
