package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {

    public static boolean isPasswordComplex(String password) {
        //6 caracteres, 1 uppercase, 1 lowercase, 1 number
        final String regex = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d).{6,}$";

        if(password.matches(regex)){
            return true;
        } 

        return false;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter a password: ");
        String userInput = scanner.nextLine();
        System.out.println("Is the password complex? "
                + isPasswordComplex(userInput));

        scanner.close();
    }
}
