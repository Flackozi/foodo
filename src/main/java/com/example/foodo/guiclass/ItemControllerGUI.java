package com.example.foodo.guiclass;

import com.example.foodo.engineering.Utils.MyListener;
import com.example.foodo.engineering.bean.RecipeItemBean;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

import java.io.IOException;
import java.util.Objects;

public class ItemControllerGUI {
    @FXML
    public Label recipeNameLabel;
    @FXML
    public Label chefLabel;
    @FXML
    public ImageView img;
    private Parent root;
    private Stage stage;
    private Scene scene;

    private RecipeItemBean recipeItemBean;
    private MyListener myListener;

    public void setData(RecipeItemBean recipeItemBean, MyListener myListener) {
        this.recipeItemBean = recipeItemBean;
        this.myListener = myListener;
        recipeNameLabel.setText(recipeItemBean.getRecipeName());
        String path = recipeItemBean.getImgSrc();
        chefLabel.setText(recipeItemBean.getChefName());
        Image image = new Image(path);
        img.setImage(image);

    }

    public void showRecipeDet(MouseEvent event) throws IOException {
        root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("/guiclass/recipeDet1.fxml")));
        scene = new Scene(root);
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        stage.setScene(scene);
        stage.show();
    }
}
