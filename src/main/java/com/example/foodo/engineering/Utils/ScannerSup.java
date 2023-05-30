package com.example.foodo.engineering.Utils;

import java.util.Scanner;

public class ScannerSup {

    private ScannerSup() {
        //Costruttore privato perché ho tutti i metodi statici
    }
    public static void waitEnter() {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        while (!input.equals("")) {
            input = scanner.nextLine();
        }
    }
}
