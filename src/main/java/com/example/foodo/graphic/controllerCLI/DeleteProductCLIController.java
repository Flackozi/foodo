package com.example.foodo.graphic.controllerCLI;

import com.example.foodo.controllerappl.PantryController;
import com.example.foodo.engineering.bean.ProductBean;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.graphic.viewcli.DeleteProductViewCLI;

import java.sql.SQLException;

public class DeleteProductCLIController implements GrapghiCLIController{
    private DeleteProductViewCLI deleteProductCLIView;

    @Override
    public void start() {
        this.deleteProductCLIView= new DeleteProductViewCLI(this);
        this.deleteProductCLIView.run();
    }

    public void deleteProduct(String name) throws SQLException, ConnectionDbException {
        ProductBean productBean=new ProductBean(name);
        PantryController pantryController= new PantryController();
        pantryController.deleteProduct(productBean);
    }
}
