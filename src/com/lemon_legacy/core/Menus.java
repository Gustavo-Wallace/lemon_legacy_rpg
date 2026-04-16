package com.lemon_legacy.core;

public class Menus {

    public static void mainMenu() {
        System.out.println("\n============ ============");
        System.out.println("  === LEMON LEGACY ===");
        System.out.println("============ ============");
        System.out.println();
        System.out.println("1 - NEW GAME");
        System.out.println("2 - RESUME");
        System.out.println("3 - EXIT");
    }

    public static void nameChoose() {
        System.out.println("\nCreate a new character");
        System.out.println();
        System.out.println("Enter the character name: ");
    }

    public static void classChoose() {
        System.out.println();
        System.out.println("Choose your class:");
        System.out.println("1 - Warrior");
        System.out.println("2 - Mage");
        System.out.println("3 - Rogue");
    }


}
