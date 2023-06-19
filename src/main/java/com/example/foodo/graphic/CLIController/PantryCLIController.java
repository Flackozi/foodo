package com.example.foodo.graphic.CLIController;

import com.example.foodo.controllerappl.PantryController;
import com.example.foodo.engineering.bean.ChefBean;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.bean.UserBean;
import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.engineering.exception.ProductNotFoundException;
import com.example.foodo.graphic.viewcli.PantryViewCLI;
import com.example.foodo.engineering.session.Session;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PantryCLIController implements GrapghiCLIController {
    private PantryViewCLI pantryViewCLI;
    private static final String NEWPRODUCT="1";
    private static final String HOMEPAGE="2";
    private static final String SEARCH="3";
    private static final String DELETE="4";

    private UserBean userBean;
    private ChefBean chefBean;
    @Override
    public void start() throws SQLException, ConnectionDbException, FileNotFoundException, ProductNotFoundException {
        this.pantryViewCLI = new PantryViewCLI(this);
        this.pantryViewCLI.run();
    }

    public List<ProductBean> retrieveProducts() throws SQLException, ConnectionDbException {
        List<ProductBean> productBeans= new ArrayList<>();
        PantryController pantryController= new PantryController();
        productBeans=pantryController.retriveAllProduct();
        return productBeans;
    }

    public void executeCommand(String inputLine) throws CommandNotValidException, SQLException, ConnectionDbException, FileNotFoundException, ProductNotFoundException {
        switch(inputLine){
            case NEWPRODUCT ->{
                AddProductCLIController addProductCLIController=new AddProductCLIController();
                addProductCLIController.start();
                this.start();
            }case HOMEPAGE -> {
                if(Session.getCurrentSession().getUserBean()!= null){
                    UserCLIController userCLIController= new UserCLIController();
                    userCLIController.start();
                }else{
                    ChefCLIController chefCLIController = new ChefCLIController();
                    chefCLIController.start();
                }
                UserCLIController userCLIController= new UserCLIController();
                userCLIController.start();
            }case SEARCH -> {
                SearchProductCLIController searchProductCLIController= new SearchProductCLIController();
                searchProductCLIController.start();
                this.start();
            }case DELETE -> {
                DeleteProductCLIController deleteProductCLIController= new DeleteProductCLIController();
                deleteProductCLIController.start();
                this.start();
            }


        }

    }

}
