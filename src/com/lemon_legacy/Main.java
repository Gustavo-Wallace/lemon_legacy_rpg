package com.lemon_legacy;

import com.lemon_legacy.models.Player;
import com.lemon_legacy.systems.Inventory;
import com.lemon_legacy.systems.Store;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Player player = new Player("Joekako");
        
        boolean running = true;

        while (running) {
            Utils.clearScreen();
            showMainMenu();

            int option = Utils.readOption(sc);

            switch (option) {
                case 1:
                    player.showStatus();
                    break;
                case 2:
                    Inventory.showInventory(player);
                    break;
                case 3:

                    break;
                case 4:
                    Store.openStore(player, sc);
                    break;
                case 5:
                    player.fullRecover();
                    break;
                case 0:
                    running = false;
                    System.out.println("Leaving Lemon Legacy...");
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
            }

            System.out.println();
        }


        sc.close();
    }

    private static void showMainMenu() {
        System.out.println("===== Lemon Legacy =====");
        System.out.println("1 - View Status");
        System.out.println("2 - Inventory");
        System.out.println("3 - Battle");
        System.out.println("4 - Store");
        System.out.println("5 - Rest");
        System.out.println("0 - Exit");
        System.out.print("Choose an option: ");
    }

}
