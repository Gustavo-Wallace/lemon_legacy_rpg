package com.lemon_legacy;

import com.lemon_legacy.models.Player;
import com.lemon_legacy.models.Quest;
import com.lemon_legacy.systems.Adventure;
import com.lemon_legacy.systems.Inventory;
import com.lemon_legacy.systems.Store;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Player player = new Player("Joekako");

        Quest initialQuest = new Quest("Slime Hunt", "Slime", 3, 50, 80);
        player.setCurrentQuest(initialQuest);
        
        boolean running = true;

        while (running) {
            showMainMenu();

            int option = Utils.readOption(sc);

            switch (option) {
                case 1:
                    player.showStatus();
                    break;

                case 2:
                    Inventory.openInventoryMenu(player, sc);
                    break;

                case 3:
                    Adventure.openAdventureMenu(player, sc);
                    break;

                case 4:
                    Store.openStore(player, sc);
                    break;

                case 5:
                    player.fullRecover();
                    System.out.println(player.getName() + " rested and recovered health and mana.");
                    break;

                case 6:
                    Quest.showCurrentQuest(player);
                    break;

                case 0:
                    running = false;
                    System.out.println("Leaving Lemon Legacy...");
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }

            if (!player.isAlive()) {
                showGameOver();
                running = false;
            }

            System.out.println();
        }

        sc.close();
    }

    private static void showMainMenu() {
        System.out.println("===== Lemon Legacy =====");
        System.out.println("1 - View Status");
        System.out.println("2 - Inventory");
        System.out.println("3 - Adventure");
        System.out.println("4 - Store");
        System.out.println("5 - Rest");
        System.out.println("6 - Quest");
        System.out.println("0 - Exit");
        System.out.print("Choose an option: ");
    }

    private static void showGameOver() {
        System.out.println("===== Game Over =====");
        System.out.println("Your journey has ended.");
    }

}
