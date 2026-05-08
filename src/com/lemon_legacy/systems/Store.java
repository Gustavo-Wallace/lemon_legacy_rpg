package com.lemon_legacy.systems;

import com.lemon_legacy.models.Item;
import com.lemon_legacy.models.Player;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Store {
    
    public static void openStore(Player player, Scanner sc) {
        List<Item> storeItems = createStoreItems();

        boolean shopping = true;

        while (shopping) {
            System.out.println("===== STORE =====");
            System.out.println("Your gold: " + player.getGold());
            System.out.println();

            for (int i = 0; i < storeItems.size(); i++) {
                Item item = storeItems.get(i);

                System.out.println((i + 1) + " - " + item.getName() + " (" + item.getType() + ")");
                System.out.println(" | Price: " + item.getValue());

                if (item.getHeal() > 0) {
                    System.out.println(" | Heal: " + item.getHeal());
                }

                if (item.getMana() > 0) {
                    System.out.println(" | Mana " + item.getMana());
                }

                if (item.getBonusAttack() > 0) {
                    System.out.println(" | Attack: +" + item.getBonusAttack());
                }

                if (item.getBonusDefense() > 0) {
                    System.out.println(" | Defense +" + item.getBonusDefense());
                }

                if (item.getBonusHealth() > 0) {
                    System.out.println(" | Health + " + item.getBonusHealth());
                }

                System.out.println();
            }

            System.out.println("0 - Exit Store");
            System.out.println("Choose an item to buy: ");

            int option = readOption(sc);
            System.out.println();

            if (option == 0) {
                shopping = false;
                continue;
            }


        }
    }

    private static List<Item> createStoreItems() {
        List<Item> items = new ArrayList<>();

        items.add(new Item("Health Potion", "consumable", 10, 30, 0, 0, 0, 0));

        return items;
    }

    private static int readOption(Scanner sc) {
        while (!sc.hasNextInt()) {
            System.out.println("Invalid option. Please enter a number.");
            sc.next();
        }

        return sc.nextInt();
    }
}
