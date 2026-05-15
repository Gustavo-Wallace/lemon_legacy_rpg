package com.lemon_legacy.systems;

import com.lemon_legacy.Utils;
import com.lemon_legacy.factories.EnemyFactory;
import com.lemon_legacy.factories.ItemFactory;
import com.lemon_legacy.models.Enemy;
import com.lemon_legacy.models.Item;
import com.lemon_legacy.models.Player;
import java.util.Random;
import java.util.Scanner;

public class Adventure {

    private static final Random random = new Random();

    public static void openAdventureMenu(Player player, Scanner sc) {
        boolean running = true;

        while (running) {
            System.out.println("===== Adventure =====");
            System.out.println("1 - Search for enemy");
            System.out.println("2 - Explore area");
            System.out.println("0 - Back");
            System.out.print("Choose an option: ");

            int option = Utils.readOption(sc);

            switch (option) {
                case 1:
                    Enemy enemy = EnemyFactory.createRandomEnemy(player.getLevel());
                    Combat.startBattle(player, enemy, sc);
                    break;

                case 2:
                    exploreArea(player, sc);
                    break;

                case 0:
                    running = false;
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }

            if (!player.isAlive()) {
                running = false;
            }

            System.out.println();
        }
    }

    private static void exploreArea(Player player, Scanner sc) {
        System.out.println(player.getName() + " explores the area...");
        System.out.println();

        int chance = random.nextInt(100);

        if (chance < 30) {
            nothingHappens();
        } else if (chance < 50) {
            findGold(player);
        } else if (chance < 65) {
            findHealthPotion(player);
        } else if (chance < 80) {
            findManaPotion(player);
        } else {
            findEnemy(player, sc);
        }
    }

    private static void nothingHappens() {
        System.out.println("You walk for a while, but nothing happens.");
    }

    private static void findGold(Player player) {
        int goldFound = random.nextInt(11) + 5;

        player.addGold(goldFound);

        System.out.println("You found a small pouch containing " + goldFound + " gold!");
    }

    private static void findHealthPotion(Player player) {
        Item potion = ItemFactory.createHealthPotion();

        player.addItem(potion);

        System.out.println("You found a Health Potion!");
    }

    private static void findManaPotion(Player player) {
        Item potion = ItemFactory.createManaPotion();

        player.addItem(potion);

        System.out.println("You found a Mana Potion!");
    }

    private static void findEnemy(Player player, Scanner sc) {
        System.out.println("A monster appears!");

        Enemy enemy = EnemyFactory.createRandomEnemy(player.getLevel());
        Combat.startBattle(player, enemy, sc);
    }
}