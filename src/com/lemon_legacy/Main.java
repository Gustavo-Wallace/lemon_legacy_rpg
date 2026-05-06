package com.lemon_legacy;

import com.lemon_legacy.models.Enemy;
import com.lemon_legacy.models.Player;
import com.lemon_legacy.systems.Combat;
import com.lemon_legacy.systems.Inventory;

public class Main {

    public static void main(String[] args) {

        Player player = new Player("Joekako");

        Enemy enemy = new Enemy("Goblin", 50, 10, 2, 15, 20);

        System.out.println("Character created: " + player.getName());
        System.out.println("Health: " + player.getTotalMaxHealth());
        System.out.println("Attack: " + player.getTotalAttack());

        Inventory.showInventory(player);

        Combat.startBattle(player, enemy);

        System.out.println("===== Final Status =====");
        System.out.println("Level: " + player.getLevel());
        System.out.println("XP: " + player.getXp());
        System.out.println("Gold: " + player.getGold());
        System.out.println("Health: " + player.getHealth() + "/" + player.getTotalMaxHealth());
        
    }
    
}
