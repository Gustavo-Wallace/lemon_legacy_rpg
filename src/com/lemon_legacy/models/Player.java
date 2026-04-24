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

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
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

    public void receiveDamage(int damage) {
        int finalDamage = damage - getTotalDefense();

        if (finalDamage < 1) {
            finalDamage = 1;
        }

        health -= finalDamage;

        if (health < 0) {
            health = 0;
        }
    }

    public void heal(int amount) {
        health += amount;

        if (health > getTotalMaxHealth()) {
            health = getTotalMaxHealth();
        }
    }

    public void recoverMana(int amount) {
        mana += amount;

        if (mana > maxMana) {
            mana = maxMana;
        }
    }

    public void gainXp(int amount) {
        xp += amount;

        if (xp >= xpToLevelUp) {
            level++;
            xpToLevelUp += 20;

            maxHealth += 20;
            maxMana += 10;
            attack += 3;
            defense += 1;

            health = maxHealth;
            mana = maxMana;
            
        }
    }

    public void gainGold(int amount) {
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
    
}
