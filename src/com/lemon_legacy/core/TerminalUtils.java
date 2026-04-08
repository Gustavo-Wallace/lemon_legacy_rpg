package com.lemon_legacy.core;

import java.util.Scanner;

public class TerminalUtils {

    public static void invalid_code() {
        System.err.println("\nInvalid code");
    }

    public static void clear_screen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void pause(Scanner sc) {
            System.out.println("\nPress ENTER to continue");
            sc.nextLine();
            sc.nextLine();
    }

}
