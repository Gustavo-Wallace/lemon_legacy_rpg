package com.lemon_legacy.systems;

import com.lemon_legacy.Utils;
import com.lemon_legacy.factories.AreaFactory;
import com.lemon_legacy.factories.EnemyFactory;
import com.lemon_legacy.factories.ItemFactory;
import com.lemon_legacy.models.Area;
import com.lemon_legacy.models.Enemy;
import com.lemon_legacy.models.Item;
import com.lemon_legacy.models.Player;
import java.util.Random;
import java.util.Scanner;

public class Adventure {

    private static final Random random = new Random();

    private static Area currentArea = AreaFactory.createLemonFields();

    public static void openAdventureMenu(Player player, Scanner sc) {
        boolean running = true;

        while (running) {
            System.out.println("===== Adventure =====");
            System.out.println("Current area: " + currentArea.getName());
            System.out.println("1 - Search for enemy");
            System.out.println("2 - Explore area");
            System.out.println("3 - View area details");
            System.out.println("4 - Travel");
            System.out.println("0 - Back");
            System.out.print("Choose an option: ");

            int option = Utils.readOption(sc);

            switch (option) {
                case 1:
                    System.out.println(player.getName() + " searches for enemies in " + currentArea.getName() + "...");
                    System.out.println();

                    Enemy enemy = EnemyFactory.createRandomEnemy(currentArea, player.getLevel());
                    Combat.startBattle(player, enemy, sc);
                    break;

                case 2:
                    exploreArea(player, sc, currentArea);
                    break;

                case 3:
                    currentArea.showDetails();
                    System.out.println();
                    break;

                case 4:
                    openTravelMenu(sc);
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

    private static void openTravelMenu(Scanner sc) {
        boolean traveling = true;

        while (traveling) {
            System.out.println("===== Travel =====");
            System.out.println("Current area: " + currentArea.getName());
            System.out.println("1 - Lemon Fields");
            System.out.println("2 - Sour Cave");
            System.out.println("0 - Back");
            System.out.print("Choose an area: ");

            int option = Utils.readOption(sc);

            switch (option) {
                case 1:
                    currentArea = AreaFactory.createLemonFields();
                    System.out.println("You traveled to Lemon Fields.");
                    traveling = false;
                    break;

                case 2:
                    currentArea = AreaFactory.createSourCave();
                    System.out.println("You traveled to Sour Cave.");
                    traveling = false;
                    break;

                case 0:
                    traveling = false;
                    break;

                default:
                    System.out.println("Invalid option.");
                    break;
            }

            System.out.println();
        }
    }

    private static void exploreArea(Player player, Scanner sc, Area area) {
        System.out.println(player.getName() + " explores " + area.getName() + "...");
        System.out.println();

        if (area.getName().equalsIgnoreCase("Lemon Fields")) {
            exploreLemonFields(player, sc, area);
            return;
        }

        exploreLemonFields(player, sc, area);
    }

    private static void exploreLemonFields(Player player, Scanner sc, Area area) {
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
            findEnemy(player, sc, AreaFactory.createLemonFields());
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

    private static void findEnemy(Player player, Scanner sc, Area area) {
        System.out.println("A monster appears!");

        Enemy enemy = EnemyFactory.createRandomEnemy(area, player.getLevel());
        Combat.startBattle(player, enemy, sc);
    }


}