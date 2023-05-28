package com.example.foodo.guiclass;

import com.example.foodo.controllerappl.KitchenController;
import com.example.foodo.engineering.Utils.MyListener;
import com.example.foodo.engineering.bean.KitchenBean;
import com.example.foodo.engineering.bean.RecipeBean;
import com.example.foodo.engineering.bean.RecipeItemBean;
import com.example.foodo.engineering.exception.ConnectionDbException;
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
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class MyKitchenControllerGUI {

    @FXML
    private Button HomeButton;

    @FXML
    private Button confirmButton;

    @FXML
    private Button generateRecipe;

    @FXML
    private GridPane grid;

    @FXML
    private TextField ingredient1;

    @FXML
    private TextField ingredient2;

    @FXML
    private TextField ingredient3;

    @FXML
    private TextField ingredient4;

    @FXML
    private TextField ingredient5;

    @FXML
    private ScrollPane scroll;

    @FXML
    private Button searchRecipeButton;

    private MyListener myListener;

    public void confirmIngredients(ActionEvent actionEvent) throws SQLException, ConnectionDbException {
        KitchenBean kitchenBean= new KitchenBean();
        List<RecipeItemBean> recipeItemBeans= new ArrayList<>();
        kitchenBean.setIngredient1(ingredient1.getText());
        kitchenBean.setIngredient2(ingredient2.getText());
        kitchenBean.setIngredient3(ingredient3.getText());
        kitchenBean.setIngredient4(ingredient4.getText());
        kitchenBean.setIngredient5(ingredient5.getText());

        KitchenController kitchenController= new KitchenController();
        recipeItemBeans=kitchenController.searchRecipe(kitchenBean);

        showRecipe(recipeItemBeans);
    }

    private void showRecipe(List<RecipeItemBean> recipeItemBeans) {
        int column = 0;
        int row = 1;
        try {
            for (int i = 0; i < recipeItemBeans.size(); i++) {
                FXMLLoader fxmlLoader = new FXMLLoader();
                fxmlLoader.setLocation(getClass().getResource("/guiclass/recipeItem.fxml"));
                AnchorPane anchorPane = fxmlLoader.load();

                ItemControllerGUI itemControllerGUI = fxmlLoader.getController();
                itemControllerGUI.setData(recipeItemBeans.get(i),myListener, i, recipeItemBeans.get(i).getRecipeName());

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

    public void backHome(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/sceneHomeUser.fxml")));
        Scene sceneMainView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }

    public void showPantry(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/sceneMyPantry.fxml")));
        Scene sceneMainView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }

    public void searchRecipe(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/KitchenSearch.fxml")));
        Scene sceneMainView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }
}
