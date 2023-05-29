module com.example.foodo_fx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    requires java.desktop;
    requires javafx.graphics;



    opens com.example.foodo to javafx.fxml;
    exports com.example.foodo;
    exports com.example.foodo.guiclass;
    //opens com.example.foodo_fx.controller to javafx.fxml;
    //opens com.example.foodo_fx.controllerApplicativi to javafx.fxml;
    opens com.example.foodo.guiclass to javafx.fxml;
    exports com.example.foodo.model;
    opens com.example.foodo.model to javafx.fxml;
    opens com.example.foodo.engineering.bean to javafx.fxml;
    exports com.example.foodo.engineering.bean;

}