package com.example.foodo.guiclass;

import com.example.foodo.controllerappl.MyChefController;
import com.example.foodo.engineering.Utils.MyListener;
import com.example.foodo.engineering.bean.RecipeItemBean;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.model.RecipeItemModel;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.awt.*;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.ResourceBundle;
import javafx.geometry.Insets;

public class MyChefControllerGUI implements Initializable {

    public GridPane grid;
    public ScrollPane scroll;
    private MyListener myListener;
    private List<RecipeItemBean> recipeItembeanList = new ArrayList<>();



    private List<RecipeItemBean> getData() throws SQLException, ConnectionDbException {
        List<RecipeItemBean> recipeItemBeanList = new ArrayList<>();
        //RecipeItemModel recipeItemModel = new RecipeItemModel();
        //bisogna ottenere il numero di ricette che saranno presenti nella schermata
        //attraverso controller appl. ottengo le info delle sole ricette di chef seguiti dal utente
        //correntemente loggato
        MyChefController myChefController = new MyChefController();
        recipeItemBeanList = myChefController.retriveItem();

        return recipeItemBeanList;
    }
    public void backHome(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/sceneHomeUser.fxml")));
        Scene sceneMainView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }

    public void initialize(URL location, ResourceBundle resources){
        try {
            recipeItembeanList.addAll(getData());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ConnectionDbException e) {
            throw new RuntimeException(e);
        }

        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < recipeItembeanList.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/guiclass/recipeItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemController itemController = fxmlLoader.getController();
                itemController.setData(recipeItembeanList.get(i),myListener);

                if (column == 2) {
                    column = 0;
                    row++;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)
                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
