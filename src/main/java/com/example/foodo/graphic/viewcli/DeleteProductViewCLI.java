package com.example.foodo.graphic.viewcli;

import com.example.foodo.engineering.Utils.Printer;
import com.example.foodo.graphic.CLIController.DeleteProductCLIController;

public class DeleteProductViewCLI {
    DeleteProductCLIController deleteProductCLIController= new DeleteProductCLIController();
    public DeleteProductViewCLI(DeleteProductCLIController deleteProductCLIController) {
        this.deleteProductCLIController=deleteProductCLIController;
    }

    public void run() {
        Printer.printMessage("\n-------------------------------------------- DELETE PRODUCT PAGE --------------------------------------------");

    }
}
