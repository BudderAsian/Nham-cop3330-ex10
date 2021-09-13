package com.example;

import java.text.NumberFormat;
import java.util.Locale;
import java.util.Scanner;
/*
 *  UCF COP3330 Fall 2021 Assignment 10 Solution
 *  Copyright 2021 Richard Nham
 */

public class Main {

    public static void main(String[] args) {
        // TODO Auto-generated method stub
        double[][] userInput = new double[3][2];
        double taxRate = 5.5;
        double subTotal;
        double tax;
        double total;

        userInput = getInput();
        subTotal = getSubtotal(userInput);
        tax = getTax(subTotal, taxRate);
        total = getTotal(subTotal, tax);
        printTResults(subTotal, total, tax);

    }



    private static void printTResults(double subTotal, double total, double tax) {
        // TODO Auto-generated method stub
        Locale usa = new Locale("en", "US");
        NumberFormat formatter = NumberFormat.getCurrencyInstance(usa);

        System.out.println("Subtotal: " + formatter.format(subTotal));
        System.out.println("Tax: " + formatter.format(tax));
        System.out.println("Total: " + formatter.format(total));
    }



    private static double getTotal(double subTotal, double tax) {
        // TODO Auto-generated method stub
        return subTotal + tax;
    }

    private static double getTax(double subTotal, double taxRate) {
        // TODO Auto-generated method stub
        return taxRate*subTotal/(double)100;
    }

    private static double getSubtotal(double[][] userInput) {
        // TODO Auto-generated method stub
        double subTotal = 0.0;
        for(int i=0; i<3; i++) {
            subTotal += (userInput[i][0] * userInput[i][1]);
        }

        return subTotal;
    }

    private static double[][] getInput() {
        // TODO Auto-generated method stub
        double[][] userInput = new double[3][2];
        Scanner scannerUserInput= new Scanner(System.in);

        for(int i=0; i<3; i++) {
            System.out.print("Enter the price of item " + (i+1) + " ");
            userInput[i][0] =  scannerUserInput.nextDouble();

            System.out.print("Enter the quantity of item " + (i+1) + " ");
            userInput[i][1] =  scannerUserInput.nextDouble();
        }

        scannerUserInput.close();

        return userInput;
    }

}
