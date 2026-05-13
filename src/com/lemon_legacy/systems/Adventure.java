package com.lemon_legacy.systems;

import com.lemon_legacy.Utils;
import com.lemon_legacy.factories.EnemyFactory;
import com.lemon_legacy.models.Enemy;
import com.lemon_legacy.models.Player;

import java.util.Scanner;

public class Adventure {

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
                    exploreArea();
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

    private static void exploreArea() {
        System.out.println("You explore the area, but nothing happens yet.");
    }
}