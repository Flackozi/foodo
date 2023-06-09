package com.example.foodo.graphic.CLIController;

import com.example.foodo.controllerappl.SearchProductController;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.bean.SearchBean;
import com.example.foodo.graphic.viewcli.SearchProductCLIView;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class SearchProductCLIController implements GrapghiCLIController{
    private static final String SEARCHNAME="1";
    private static final String FILTER="2";
    private static final String PANTRY="3";


    private SearchProductCLIView searchProductCLIView;



    @Override
    public void start() {
        this.searchProductCLIView= new SearchProductCLIView(this);
        this.searchProductCLIView.run();
    }

    public void executeCommand(String inputLine) {
        switch(inputLine){
            case SEARCHNAME -> {
                this.searchProductCLIView.searchName();
                this.start();
            }case FILTER -> {
                this.searchProductCLIView.filterSearch();
                this.start();
            }case PANTRY -> {
                PantryCLIController pantryCLIController= new PantryCLIController();
                pantryCLIController.start();
            }
        }

    }

    public void searchName(String name, boolean spices, boolean fruit, boolean meat, boolean vegetable, boolean sweet, boolean liquid, boolean fish) {
        SearchBean searchBean= new SearchBean(name, spices, fruit, meat, vegetable, sweet, liquid, fish);
        List<ProductBean> productBeanList= new ArrayList<>();
        SearchProductController searchProductController= new SearchProductController();
        productBeanList= searchProductController.searchProduct(searchBean);
        for(ProductBean productBean: productBeanList){
            SearchProductCLIView searchProductCLIView1= new SearchProductCLIView(this);
            searchProductCLIView1.printProduct(productBean.getName(), productBean.getQuantity(), productBean.getTypeOfFood(), productBean.getExpiration());
        }

    }
}
