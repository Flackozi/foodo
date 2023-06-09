package com.example.foodo.graphic.CLIController;

import com.example.foodo.graphic.viewcli.DeleteProductCLIView;

public class DeleteProductCLIController implements GrapghiCLIController{
    private DeleteProductCLIView deleteProductCLIView;

    @Override
    public void start() {
        this.deleteProductCLIView= new DeleteProductCLIView(this);
        this.deleteProductCLIView.run();
    }
}
