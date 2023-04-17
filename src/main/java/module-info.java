module com.example.foodo_fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.foodo to javafx.fxml;
    exports com.example.foodo;
    exports com.example.foodo.GUIclass;
    //opens com.example.foodo_fx.controller to javafx.fxml;
    //opens com.example.foodo_fx.controllerApplicativi to javafx.fxml;
    opens com.example.foodo.GUIclass to javafx.fxml;
    exports com.example.foodo.model;
    opens com.example.foodo.model to javafx.fxml;

}