package com.lemon_legacy.core;

public class game {
    
    public static void main_menu() {
        System.out.println("LEMON LEGACY");
        System.out.println();
        System.out.println("1 - NEW GAME");
        System.out.println("2 - RESUME");
        System.out.println("3 - EXIT");
    }

    public static void exit() {
        System.exit(0);
    }

    public static void invalid_code() {
        System.out.println("Invalid code");
    }

    public static void clear_screen() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    } 
}
