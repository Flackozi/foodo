package com.example.foodo.graphic.guiclass;

import com.example.foodo.controllerappl.MyRecipeController;
import com.example.foodo.engineering.utils.MyListener;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.exception.ConnectionDbException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.geometry.Insets;

public class MyRecipeControllerGUI implements Initializable{
    @FXML
    private GridPane grid;
    @FXML
    private ScrollPane scroll;
    private MyListener myListener;
    private List<RecipeBean> recipeBeans1 = new ArrayList<>();


    private List<RecipeBean> getData() throws SQLException, ConnectionDbException {
        List<RecipeBean> recipeBeans = new ArrayList<>();

        MyRecipeController myRecipeController = new MyRecipeController();
        recipeBeans = myRecipeController.retriveRecipeItem();
        return recipeBeans;
    }

    public void backHome(ActionEvent event) throws IOException {
        Parent scene = FXMLLoader.load(getClass().getResource("/guiclass/chefMainPage.fxml"));
        Scene sceneMainView = new Scene(scene);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }

    public void initialize(URL location, ResourceBundle resources){

        int column = 0;
        int row = 1;



        try {
            recipeBeans1.addAll(getData());
            for (RecipeBean recipeBean : recipeBeans1) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/guiclass/recipeItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemControllerGUI itemControllerGUI = fxmlLoader.getController();
                itemControllerGUI.setData(recipeBean, myListener, recipeBean.getRecipeName(), recipeBean.getChefName());
                itemControllerGUI.setInterfaceName("myRecipe");


                if (column == 2) {
                    row++;
                    column = 0;
                }

                grid.add(anchorPane, column++, row); //(child,column,row)

                //set grid height
                grid.setMinHeight(Region.USE_COMPUTED_SIZE);
                grid.setPrefHeight(Region.USE_COMPUTED_SIZE);
                grid.setMaxHeight(Region.USE_PREF_SIZE);

                //set grid width
                grid.setMinWidth(Region.USE_COMPUTED_SIZE);
                grid.setPrefWidth(Region.USE_COMPUTED_SIZE);
                grid.setMaxWidth(Region.USE_PREF_SIZE);


                GridPane.setMargin(anchorPane, new Insets(10));
            }
        } catch (IOException | SQLException | ConnectionDbException e) {
            e.printStackTrace();
        }

    }

    public void showAddNewRecipes(ActionEvent event) throws IOException{
        Parent scene = FXMLLoader.load(getClass().getResource("/guiclass/addNewRecipes.fxml"));
        Scene sceneMainView = new Scene(scene);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }


}

