package com.example.foodo.guiclass;

import com.example.foodo.engineering.Utils.MyListener;
import com.example.foodo.engineering.bean.RecipeItemBean;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class ItemControllerGUI {
    @FXML
    public Label recipeNameLabel;
    @FXML
    public Label chefLabel;
    @FXML
    public ImageView img;

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
}
