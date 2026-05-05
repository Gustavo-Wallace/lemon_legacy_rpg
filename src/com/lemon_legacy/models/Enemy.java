package com.lemon_legacy.models;

public class Enemy {

    private String name;
    private int maxHealth;
    private int health;
    private int attack;
    private int defense;
    private int rewardGold;
    private int rewardXp;

    public Enemy (String name, int maxHealth, int attack, int defense, int rewardGold, int rewardXp) {
        this.name = name;
        this.maxHealth = maxHealth;
        this.health = maxHealth;
        this.attack = attack;
        this.defense = defense;
        this.rewardGold = rewardGold;
        this.rewardXp = rewardXp;
    }

    public boolean isAlive() {
        return health > 0;
    }

    public int receiveDamage(int damage) {
        int finalDamage = damage - defense;

        if (finalDamage < 1) {
            finalDamage = 1;
        }

        health -= finalDamage;

        if (health < 0) {
            health = 0;
        }

        return finalDamage;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public int getAttack() {
        return attack;
    }

    public int getRewardGold() {
        return rewardGold;
    }

    public int getRewardXp() {
        return rewardXp;
    }
    
}
