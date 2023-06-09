package com.example.foodo.graphic.viewcli;

import com.example.foodo.engineering.Utils.Printer;
import com.example.foodo.graphic.CLIController.DeleteProductCLIController;

public class DeleteProductCLIView {
    DeleteProductCLIController deleteProductCLIController= new DeleteProductCLIController();
    public DeleteProductCLIView(DeleteProductCLIController deleteProductCLIController) {
        this.deleteProductCLIController=deleteProductCLIController;
    }

    public void run() {
        Printer.printMessage("\n-------------------------------------------- DELETE PRODUCT PAGE --------------------------------------------");

    }
}
