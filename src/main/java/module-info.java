module com.example.foodo_fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.foodo_fx to javafx.fxml;
    exports com.example.foodo_fx;
    exports com.example.foodo_fx.GUIclass;
    //opens com.example.foodo_fx.controller to javafx.fxml;
    //opens com.example.foodo_fx.controllerApplicativi to javafx.fxml;
    opens com.example.foodo_fx.GUIclass to javafx.fxml;
    exports com.example.foodo_fx.model;
    opens com.example.foodo_fx.model to javafx.fxml;

}