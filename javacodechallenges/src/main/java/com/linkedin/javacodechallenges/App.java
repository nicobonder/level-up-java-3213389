package com.linkedin.javacodechallenges;

import java.util.Scanner;

public class App {

    public static double calculateWaterBill(double gallonsUsage) {
           
        // TODO: Implement method
        final double minimunCharge = 18.84;
        final double extraVolumeCost = 3.90;
        final double CCFToCharge = CCFUsed(gallonsUsage) - 2;
        final double extraCharges = CCFToCharge * extraVolumeCost; 
        return minimunCharge + extraCharges;
    }

    final static double CCFUsed(double gallonsUsage) {
        final int CCF = 748;
        if (gallonsUsage <= 1496) {
            return 2;
        } else {
           return Math.ceil(gallonsUsage / CCF);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("How many gallons of water did you " +
                "use this month?");
        double usage = scanner.nextDouble();
        System.out.println("Your water bill is " +
                calculateWaterBill(usage));
        scanner.close();
    }
}
