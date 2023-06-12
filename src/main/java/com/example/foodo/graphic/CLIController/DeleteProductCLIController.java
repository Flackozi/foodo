package com.example.foodo.graphic.CLIController;

import com.example.foodo.graphic.viewcli.DeleteProductViewCLI;

public class DeleteProductCLIController implements GrapghiCLIController{
    private DeleteProductViewCLI deleteProductViewCLI;

    @Override
    public void start() {
        this.deleteProductViewCLI = new DeleteProductViewCLI(this);
        this.deleteProductViewCLI.run();
    }
}
