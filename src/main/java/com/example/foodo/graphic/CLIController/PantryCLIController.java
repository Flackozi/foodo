package com.example.foodo.graphic.CLIController;

import com.example.foodo.controllerappl.PantryController;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.graphic.viewcli.PantryView;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PantryCLIController implements GrapghiCLIController {
    private PantryView pantryView;
    private static final String NEWPRODUCT="1";
    private static final String HOMEPAGE="2";
    private static final String SEARCH="3";
    private static final String DELETE="4";
    @Override
    public void start() {
        this.pantryView= new PantryView(this);
        this.pantryView.run();
    }

    public List<ProductBean> retrieveProducts() throws SQLException, ConnectionDbException {
        List<ProductBean> productBeans= new ArrayList<>();
        PantryController pantryController= new PantryController();
        productBeans=pantryController.retriveAllProduct();
        return productBeans;
    }

    public void executeCommand(String inputLine) throws CommandNotValidException {
        switch(inputLine){
            case NEWPRODUCT ->{
                AddProductCLIController addProductCLIController=new AddProductCLIController();
                addProductCLIController.start();
                this.start();
            }case HOMEPAGE -> {
                UserCLIController userCLIController= new UserCLIController();
                userCLIController.start();
            }case SEARCH -> {
                SearchProductCLIController searchProductCLIController= new SearchProductCLIController();
                searchProductCLIController.start();
            }case DELETE -> {
                DeleteProductCLIController deleteProductCLIController= new DeleteProductCLIController();
                deleteProductCLIController.start();

            }


        }

    }

}
