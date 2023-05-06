package com.example.foodo;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
//import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.io.IOException;

public class Main extends Application {
    private static Stage stage;
    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(Main.class.getResource("/guiclass/mainSceneLogin.fxml"));
        Scene scene = new Scene(fxmlLoader.load(), 390, 844);
        stage.setTitle("Foodo");
        stage.setScene(scene);
        stage.show();
    }
    public static void setStage(Stage stage) {
        Main.stage = stage;
    }
    public static Stage getStage(){
        return stage;
    }

    public static void main(String[] args) {
        launch();
    }
}
