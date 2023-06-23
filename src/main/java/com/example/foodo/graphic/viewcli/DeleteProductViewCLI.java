package com.example.foodo.graphic.viewcli;

import com.example.foodo.engineering.utils.Printer;
import com.example.foodo.engineering.exception.ConnectionDbException;
import com.example.foodo.graphic.controllercli.DeleteProductCLIController;

import java.sql.SQLException;
import java.util.Scanner;

public class DeleteProductViewCLI {
    DeleteProductCLIController deleteProductCLIController= new DeleteProductCLIController();
    public DeleteProductViewCLI(DeleteProductCLIController deleteProductCLIController) {
        this.deleteProductCLIController=deleteProductCLIController;
    }

    public void run() {
        Printer.printMessage("\n-------------------------------------------- DELETE PRODUCT PAGE --------------------------------------------");
        Printer.printMessage("\nEnter the name of the product to be deleted:");
        Scanner scanner= new Scanner(System.in);
        String name= scanner.nextLine();
        try{
            this.deleteProductCLIController.deleteProduct(name);
        } catch (SQLException | ConnectionDbException e) {
            throw new RuntimeException(e);
        }
    }
}
