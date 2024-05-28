package com.linkedin.javacodechallenges;

import java.io.FileReader;
import java.io.IOException;
import java.util.Scanner;

import com.opencsv.CSVReader;
import com.opencsv.exceptions.CsvValidationException;

public class App {
    public static void main(String[] args) throws CsvValidationException, IOException {

        String csvFile = "ticketholders.csv";
        CSVReader csvReader = new CSVReader(new FileReader(csvFile));
        String[] row = null;

       Scanner sc = new Scanner(System.in);
        System.out.println("Write your name");
        String userNameToSearch = sc.nextLine();
        sc.close();

        boolean foundName = false;

        while ((row = csvReader.readNext()) != null) {
            //itero moviendome por las lineas
            //el valor de indice 0 son los nombres y el indice 1 son las cantidades
            String name = row[0];
            String qty = row[1];
            //userNameToSearch es lo que escribe el usuario
            if(name.equalsIgnoreCase(userNameToSearch)) {
                System.out.println(name + " bought " + qty + " tickets.");
                foundName = true;
                break;
            } 
        }
        if(!foundName) {
            System.out.println( userNameToSearch + " is not in the list.");
        }
        csvReader.close();
    }
}
