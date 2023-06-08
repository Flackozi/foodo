package com.example.foodo.graphic.viewcli;

import com.example.foodo.engineering.Utils.Printer;
import com.example.foodo.engineering.exception.CommandNotValidException;
import com.example.foodo.engineering.exception.NonUsableFunctionException;
import com.example.foodo.graphic.CLIController.SearchProductCLIController;

import java.util.Scanner;

public class SearchProductCLIView {
    private final SearchProductCLIController searchProductCLIController;

    public SearchProductCLIView(SearchProductCLIController searchProductCLIController) {
        this.searchProductCLIController = searchProductCLIController;
    }

    public void run() {
        Printer.printMessage("\n-------------------------------------------- SEARCH PAGE --------------------------------------------");
        Printer.printMessage("\n 1)Insert the name \n 2)Filter your search");
        Scanner scanner = new Scanner(System.in);
        String inputLine=scanner.nextLine();
        try {
            this.searchProductCLIController.executeCommand(inputLine);
        } catch (CommandNotValidException | NonUsableFunctionException e) {
            run();
        }
    }
}
