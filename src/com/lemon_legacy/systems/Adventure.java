package com.lemon_legacy.systems;

import com.lemon_legacy.Utils;
import com.lemon_legacy.factories.EnemyFactory;
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
        int event = random.nextInt(5);

        switch (event) {
            case 0:
                findGold(player);
                break;

            case 1:
                findHealthPotion(player);
                break;

            case 2:
                findManaPotion(player);
                break;

            case 3:
                findEnemy(player, sc);
                break;

            case 4:
                System.out.println("You explore the area, but nothing happens.");
                break;

            default:
                System.out.println("You continue walking...");
                break;
        }
    }

    private static void findGold(Player player) {
        int goldFound = random.nextInt(11) + 5;

        player.addGold(goldFound);

        System.out.println("You found " + goldFound + " gold!");
    }

    private static void findHealthPotion(Player player) {
        Item potion = new Item("Health Potion", "consumable", 10, 30, 0, 0, 0, 0);

        player.addItem(potion);

        System.out.println("You found a Health Potion!");
    }

    private static void findManaPotion(Player player) {
        Item potion = new Item("Mana Potion", "consumable", 12, 0, 20, 0, 0, 0);

        player.addItem(potion);

        System.out.println("You found a Mana Potion!");
    }

    private static void findEnemy(Player player, Scanner sc) {
        System.out.println("A monster appears!");

        Enemy enemy = EnemyFactory.createRandomEnemy(player.getLevel());
        Combat.startBattle(player, enemy, sc);
    }
}