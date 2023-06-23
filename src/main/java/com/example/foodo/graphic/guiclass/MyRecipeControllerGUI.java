package com.example.foodo.graphic.guiclass;

import com.example.foodo.controllerappl.MyRecipeController;
import com.example.foodo.engineering.utils.MyListener;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.exception.ConnectionDbException;
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

import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import javafx.geometry.Insets;

public class MyRecipeControllerGUI implements Initializable{

    private GridPane grid;
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
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/chefMainPage.fxml"));
        Scene sceneMainView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }

    public void showAddNewRecipes(ActionEvent event) throws IOException{
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/addNewRecipes.fxml"));
        Scene sceneMainView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }

    public void initialize(URL location, ResourceBundle resources){
        try {
            recipeBeans1.addAll(getData());

        } catch (SQLException e) {
            throw new RuntimeException(e);
        } catch (ConnectionDbException e) {
            throw new RuntimeException(e);
        }

        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < recipeBeans1.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/guiclass/recipeItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemControllerGUI itemControllerGUI = fxmlLoader.getController();
                itemControllerGUI.setData(recipeBeans1.get(i),myListener,i, recipeBeans1.get(i).getRecipeName(), recipeBeans1.get(i).getChefName());
                itemControllerGUI.setInterfaceName("myRecipe");


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
