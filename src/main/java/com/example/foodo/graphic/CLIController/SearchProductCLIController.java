package com.example.foodo.graphic.CLIController;

import com.example.foodo.graphic.viewcli.SearchProductCLIView;

public class SearchProductCLIController implements GrapghiCLIController{
    private SearchProductCLIView searchProductCLIView;



    @Override
    public void start() {
        this.searchProductCLIView= new SearchProductCLIView(this);
        this.searchProductCLIView.run();
    }

    public void executeCommand(String inputLine) {
    }
}
