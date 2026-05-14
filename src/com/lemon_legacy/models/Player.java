package com.lemon_legacy.models;

import java.util.ArrayList;
import java.util.List;

public class Player {

    private String name;
    private int level = 1;
    private int xp = 0;
    private int xpToLevelUp = 40;

    private int maxHealth = 100;
    private int health = 100;

    private int maxMana = 40;
    private int mana = 40;

    private int attack = 12;
    private int defense = 3;
    private int gold = 30;

    private int x = 0;
    private int y = 0;

    private List<Item> inventory = new ArrayList<>();

    private Item weapon = null;
    private Item armor = null;

    private Quest currentQuest = null;


    public Player(String name) {
        this.name = name;
        inventory.add(new Item("Health Potion", "consumable", 10, 30, 0, 0, 0, 0));
    }


    public String getName() {
        return name;
    }

    public int getLevel() {
        return level;
    }

    public int getXp() {
        return xp;
    }

    public int getXpToLevelUp() {
        return xpToLevelUp;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxMana() {
        return maxMana;
    }

    public int getMana() {
        return mana;
    }

    public int getAttack() {
        return attack;
    }

    public int getDefense() {
        return defense;
    }

    public int getGold() {
        return gold;
    }

    public Item getWeapon() {
        return weapon;
    }

    public Item getArmor() {
        return armor;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Quest getCurrentQuest() {
        return currentQuest;
    }

    public void setCurrentQuest(Quest currentQuest) {
        this.currentQuest = currentQuest;
    }

    // player movement
    public void moveUp() {
        y--;
    }

    public void moveDown() {
        y++;
    }

    public void moveLeft() {
        x--;
    }

    public void moveRight() {
        x++;
    }


    public boolean isAlive() {
        return health > 0;
    }

    public int receiveDamage(int damage) {
        int finalDamage = damage - getTotalDefense();

        if (finalDamage < 1) {
            finalDamage = 1;
        }

        health -= finalDamage;

        if (health < 0) {
            health = 0;
        }

        return finalDamage;
    }

    public int heal(int amount) {
        int oldHealth = health;

        health += amount;

        if (health > getTotalMaxHealth()) {
            health = getTotalMaxHealth();
        }

        return health - oldHealth;
    }

    public int recoverMana(int amount) {
        int oldMana = mana;

        mana += amount;

        if (mana > maxMana) {
            mana = maxMana;
        }

        return mana - oldMana;
    }

    public void gainXp(int amount) {
        xp += amount;

        while (xp >= xpToLevelUp) {
            xp -= xpToLevelUp;
            level++;
            xpToLevelUp += 20;

            maxHealth += 20;
            maxMana += 10;
            attack += 3;
            defense += 1;

            health = getTotalMaxHealth();
            mana = maxMana;

            System.out.println("You've leveled up!");
            
        }
    }

    public void addGold(int amount) {
        gold += amount;
    }

    public boolean spendGold(int amount) {
        if (gold < amount) {
            return false;
        }

        gold -= amount;
        return true;
    }


    public void addItem(Item item) {
        inventory.add(item);
    }

    public List<Item> getInventory() {
        return inventory;
    }

    public boolean equipItem(Item item) {
        if (item == null) {
            return false;
        }

        if (item.getType().equalsIgnoreCase("weapon")) {
            if (weapon != null) {
                inventory.add(weapon);
            }

            inventory.remove(item);
            weapon = item;

            return true;
        }

        if (item.getType().equalsIgnoreCase("armor")) {
            if (armor != null) {
                inventory.add(armor);
            }

            inventory.remove(item);
            armor = item;

            if (health > getTotalMaxHealth()) {
                health = getTotalMaxHealth();
            }

            return true;
        }

        return false;
    }


    public int getTotalAttack() {
        int bonus = 0;

        if (weapon != null) {
            bonus += weapon.getBonusAttack();
        }

        return attack + bonus;
    }

    public int getTotalDefense() {
        int bonus = 0;

        if (armor != null) {
            bonus += armor.getBonusDefense();
        }

        return defense + bonus;
    }

    public int getTotalMaxHealth() {
        int bonus = 0;

        if (armor != null) {
            bonus += armor.getBonusHealth();
        }

        return maxHealth + bonus;
    }

    public boolean useHealthPotion() {
        for (int i = 0; i < inventory.size(); i++) {
            Item item = inventory.get(i);

            if (item.getType().equalsIgnoreCase("consumable") && item.getHeal() > 0) {
                int healed = heal(item.getHeal());

                if (healed <= 0) {
                    return false;
                }

                inventory.remove(i);
                return true;
            }
        }

        return false;
    }


    public void fullRecover() {
        health = getTotalMaxHealth();
        mana = maxMana;
    }

    public void registerQuestKill(String enemyName) {
        if (currentQuest == null) {
            return;
        }

        if (currentQuest.isCompleted()) {
            return;
        }

        currentQuest.registerKill(enemyName);

        if (currentQuest.isCompleted()) {
            addGold(currentQuest.getGoldReward());
            gainXp(currentQuest.getXpReward());

            System.out.println("Quest reward received:");
            System.out.println("Gold: " + currentQuest.getGoldReward());
            System.out.println("XP: " + currentQuest.getXpReward());
        }
    }

    public void showStatus() {
        System.out.println("===== Player Status =====");
        System.out.println("Name: " + name);
        System.out.println("Level: " + level);
        System.out.println("XP: " + xp + "/" + xpToLevelUp);
        System.out.println("Health: " + health + "/" + getTotalMaxHealth());
        System.out.println("Mana: " + mana + "/" + maxMana);
        System.out.println("Attack: " + getTotalAttack());
        System.out.println("Defense: " + getTotalDefense());
        System.out.println("Gold: " + gold);

        if (currentQuest != null) {
            System.out.println();
            currentQuest.showDetails();
        }
    }

    public void showCurrentQuest() {
        if (currentQuest == null) {
            System.out.println("You do not have an active quest.");
            return;
        }

        currentQuest.showDetails();
    }
    
}
