package com.lemon_legacy.systems;

import com.lemon_legacy.models.Enemy;
import com.lemon_legacy.models.Player;
import java.util.Random;

public class Combat {

    private static final Random random = new Random();

    public static void startBattle(Player player, Enemy enemy) {
        System.out.println("===== Battle Started =====");
        System.out.println(player.getName() + " vs " + enemy.getName());
        System.out.println();

        while (player.isAlive() && enemy.isAlive()) {
            int playerDamage = calculateDamage(player.getTotalAttack());
            enemy.receiveDamage(playerDamage);

            System.out.println(player.getName() + " caused damage to " + enemy.getName() + ".");
            System.out.println("Enemy health: " + enemy.getHealth() + "/" + enemy.getMaxHealth());
            System.out.println();

            if (!enemy.isAlive()) {
                System.out.println(enemy.getName() + " was defeated");
                player.addGold(enemy.getRewardGold());
                player.gainXp(enemy.getRewardXp());

                System.out.println("You loot " + enemy.getRewardGold() + " gold coins.");
                System.out.println("You receive " + enemy.getRewardXp() + " xp.");
                System.out.println();
                return;
            }

            int enemyDamage = calculateDamage(enemy.getAttack());
            player.receiveDamage(enemyDamage);

            System.out.println(enemy.getName() + " attacks " + player.getName() + ".");
            System.out.println("Player health: " + player.getHealth() + "/" + player.getTotalMaxHealth());
            System.out.println();

            if (!player.isAlive()) {
                System.out.println(player.getName() + " died...");
                return;
            }
        }


    }

    private static int calculateDamage(int attack) {
        int minDamage = Math.max(1, attack - 3);
        int maxDamage = attack;

        return random.nextInt(maxDamage - minDamage + 1) + minDamage;
    }
    
}
