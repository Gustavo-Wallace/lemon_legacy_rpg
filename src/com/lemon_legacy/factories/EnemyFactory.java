package com.lemon_legacy.factories;

import com.lemon_legacy.models.Enemy;
import java.util.Random;

public class EnemyFactory {

    private static final Random random = new Random();

    public static Enemy createRandomEnemy(int playerLevel) {
        int option = random.nextInt(4);

        switch (option) {
            case 0:
                return createScaledEnemy("Slime", 40, 8, 1, 10, 20, playerLevel);

            case 1:
                return createScaledEnemy("Goblin", 55, 11, 2, 15, 30, playerLevel);

            case 2:
                return createScaledEnemy("Wolf", 45, 13, 1, 12, 25, playerLevel);

            case 3:
                return createScaledEnemy("Lemon-man", 66, 33, 33, 999, 999, playerLevel);

            default:
                return createScaledEnemy("Slime", 40, 8, 1, 10, 20, playerLevel);
        }
    }

    private static Enemy createScaledEnemy( 
        String name,
        int baseMaxHealth,
        int baseAttack,
        int baseDefense,
        int baseGoldReward,
        int baseXpReward,
        int playerLevel
    ) {
        int levelBonus = playerLevel - 1;

        int maxHealth = baseMaxHealth + (levelBonus * 8);
        int attack = baseAttack + (levelBonus * 2);
        int defense = baseDefense + (levelBonus);
        int goldReward = baseGoldReward + (levelBonus * 3);
        int xpReward = baseXpReward + (levelBonus * 5);

        return new Enemy(name, maxHealth, attack, defense, goldReward, xpReward);
    }
}