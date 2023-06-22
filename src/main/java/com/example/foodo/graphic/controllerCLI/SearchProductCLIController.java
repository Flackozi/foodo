package com.example.foodo.graphic.controllerCLI;

import com.example.foodo.controllerappl.SearchProductController;
import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.engineering.exception.ProductNotFoundException;
import com.example.foodo.engineering.session.Session;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.bean.SearchBean;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.graphic.viewcli.SearchProductViewCLI;

import java.io.FileNotFoundException;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SearchProductCLIController implements GrapghiCLIController{
    private static final String SEARCHNAME="1";
    private static final String FILTER="2";
    private static final String PANTRY="3";
    private static final String BACK="4";


    private SearchProductViewCLI searchProductViewCLI;



    @Override
    public void start() throws SQLException, ConnectionDbException, FileNotFoundException, ProductNotFoundException, CommandNotValidException {
        this.searchProductViewCLI = new SearchProductViewCLI(this);
        this.searchProductViewCLI.run();
    }

    public void executeCommand(String inputLine) throws SQLException, ConnectionDbException, FileNotFoundException, ProductNotFoundException, CommandNotValidException {
        switch(inputLine){
            case SEARCHNAME -> {
                this.searchProductViewCLI.searchName();
                this.start();
            }case FILTER -> {
                this.searchProductViewCLI.filterSearch();
                this.start();
            }case PANTRY -> {
                PantryCLIController pantryCLIController= new PantryCLIController();
                pantryCLIController.start();
            }case BACK -> {
                if(Session.getCurrentSession().getUserBean()!= null){
                    UserCLIController userCLIController= new UserCLIController();
                    userCLIController.start();
                }else{
                    ChefCLIController chefCLIController = new ChefCLIController();
                    chefCLIController.start();
                }
            }default -> throw new CommandNotValidException();
        }

    }

    public void searchName(String name, SearchBean searchBean) throws ProductNotFoundException, SQLException, ConnectionDbException {
        SearchBean searchBean1= new SearchBean();
        searchBean1.setSearchText(name);
        searchBean1.setSpices(searchBean.getSpices());
        searchBean1.setFruit(searchBean.getFruit());
        searchBean1.setFish(searchBean.getFish());
        searchBean1.setMeat(searchBean.getMeat());
        searchBean1.setLiquid(searchBean.getLiquid());
        searchBean1.setSweet(searchBean.getSweet());
        searchBean1.setVegetable(searchBean.getVegetable());
        List<ProductBean> productBeanList= new ArrayList<>();
        SearchProductController searchProductController= new SearchProductController();
        productBeanList= searchProductController.searchProduct(searchBean1);
        for(ProductBean productBean: productBeanList){
            SearchProductViewCLI searchProductViewCLI1 = new SearchProductViewCLI(this);
            searchProductViewCLI1.printProduct(productBean.getName(), productBean.getQuantity(), productBean.getTypeOfFood(), productBean.getExpiration());
        }

    }
}
