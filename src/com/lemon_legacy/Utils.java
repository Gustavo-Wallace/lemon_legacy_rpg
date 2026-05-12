package com.lemon_legacy;

import java.util.Scanner;

public class Utils {

    public static int readOption(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Invalid Input. Please type a number.");
            sc.next();
        }

        return sc.nextInt();
    }
    
}
