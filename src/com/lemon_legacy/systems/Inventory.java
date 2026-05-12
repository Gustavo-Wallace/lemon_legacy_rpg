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
        List<Item> inventory = player.getInventory();

        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
            System.out.println();
            return;
        }

        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);

            System.out.print((i + 1) + " - " + item.getName() + " (" + item.getType() + ") ");

            if (item.getHeal() > 0) {
                System.out.print("| Heal: " + item.getHeal());
            }

            if (item.getMana() > 0) {
                System.out.print("| Mana: " + item.getMana());
            }

            if (item.getBonusAttack() > 0) {
                System.out.print("| Attack: " + item.getBonusAttack());
            }

            if (item.getBonusDefense() > 0) {
                System.out.print("| Defense: " + item.getBonusDefense());
            }

            if (item.getBonusHealth() > 0) {
                System.out.print("| Health: " + item.getBonusHealth());
            }

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
            System.out.println(player.getName() + " recovered " + healed + " HP.");
            used = true;
        }

        if (item.getMana() > 0) {
            int recoveredMana = player.recoverMana(item.getMana());
            System.out.println(player.getName() + " recovered " + recoveredMana + " mana.");
            used = true;
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

    public static boolean equipItemByIndex(Player player, int index) {
        List<Item> inventory = player.getInventory();

        if (index < 0 || index >= inventory.size()) {
            System.out.println("Invalid item.");
            System.out.println();
            return false;
        }

        Item item = inventory.get(index);

        if (!item.getType().equalsIgnoreCase("weapon") && !item.getType().equalsIgnoreCase("armor")) {
            System.out.println("This item cannot be equipped.");
            System.out.println();
            return false;
        }

        boolean equipped = player.equipItem(item);

        if (equipped) {
            System.out.println(item.getName() + " was equipped successfully.");
            System.out.println();
            return true;
        }

        System.out.println("Could not equip item.");
        System.out.println();
        return false;
    }

    public static void showEquippedItems(Player player) {
        System.out.println("===== EQUIPPED ITEMS =====");

        if (player.getWeapon() != null) {
            System.out.println("Weapon: " + player.getWeapon().getName());
        } else {
            System.out.println("Weapon: None");
        }

        if (player.getArmor() != null) {
            System.out.println("Armor: " + player.getArmor().getName());
        } else {
            System.out.println("Armor: None");
        }

        System.out.println();
    }

    
}
