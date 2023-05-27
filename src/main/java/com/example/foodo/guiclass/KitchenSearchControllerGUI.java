package com.example.foodo.guiclass;

import com.example.foodo.controllerappl.SearchRecipeController;
import com.example.foodo.engineering.Utils.MyListener;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.bean.RecipeItemBean;
import com.example.foodo.engineering.bean.SearchRecipeBean;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Insets;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Region;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class KitchenSearchControllerGUI {
    @FXML
    private Button searchButton;
    public GridPane grid;
    public ScrollPane scroll;
    private MyListener myListener;

    @FXML
    private TextField searchTextField;



    @FXML
    void backHome(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/sceneHomeUser.fxml"));
        Scene sceneMainView = new Scene(scenePantryParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }

    @FXML
    void showGenerateRecipe(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/myKitchen.fxml"));
        Scene sceneMainView = new Scene(scenePantryParent);
        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }

    public void searchRecipe(ActionEvent actionEvent) {
        SearchRecipeBean searchRecipeBean= new SearchRecipeBean();
        searchRecipeBean.setRecipeName(searchTextField.getText());
        List<RecipeItemBean> recipeItemBeans= new ArrayList<>();


        SearchRecipeController searchRecipeController= new SearchRecipeController();
        recipeItemBeans=searchRecipeController.searchRecipe(searchRecipeBean);

        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < recipeItemBeans.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/guiclass/recipeItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemControllerGUI itemControllerGUI = fxmlLoader.getController();
                itemControllerGUI.setData(recipeItemBeans.get(i),myListener);

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
