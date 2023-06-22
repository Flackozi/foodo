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
import java.time.LocalTime;
import java.util.*;
import com.example.foodo.engineering.exception.*;

public class PantryControllerGUI  implements Initializable, Observer {
    @FXML
    private TableColumn<ProductBean, DatePicker> Expiration;

    @FXML
    private Button HomeButton;

    @FXML
    private TableColumn<ProductBean, String> Name;

    @FXML
    private TableColumn<ProductBean, Integer> Quantity;

    @FXML
    private TableColumn<ProductBean, String> TypeOfFood;

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
        Parent scenePantryParent;
        if(Session.getCurrentSession().getChefBean() == null){
            scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/sceneHomeUser.fxml"));
        }else{
            scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/chefMainPage.fxml"));
        }
        Scene sceneMainView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(sceneMainView);
        window.show();
    }
    @FXML
    public void showSearch(ActionEvent event) throws IOException {
        Parent scenePantryParent = FXMLLoader.load(getClass().getResource("/guiclass/sceneSearchProduct.fxml"));
        Scene scenePantryView = new Scene(scenePantryParent);

        Stage window = (Stage) ((Node)event.getSource()).getScene().getWindow();
        window.setScene(scenePantryView);
        window.show();
    }



    private String[] typeOfFood = {"spices", "fruit", "meat", "vegetable", "sweet", "liquid", "fish", "other"};
    private ProductDAO productDAO = new ProductDAO();
    public void initialize(URL url, ResourceBundle resourceBundle){
        Name.setCellValueFactory(new PropertyValueFactory<>("Name"));
        Quantity.setCellValueFactory(new PropertyValueFactory<>("Quantity"));
        Expiration.setCellValueFactory(new PropertyValueFactory<>("Expiration"));
        TypeOfFood.setCellValueFactory(new PropertyValueFactory<>("TypeOfFood"));

        typeOfFoodPicker.getItems().addAll(typeOfFood);
        typeOfFoodPicker.setOnAction(this::getType);
        try{
            PantryController pantryController = new PantryController();
            List<ProductBean> productBeans = new ArrayList<>();
            productBeans = pantryController.retriveAllProduct();
            tablePantry.getItems().clear();
            Iterator<ProductBean> iteratorProduct= productBeans.iterator();
            obl = tablePantry.getItems();
            while(iteratorProduct.hasNext()) {
                ProductBean productBean = iteratorProduct.next();
                //ProductModel productModel=new ProductModel(productBean.getName(), productBean.getQuantity(), productBean.getTypeOfFood(), productBean.getExpiration());
                //productBean.register(this);
                obl.add(productBean);
            }

            tablePantry.setItems(obl);

        }catch(Exception e){
            e.printStackTrace();
        }

    }

    public void getType(ActionEvent event){
        String myType = typeOfFoodPicker.getValue();
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

            ProductBean productBean = new ProductBean();
            PantryController pantryController = new PantryController();
            productBean.setName(nameText.getText());
            productBean.setQuantity(quantityField.getText());
            productBean.setTypeOfFood(typeOfFoodPicker.getValue());

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
            productBean.setDay(day);
            productBean.setMonth(month);
            productBean.setYear(year);



            String exp = day + "/" + month + "/" + year;
            productBean.setExpiration(exp);
            this.productBean=productBean;
            this.productBean.register(this);
            pantryController.addNewProduct(productBean);



        } catch (FieldEmptyException | DateFormatNotValidException e){
            ExceptionController.showExceptionGUI(e.getMessage());
        }


    }

    public void deleteProduct(ActionEvent actionEvent) throws SQLException, ConnectionDbException {
        int year;
        int month;
        int day;

        PantryController pantryController= new PantryController();


        ObservableList<ProductBean> allProduct, SingleProduct;
        allProduct=tablePantry.getItems();
        SingleProduct=tablePantry.getSelectionModel().getSelectedItems();
        String Name= SingleProduct.get(0).getName();
        SingleProduct.forEach(allProduct::remove);
        ProductBean productBean = new ProductBean(Name);

        pantryController.deleteProduct(productBean);


    }



    @Override
    public void updateProductList(){
        ProductBean product= new ProductBean(this.productBean.getName(), this.productBean.getQuantity(), this.productBean.getTypeOfFood(), this.productBean.getExpiration());
        obl.add(product);
        tablePantry.setItems(obl);

    }

}
