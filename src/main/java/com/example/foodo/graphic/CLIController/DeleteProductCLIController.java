package com.example.foodo.graphic.CLIController;

import com.example.foodo.controllerappl.PantryController;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.graphic.viewcli.DeleteProductCLIView;

import java.sql.SQLException;

public class DeleteProductCLIController implements GrapghiCLIController{
    private DeleteProductCLIView deleteProductCLIView;

    @Override
    public void start() {
        this.deleteProductCLIView= new DeleteProductCLIView(this);
        this.deleteProductCLIView.run();
    }

    public void deleteProduct(String name) throws SQLException, ConnectionDbException {
        ProductBean productBean=new ProductBean(name);
        PantryController pantryController= new PantryController();
        pantryController.deleteProduct(productBean);
    }
}
