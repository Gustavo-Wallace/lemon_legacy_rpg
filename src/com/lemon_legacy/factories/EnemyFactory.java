package com.lemon_legacy.factories;

import com.lemon_legacy.models.Enemy;
import java.util.Random;

public class EnemyFactory {

    private static final Random random = new Random();

    public static Enemy createRandomEnemy() {
        int option = random.nextInt(3);

        switch (option) {
            case 0:
                return new Enemy("Slime", 40, 8, 1, 10, 20);

            case 1:
                return new Enemy("Goblin", 55, 11, 2, 15, 30);

            case 2:
                return new Enemy("Wolf", 45, 13, 1, 12, 25);

            default:
                return new Enemy("Slime", 40, 8, 1, 10, 20);
        }
    }
}