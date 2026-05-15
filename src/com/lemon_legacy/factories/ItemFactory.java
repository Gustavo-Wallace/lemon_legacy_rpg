package com.lemon_legacy.factories;

import com.lemon_legacy.models.Item;
import java.util.Random;

public class ItemFactory {

    private static final Random random = new Random();

    public static Item createHealthPotion() {
        return new Item("Health Potion", "consumable", 10, 30, 0, 0, 0, 0);
    }

    public static Item createManaPotion() {
        return new Item("Mana Potion", "consumable", 12, 0, 20, 0, 0, 0);
    }

    public static Item createIronSword() {
        return new Item("Iron Sword", "weapon", 40, 0, 0, 5, 0, 0);
    }

    public static Item createLeatherArmor() {
        return new Item("Leather Armor", "armor", 35, 0, 0, 0, 10, 2);
    }

    public static Item createRandomLootItem() {
        int option = random.nextInt(4);

        switch (option) {
            case 0:
                return createHealthPotion();

            case 1:
                return createManaPotion();

            case 2:
                return createIronSword();

            case 3:
                return createLeatherArmor();

            default:
                return createHealthPotion();
        }
    }
}