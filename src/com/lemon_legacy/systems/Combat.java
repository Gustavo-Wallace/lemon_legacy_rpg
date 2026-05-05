package com.lemon_legacy.systems;

import com.lemon_legacy.models.Enemy;
import com.lemon_legacy.models.Player;
import java.util.Random;
import java.util.Scanner;


public class Combat {

    private static final Random random = new Random();

    public static void startBattle(Player player, Enemy enemy) {
        Scanner sc = new Scanner(System.in);

        System.out.println("===== BATTLE STARTED =====");
        System.out.println(player.getName() + " vs " + enemy.getName());
        System.out.println("Player health: " + player.getHealth() + "/" + player.getTotalMaxHealth());
        System.out.println("Enemy health: " + enemy.getHealth() + "/" + enemy.getMaxHealth());
        System.out.println();

        while (player.isAlive() && enemy.isAlive()) {
            System.out.println("===== YOUR TURN =====");
            System.out.println("1 - Attack");
            System.out.println("2 - Use health potion");
            System.out.println("3 - Run away");
            System.out.println("Choose an action:");

            int option = readOption(sc);
            System.out.println();

            if (option == 1) {
                int[] playerAttackResult = calculateDamageWithCritical(player.getTotalAttack());
                int playerDamage = playerAttackResult[0];
                boolean playerCritical = playerAttackResult[1] == 1;

                int finalPlayerDamage = enemy.receiveDamage(playerDamage);

                if (playerCritical) {
                    System.out.println("CRITICAL HIT!");
                }

                System.out.println(player.getName() + " dealt " + finalPlayerDamage + " damage to " + enemy.getName() + ".");
                System.out.println("Enemy health: " + enemy.getHealth() + "/" + enemy.getMaxHealth());
                System.out.println();
            } else if (option == 2) {
                boolean usedPotion = player.useHealthPotion();

                if (usedPotion) {
                    System.out.println("You used a health Potion.");
                    System.out.println("Player health: " + player.getHealth() + "/" + player.getTotalMaxHealth());
                    System.out.println();
                } else {
                    System.out.println("You do not have a health potion.");
                    System.out.println();
                    continue;
                }

            } else if (option == 3) {
                boolean escaped = tryToRun();

                if (escaped) {
                    System.out.println(player.getName() + " sucessfully ran away.");
                    System.out.println();
                    return;
                } else {
                    System.out.println(player.getName() + " tries to run away, but failed.");
                    System.out.println();
                }

            } else {
                System.out.println("Invalid Option.");
                System.out.println();
                continue;
            }

            if (!enemy.isAlive()) {
                System.out.println(enemy.getName() + " was defeated");
                player.addGold(enemy.getRewardGold());
                player.gainXp(enemy.getRewardXp());

                System.out.println("You loot " + enemy.getRewardGold() + " gold coins.");
                System.out.println("You receive " + enemy.getRewardXp() + " xp.");
                System.out.println();
                return;
            }

            int[] enemyAttackResult = calculateDamageWithCritical(enemy.getAttack());
            int enemyDamage = enemyAttackResult[0];
            boolean enemyCritical = enemyAttackResult[1] == 1;

            int finalEnemyDamage = player.receiveDamage(enemyDamage);

            if (enemyCritical) {
                System.out.println("CRITICAL HIT FROM " + enemy.getName() + "!");
            }

            System.out.println(enemy.getName() + " dealt " + finalEnemyDamage + " damage to " + player.getName() + ".");
            System.out.println("Player health: " + player.getHealth() + "/" + player.getTotalMaxHealth());
            System.out.println();

            if (!player.isAlive()) {
                System.out.println(player.getName() + " died...");
                return;
            }
        }


    }

    private static int readOption(Scanner sc) {
        while(!sc.hasNextInt()) {
            System.out.println("Invalid Option. Please enter a number.");
            sc.next();
        }
        return sc.nextInt();
    }

    private static int[] calculateDamageWithCritical(int attack) {
        int minDamage = Math.max(1, attack - 3);
        int maxDamage = attack;

        int damage = random.nextInt(maxDamage - minDamage + 1) + minDamage;
        boolean critical = random.nextInt(100) < 15;

        if (critical) {
            damage *= 2;
        }

        return new int[] {damage, critical ? 1 : 0};
    }

    private static boolean tryToRun() {
        return random.nextInt(100) < 40;
    }
    
}
