package com.lemon_legacy.systems;

import com.lemon_legacy.Utils;
import com.lemon_legacy.models.Item;
import com.lemon_legacy.models.Player;
import java.util.List;
import java.util.Scanner;

public class Inventory {

    public static void openInventoryMenu(Player player, Scanner sc) {
        boolean running = true;

        while(running) {
            System.out.println("===== Inventory =====");
            System.out.println("1 - Show items");
            System.out.println("2 - Use Item");
            System.out.println("3 - Equip item");
            System.out.println("4 - Show equipped items");
            System.out.println("0 - Back");
            System.out.print("Choose an option: ");

            int option = Utils.readOption(sc);

            System.out.println();

            switch (option) {
                case 1:
                    showInventory(player);
                    break;
                case 2:
                    showInventory(player);
                    System.out.print("Choose the item number to use: ");
                    int useIndex = Utils.readOption(sc) - 1;
                    useItem(player, useIndex);

                    break;
                case 3:
                    showInventory(player);
                    System.out.print("Choose the item number to equip: ");
                    int equipIndex = Utils.readOption(sc) - 1;
                    equipItemByIndex(player, equipIndex);

                    break;
                case 4:
                    showEquippedItems(player);
                    break;
                case 0:
                    running = false;
                    break;
                default:
                    System.out.println("Invalid option.");
                    break;
        }

        System.out.println();
        }
    }

    public static void showInventory(Player player) {
        if (player.getInventory().isEmpty()) {
            System.out.println("Inventory is empty.");
            return;
        }

        System.out.println("===== INVENTORY =====");

        for (int i = 0; i < player.getInventory().size(); i++) {
            Item item = player.getInventory().get(i);

            System.out.print((i + 1) + " - ");
            item.showDetails();
            System.out.println();
        }
    }

    public static boolean useItem(Player player, int index) {
        List<Item> inventory = player.getInventory();

        if (index < 0 || index >= inventory.size()) {
            System.out.println("Invalid item.");
            System.out.println();
            return false;
        }
            
        Item item = inventory.get(index);

        if (!item.getType().equalsIgnoreCase("consumable")) {
            System.out.println("This item is not consumable.");
            System.out.println();
            return false;
        }

        boolean used = false;

        if (item.getHeal() > 0) {
            int healed = player.heal(item.getHeal());

            if (healed > 0) {
                System.out.println(player.getName() + " recovered " + healed + " HP.");
                used = true;
            } else {
                System.out.println(player.getName() + " is already at full health.");
            }
        }

        if (item.getMana() > 0) {
            int recoveredMana = player.recoverMana(item.getMana());

            if (recoveredMana > 0) {
                System.out.println(player.getName() + " recovered " + recoveredMana + " mana.");
                used = true;
            } else {
                System.out.println(player.getName() + " is already at full mana.");
            }
        }

        if (used) {
            inventory.remove(index);
            System.out.println(item.getName() + " was used.");
            System.out.println();
            return true;
        }

        System.out.println("This item had no affect.");
        System.out.println();
        return false;
    }

    public static void equipItemByIndex(Player player, int index) {
        if (index < 0 || index >= player.getInventory().size()) {
            System.out.println("Invalid item.");
            return;
        }

        Item item = player.getInventory().get(index);
        player.equipItem(item);
    }

    public static void showEquippedItems(Player player) {
        System.out.println("===== EQUIPPED ITEMS =====");

        if (player.getWeapon() == null) {
            System.out.println("Weapon: none");
        } else {
            System.out.print("Weapon: ");
            player.getWeapon().showDetails();
        }

        if (player.getArmor() == null) {
            System.out.println("Armor: none");
        } else {
            System.out.print("Armor: ");
            player.getArmor().showDetails();
        }
    }

}
