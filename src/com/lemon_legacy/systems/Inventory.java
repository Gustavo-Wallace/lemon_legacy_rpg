package com.lemon_legacy.systems;

import com.lemon_legacy.models.Item;
import com.lemon_legacy.models.Player;
import java.util.List;

public class Inventory {

    public static void showInventory(Player player) {
        List<Item> inventory = player.getInventory();

        System.out.println("===== Inventory =====");

        if (inventory.isEmpty()) {
            System.out.println("Your inventory is empty.");
            System.out.println();
            return;
        }

        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);

            System.out.println((i + 1) + " - " + item.getName() + " (" + item.getType() + ") ");

            if (item.getHeal() > 0) {
                System.out.println("| Heal: " + item.getHeal());
            }

            if (item.getMana() > 0) {
                System.out.println("| Mana: " + item.getMana());
            }

            if (item.getBonusAttack() > 0) {
                System.out.println("| Attack: " + item.getBonusAttack());
            }

            if (item.getBonusDefense() > 0) {
                System.out.println("| Defense: " + item.getBonusDefense());
            }

            if (item.getBonusHealth() > 0) {
                System.out.println("| Health: " + item.getBonusHealth());
            }
        }

        System.out.println();
    }
    
}
