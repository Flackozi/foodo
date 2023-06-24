package com.example.foodo.graphic.guiclass;
import com.example.foodo.controllerappl.PantryController;
import com.example.foodo.engineering.session.Session;
import com.example.foodo.engineering.utils.ExceptionController;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.dao.ProductDAO;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.engineering.pattern.observer.Observer;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import java.io.IOException;
import java.net.URL;
import java.sql.SQLException;
import java.util.*;
import com.example.foodo.engineering.exception.*;

public class PantryControllerGUI  implements Initializable, Observer {
    @FXML
    private TableColumn<ProductBean, DatePicker> expiration;

    @FXML
    private Button homeButton;

    @FXML
    private TableColumn<ProductBean, String> name;

    @FXML
    private TableColumn<ProductBean, Integer> quantity;

    @FXML
    private TableColumn<ProductBean, String> typeOfFood;

    @FXML
    private DatePicker expirationDate;

    @FXML
    private TextField nameText;

    @FXML
    private TextField quantityField;

    @FXML
    private ChoiceBox<String> typeOfFoodPicker;

    @FXML
    private TableView tablePantry;
    private ObservableList<ProductBean> obl;
    private ProductBean productBean;


    public void backHome(ActionEvent event) throws IOException {
        Parent scene;
        if(Session.getCurrentSession().getChefBean() == null){
            scene = FXMLLoader.load(getClass().getResource("/guiclass/sceneHomeUser.fxml"));
        }else{
            scene = FXMLLoader.load(getClass().getResource("/guiclass/chefMainPage.fxml"));
        }
        Scene sceneMainView = new Scene(scene);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }
    @FXML
    public void showSearch(ActionEvent event) throws IOException {
        Parent scene = FXMLLoader.load(getClass().getResource("/guiclass/sceneSearchProduct.fxml"));
        Scene sceneView = new Scene(scene);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneView);
        window.show();
    }



    private String[] typeOfFood1 = {"spices", "fruit", "meat", "vegetable", "sweet", "liquid", "fish", "other"};
    private ProductDAO productDAO = new ProductDAO();
    public void initialize(URL url, ResourceBundle resourceBundle){
        name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        expiration.setCellValueFactory(new PropertyValueFactory<>("Expiration"));
        typeOfFood.setCellValueFactory(new PropertyValueFactory<>("TypeOfFood"));

        typeOfFoodPicker.getItems().addAll(typeOfFood1);
        try{
            PantryController pantryController = new PantryController();
            List<ProductBean> productBeans = new ArrayList<>();
            productBeans = pantryController.retriveAllProduct();
            tablePantry.getItems().clear();
            Iterator<ProductBean> iteratorProduct= productBeans.iterator();
            obl = tablePantry.getItems();
            while(iteratorProduct.hasNext()) {
                ProductBean productBean1 = iteratorProduct.next();

                obl.add(productBean1);
            }
            tablePantry.setItems(obl);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void addNewProduct(ActionEvent actionEvent){


        //prendiamo i dati e li mettiamo nella bean
        try {

            if(Objects.equals(nameText.getText(), "")){
                throw new FieldEmptyException("Name");
            }
            if(Objects.equals(quantityField.getText(), "")){
                throw new FieldEmptyException("Quantity");
            }
            if(typeOfFoodPicker.getValue() == null){
                throw new FieldEmptyException("Type of food");
            }
            if(expirationDate.getValue() == null){
                throw new FieldEmptyException("Date");
            }

            ProductBean productBean1 = new ProductBean();
            PantryController pantryController = new PantryController();
            productBean1.setName(nameText.getText());
            productBean1.setQuantity(quantityField.getText());
            productBean1.setTypeOfFood(typeOfFoodPicker.getValue());

            int year;
            int month;
            int day;

           year = expirationDate.getValue().getYear();
            month = expirationDate.getValue().getMonthValue();
            day = expirationDate.getValue().getDayOfMonth();

            if(day > 31 && day <1){
                throw new DateFormatNotValidException();
            }
            if(month > 12 && month < 1){
                throw new DateFormatNotValidException();
            }
            if(year < 2023){
                throw new DateFormatNotValidException();
            }
            productBean1.setDay(day);
            productBean1.setMonth(month);
            productBean1.setYear(year);



            String exp = day + "/" + month + "/" + year;
            productBean1.setExpiration(exp);
            this.productBean=productBean1;
            this.productBean.register(this);
            pantryController.addNewProduct(productBean1);



        } catch (FieldEmptyException | DateFormatNotValidException e){
            ExceptionController.showExceptionGUI(e.getMessage());
        }


    }

    public void deleteProduct(ActionEvent actionEvent) throws SQLException, ConnectionDbException {

        PantryController pantryController= new PantryController();


        ObservableList<ProductBean> allProduct, singleProduct;
        allProduct=tablePantry.getItems();
        singleProduct=tablePantry.getSelectionModel().getSelectedItems();
        String name1= singleProduct.get(0).getName();
        singleProduct.forEach(allProduct::remove);
        ProductBean productBean1 = new ProductBean(name1);

        pantryController.deleteProduct(productBean1);


    }



    @Override
    public void updateProductList(){
        ProductBean product= new ProductBean(this.productBean.getName(), this.productBean.getQuantity(), this.productBean.getTypeOfFood(), this.productBean.getExpiration());
        obl.add(product);
        tablePantry.setItems(obl);

    }

}
